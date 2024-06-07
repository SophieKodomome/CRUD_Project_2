<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
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
    <title>Notodo</title>
</head>

<body>
    <a href="readtask">List</a>
</body>

</html>
