from pymongo import MongoClient;

#mongodb 접속
client = MongoClient("192.168.0.197", 27017);

# 사용할 데이터베이스 접속
db = client["mydb"];
# collection 접근
my_collection = db["exam"];

result = my_collection.remove({"java":{"$gt":90}});
print(result);