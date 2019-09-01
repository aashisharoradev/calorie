#!/bin/sh
cd /discovery
mvn clean install
java -jar ./target/discovery*.jar