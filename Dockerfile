FROM openjdk:17
EXPOSE 8080
ADD target/userdemo.jar userdemo.jar
ENTRYPOINT [ "java", "-jar" ,"userdemo.jar" ]