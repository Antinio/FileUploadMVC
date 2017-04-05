<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Upload multi files</title>
</head>
<body>
    <h1>Spring MVC single file uploader</h1>

    <form:form method="post" action="${pageContext.request.contextPath}/uploadMultiForm"
               modelAttribute="uploadForm" enctype="multipart/form-data">

        <input type="file" name="files" /><br>
        <input type="file" name="files" /><br>
        <input type="file" name="files" /><br><br>
        <input type="submit" value="Submit" />

    </form:form>

</body>
</html>
