# group3

CREATE DATABASE tgsdb;
 
CREATE TABLE tgsdb.customer ( 
ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(50) NOT NULL, 
email VARCHAR(50) NOT NULL UNIQUE, 
password VARCHAR(50) NOT NULL, 
DOB DATE NOT NULL, 
phone VARCHAR(20) NOT NULL 
) AUTO_INCREMENT = 1000; 
 
CREATE TABLE tgsdb.staff ( 
ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(50) NOT NULL, 
email VARCHAR(50) NOT NULL UNIQUE, 
password VARCHAR(50) NOT NULL, 
DOB DATE NOT NULL, 
phone VARCHAR(20) NOT NULL 
) AUTO_INCREMENT = 10000; 
 
CREATE TABLE tgsdb.manager ( 
manager_ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(50) NOT NULL, 
email VARCHAR(50) NOT NULL UNIQUE, 
password VARCHAR(50) NOT NULL, 
DOB DATE NOT NULL 
) AUTO_INCREMENT = 1; 
 
CREATE TABLE tgsdb.room ( 
room_ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
room_No VARCHAR(10) NOT NULL UNIQUE,
type VARCHAR(50) NOT NULL, 
description TEXT NOT NULL, 
price INTEGER NOT NULL 
) AUTO_INCREMENT = 2000; 
  
CREATE TABLE tgsdb.booking ( 
booking_ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
customer_ID INTEGER NOT NULL, 
check_in DATE NOT NULL, 
check_out DATE NOT NULL, 
description TEXT, 
total_price INTEGER NOT NULL,
created_date DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
FOREIGN KEY(customer_ID) REFERENCES customer(ID) ON DELETE NO ACTION 
) AUTO_INCREMENT = 3000; 
 
CREATE TABLE tgsdb.booked_rooms (
booking_ID INTEGER NOT NULL,
room_ID INTEGER NOT NULL,
FOREIGN KEY(booking_ID) REFERENCES booking(booking_ID) ON DELETE NO ACTION,
FOREIGN KEY(room_ID) REFERENCES room(room_ID) ON DELETE NO ACTION,
PRIMARY KEY (booking_ID, room_ID)
);  

 CREATE TABLE tgsdb.report_logs(
 report_ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
 report_from_date DATETIME NOT NULL,
 report_to_date DATETIME NOT NULL,
 number_of_bookings INTEGER,
 revenue INTEGER,
 created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP) AUTO_INCREMENT = 100;

INSERT INTO tgsdb.customer (name, email, password, dob, phone) 
VALUES  
('James Smith','james.s@gmail.com', 'Helloworld123', '1978/01/01', '+01477134555'),  
('Michael Smith', 'michael@outlook.com','Javaworld123', '1989/04/05', '+04422444532'),  
('Robert Harlow', 'robert@live.com','Helloo123', '1977/02/09', '+61422334532'),  
('Maria Garcia','maria.g@gmail.com','Mariaworld222', '2000/09/13', '+07422331531'),  
('David Sutton','david.s@outlook.com','Davidworld333', '2001/10/12', '+02422333533'),  
('Oliver Gomez','oliver.g@live.com','Helloworld123', '1998/08/13', '+03412314532'),  
('Jeff Garcia','jeffgarcia@gmail.com','Helloworld123', '1995/03/27', '+81432333533'),  
('Mary House','mary@gmail.com','Helloworld123', '2000/01/26', '+44420304530'),  
('Tom Harding','tom.harding@outlook.com','Helloworld123', '1995/05/16', '+33422334530'),  
('Chris Rock', 'chris.r@gmail.com','Helloworld123', '1985/07/19', '+61421114532'),  
('Tom Selleck','tom.s@live.com','Helloworld123', '1998/02/14', '+61400304532'),  
('Richard Attenborough','richard.a@gmail.com','Helloworld123', '1988/03/13', '+61421004532'),  
('Sam Smith','sam.smith@live.com','Helloworld123', '1969/08/12', '+228422334121'),  
('Gary New','gary.n@gmail.com','Helloworld123', '1945/05/06', '+554422121121'),  
('Jillian Davis','jillian@outlook.com','Helloo123', '1998/11/13', '+886498334732'),  
('Linda Hall','lindahall@live.com', 'Helloworld123', '1997/10/16', '+09392334999'), 
('Eric Tenner','eric.t@gmail.com','Helloworld123', '1994/6/12', '+10422888532'),  
('Mick Lamb','mick.l@gmail.com','Helloworld123', '1957/10/15', '+77222884592'),  
('Joe Muller','joe.muller@outlook.com','Helloworld123', '1983/08/13', '+919498334122'),  
('Adam Wellington','adam@live.com','Helloworld123', '1999/08/19', '+61442338532');


