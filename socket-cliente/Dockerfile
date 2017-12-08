FROM payara/micro
COPY target/socket-cliente-jar-with-dependencies.jar socket.jar
ENTRYPOINT ["java", "-jar", "socket.jar"]