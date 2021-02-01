"""config URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include

from hello import views

urlpatterns = [
    path('admin/', admin.site.urls),
    # 최초에 아무것도 안치고 들어오면 보여질 페이지
    # views 라는 파이썬 파일 안에 home 이 동작하게 해줘
    path('', views.home, name='home'),
    path('page2', views.page2),
    path('page3', views.page3),
    path('page4', views.page4),
    path('page5', views.page5),
    path('page6', views.page6),
    path('register', views.register, name='register'),
    path('multi', views.multi, name='multi'),
]
