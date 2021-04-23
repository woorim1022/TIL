from django.contrib import admin
from django.urls import path
from django.conf.urls import url,include
from board import views


urlpatterns = [
    path('', views.index, name="index"),
    path('list', views.list, name="list"),
    path('login', views.login, name="login"),
]
