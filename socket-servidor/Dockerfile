FROM payara/micro
COPY target/socket-servidor-jar-with-dependencies.jar socket.jar
ENTRYPOINT ["java", "-jar", "socket.jar"]