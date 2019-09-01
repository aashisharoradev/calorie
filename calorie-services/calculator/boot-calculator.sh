#!/bin/sh
cd /calculator
mvn clean install
java -jar ./target/calculator*.jar