FROM centos

MAINTAINER Taichi Uragami <backpaper0@gmail.com>

ENV PAYARA_URL https://s3-eu-west-1.amazonaws.com/payara.co/Payara+Downloads/payara-micro-4.1.152.1.jar
ENV JAVAYOU_URL=https://github.com/backpaper0/java-you.git
ENV JAVAYOU_DIR=java-you

RUN \
 yum install -y wget git java-1.8.0-openjdk-devel && \
 wget $PAYARA_URL && \
 git clone $JAVAYOU_URL && \
 ./$JAVAYOU_DIR/gradlew -p ./$JAVAYOU_DIR build

ENTRYPOINT ["java", "-jar", "payara-micro-4.1.152.1.jar", "--deploy", "./java-you/build/libs/java-you.war"]
