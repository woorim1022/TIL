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
from django.views.generic import TemplateView

from ajax import views

urlpatterns = [
    path('', TemplateView.as_view(template_name='home.html'),name='home'),
    path('aj1/', TemplateView.as_view(template_name='aj1.html'), name='aj1'),
    path('getuser/', views.getuser, name='getuser'),
    path('getid/', views.getid, name='getid'),
    path('graph/', views.graph, name='graph'),
]
