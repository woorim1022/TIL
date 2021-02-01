from django.http import HttpResponseRedirect
from django.shortcuts import render, redirect

from frame.error import ErrorCode
from frame.itemdb import ItemDb
from frame.userdb import UserDb
from frame.value import User
from django.utils.http import urlencode


def userlist(request):
    rsuserlist = UserDb().select();
    context = {
        'section':'shop2/userlist.html',
        'rsusers':rsuserlist
    };
    return render(request, 'shop2/shop2.html',context)

def userdetail(request):
    id  = request.GET['id'];
    rsuser = UserDb().selectone(id)
    context = {
        'section': 'shop2/userdetail.html',
        'rsuser': rsuser
    };
    return render(request, 'shop2/shop2.html',context)

def useradd(request):
    context = {
        'section': 'shop2/useradd.html'
    };
    return render(request, 'shop2/shop2.html',context)

def useraddimpl(request):
    id = request.POST['id'];
    pwd = request.POST['pwd'];
    name = request.POST['name'];
    user = User(id, pwd, name)
    try:
        UserDb().insert(user)
    except:
        context = {
            'section': 'shop2/useradd.html',
            'message': ErrorCode.e0001
        };
        return render(request, 'shop2/shop2.html',context)
    context = {
        'section':'userdetail',
        'rsuser': user
    };
    return render(request, 'shop2/shop2.html',context)

def userupdateimpl(request):
    id = request.POST['id'];
    pwd = request.POST['pwd'];
    name = request.POST['name'];
    user = User(id, pwd, name)
    try:
        UserDb().update(id, pwd, name)
    except:
        context = {
            'section': 'shop2/userupdate.html',
            'message': ErrorCode.e0003
        };
        return render(request, 'shop2/shop2.html',context)
    return redirect('userlist')

def userdelete(request):
    id = request.GET['id'];
    try:
        UserDb().delete(id)
    except:
        context = {
            'section': 'shop2/error.html',
            'error': ErrorCode.e0002
        };
        return render(request, 'shop2/shop2.html',context)
    return redirect('userlist')

def userupdate(request):
    id = request.GET['id'];
    user = UserDb().selectone(id)
    context = {
        'section': 'shop2/userupdate.html',
        'uuser': user
    };
    return render(request, 'shop2/shop2.html',context)






class ItemView:
    def itemlist(request):
        items = ItemDb().select()
        context = {
            'section': 'shop2/itemlist.html',
            'itemlist':items,
        };
        return render(request, 'shop2/shop2.html',context)


    def itemadd(request):
        context = {
            'section': 'shop2/itemadd.html'
        };
        return render(request, 'shop2/shop2.html',context)


    def itemupdate(request):
        id = request.GET['id']
        item = ItemDb().selectone(int(id))
        context = {
            'section': 'itemupdate'
        }
        return render(request, 'shop.shop.html', context)

    def itemupdateimpl(request):
        id = request.POST['id']
        name = request.POST['name']
        price = request.POST['price']
        img = request.POST['img']
        imgname = '';
        if 'newimg' in request.FILES:
            newimg = request.FLLES['newimg']
            imgname = newimg._name

            fp = open('%s/%s' % (UPLOAD_DIR, imgname), 'wb')
            for chunk in newimg.chunks():
                fp.write(chunk)
                fp.close()
        else:
            imgname = img

        ItemDb().update(int(id), name, int(price), imgname)
        qstr = urlencode({'id':id})
        return HttpResponseRedirect('%s?%s' % ('itemdetail', qstr))
