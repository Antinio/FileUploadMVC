<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Upload form</title>
</head>
<body>
    <h1>Spring MVC single file uploader</h1>

    <form:form method="post" action="${pageContext.request.contextPath}/uploadForm"
    modelAttribute="uploadForm" enctype="multipart/form-data">

        <input type="file" name="file" /><br><br>
        <input type="submit" value="Submit" />

    </form:form>

</body>
</html>
