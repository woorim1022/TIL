from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from board.models import Board
from board.serializers import BoardSerializer
from rest_framework.parsers import JSONParser

def index(request):
    return render(request,'index.html')

def list(request):
    datalist = Board.objects.all()
    print(datalist)
    if request.method == 'GET': # get방식으로 연결이 들어오면
        # json 형식으로 전송할 수 있도록 직렬화작업
        print('test========')
        serializer = BoardSerializer(datalist,many=True) # 직렬화, many=True => 여러개의 데이터 들어간다는 의미
        print(serializer)
        return JsonResponse(serializer.data, safe=False, json_dumps_params={'ensure_ascii':False}) # serializer안에 들어있는 데이터를 json 형식으로 바꿔서 리턴

# 클라이언트(안드로이드)에서 넘어오는 데이터를 가지고 작업 - 데이터가 json 형식으로 전달
def login(request):
    if request.method == 'POST':
        print("request_ok")
        data = JSONParser().parse(request)
        print(data)
        boardNo = data['boardNo']
        print(boardNo)
        obj = Board.objects.get(boardNo=int(boardNo))
        print(obj)
        # 패스워드 비교
        if data['writer'] == obj.writer:
            return JsonResponse("ok",safe=False, json_dumps_params={'ensure_ascii':False})
        else:
            return JsonResponse("fail", safe=False, json_dumps_params={'ensure_ascii': False})

# 원래 배운 방법으로 화면에 데이터 전송하는 메서드
# def list(request):
#     rsBoard = Board.objects.all() # 자동으로 만들어서 테스트 할 수 있음
#     print(rsBoard)
#     context = {
#         "rsBoard":rsBoard
#     }
#     return render(request,"board_list.html",context)



def cctv(request):
    return render(request, 'mqtt.html')