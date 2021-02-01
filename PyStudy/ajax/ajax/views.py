from django.http import JsonResponse, HttpResponse
from django.shortcuts import render

# Create your views here.
def getuser(request):
    users = [
                {'id':'id01','name':'james1','age':10},
                {'id':'id02','name':'james2','age':20},
                {'id':'id03','name':'james3','age':30},
                {'id':'id04','name':'james4','age':40},
                {'id':'id05','name':'james5','age':50}
            ];
    context = {
        'datas':users
    }
    return JsonResponse(context)


def getid(request):
    id = request.GET['id']
    if id == 'aaa' or id == 'bbb':
        return HttpResponse('1')
    else:
        return HttpResponse('0')

def graph(request):
    datas = [
                ['Shanghai', 24.2],
                ['Beijing', 20.8],
                ['Karachi', 14.9],
                ['Shenzhen', 13.7],
                ['Guangzhou', 13.1],
                ['Istanbul', 12.7],
                ['Mumbai', 12.4],
                ['Moscow', 12.2],
                ['São Paulo', 12.0],
                ['Delhi', 11.7],
                ['Kinshasa', 11.5],
                ['Tianjin', 11.2],
                ['Lahore', 11.1],
                ['Jakarta', 10.6],
                ['Dongguan', 10.6],
                ['Lagos', 10.6],
                ['Bengaluru', 10.3],
                ['Seoul', 9.8],
                ['Foshan', 9.3],
                ['Tokyo', 9.3]
            ]
    context = {
        'datas': datas
    }
    return JsonResponse(context)
