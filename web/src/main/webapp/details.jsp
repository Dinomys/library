<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--
  Created by IntelliJ IDEA.
  User: hanna
  Date: 07/04/2019
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book details</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<form action="/details" method="post">
    <input type="hidden" name="bookid" value="${book.id}">
    <div class="form-group row">
        <label for="title" class="col-sm-2 col-form-label">Title:</label>
        <div class="col">
            <input type="text" readonly class="form-control-plaintext" id="title" value="${book.title}">
        </div>
    </div>
    <div class="form-group row">
        <label for="author" class="col-sm-2 col-form-label">Author:</label>
        <div class="col">
            <input type="text" readonly class="form-control-plaintext" id="author" value="${book.author}" readonly>
        </div>
    </div>
    <div class="form-group row">
        <label for="isbn" class="col-sm-2 col-form-label">ISBN:</label>
        <div class="col">
            <input type="text" readonly class="form-control-plaintext" id="isbn" value="${book.isbn}" readonly>
        </div>
    </div>
    <div class="form-group row">
        <label for="category" class="col-sm-2 col-form-label">Category:</label>
        <div class="col">
            <input type="text" readonly class="form-control-plaintext" id="category" value="${book.category}" readonly>
        </div>
    </div>
    <div class="form-group row">
        <label for="published" class="col-sm-2 col-form-label">Published date:</label>
        <div class="col">
            <input type="date" readonly class="form-control-plaintext" id="published" value="${book.published}"
                   readonly>
        </div>
    </div>
    <div class="form-group row">
        <label for="pages" class="col-sm-2 col-form-label">Number of pages:</label>
        <div class="col">
            <input type="text" readonly class="form-control-plaintext" id="pages" value="${book.pages}" readonly>
        </div>
    </div>
    <div class="form-group row">
        <label for="summary" class="col-sm-2 col-form-label">Summary:</label>
        <div class="col text-area">
            <input type="text" readonly class="form-control-plaintext" id="summary" value="${book.summary}" readonly>
        </div>
    </div>
    <c:choose>
        <c:when test="$book.borrow = true">
            <input type="text" readonly class="form-control-plaintext" value="${requestScope.book.borrower}">
            <button type="submit" class="btn btn-primary" name="action" value="return">Return book</button>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Borrow the book to:</label>
                <select class="form-control" id="exampleFormControlSelect1" name="borrowerid">
                    <c:forEach var="borrower" items="${requestScope.borrowers}" varStatus="loop">
                        <option value="${borrower.id}">${borrower.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary" name="action" value="borrow">Borrow book</button>
        </c:otherwise>
    </c:choose>
    <button type="submit" class="btn btn-secondary" name="action" value="index">Back to index</button>
</form>

</body>
</html>
