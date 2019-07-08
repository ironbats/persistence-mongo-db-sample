# persistence-mongo-db-sample
Project to share with all peoples how work with mongoDB

An API to sent messages and save in mongo DB 


# Requirements
[JDK 8] - Minimum version of Java JDK 8


# Build project

./gradlew clean build bootRun

# Swagger UI

http://localhost:8080/swagger-ui.html

# How to Test API 

* first you need to mass of data , so

<b>
1-) Create bots 
</b>
</br>
  
<i>
{
  "id": "string",
  "name": "string"
}
 </i>
 </br>


<b>
2-) Create message bots 
</b>
</br>
<i>
{
  "timestamp": "2019-07-04T17:53:46.821Z",
 "from": "36b9f842-ee97-11e8-9443-0242ac120002",
 "to": "16edd3b3-3f75-40df-af07-2a3813a79ce9",
 "text": "Oi! Como posso te ajudar?"
}
</i>
</br>

<b>
3-) Create message anonymous
</b>

<i>
{
  "timestamp": "2019-07-04T17:53:46.821Z",
 "from": "16edd3b3-3f75-40df-af07-2a3813a79ce9",
 "to": "36b9f842-ee97-11e8-9443-0242ac120002",
 "text": "Sim , claro que pode "
}
</i>





