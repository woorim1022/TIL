#  Django-rest-framework

### 패키지명

TIL/Pystudy/raspberryWeb



### 설치할 패키지

pip install djangorestframework

pip install django-filter



### settings.py

```python
INSTALLED_APPS = [
    ...
    'rest_framework',
]

ALLOWED_HOSTS = ['*']

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.mysql',
        'NAME': 'mydb',
        'USER': 'root',
        'PASSWORD': '111111',
        'HOST': '127.0.0.1',
        'PORT': '3306',
    }
}

REST_FRAMEWORK = {
    # Use Django's standard `django.contrib.auth` permissions,
    # or allow read-only access for unauthenticated users.
    'DEFAULT_PERMISSION_CLASSES': [
        'rest_framework.permissions.DjangoModelPermissionsOrAnonReadOnly'
    ]
}

```



### Edit configurations 

* Script path 
  * 패키지\manage.py
* Parameters
  * runserver 0.0.0.0:8000
* pc ip주소:8000 으로 접속 가능

---> 파이썬 파일 실행하면 바로 runserver되게 하기 위한 작업







### models.py

```python
from django.db import models

# Create your models here.
class Board(models.Model):
    boardNo = models.AutoField(db_column='boardNo', primary_key=True)
    title = models.CharField(db_column='title', max_length=255)
    content = models.TextField(db_column='content', ) # 글자제한 x
    writer = models.CharField(db_column='writer', max_length=50) # 글자제한 o
    write_date = models.DateField(db_column='write_date', )

    class Meta:
        managed = False
        db_table = 'board'

    def __str__(self):
        return "제목 : " + self.title + ", 작성자 : " + self.writer

```





###  직렬화

* 데이터를 패킷 단위로 쪼개서 보내는 것
* 역직렬화 : 직렬화 한 데이터를 다시 합치는 것
* 직접 하지 않고 프레임워크에서 직렬화 작업해줌