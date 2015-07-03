
INSERT INTO customer(id,name,email,mobile) values(CUSTOMER_SEQ.nextVal,'Best','best@best.com','0987654321');
INSERT INTO customer(id,name,email,mobile) values(CUSTOMER_SEQ.nextVal,'Nut','nut@nut.com','0987987888');
INSERT INTO customer(id,name,email,mobile) values(CUSTOMER_SEQ.nextVal,'Ooo','o@o.com','098767878');
--INSERT INTO user(email,password) values('xx@xx.com','12345');I
INSERT INTO DEPARTMENT(id,name) values(DEPARTMENT_SEQ.nextVal,'software development');
INSERT INTO DEPARTMENT(id,name) values(DEPARTMENT_SEQ.nextVal,'software Engineering');
INSERT INTO DEPARTMENT(id,name) values(DEPARTMENT_SEQ.nextVal,'software singular');

INSERT INTO AUTHORITY(ROLES) values('add');
INSERT INTO AUTHORITY(ROLES) values('update');
INSERT INTO AUTHORITY(ROLES) values('delete');


-- INSERT INTO EMPLOYEE(id,password,email,pid,nameTH,nameENG
-- ,sex,blood,soldierstatus,marrystatus,nation,race,address
-- ,tel,mobile,workstatus,enabled,birthday,addressofpid,startwork,endwork)
-- values(user_SEQ.nextVal,'2921615','aaa@aaa','11111','jasin1','jasin001','M','B','no','marry','thai'
-- ,'thai','113 moo.1','014289234','0199398765','on work',TRUE,'2011-11-22','122moo.3','2012-11-22','2012-11-22');
-- 
-- INSERT INTO EMPLOYEE(id,password,email,pid,nameTH,nameENG
-- ,sex,blood,soldierstatus,marrystatus,nation,race,address
-- ,tel,mobile,workstatus,enabled,birthday,addressofpid,startwork,endwork)
-- values(user_SEQ.nextVal,'2921718','bbbb@aaa','22222','jasin007','jasin001','M','B','no','marry','thai'
-- ,'thai','113 moo.1','024289234','0299398765','on work',TRUE,'2012-11-22','124moo.4','2012-11-22','2012-11-22');



INSERT INTO Medical_History(disease) values('Nomal');
INSERT INTO Medical_History(disease) values('High Blood Pressure');
INSERT INTO Medical_History(disease) values('Anemia');
INSERT INTO Medical_History(disease) values('Diabetes');
INSERT INTO Medical_History(disease) values('Dissolves blood clots');
INSERT INTO Medical_History(disease) values('Heart disease');
INSERT INTO Medical_History(disease) values('Hepatitis');
INSERT INTO Medical_History(disease) values('Losers drug history');


