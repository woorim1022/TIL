from django.shortcuts import render

# Create your views here.
from orm.models import Board


def getboard(request):
    boards = Board.objects.all();
    context = {
        'boards':boards
    }
    return render(request, 'boardlist.html', context)