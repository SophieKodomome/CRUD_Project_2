<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%
    ArrayList<String> task;
    ArrayList<Timestamp> remind;
    ArrayList<Timestamp> due;
    int[] id = (int[]) request.getAttribute("id");
    task = (ArrayList<String>) request.getAttribute("tosk");
    int[] orderTask = (int[]) request.getAttribute("orderTask");
    remind = (ArrayList<Timestamp>) request.getAttribute("remind");
    due = (ArrayList<Timestamp>) request.getAttribute("due");
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
            <% for (int i=0; i<id.length; i++) { %>
                <tr>
                    <%=id[i] %>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
