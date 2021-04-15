from pymongo import MongoClient;

#mongodb 접속
# mongo_uri = "mongodb://192.168.234.209:27017";
# client = MongoClient(mongo_uri);
client = MongoClient("192.168.0.197", 27017);
print(client.list_database_names());

# 사용할 데이터베이스 접속
db = client["mydb"];
# collection 접근
my_collection = db["exam"];

# CRUD 메소드 테스트
# my_collection.insert_one({"name": "장동건", "age": 40,
#                                    "subject":["java","python"]});

my_data = [
    {"name": "이민호", "age": 40, "subject":["java","python"]},
    {"name": "김어준", "age": 40, "subject":["raspberry","python"]},
    {"name": "김서연", "age": 40, "subject":["mongo","python"]},
]
result = my_collection.insert_many(my_data);
print(result);