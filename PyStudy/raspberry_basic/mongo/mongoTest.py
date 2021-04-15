from pymongo import MongoClient;

#mongodb 접속
# mongo_uri = "mongodb://192.168.234.209:27017";
# client = MongoClient(mongo_uri);
client = MongoClient("192.168.0.197", 27017);
print(client.list_database_names());

# 사용할 데이터베이스 접속
# db = client.mydb
db = client["mydb"];
print(db.list_collection_names());

# collection 접근
# my_collection = db.exam
my_collection = db["exam"];
print(my_collection.name);

# CRUD 메소드 테스트
result = my_collection.find_one();
print(result);