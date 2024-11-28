<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests</title>
</head>
<body>
    <h2>Pending Requests</h2>
    <table border="1">
        <tr>
            <th>Employee</th>
            <th>Software</th>
            <th>Access Type</th>
            <th>Reason</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${pendingRequests}" var="request">
            <tr>
                <td>${request.user.username}</td>
                <td>${request.software.name}</td>
                <td>${request.accessType}</td>
                <td>${request.reason}</td>
                <td>
                    <form action="/manager/requests/${request.id}" method="post">
                        <button name="action" value="approve">Approve</button>
                        <button name="action" value="reject">Reject</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
