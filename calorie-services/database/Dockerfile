# mssql-agent-fts-ha-tools
# Maintainers: Microsoft Corporation (twright-msft on GitHub)
# GitRepo: https://github.com/Microsoft/mssql-docker

# Base OS layer: Latest Ubuntu LTS
FROM ubuntu:16.04

# Install prerequistes since it is needed to get repo config for SQL server
RUN export DEBIAN_FRONTEND=noninteractive && \
    apt-get update && \
    apt-get install -yq curl apt-transport-https && \
    # Get official Microsoft repository configuration
    curl https://packages.microsoft.com/keys/microsoft.asc | apt-key add - && \
    curl https://packages.microsoft.com/config/ubuntu/16.04/mssql-server-2017.list | tee /etc/apt/sources.list.d/mssql-server.list && \
    apt-get update && \
    # Install SQL Server from apt
    apt-get install -y mssql-server && \
    # Install optional packages
    apt-get install -y mssql-server-ha && \
    apt-get install -y mssql-server-fts && \
    # Cleanup the Dockerfile
    apt-get clean && \
    rm -rf /var/lib/apt/lists

RUN curl https://packages.microsoft.com/keys/microsoft.asc | apt-key add -
RUN curl https://packages.microsoft.com/config/ubuntu/16.04/prod.list > /etc/apt/sources.list.d/mssql-release.list

# install SQL Server drivers and tools
RUN apt-get update && ACCEPT_EULA=Y apt-get install -y msodbcsql mssql-tools
RUN echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bashrc
RUN /bin/bash -c "source ~/.bashrc"



RUN apt-get -y install locales
RUN locale-gen en_US.UTF-8
RUN update-locale LANG=en_US.UTF-8

RUN mkdir /dbboot
COPY ./food.sql /dbboot/food.sql

COPY ./loaddata.sh /dbboot/loaddata.sh

CMD /dbboot/loaddata.sh