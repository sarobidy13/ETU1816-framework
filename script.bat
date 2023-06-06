
javac *.java
cd "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\Framework\Framework"
jar cvf framework.jar *
move "./framework.jar" "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\Framework\testFramework\WEB-INF\lib"
cd "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\Framework\testFramework"
jar cvf "testFramework.war" *
move "testFramework.war" "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps"
