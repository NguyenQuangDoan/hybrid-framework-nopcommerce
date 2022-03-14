set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent: "%ProjectPath%libAllure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libExtendV5\*;%ProjectPath%libLog4j\*;%ProjectPath%libReportNG\*;%ProjectPath%libSelenium\*;%ProjectPath%libWebDriverManager\*" org.testng.TestNG "%ProjectPath%bin\runNopcommerceTestcasesUser.xml"
pause