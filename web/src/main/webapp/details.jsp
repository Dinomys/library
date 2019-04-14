<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--
  Created by IntelliJ IDEA.
  User: hanna
  Date: 07/04/2019
  Time: 15:22
  To change this template use File | Settings | File Templates.
    private long id;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private Date published;
    private String borrowedBy;
    boolean borrow;
    int pages;
    String summary;
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book details</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<form>
    <div class="form-group row">
        <label for="title" class="col-sm-2 col-form-label">Title</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="title" value=${book.title}>
        </div>
    </div>
    <div class="form-group row">
        <label for="author" class="col-sm-2 col-form-label">Author</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" id="author" value=${book.author}>
        </div>
    </div>
</form>

</body>
</html>
