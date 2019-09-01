FROM ubuntu:16.04

RUN apt-get update -y && \
    apt-get install -y default-jdk && \
    apt-get install -y maven

RUN mkdir /scripts

COPY ./boot-discovery.sh /scripts

EXPOSE 8761