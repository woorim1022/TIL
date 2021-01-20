# CART 구현
#
# 1. 상품이름, 가격, 개수
# 2. 위의 항목을 입력 받아서 CART에 넣는다.

# Application
# 1. menu - 1. (i)cart에 넣기 2. (v)cart 정보 보기


def viewCart(cart):
    ptotal = 0;
    ctotal = 0;
    num = 0;
    for item in cart:
        ptotal += item[1];
        ctotal += item[2];
        print('%d번 상품(이름/가격/개수): %s %d %d' % (num+1, item[0],
                                        item[1],
                                        item[2]));
        num += 1;
    print('Total: %d %d' % (ptotal, ctotal));

print('start');

cart = [];
while True:
    menu = input('menu(i / v / q / r): ');
    if menu == 'i':
        item = input('상품이름 가격 개수: ');
        itemlist = item.split(' ');
        itemlist[1] = int(itemlist[1]);
        itemlist[2] = int(itemlist[2]);
        cart.append(itemlist);
    elif menu == 'v':
        viewCart(cart);
    elif menu == 'q':
        print('bye');
        break;
    elif menu == 'r':
        # 삭제 하고자 하는 item명을 입력받는다
        # 입력받은 item이 cart에 존재 하는지 확인한다
        # 존재하면 삭제한다.
        itemname = input('삭제할 상품 이름: ');
        for citem in cart:
            if itemname in citem:
                cart.remove(citem);
                print(citem[0]+'삭제 되었습니다');

print('end');


