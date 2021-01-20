f = None;
f = open('text.txt','rt',encoding='UTF-8');
# 4 바이트를 건너뛰어서 파일을 읽어들인다는 의미
# 1바이트당 알파벳 1개
# UTF-8에서는 3바이트당 한글 1자
# (3의 배수가 아니면 에러가 난다 ㄷㄷ 깨진다)
f.seek(3,0);
text = f.read();

# 한글의 길이는 한 글자 단위로 읽어들인다(3byte 당 len 1)
print(len(text));

print(text);