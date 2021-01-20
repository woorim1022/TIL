import sqlite3;

con = None;
cursor = None;

def connectDB(dbName):
    "Connect SQLite..."
    global con, cursor;

    con = sqlite3.connect(dbName);
    cursor = con.cursor();
    print('SQLite connected...');

def makeTable():
    "Make users Table"

    # cursor.execute("""
    #     create table if not exists users (
    #         id CHAR(16) primary key,
    #         pwd CHAR(16),
    #         name CHAR(10),
    #         phone CHAR(15),
    #         addr CHAR(20),
    #         age NUMBER(3));
    #     """);
    # print('Table Created..')

def insertUser(user):
    "Insert User Data"

    insetSQL = """Insert into users values ('%s','%s','%s','%s','%s','%d')""" % \
               (user[0],user[1],user[2],user[3],user[4],user[5]);

    cursor.execute(insetSQL);
    con.commit();

def selectOneUser(id):
    "Select One User"
    user = [];
    selectOneSQL = """select * from users where id='%s'""" % (id);
    cursor.execute(selectOneSQL);

    ######한개의 데이터를 가지고 올때는 fetchone()으로 커서를 한 칸 이동시켜야 한다#####
    ######데이터를 execute()하면 가지고 오고자 하는 데이터의 이전 데이터를 가지고있음###
    ######fetchone()으로 한 칸 이동해서 원하는 데이터를 가리킨 뒤 꺼내야한다##########
    userData = cursor.fetchone();
    ###########################################################################

    user.append(userData[0]);
    user.append(userData[1]);
    user.append(userData[2]);
    user.append(userData[3]);
    user.append(userData[4]);
    user.append(userData[5]);
    return user;

def deleteUser(id):
    "Delete One User"
    deleteSQL = """delete from users where id='%s'""" % (id);
    cursor.execute(deleteSQL);
    con.commit();

def updateUser(user):
    "Update One User"
    updateSQL = """update users set pwd='%s',name='%s',phone='%s',addr='%s',age=%d where id='%s'""" \
                % (user[1],user[2],user[3],user[4],user[5],user[0]);
    cursor.execute(updateSQL);
    con.commit();

def selectUser():
    "Select User Data"
    global con, cursor;

    cursor.execute('select * from users');
    allusers = cursor.fetchall();
    return allusers;

def closeDB():
    "Close SQLite"

    if cursor != None:
        cursor.close();
    if con != None:
        con.close();