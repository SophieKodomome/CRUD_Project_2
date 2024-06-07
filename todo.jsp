<%@page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement"%>
<%
    // Capture the task ID from the request parameter
    String taskId = request.getParameter("id");

    // Verify the task ID is not null
    if (taskId != null) {
        try {
            // Database connection setup (replace with your actual database details)
            Class.forName("com.mysql.jdbc.Driver"); // Replace with your database driver
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // Update the task status in the database
            String query = "UPDATE tasks SET status = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setBoolean(1, true);
            stmt.setInt(2, Integer.parseInt(taskId));
            stmt.executeUpdate();

            // Close the connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        out.println("Task ID is missing!");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task Completion</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="font-sans leading-normal tracking-normal">
    <div class="container mx-auto py-8">
        <header class="py-8">
            <h1 class="text-3xl text-blue-500 font-bold mb-4">Task Completed</h1>
        </header>
        <article>
            <section class="p-4 border rounded-xl shadow-lg">
                <h2 class="text-2xl text-blue-500 font-bold mb-4">Task ID: <%=taskId %></h2>
                <p class="text-gray-700">The task with ID <strong><%=taskId %></strong> has been marked as completed.</p>
                <a href="todo.html" class="inline-block mt-4 py-2 px-4 text-white font-semibold bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500 rounded-lg shadow-lg">Back to Task List</a>
            </section>
        </article>
    </div>
</body>
</html>
