from pymongo import MongoClient;

#mongodb 접속
client = MongoClient("192.168.0.197", 27017);

# 사용할 데이터베이스 접속
db = client["mydb"];
# collection 접근
my_collection = db["exam"];

# 맨 위의 document 한 개만 조회하기
exam_document = my_collection.find_one();
print(exam_document);

print("=======================================================================");
# 전체 목록 조회
list_data = my_collection.find();
for my_doc in list_data:
    print(my_doc);

print("=======================================================================");
# name을 기준으로 오름차순 정렬
list_data = my_collection.find().sort("name", 1);
for my_doc in list_data:
    print(my_doc);

print("=======================================================================");
# 조건에 따라 조회하기
# my_query = {"java":{"$gt":90}};
my_query = {"subject":['java', 'python']};
list_data = my_collection.find(my_query);
for my_doc in list_data:
    print(my_doc);