<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Upload form</title>
</head>
<body>
    <h1>Spring MVC multi files uploader</h1>

    <form:form method="post" action="${pageContext.request.contextPath}/uploadMulti"
    modelAttribute="uploadForm" enctype="multipart/form-data">

        <input type="file" name="files" /><br>
        <input type="file" name="files" /><br>
        <input type="file" name="files" /><br><br>
        <input type="submit" value="submit" />

    </form:form>

</body>
</html>