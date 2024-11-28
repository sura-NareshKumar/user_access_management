<!DOCTYPE html>
<html>
<head>
    <title>Create Software</title>
</head>
<body>
    <h2>Create New Software</h2>
    <form action="/admin/software" method="post">
        <label for="name">Software Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="description">Description:</label>
        <textarea id="description" name="description"></textarea><br>
        <label for="accessLevels">Access Levels:</label><br>
        <input type="checkbox" name="accessLevels" value="Read"> Read<br>
        <input type="checkbox" name="accessLevels" value="Write"> Write<br>
        <input type="checkbox" name="accessLevels" value="Admin"> Admin<br>
        <button type="submit">Create</button>
    </form>
</body>
</html>
