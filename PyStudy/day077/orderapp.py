from orderutil_class import OrderDb;
from ordervalue import Order;

print('Start ....')

orderDb = OrderDb('order.db')
orderDb.makeTable()

while True:
    menu = input('***주문테이블구성***\n'
                 '주문추가(i)\n'
                 '주문정보전체조회(a)\n'
                 '주문번호조회(s)\n'
                 '주문삭제(d)\n'
                 '주문수정(u)\n'
                 '나가기(q)');
    menu = menu.lower()
    if menu == 'q':
        print('Bye')
        break

    #주문 추가
    if menu == 'i':
        orderInfo = input('추가할 주문정보를 입력하세요\n'
                     'userid, itemid, price, qt\n'
                     '(띄어쓰기기준)').split(' ')
        serialNum = orderDb.serialCnt()
        orderObj = Order(serialNum,
                         serialNum[:8],
                         orderInfo[0],
                         orderInfo[1],
                         int(orderInfo[2]),
                         int(orderInfo[3]))
        orderDb.insertOrder(orderObj)

    #주문정보 전체 조회
    if menu =='a':
        allOrders = orderDb.selectOrder()
        for o in allOrders:
            print("주문번호: %s,주문날짜: %s,사용자id: %s,제품id: %s,가격: %s,수량: %s" % (o.id,
                                         o.date,
                                         o.userid,
                                         o.itemid,
                                         o.price,
                                         o.qt))

    #주문정보 한개 조회
    if menu == 's':
        id = input('조회하실 주문번호를 입력해주세요')
        oneOrder = orderDb.selectOneOrder(id)
        print("주문번호: %s,주문날짜: %s,사용자id: %s,제품id: %s,가격: %s,수량: %s" % (oneOrder.id,
                                                                      oneOrder.date,
                                                                      oneOrder.userid,
                                                                      oneOrder.itemid,
                                                                      oneOrder.price,
                                                                      oneOrder.qt))

    # 주문정보 수정
    if menu == 'u':
        orderInfo = input('수정하실 주문번호와 정보를 입력해주세요\n'
                     'id, userid, itemid, price, qt\n'
                     '(띄어쓰기기준)').split(' ')
        orderObj = Order(orderInfo[0],
                         orderInfo[0][:8],
                         orderInfo[1],
                         orderInfo[2],
                         int(orderInfo[3]),
                         int(orderInfo[4]))
        orderDb.updateOrder(orderObj)

    # 주문 삭제
    if menu == 'd':
        id = input('삭제하실 주문번호를 입력하세요')
        orderDb.deleteOrder(id)


print('End ....')