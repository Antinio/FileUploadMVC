package com.antinio.controller;


import com.antinio.model.UploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

@Controller
public class UploadController {

    //Save uploaded file in folder
    private static String UPLOADED_FOLDER = "C:\\temp\\";

    @GetMapping("/")
    public String index(){
        return "upload";
    }

    @GetMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){

        if (file.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "Please select file to upload");
            return "redirect:uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:uploadStatus";

    }

    @PostMapping("/uploadMulti")
    public String multiFileUpload(@ModelAttribute UploadForm form,
            RedirectAttributes redirectAttributes) {

        StringJoiner stringJoiner = new StringJoiner(" , ");

        for (MultipartFile file : form.getFiles()) {
            if (file.isEmpty()){
                continue; //next pls
            }

            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);

                stringJoiner.add(file.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String uploadFileName = stringJoiner.toString();
        if (StringUtils.isEmpty(uploadFileName)) {
            redirectAttributes.addAttribute("message", "Please select a file to upload!");
        } else {
            redirectAttributes.addAttribute("message", "You successfully uploaded '" + uploadFileName + "'");
        }
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }


}
