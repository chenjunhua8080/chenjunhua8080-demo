FROM openjdk:8

EXPOSE 8080

#RUN mkdir /root/raptor

COPY target/jenkins-docker-demo-*.jar /app/jenkins-docker-demo.jar
COPY service_start.sh /service_start.sh


RUN chmod +x service_start.sh ;\
    mkdir -p /root/signum

CMD ["/service_start.sh"]
