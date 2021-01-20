st = [
    {'id':'st1', 'ko':90, 'en':100, 'ma':99},
    {'id':'st2', 'ko':91, 'en':90, 'ma':98},
    {'id':'st3', 'ko':92, 'en':91, 'ma':97}
];

# 학생 별 성적 평균과
# 전체 학생의 과목 별 평균을 출력하시오

kosum = 0;
ensum = 0;
masum = 0;
for sts in st:
    cnt = 0;
    sum = 0;
    student = sts.values();
    kosum += sts.get('ko');
    ensum += sts.get('en');
    masum += sts.get('ma');
    for score in student:
        if type(score) == str:
            continue;
        else:
            cnt += 1;
            sum += score;
    print(sum / cnt);
print('----------------')
print(kosum / len(st));
print(ensum / len(st));
print(masum / len(st));
