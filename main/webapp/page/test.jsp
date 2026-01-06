<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: X
  Date: 2026/1/5
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<div>
    <form action="<c:url value="/testUpload"/>" method="post" enctype="multipart/form-data">
        <label>picture</label>
        <input type="file" name="file"/><br/>
        <button type="submit">upload</button>
    </form>
</div>
</body>
</html>
