#!/bin/bash
IFS="|"
while read food_id display_name
do
if [[ $display_name != *\'* ]]; then
  echo "INSERT INTO FOOD (FOOD_ID, DISPLAY_NAME) VALUES ( $food_id, '$display_name' );  "
fi

 
done < Food_Data.csv