INSERT INTO tgsdb.staff (name, email, password, dob, phone)  
VALUES  
('Mario Gotze','mario.g@tgsstaff.com', 'Helloworld123', '1998/01/01','+61411292333'),  
('Manuel Neuer', 'manuel.neuer@tgsstaff.com','Javaworld123', '1999/04/05','+61410291331'),  
('Leon Goretzka', 'leon.g@tgsstaff.com','Helloo123', '1998/02/09','+61410822331'),  
('Marc Andre Ter Stegen','marc.a.t.s@tgsstaff.com','Marcworld222', '2000/09/13','+61411251322'),  
('Kai Havertz','kai.h@tgsstaff.com','Kaiworld333', '2001/10/15','+61421212313'),  
('Antonio Rudiger','antonio.r@ tgsstaff.com','Antonioworld123', '1998/06/03','+61411262300'),  
('Joshua Kimmich','joshua.k@tgsstaff.com','Joshuaworld123', '1995/07/27','+61411522301'),  
('David Raum','davidraum.r@tgsstaff.com','Davidworld121', '2000/03/26','+61411262302'),  
('Thomas Muller','thomas.m@tgsstaff.com','Thomasmuller555', '1999/09/16','+61418222303'),  
('Matthias Ginter', 'matthias.g@tgsstaff.com','Ginterworld444', '1985/07/19','+61416222304'),  
('Nico Schlotterbeck','nico.s@tgsstaff.com','Nicoworld123', '1998/02/14','+61411232305'),  
('Christian Gunter','christian.g@tgsstaff.com','Pasword333', '1998/06/23','+61411252306'),  
('Niklas Sule','niklas.s@tgsstaff.com','Nikiworld444', '1999/08/18','+61411205373'),  
('Lukas Klostermann','lukas.k@tgsstaff.com','Lukasklos555', '2000/05/09','+61491222307'),  
('Julian Brandt','julian.b@tgsstaff.com','Julzworld666', '1998/11/13','+61411252308'),  
('Jonas Hofmann','jonas.h@tgsstaff.com', 'Jonashello989', '1997/12/26','+61411522309'),  
('Ilkay Gundogan','ilkay.g@tgsstaff.com','Helloworld123', '2000/11/04','+61414222363'),  
('Niclas Fullkrug','niclas.f@tgsstaff.com','Niclasf696', '1967/10/14','+61411268323'), 
('Serge Gnabry','serge.g@tgsstaff.com','Helloworld123', '2000/08/12','+61411222953'),  
('Marvin Gaston','marvin.g@tgsstaff.com','Helloworld123', '1989/03/10','+61421224323');


INSERT INTO tgsdb.manager (name, email, password, dob)
VALUES
('Oliver Gomez','oliver.g@tgsmanager.com','Helloworld123', '1998/08/13'), 
('Jeff Garcia','jeff.g@tgsmanager.com','Helloworld123', '1995/03/27'), 
('Mary House','mary.h@tgsmanager.com','Helloworld123', '2000/01/26'), 
('Tom Harding','tom.h@tgsmanager.com','Helloworld123', '1995/05/16'),
('Adam Wellington','adam.w@tgsmanager.com','Helloworld123', '1999/08/19');

