fligtList = []; # 예약 가능한 항공편 리스트
allPoint = {};  # 전체 사용자의 보유 포인트
allRes = [];    # 전체 사용자의 예매내역
resIndex = 0;   # allRes의 인덱스

# 항공편 데이터 삽입
def insertData():
    fligtList.append(['k1111','2021년 1월 11일','서울/제주','50000','100000','200000']);
    fligtList.append(['k2222','2021년 1월 12일','서울/제주','50000','100000','200000']);
    fligtList.append(['k3333','2021년 1월 13일','서울/제주','50000','100000','200000']);
    fligtList.append(['k4444','2021년 1월 14일','서울/제주','50000','100000','200000']);

# 항공권 예약
# 항공번호, 인원수, 좌석종류(이코노미/비즈니스/퍼스트) 입력
# 결제 방법 선택 가능(포인트/돈)
# 예약 정보 리턴
def reservation(userID):

    # 초기화
    point = 0;
    resInfo = [];
    seatPrice = 0;
    if allPoint.get(userID) == None:
        allPoint[userID] = '';
    else:
        point = int(allPoint[userID]);

    # 항공편 리스트 출력
    for i in fligtList:
        print('항공번호: %s \n날짜: %s \n출발/도착지: %s \n가격: 이코노미%s 비즈니스%s 퍼스트%s\n' % (i[0],i[1],i[2],i[3],i[4],i[5]));

    # 항공번호, 인원수, 좌석종류(이코노미/비즈니스/퍼스트) 사용자에게 입력받자
    inputRes = input('예약할 항공권의 항공번호, 인원, 좌석종류(이코노미/비즈니스/퍼스트)를 선택하세요: \n').split();
    flightNum = inputRes[0];
    peopleNum = int(inputRes[1]);
    seatType = inputRes[2];
    for i in fligtList:
        if flightNum == i[0]:
            if seatType == '이코노미':
                seatPrice = int(i[3]);
            elif seatType == '비즈니스':
                seatPrice = int(i[4]);
            elif seatType == '퍼스트':
                seatPrice = int(i[5]);
    totalPrice = seatPrice*peopleNum;

    # 결제
    # 총 결제 금액 = 1좌석당 가격 * 인원수
    # 포인트 적립 금액 = 총 결제 금액 * 0.1
    print();
    print('%s 항공편 %d명 예약, ' % (flightNum, peopleNum));
    print('총 결제 금액은 %d 원 입니다.' % (totalPrice));
    print();
    while True:
        # 결제 방법 선택
        paymentOption = input('결제 방법을 선택하세요(포인트/돈): ');
        # 결제 방법으로 포인트를 선택한 경우
        if paymentOption == '포인트':
            if totalPrice > point:
                print('포인트 부족, 결제불가');
                continue;
            else:
                point -= totalPrice;
                allPoint[userID] = point;
                print('결제가 완료되었습니다. 잔여 포인트는 %d 포인트 입니다.' % (point));
                print('예약 완료');
                break;
        # 결제 방법으로 돈을 선택한 경우
        elif paymentOption == '돈':
            point += round(totalPrice*0.1);
            allPoint[userID] = point;
            print('%d 포인트가 적립되었습니다, 총 보유 포인트는 %d 포인트 입니다. ' % (round(totalPrice*0.1), point));
            print('결제가 완료되었습니다.');
            print('예약 완료');
            break;

    resInfo.append(flightNum);
    resInfo.append(peopleNum);
    resInfo.append(seatType);
    return resInfo;

# 데이터베이스(?)에 예약정보 삽입
def insertRes(userID, resInfo):
    global resIndex;
    allRes.append([]);
    allRes[resIndex].append(userID);
    allRes[resIndex].append(resInfo);
    resIndex += 1;

# 현재 로그인한 사용자의 예매내역 확인
def viewRes(userID):
    print('%s님의 예매 내역' % (userID));
    for i in allRes:
        if i[0] == userID:
            print('항공번호 : %s 인원 수 : %d 좌석종류 : %s' % (i[1][0], i[1][1], i[1][2]));

# 예약 취소
def cancelRes(userID):
    viewRes(userID);
    cancelFlight = input('취소할 항공편의 항공번호를 입력하세요: ');
    for i in range(0, len(allRes)):
        if allRes[i][0] == userID:
            if allRes[i][1][0] == cancelFlight:
                del(allRes[i]);
    viewRes(userID);

# 현재 로그인한 사용자의 보유 포인트 확인
def viewPoint(userID):
    if allPoint.get(userID) == None:
        print('총 보유 포인트 : 0원');
    else:
        print('총 보유 포인트 : %d원' % (allPoint[userID]));


print('start');

while True:
    print('========================================================');
    userID = input('아이디 : ');
    inGame = input('항공권 예매 페이지 이동(s), 종료(q) : ');

    if inGame == 'q':
        break;
    elif inGame == 's':
        insertData();
        chooseMenu = input('예약하기(s), 예약확인(v), 예약취소(d), 포인트확인(p) : \n');
        if chooseMenu == 's':
            res = reservation(userID);
            insertRes(userID, res);
        elif chooseMenu == 'v':
            viewRes(userID);
        elif chooseMenu == 'd':
            cancelRes(userID);
        elif chooseMenu == 'p':
            viewPoint(userID);
    else:
        print('잘못 입력하셨습니다, 다시 입력하세요.');

print('end');

