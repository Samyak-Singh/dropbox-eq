Inorder to run this Application you will need
1) IntelliJ IDE 
2) Maven 
3) Java 17 (Azul 17 JDK)
4) MYSQL (Server version: 8.0.35 MySQL Community Server - GPL) 


Use commands mentioned in  database.sql file to create a database and a user in your mysql terminal
(Note: Please crosscheck host and port of mysql, and change in application.properties if necessary )



Once Appplication is build via maven using 
1) mvn clean install 
2) Trigger the curl command in cmd using this format
   3) curl http://localhost:8080/files/upload -d binaryData=1010101 -d fileName=dropboxEqFirstFile -d size=324 -d fileType=.txt