INSERT INTO tgsdb.room (room_No,type,description, price) VALUES
('DL_101','DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('DL_102', 'DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('DL_103','DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('DL_104','DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('DL_105','DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('DL_106','DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('DL_107','DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('DL_108','DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('DL_109','DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('DL_110','DELUXE_ROOM','Room can accommodate up to 2 adults.','150'), 
('FL_201','FAMILY_ROOM','Room can accommodate up to 4 adults','250'), 
('FL_202','FAMILY_ROOM','Room can accommodate up to 4 adults','250'), 
('FL_203','FAMILY_ROOM','Room can accommodate up to 4 adults','250'), 
('FL_204','FAMILY_ROOM','Room can accommodate up to 4 adults','250'), 
('FL_205','FAMILY_ROOM','Room can accommodate up to 4 adults','250'), 
('FL_206','FAMILY_ROOM','Room can accommodate up to 4 adults','250'), 
('FL_207','FAMILY_ROOM','Room can accommodate up to 4 adults','250'), 
('ES_301','EXECUTIVE_SUITE','Room can accommodate up to 6 adults. Contains 3 bedrooms with a queen bed in each.','500'),
('ES_302','EXECUTIVE_SUITE','Room can accommodate up to 6 adults. Contains 3 bedrooms with a queen bed in each.','500'),
('ES_303','EXECUTIVE_SUITE','Room can accommodate up to 6 adults. Contains 3 bedrooms with a queen bed in each.','500');



INSERT INTO tgsdb.booking (customer_ID, check_in, check_out,total_price) 
VALUES 
('1003', '2022-12-30', '2023-01-02',900), 
('1004', '2022-12-30', '2023-01-02',1350), 
('1005', '2022-12-30', '2023-01-02',2400), 
('1000', '2022-12-30', '2023-01-02',1650), 
('1000', '2023-01-24', '2023-01-27',450), 
('1003', '2023-01-24', '2023-01-27',2250), 
('1001', '2023-01-24', '2023-01-27',750), 
('1002', '2023-01-24', '2023-01-27',750), 
('1005', '2023-01-24', '2023-01-29',2500), 
('1009', '2023-01-24', '2023-01-29',2500), 
 
('1001', '2023-02-01', '2023-02-04',750), 
('1006', '2023-02-01', '2023-02-04',750), 
('1007', '2023-02-16', '2023-02-18',500), 
('1008', '2023-02-17', '2023-02-20',450), 
('1009', '2023-03-01', '2023-03-03',300), 
('1000', '2023-03-01', '2023-03-03',300), 
('1002', '2023-02-16', '2023-02-18',300), 
('1002', '2023-02-25', '2023-02-28',450), 
('1010', '2023-02-16', '2023-02-18',500), 
('1013', '2023-02-16', '2023-02-18',500), 
 
 
 
 
('1003', '2002-12-30', '2003-01-02',900), 
('1001', '2002-12-30', '2003-01-02',1350), 
('1002', '2002-12-30', '2003-01-02',2400), 
('1000', '2002-12-30', '2003-01-02',1650), 
('1003', '2003-01-24', '2003-01-27',450), 
('1004', '2003-01-24', '2003-01-27',2250), 
('1005', '2003-01-24', '2003-01-27',750), 
('1006', '2003-01-24', '2003-01-27',750), 
('1007', '2003-01-24', '2003-01-29',2500), 
('1008', '2003-01-24', '2003-01-29',2500), 
 
('1018', '2003-02-01', '2003-02-04',750), 
('1015', '2003-02-01', '2003-02-04',750), 
('1012', '2003-02-16', '2003-02-18',500), 
('1011', '2003-02-17', '2003-02-20',450), 
('1017', '2003-03-01', '2003-03-03',300), 
('1016', '2003-03-01', '2003-03-03',300), 
('1010', '2003-02-16', '2003-02-18',300), 
('1013', '2003-02-25', '2003-02-28',450), 
('1014', '2003-02-16', '2003-02-18',500), 
('1009', '2003-02-16', '2003-02-18',500), 
 
 
 
('1003', '2004-12-30', '2005-01-02',900), 
('1001', '2004-12-30', '2005-01-02',1350), 
('1002', '2004-12-30', '2005-01-02',2400), 
('1000', '2004-12-30', '2005-01-02',1650), 
('1003', '2005-01-24', '2005-01-27',450), 
('1004', '2005-01-24', '2005-01-27',2250), 
('1005', '2005-01-24', '2005-01-27',750), 
('1006', '2005-01-24', '2005-01-27',750), 
('1007', '2005-01-24', '2005-01-29',2500), 
('1008', '2005-01-24', '2005-01-29',2500), 
 
('1018', '2005-02-01', '2005-02-04',750), 
('1015', '2005-02-01', '2005-02-04',750), 
('1012', '2005-02-16', '2005-02-18',500), 
('1011', '2005-02-17', '2005-02-20',450), 
('1017', '2005-03-01', '2005-03-03',300), 
('1016', '2005-03-01', '2005-03-03',300), 
('1010', '2005-02-16', '2005-02-18',300), 
('1013', '2005-02-25', '2005-02-28',450), 
('1014', '2005-02-16', '2005-02-18',500), 
('1009', '2005-02-16', '2005-02-18',500),
 
  
 
('1003', '2009-12-30', '2010-01-02',900), 
('1001', '2009-12-30', '2010-01-02',1350), 
('1002', '2009-12-30', '2010-01-02',2400), 
('1000', '2009-12-30', '2010-01-02',1650), 
('1003', '2010-01-24', '2010-01-27',450), 
('1004', '2010-01-24', '2010-01-27',2250), 
('1005', '2010-01-24', '2010-01-27',750), 
('1006', '2010-01-24', '2010-01-27',750), 
('1007', '2010-01-24', '2010-01-29',2500), 
('1008', '2010-01-24', '2010-01-29',2500), 
 
('1018', '2010-02-01', '2010-02-04',750), 
('1015', '2010-02-01', '2010-02-04',750), 
('1012', '2010-02-16', '2010-02-18',500), 
('1011', '2010-02-17', '2010-02-20',450), 
('1017', '2010-03-01', '2010-03-03',300), 
('1016', '2010-03-01', '2010-03-03',300), 
('1010', '2010-02-16', '2010-02-18',300), 
('1013', '2010-02-25', '2010-02-28',450), 
('1014', '2010-02-16', '2010-02-18',500), 
('1009', '2010-02-16', '2010-02-18',500); 
 
 
 
 

 
 
 
  
INSERT INTO tgsdb.booked_rooms (booking_ID, room_id) 
VALUES 
('3000', '2000'), 
('3000', '2001'), 
('3001', '2002'), 
('3001', '2003'), 
('3001', '2004'), 
('3002', '2005'), 
('3002', '2006'), 
('3002', '2011'), 
('3002', '2010'), 
('3003', '2007'), 
('3003', '2008'), 
('3003', '2012'), 
 
('3004', '2000'), 
('3005', '2001'), 
('3005', '2002'), 
('3005', '2003'), 
('3005', '2004'), 
('3005', '2005'), 
('3006', '2010'), 
('3007', '2011'), 
('3008', '2018'), 
('3009', '2019'), 
('3010', '2010'), 
('3011', '2011'), 
('3012', '2010'), 
('3013', '2000'), 
('3014', '2000'), 
('3015', '2001'), 
('3016', '2000'), 
('3017', '2000'), 
('3018', '2010'), 
('3019', '2011'),
 
('3020', '2000'), 
('3020', '2001'), 
('3021', '2002'), 
('3021', '2003'), 
('3021', '2004'), 
('3022', '2005'), 
('3022', '2006'), 
('3022', '2011'), 
('3022', '2010'), 
('3023', '2007'), 
('3023', '2008'), 
('3023', '2012'), 
 
('3024', '2000'), 
('3025', '2001'), 
('3025', '2002'), 
('3025', '2003'), 
('3025', '2004'), 
('3025', '2005'), 
('3026', '2010'), 
('3027', '2011'), 
('3028', '2018'), 
('3029', '2019'), 
('3030', '2010'), 
('3031', '2011'), 
('3032', '2010'), 
('3033', '2000'), 
('3034', '2000'), 
('3035', '2001'), 
('3036', '2000'), 
('3037', '2000'), 
('3038', '2010'), 
('3039', '2011'),
 
 
 
 
('3040', '2000'), 
('3040', '2001'), 
('3041', '2002'), 
('3041', '2003'), 
('3041', '2004'), 
('3042', '2005'), 
('3042', '2006'), 
('3042', '2011'), 
('3042', '2010'), 
('3043', '2007'), 
('3043', '2008'), 
('3043', '2012'), 
 
('3044', '2000'), 
('3045', '2001'), 
('3045', '2002'), 
('3045', '2003'), 
('3045', '2004'), 
('3045', '2005'), 
('3046', '2010'), 
('3047', '2011'), 
('3048', '2018'), 
('3049', '2019'), 
('3050', '2010'), 
('3051', '2011'), 
('3052', '2010'), 
('3053', '2000'), 
('3054', '2000'), 
('3055', '2001'), 
('3056', '2000'), 
('3057', '2000'), 
('3058', '2010'), 
('3059', '2011'),
 
 
 
('3060', '2000'), 
('3060', '2001'), 
('3061', '2002'), 
('3061', '2003'), 
('3061', '2004'), 
('3062', '2005'), 
('3062', '2006'), 
('3062', '2011'), 
('3062', '2010'), 
('3063', '2007'), 
('3063', '2008'), 
('3063', '2012'), 
 
('3064', '2000'), 
('3065', '2001'), 
('3065', '2002'), 
('3065', '2003'), 
('3065', '2004'), 
('3065', '2005'), 
('3066', '2010'), 
('3067', '2011'), 
('3068', '2018'), 
('3069', '2019'), 
('3070', '2010'), 
('3071', '2011'), 
('3072', '2010'), 
('3073', '2000'), 
('3074', '2000'), 
('3075', '2001'), 
('3076', '2000'), 
('3077', '2000'), 
('3078', '2010'), 
('3079', '2011'); 

INSERT INTO tgsdb.report_logs (report_from_date, report_to_date, number_of_bookings, revenue) 
VALUES 
('2002-12-30 00:00:00', '2003-01-05 00:00:00',12,2100), 
('2002-01-05 00:00:00', '2002-01-16 00:00:00',0,0), 
('2003-01-14 00:00:00', '2003-01-30 00:00:00',10,2400), 
('2003-01-01 00:00:00', '2003-01-30 00:00:00',10,2400), 
('2003-01-01 00:00:00', '2003-02-20 00:00:00',17,3950), 
('2003-02-01 00:00:00', '2003-02-28 00:00:00',8,1700), 
('2004-12-01 00:00:00', '2005-01-01 00:00:00',12,2100),
('2005-01-02 00:00:00', '2005-01-15 00:00:00',0,0), 
('2005-01-01 00:00:00', '2005-04-01 00:00:00',20,4400), 
('2005-01-08 00:00:00', '2005-02-08 00:00:00',12,2900), 
('2003-01-01 00:00:00', '2005-03-01 00:00:00',52,10900),
('2005-02-13 00:00:00', '2005-03-13 00:00:00',8,1500), 
('2009-12-01 00:00:00', '2010-02-01 00:00:00',24,5000),
('2010-01-01 00:00:00', '2010-02-01 00:00:00',12,2900),
('2010-01-08 00:00:00', '2010-02-08 00:00:00',12,2900),
('2010-02-01 00:00:00', '2010-03-09 00:00:00',10,2000),
('2002-12-01 00:00:00', '2010-12-01 00:00:00',96,19500), 
('2003-02-02 00:00:00', '2007-02-01 00:00:00',40,8000),
('2022-12-01 00:00:00', '2023-01-01 00:00:00',12,2100),
('2002-12-01 00:00:00', '2023-03-03 00:00:00',128,26000);
