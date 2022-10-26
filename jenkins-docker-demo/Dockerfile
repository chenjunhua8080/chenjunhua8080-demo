FROM openjdk:8

#RUN mkdir /root/raptor

COPY target/jenkins-docker-demo-*.jar /app/jenkins-docker-demo.jar
COPY src/main/resources /src/main/resources

RUN chmod +x service_start.sh ;\
    mkdir -p /root/signum

CMD ["/service_start.sh"]
