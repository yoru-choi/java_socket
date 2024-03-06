FROM ubuntu:latest
LABEL authors="choi_yeol"

ENTRYPOINT ["java", "-jar", "/build/libs/socket-0.0.1-SNAPSHOT.jar"]
