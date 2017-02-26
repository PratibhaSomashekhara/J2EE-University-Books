
insert ignore into sec_group(groupname, groupdesc) values('STUDENTS','This group contains students.');
insert ignore into sec_group(groupname, groupdesc) values('LIBRARIAN','This group contains librarian.');

insert ignore into sec_user(username, password) values('student1',SHA2('student1',256)); 
insert ignore into sec_user(username, password) values('student2',SHA2('student2',256)); 
insert ignore into sec_user(username, password) values('student3',SHA2('student3',256)); 
insert ignore into sec_user(username, password) values('librarian1',SHA2('librarian1',256)); 
insert ignore into sec_user(username, password) values('librarian2',SHA2('librarian2',256)); 
insert ignore into sec_user(username, password) values('librarian3',SHA2('librarian3',256)); 


insert ignore into sec_user_groups(username, groupname) values('student1','STUDENTS');
insert ignore into sec_user_groups(username, groupname) values('student2','STUDENTS');
insert ignore into sec_user_groups(username, groupname) values('student3','STUDENTS');
insert ignore into sec_user_groups(username, groupname) values('librarian1','LIBRARIAN');
insert ignore into sec_user_groups(username, groupname) values('librarian2','LIBRARIAN');
insert ignore into sec_user_groups(username, groupname) values('librarian3','LIBRARIAN');



INSERT IGNORE INTO types(id, name) VALUES (1, 'Novel');
INSERT IGNORE INTO types(id, name) VALUES (2, 'Fictions');
INSERT IGNORE INTO types(id, name) VALUES (3, 'Programming');
INSERT IGNORE INTO types(id, name) VALUES (4, 'science');
INSERT IGNORE INTO types(id, name) VALUES (5, 'Magazines');
INSERT IGNORE INTO types(id, name) VALUES (6, 'Law');

INSERT IGNORE INTO librarian(id, first_name, last_name, address, city, telephone, username) VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023','librarian1');
INSERT IGNORE INTO librarian(id, first_name, last_name, address, city, telephone, username) VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749','librarian2');
INSERT IGNORE INTO librarian(id, first_name, last_name, address, city, telephone, username) VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763','librarian3');

INSERT IGNORE INTO students(id, first_name, last_name, username,librarian_id) VALUES (1, 'James', 'Carter', 'student1',1);
INSERT IGNORE INTO students(id, first_name, last_name, username,librarian_id)VALUES (2, 'Helen', 'Leary', 'student2',1);
INSERT IGNORE INTO students(id, first_name, last_name, username,librarian_id)VALUES (3, 'Linda', 'Douglas', 'student3',1);


insert ignore into book (id,isbn,nbOfPage,publicationDate,title,description,version,type_id,student_id,librarian_id)values (1,'123456',250,'1970-09-01','Advance Java','Contains advance topics of java',3,3,1,1);
insert ignore into book(id,isbn,nbOfPage,publicationDate,title,description,version,type_id,student_id,librarian_id) values(2,'456754',255,'1988-09-01','Basic of java','Contains basic topics of java',1,3,1,1);
insert ignore into book (id,isbn,nbOfPage,publicationDate,title,description,version,type_id,student_id,librarian_id) values(3,'58789347',350,'1856-09-01','Advance python','Contains advance topics of python',4,3,2,1);
insert ignore into book(id,isbn,nbOfPage,publicationDate,title,description,version,type_id,student_id,librarian_id) values(4,'67848590',750,'2006-09-01','Advance J2ee','Contains advance topics of j2ee',1,3,2,2);
insert ignore into book(id,isbn,nbOfPage,publicationDate,title,description,version,type_id,student_id,librarian_id) values(5,'5674584',1200,'1876-09-01','Advance SQL','Contains advance topics of SQL',2,3,3,2);
insert ignore into book(id,isbn,nbOfPage,publicationDate,title,description,version,type_id,student_id,librarian_id) values(6,'23675884',120,'1896-09-03','Hammer','Contains hammer Story',2,1,3,2);
insert ignore into book(id,isbn,nbOfPage,publicationDate,title,description,version,type_id,student_id,librarian_id) values(7,'5321584',1200,'1890-12-08','The girl on the Train','story about girl',2,2,1,2);



insert ignore into publisher (name,title) values('Advance Java','Raj Krishnan');
insert ignore into publisher (name,title) values('Radhika Dewan','Basic of Java');
insert ignore into publisher (name,title) values('Chetan Bagath','3 idiots');
insert ignore into publisher (name,title) values('Dinesh Pandit','Advance J2ee');
insert ignore into publisher (name,title) values('Vasuki Koushik','Advance Python');


insert ignore into author(firstname, lastname)values('Raj', 'Krishnan');
insert ignore into author (firstname, lastname)values('Radhika', 'Dewan');
insert ignore into author(firstname, lastname)values ('Chetan', 'Bagath');
insert ignore into author (firstname, lastname)values('Dinesh', 'Pandit');
insert ignore into author (firstname, lastname)values('Vasuki', 'Koushik');