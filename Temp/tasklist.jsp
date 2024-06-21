<%@page import="java.sql.Timestamp"%>
<%
    int[] id = (int[]) request.getAttribute("id");
    String[] task = (String[]) request.getAttribute("tasklist");
    int[] orderTask = (int[]) request.getAttribute("orderTask");
    Timestamp[] remind = (Timestamp[]) request.getAttribute("remind");
    Timestamp[] due = (Timestamp[]) request.getAttribute("due");
    boolean[] status = (boolean[]) request.getAttribute("status");
    String name= new String();

    if(session.getAttribute("username")!=null){
        name= (String) session.getAttribute("username");
    }else{
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notodo</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@3.4.4/base.min.css">
</head>

<body class="font-sans leading-normal tracking-normal">
    <div class="flex md:flex-row md:min-h-screen">
        <aside class="bg-blue-600 md:w-52 md:min-h-screen py-6 px-4 text-white">
            <header class="mb-10">
                <h1 class="font-extrabold uppercase text-xl tracking-tight">Notodo</h1>
                <h2><%=name  %></h2>
                <a href="/destroySession">Destroy</a>
            </header>
            <!--
            <nav class="flex flex-col">
                <a href="personal_todo.html" class="font-semibold block py-2 px-4 text-sm text-gray-200 hover:text-white hover:underline hover:underline-offset-2">
                    Personal Tasks
                </a>
                <a href="professional_todo.html" class="font-semibold block py-2 px-4 text-sm text-gray-200 hover:text-white hover:underline hover:underline-offset-2">
                    Professional Tasks
                </a>
            </nav>
        -->
        </aside>
        <main class="container mx-auto py-8 ml-10 mb-10">
            <header class="py-8 ">
                <h1 class="text-3xl text-blue-500 font-bold mb-4">
                    Personal to do list &#128151
                </h1>
            </header>
            <article>
                <section>
            <% for(int i=0;i<id.length;i++){
                if(status[i]==false){
            %>
                    <section class="p-4 border rounded-xl shadow-lg flex flex-row mr-10 mb-10 md:min-w-screen">
                        <aside class="flex flex-col mr-10">
                            <header>
                                <h2 class="hover:text-blue-600 text-blue-500 font-bold">
                                    <%=task[i] %>
                                </h2>
                            </header>
                            <article class="flex flex-row space-x-4">
                                <span class="flex flex-row space-x-2">
                                    <h3 class="text-gray-400">
                                        Reminder:
                                    </h3>
                                    <strong class="text-blue-500">
                                        <%=remind[i] %>
                                    </strong>
                                </span>
                                <span class="flex flex-row space-x-2">
                                    <h3 class="text-gray-400">
                                        Due: 
                                    </h3>
                                    <strong class="text-blue-500">
                                        <%=due[i] %>
                                    </strong>
                                </span>
                                <strong class="hover:text-green-600 text-green-500">
                                    In Progress
                                </strong>
                            </article>
                        </aside>
                        <aside class="border-l pt-4 pl-10 flex flex-row space-x-2">
                            <!---<a href="todo.html">
                                <button class="bg-white border-2 border-blue-500 hover:bg-blue-500 hover:text-white text-blue-500 font-bold py-2 px-4 rounded-lg" value=<%=id[i] %>>
                                    &uarr;
                                </button>
                            </a>
                            <a href="todo.html">
                                <button class="bg-white border-2 border-blue-500 hover:bg-blue-500 hover:text-white text-blue-500 font-bold py-2 px-4 rounded-lg" value=<%=id[i] %>>
                                    &darr;
                                </button>
                            </a>--->
                            <a href="finishTask?id=<%=id[i] %>">
                            <button class="overflow-hidden relative w-32 py-2 bg-black text-white border-none rounded-md text-xl font-bold cursor-pointer relative z-10 group">
                                Finish
                                <span class="absolute w-36 h-32 -top-8 -left-2 bg-white rotate-12 transform scale-x-0 group-hover:scale-x-100 transition-transform group-hover:duration-500 duration-1000 origin-left"></span>
                                <span class="absolute w-36 h-32 -top-8 -left-2 bg-purple-400 rotate-12 transform scale-x-0 group-hover:scale-x-100 transition-transform group-hover:duration-700 duration-700 origin-left"></span>
                                <span class="absolute w-36 h-32 -top-8 -left-2 bg-purple-600 rotate-12 transform scale-x-0 group-hover:scale-x-100 transition-transform group-hover:duration-1000 duration-500 origin-left"></span>
                                <span class="group-hover:opacity-100 group-hover:duration-1000 duration-100 opacity-0 absolute top-2.5 left-6 z-10" >Finish!</span>
                            </button>

                            </a>
                            <a href="readTaskById?id=<%=id[i]%>">
                                <button class=" hover:text-blue-600 text-blue-400 underline underline-offset-2 py-2 px-2 rounded" value=<%=id[i] %>>
                                    Modify
                                </button>
                            </a>
                            <a href="deleteTask?id=<%=id[i]%>">
                                <button class=" hover:text-red-800 text-red-400 underline underline-offset-2 py-2 px-2 rounded" value=<%=id[i] %>>
                                    Delete
                                </button>
                            </a>
                        </aside>
                    </section>
            <%
                }
            }
            %>
                    <section>
                        <header>
                            <h3 class="text-2xl text-blue-500 font-bold border-b-2 pb-4 mb-4 mr-10">
                                Completed
                            </h3>
                        </header>
            <%  for(int i=0;i<id.length;i++){
                    if(status[i]==true){
            %>
                        <section class="p-4 border rounded-xl shadow-lg flex flex-row mr-10 mb-10 md:min-w-screen bg-gray-800">
                            <aside class="flex flex-col mr-10 opacity-50">
                                <header>
                                    <h2 class="hover:text-blue-600 text-blue-500 font-bold">
                                        <%=task[i] %>
                                    </h2>
                                </header>
                                <article class="flex flex-row space-x-4">
                                    <span class="flex flex-row space-x-2">
                                        <h3 class="text-gray-400">
                                            Reminder:
                                        </h3>
                                        <strong class="text-blue-500">
                                            <%=remind[i] %>
                                        </strong>
                                    </span>
                                    <span class="flex flex-row space-x-2">
                                        <h3 class="text-gray-400">
                                            Due: 
                                        </h3>
                                        <strong class="text-blue-500">
                                            <%=due[i] %>
                                        </strong>
                                    </span>
                                    <strong class="hover:text-green-600 text-green-500">
                                        Done
                                    </strong>
                                </article>
                            </aside>
                            <aside class="border-l pt-4 pl-10 flex flex-row space-x-2 opacity-50">
                                <a href="cancelFinishTask?id=<%=id[i] %>">
                                    <button class=" hover:text-red-800 text-red-400 underline underline-offset-2 py-2 px-2 rounded" value=<%=id[i] %>>
                                        Cancel
                                    </button>
                                </a>
                            </aside>
                        </section>
                <%
                        }
                    }
                %>
                    </section>
                </section>
                <section class="p-4 border rounded-xl shadow-lg flex flex-col mr-10 mb-10 md:min-w-screen">
                    <h3 class="text-2xl text-blue-500 font-bold mb-4">
                        Add a new Task
                    </h3>

                    <form class=" flex flex-row space-x-4" method="post" action="addTask">
                        <input name="task" class="placeholder-gray-400 p-2 border-2 border-gray-400 rounded-lg hover:border-blue-500 focus:border-blue-500 focus:outline-none text-blue-500"  type="text" placeholder="New Task">
                        <section class="hover:text-blue-200 bg-blue-500 p-2 rounded-lg text-white flex flex-col">
                            <span class="font-bold">
                                <label for="remind_time">Reminder Date</label>
                            </span>
                            <input name="remind_time" id="remind_time"class="bg-blue-500" type="datetime-local">
                        </section>
                        <section class="hover:text-blue-200 bg-blue-500 p-2 rounded-lg text-white flex flex-col">
                            <span class="font-bold">
                                <label for="due_time">Due Date</label>
                            </span>
                            <input name="due_time" id="due_time"class="bg-blue-500" type="datetime-local">
                        </section>
                        <button class="py-2 px-4 text-white font-semibold bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500 rounded-lg shadow-lg">
                            Add Task
                        </button>
                    </form>
                </section>
            </article>
            <footer class="text-gray-800 border-t mr-10 pt-10 mt-10">
                <div class="container mx-auto">
                    <p class="text-sm">&copy; 2024 Gestion. All Rights Reserved to ETU2876</p>
                </div>
            </footer>
        </main>

    </div>

</body>

</html>
<script>
    const inputField = document.querySelector('input');
    inputField.addEventListener('focus', () => {
        inputField.classList.add('border-blue-500');
    });
    inputField.addEventListener('blur', () => {
        inputField.classList.remove('border-blue-500');
    });
</script>