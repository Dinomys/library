<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new book</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<h2>Add new book</h2>
<form action="/add" method="post">
    <div class="form-group">
        <label for="authorFormControlSelect">Author</label>
        <select class="form-control" id="authorFormControlSelect" name="authorFormControlSelect">
            <option>Witold Gombrowicz</option>
            <option>Czeslaw Niemen</option>
        </select>
    </div>
    <div class="form-group">
        <label for="formTitleInput">Title</label>
        <input type="text" class="form-control" id="formTitleInput" placeholder="Title" name="formTitleInput">
    </div>
    <div class="form-group">
        <label for="formSummaryInput">Summary</label>
        <input type="text" class="form-control" id="formSummaryInput" placeholder="Summary" maxlength="255" name="formSummaryInput">
    </div>
    <div class="form-group">
        <label for="categoryFormControlSelect">Category</label>
        <select class="form-control" id="categoryFormControlSelect" name="categoryFormControlSelect">
            <option>Horror</option>
            <option>Thriller</option>
            <option>Comedy</option>
            <option>Drama</option>
            <option>History</option>
        </select>
    </div>
    <div class="form-group">
        <label for="formISBNInput">ISBN</label>
        <input type="text" class="form-control" id="formISBNInput" placeholder="ISBN" maxlength="13" minlength="13" name="formISBNInput">
    </div>
    <div class="form-group">
        <label for="formReleaseInput">Release Date</label>
        <input type="date" class="form-control" id="formReleaseInput" placeholder="Release Date" name="formReleaseInput">
    </div>
    <div class="form-group">
        <label for="formPagesInput">Amount of pages</label>
        <input type="text" class="form-control" id="formPagesInput" placeholder="Amount of pages" name="formPagesInput">
    </div>
    <button type="submit" class="btn btn-primary" name="action" value="add">Add</button>
</form>
<a href="/index">
    <button class="btn btn-primary">Cancel</button>
</a>
</body>
</html>