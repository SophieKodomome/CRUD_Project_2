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
                    Welcome &#128151
                </h1>
            </header>
            <article>
                <section class="p-4 border rounded-xl shadow-lg flex flex-col mr-40 mb-10 md:min-w-screen">
                    <h3 class="text-2xl text-blue-500 font-bold mb-4">
                        Log here
                    </h3>

                    <form class=" flex flex-col space-y-4" method="post" action="loginServlet">
                        <input name="user_name" class="placeholder-gray-400 p-2 border-2 border-gray-400 rounded-lg hover:border-blue-500 focus:border-blue-500 focus:outline-none text-blue-500"  type="text" placeholder="Your name">
                        <input name="passWord" class="placeholder-gray-400 p-2 border-2 border-gray-400 rounded-lg hover:border-blue-500 focus:border-blue-500 focus:outline-none text-blue-500"  type="text" placeholder="Your password">
                        <button class="py-2 px-4 text-white font-semibold bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500 rounded-lg shadow-lg">
                            Login
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