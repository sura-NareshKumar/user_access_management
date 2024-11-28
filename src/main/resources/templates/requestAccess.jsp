<!DOCTYPE html>
<html>
<head>
    <title>Request Access</title>
</head>
<body>
    <h2>Request Access</h2>
    <form action="/employee/request" method="post">
        <label for="software">Software:</label>
        <select id="software" name="softwareId">
            <c:forEach items="${softwareList}" var="software">
                <option value="${software.id}">${software.name}</option>
            </c:forEach>
        </select><br>
        <label for="accessType">Access Type:</label>
        <select id="accessType" name="accessType">
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select><br>
        <label for="reason">Reason:</label>
        <textarea id="reason" name="reason"></textarea><br>
        <button type="submit">Submit Request</button>
    </form>
</body>
</html>
