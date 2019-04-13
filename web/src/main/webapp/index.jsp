<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Book directory</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<h2>Book directory</h2>
<form action="/index" method post>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col"></th>
        <th scope="col">Title</th>
        <th scope="col">Author</th>
        <th scope="col">ISBN</th>
        <th scope="col">Category</th>
        <th scope="col">Published date</th>
        <th scope="col">Borrowed to</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${requestScope.books}" varStatus="loop">
        <tr>
            <th scope ="row">${loop.index + 1}</th>
            <td><input class="form-check-input" type="radio" name="id" value="${book.id}"></td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.isbn}</td>
            <td>${book.category}</td>
            <td>${book.published}</td>
            <td>${not empty book.borrowedBy ? book.borrowedBy : '-'}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <button type="submit" class="btn btn-primary" name="action" value="add">Add</button>
    <button type="submit" class="btn btn-secondary" name="action" value="details">Details</button>
    <button type="submit" class="btn btn-success" name="action" value="edit">Edit</button>
    <button type="submit" class="btn btn-danger" name="action" value="delete"> Delete</button>
</form>
</body>
</html>
