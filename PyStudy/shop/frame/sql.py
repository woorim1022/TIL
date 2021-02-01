class Sql:
    userlist = 'SELECT * FROM usertb;'
    user = "SELECT * FROM usertb WHERE id='%s';"
    insertuser = "INSERT INTO usertb VALUES ('%s','%s','%s');"
    userdelete = "DELETE FROM usertb WHERE id='%s';"
    userupdate = "UPDATE usertb SET pwd='%s', name='%s' WHERE id='%s';"

    itemlist = "SELECT * FROM itemtb";
    itemlistone = "SELECT * FROM itemtb WHERE id=%d";
    iteminsert = "INSERT INTO itemtb VALUE (null,'%s',%d,CURRENT_DATE(),'%s')";
    itemupdate = "UPDATE itemtb SET name='%s',price=%d, imgname='%s' WHERE id=%d";
    itemdelete = "DELETE FROM itemtb WHERE id=%d";
