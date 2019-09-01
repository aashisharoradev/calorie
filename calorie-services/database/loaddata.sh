#!/bin/bash

/opt/mssql/bin/sqlservr > /dev/null &
sleep 30
/opt/mssql-tools/bin/sqlcmd -S 'localhost' -U 'sa' -P 'F00dieData' -d  'master' -i /dbboot/food.sql

for (( ; ; ))
do
   echo "Pres CTRL+C to stop..."
   sleep 1
done