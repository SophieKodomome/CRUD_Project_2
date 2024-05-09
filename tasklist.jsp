<%@page import="java.sql.Timestamp"%>
<%
    int[] id = (int[]) request.getAttribute("id");
    String[] task = (String[]) request.getAttribute("tasklist");
    int[] orderTask = (int[]) request.getAttribute("orderTask");
    Timestamp[] remind = (Timestamp[]) request.getAttribute("remind");
    Timestamp[] due = (Timestamp[]) request.getAttribute("due");
    boolean[] status = (boolean[]) request.getAttribute("status");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Ajouter une depense</title>
</head>
<body>
    <h1>List de Job</h1>
    <table border="2">
        <thead>
            <tr>
                <%-- <th>ID</th> --%>
                <th>Name</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <%= task[0] %>
        </tbody>
    </table>
</body>
</html>
