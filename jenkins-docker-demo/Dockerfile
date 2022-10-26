FROM openjdk:8

#RUN mkdir /root/raptor

COPY target/jenkins-docker-demo-*.jar /app/jenkins-docker-demo.jar
COPY service_start.sh /service_start.sh


RUN chmod +x service_start.sh ;\
    mkdir -p /root/signum

EXPOSE 8080

CMD ["/service_start.sh"]
