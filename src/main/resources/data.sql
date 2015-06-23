
INSERT INTO customer(id,name,email,mobile) values(CUSTOMER_SEQ.nextVal,'Best','best@best.com','0987654321');
INSERT INTO customer(id,name,email,mobile) values(CUSTOMER_SEQ.nextVal,'Nut','nut@nut.com','0987987888');
INSERT INTO customer(id,name,email,mobile) values(CUSTOMER_SEQ.nextVal,'Ooo','o@o.com','098767878');
--INSERT INTO user(email,password) values('xx@xx.com','12345');I
INSERT INTO DEPARTMENT(id,name) values(DEPARTMENT_SEQ.nextVal,'software development');
INSERT INTO DEPARTMENT(id,name) values(DEPARTMENT_SEQ.nextVal,'software Engineering');
INSERT INTO DEPARTMENT(id,name) values(DEPARTMENT_SEQ.nextVal,'software singular');

INSERT INTO AUTHORITY(ROLES) values('add');
INSERT INTO AUTHORITY(ROLES) values('update');
INSERT INTO AUTHORITY(ROLES) values('delect');

-- INSERT INTO BANKACCOUNT(id,addcountid,addcountname,bankname,addcounttype) values(BANKACCOUNT_SEQ.nextVal,
-- '1234','xxxx','xxxx','xxxxx')
-- INSERT INTO BANKACCOUNT(id,addcountid,addcountname,bankname,addcounttype) values(BANKACCOUNT_SEQ.nextVal,
-- '5678','yyyy','yyyy','yyyy')
-- INSERT INTO BANKACCOUNT(id,addcountid,addcountname,bankname,addcounttype) values(BANKACCOUNT_SEQ.nextVal,
-- '9999','zzzz','zzzz','zzzz')

-- INSERT INTO CONTACTPERSION(id,name,telephoneNumber,relation) values(CONTACTPERSION_SEQ.nextVal,'jasin','0899899898'
-- ,'father')
-- INSERT INTO CONTACTPERSION(id,name,telephoneNumber,relation) values(CONTACTPERSION_SEQ.nextVal,'Bast','0834359988'
-- ,'father')
-- INSERT INTO CONTACTPERSION(id,name,telephoneNumber,relation) values(CONTACTPERSION_SEQ.nextVal,'Nut','0899248984'
-- ,'father')

-- INSERT INTO EMLOYEE(id,password,email,pid,nameTH,nameENG,birthday,sex,blood,soldierstatus,marrystatus,
-- nation,race,addressofpid,address,mobile,startwork,endwork,workstatus) values(user_SEQ.nextVal,'x','x','x','x','x','x','x'
-- ,'x','x','x','x','x','x','x','x','x','x','x','x')
-- INSERT INTO EMLOYEE(id,password,email,pid,nameTH,nameENG,birthday,sex,blood,soldierstatus,marrystatus,
-- nation,race,addressofpid,address,mobile,startwork,endwork,workstatus) values(user_SEQ.nextVal,'x2','x2','x2','x2','x2','x2','x2'
-- ,'x2','x2','x2','x2','x2','x2','x2','x2','x2','x2','x2','x2')
-- INSERT INTO EMLOYEE(id,password,email,pid,nameTH,nameENG,birthday,sex,blood,soldierstatus,marrystatus,
-- nation,race,addressofpid,address,mobile,startwork,endwork,workstatus) values(user_SEQ.nextVal,'x3','x3','x3','x3','x3','x3','x3'
-- ,'x3','x3','x3','x3','x3','x3','x3','x3','x3','x3','x3','x3')

INSERT INTO EMPLOYEE(id,password,email,pid,nameTH,nation,race,address,mobile,enabled) values(user_SEQ.nextVal,'12345','o@o.com','012345','jasin1', 'Thai','Thai','Aangkok','098767878',TRUE);
INSERT INTO EMPLOYEE(id,password,email,pid,nameTH,nation,race,address,mobile,enabled) values(user_SEQ.nextVal,'44545','b@b.com','234566','aasin2', 'Thai','Thai','Cangkok2','0983347878',TRUE);
INSERT INTO EMPLOYEE(id,password,email,pid,nameTH,nation,race,address,mobile,enabled) values(user_SEQ.nextVal,'66545','c@c.com','334567','basin3', 'Thai','Thai','Dangkok3','09866788',TRUE);
INSERT INTO EMPLOYEE(id,password,email,pid,nameTH,nation,race,address,mobile,enabled) values(user_SEQ.nextVal,'77545','d@d.com','999999','casin4', 'Thai','Thai','Eangkok4','098777878',TRUE);
INSERT INTO EMPLOYEE(id,password,email,pid,nameTH,nation,race,address,mobile,enabled) values(user_SEQ.nextVal,'77345','e@e.com','456789','dasin5', 'Thai','Thai','Fangkok5','098127878',TRUE);