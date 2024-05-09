set source="C:\Users\Pyvas\OneDrive\Documents\C-ITU-Files-L2\S4\ITU-S4-06-Reseaux\CRUD_Project_2\src\"
set servlet_library="C:\xampp\tomcat\lib\servlet-api.jar"
set postgre_library="C:\xampp\tomcat\lib\postgresql-42.2.24.jar"
set init_xml="C:\Users\Pyvas\OneDrive\Documents\C-ITU-Files-L2\S4\ITU-S4-06-Reseaux\CRUD_Project_2\web.xml"
set init_jsp="C:\Users\Pyvas\OneDrive\Documents\C-ITU-Files-L2\S4\ITU-S4-06-Reseaux\CRUD_Project_2\*.jsp"
set init_lib="C:\Users\Pyvas\OneDrive\Documents\C-ITU-Files-L2\S4\ITU-S4-06-Reseaux\CRUD_Project_2\lib"
set init_class="C:\Users\Pyvas\OneDrive\Documents\C-ITU-Files-L2\S4\ITU-S4-06-Reseaux\CRUD_Project_2\src\*.class"
set webapps="C:\xampp\tomcat\webapps\"
set Temp="C:\Users\Pyvas\OneDrive\Documents\C-ITU-Files-L2\S4\ITU-S4-06-Reseaux\CRUD_Project_2\Temp\"
set WEB-INF="C:\Users\Pyvas\OneDrive\Documents\C-ITU-Files-L2\S4\ITU-S4-06-Reseaux\CRUD_Project_2\Temp\WEB-INF\"
set WEB-INF-classes="C:\Users\Pyvas\OneDrive\Documents\C-ITU-Files-L2\S4\ITU-S4-06-Reseaux\CRUD_Project_2\Temp\WEB-INF\classes\"
set WEB-INF-lib="C:\Users\Pyvas\OneDrive\Documents\C-ITU-Files-L2\S4\ITU-S4-06-Reseaux\CRUD_Project_2\Temp\WEB-INF\lib\"

rmdir /s /q %Temp%

mkdir %Temp%
mkdir %WEB-INF%
mkdir %WEB-INF-classes%
mkdir %WEB-INF-lib%

cd %source%
javac -cp %servlet_library%;%postgre_library%  *.java

xcopy %init_jsp% %Temp%
xcopy %init_xml% %WEB-INF%
xcopy %init_lib%  %WEB-INF-lib%
xcopy %init_class% %WEB-INF-classes%
del %init_class *.class

cd %Temp%

rem jar cvf crud.war

rem xcopy crud.war %webapps%