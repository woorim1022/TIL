from django.shortcuts import render

# Create your views here.
def main(request):
    return render(request, 'main.html');

def table(request):
    return render(request, 'table.html');

def resume(request):
    return render(request, 'resume.html');

def multi(request):
    return render(request, 'multi.html');


def myresume(request):
    fname = request.GET.get('fname','')
    lname = request.GET.get('lname','')
    gender = request.GET.get('gender','')
    text = request.GET.get('text','')
    return render(request, 'myresume.html', {'fname':fname,'lname':lname,'gender':gender,'text':text})
