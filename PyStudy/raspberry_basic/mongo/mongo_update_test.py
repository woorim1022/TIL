from pymongo import MongoClient;

#mongodb 접속
client = MongoClient("192.168.0.197", 27017);

# 사용할 데이터베이스 접속
db = client["mydb"];
# collection 접근
my_collection = db["exam"];

my_collection.update_many({"name":"장동건"},{"$set":{"age":50}});