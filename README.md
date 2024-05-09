K, so we want to do a planner app if we sum it all ups.
Every sunday, you are plannin your week ahead.
 Let's say each day has 5 slot of things to do for now to avoid overload
Some are weekly,daily or just one event
It reminds you to do things. You can set a reminder but it can also act on its own
When you check them "done" it gives you the little gratification sound
At the end of the week it give you that little score but you can still check them every time of the week
At a certain threshold you level up
For now let's not add account but run it all in cache
Works on web and mobile

technology:
Front Office:
-html
-tailwindcss

Back Office:
-xml
-java
-redis

To do list tracker:
Main things:
  -Have an account
  -Different to do lists(personal, proffessional, etc, etc)
  -todos has:
    -Task
    -Due Date
    -Remind date
    -Status(done, not done)
    -notes
  -todos can be interchangeable(in one category)

  Todo:(for now)

  Front Office:
  (ok)-Page de to do list(index):
    (ok)-nav side: (categories)
    (ok)-main:
      (ok)-todolists:
        -(ok)on going
        (ok)-done
        (ok)-button "modify task" (call function replaceTask)
        (ok)-button "⬆️"(call function swapTask())(update)
        (ok)-button "⬇️"(call function swapTask())(update)
        (ok)-button "delete task"(call function deleteTask())(delete)
        (ok)-button "finished"(call function finishTask())(update task)
      (ok)-Form new task:
        (ok)-Button "add" (call function addtask())(create)
  Back Office:
  -create an xml
  -class Rediscon
  -class Task
    -function replaceTask()
    -function swapTask()
    -function deleteTask()
    -function finishTask()
  -create database Todolist:
   -table todolist
    (
     id primary key auto increment,
     task string,
     order number auto increment,
     status boolean,
     remind day date-time,
     due day date-time,
     note string
     )
     

