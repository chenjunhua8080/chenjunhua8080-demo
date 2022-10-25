FROM openjdk:8

#RUN mkdir /root/raptor

COPY target/jenkins-docker-demo-*.jar /app/jenkins-docker-demo.jar
COPY src/main/resources /src/main/resources

CMD ["java -Dserver.port=80 -jar /app/jenkins-docker-demo.jar --spring.profiles.active=dev"]
