FROM ubuntu:16.04

RUN apt-get update -y && \
    apt-get install -y curl

RUN curl -sL https://deb.nodesource.com/setup_12.x | bash -

RUN apt-get install -y nodejs

RUN mkdir /scripts

COPY boot-ui.sh /scripts

EXPOSE 3000
