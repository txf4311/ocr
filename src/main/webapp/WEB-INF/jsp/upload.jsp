<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>单文件上传</title>
</head>
<body>
<div>
    <form method="post" action="/uploadBusinessCard" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="提交"> （只适合名片解析）
    </form><br/>

    <form method="post" action="/uploadBusinessLicense" enctype="multipart/form-data">
        <input type="file" name="fileBusinessLicense">
        <input type="submit" value="提交"> （只适合营业执照解析）
    </form>
</div>
</body>
</html>