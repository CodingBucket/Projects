<!doctype html>
<html>
<head>
    <title>Current Projects</title>
</head>
<body>

    <table border="1">
        <g:each in="${projects}" status="i" var="thisProject">
            <tr>
                <td>${thisProject.name}</td>
                <td>${thisProject.description}</td>
                <td>${thisProject.dueDate}</td>
            </tr>
        </g:each>
    </table>

</body>
</html>
