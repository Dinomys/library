<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Book directory</h2>
<form>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col"> </th>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">Author</th>
        <th scope="col">ISBN</th>
        <th scope="col">Category</th>
        <th scope="col">Published date</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${requestScopebooks}" varStatus="loop">
        <tr>
            <th scope ="row">${loop.index + 1}</th>
            <td>${book.title}</td>
            <td><input class="form-check-input" type="radio" name="bookId" value="${book.id}"></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</form>
</body>
</html>
