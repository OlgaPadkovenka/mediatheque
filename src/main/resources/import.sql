insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE) values (1,'Kanye West', 125, 20,'2003-12-02','The college Dropout');
insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE) values (2,'Jay Z', 120, 54,'2003-11-14','The Black Album');
insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE) values (3,'Aaliyah', 73, 18,'1996-08-13','One in a million');
insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE) values (4,'D Angelo', 78, 13,'2000-01-25','Voodoo');
insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE) values (5,'Nas', 60, 18,'2006-12-19','HipHop is Dead');

insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (1,'Fleurisse','Atangana','bkzion@hotmail.fr','laforce');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (2,'Sylvie','Wagner','syzion@hotmail.fr','lesecret');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (3,'Roger','Smith','smithrog@hotmail.fr','unpassword');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (4,'Erik','Jackson','jacksEr@hotmail.fr','unknown');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (5,'Daniela','Sagna','sagnaD@hotmail.fr','flawless');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (6,'User1','User1','user1@gmail.com','$2a$12$Y/Mvz5EGwtnk/tK5dU5juu/5iOR8A5m./D/FUSzUqTVoY194/mPQG');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (7,'User2','User2','user2@gmail.com','$2a$12$Kf.4fxxcYWxkIFYhQlvhn.prAX1LeFInz2KFP8Tyjx7pVvugU6hiS');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (8,'User3','User3','user3@gmail.com','user3');

insert into ROLE (ID, NOM) values (1, 'ADMIN');
insert into ROLE (ID, NOM) values (2, 'USER');

insert into UTILISATEUR_ROLE (UTILISATEUR_ID, ROLE_ID) values (6, 1);
insert into UTILISATEUR_ROLE (UTILISATEUR_ID, ROLE_ID) values (7, 2);

insert into DVD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, DVD_TYPE) values (6,'Scorcese Martin', 178, 6,'1995-01-01','Casino', 'DVD');
insert into DVD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, DVD_TYPE) values (7,'Scorcese Martin', 146, 4,'1990-01-01','Les Affranchis', 'BLURAY');
insert into DVD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, DVD_TYPE) values (8,'Tarantino Quentin', 164, 5,'1994-01-01','Pulp Fiction', 'DVD');
insert into DVD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, DVD_TYPE) values (9,'Nolan Christopher', 147,7,'2010-01-04','Inception', 'DVD');
insert into DVD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, DVD_TYPE) values (10,'Brian De Palma', 170,3,'2005-04-04','Casino', 'BLURAY');

insert into LIVRE (ID, NOM, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, NUMERO_ISBN) values (11,'Georges Orwell', 4,'1949-06-08', '1984','207036822X');
insert into LIVRE (ID, NOM, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, NUMERO_ISBN) values (12,'Georges Orwell', 5, '1945-05-08', 'The Animal Farm','307036822X');
insert into LIVRE (ID, NOM, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, NUMERO_ISBN) values (13,'Victor Hugo', 7, '1831-03-19', 'Notre de Dame de Paris','407036822X');
insert into LIVRE (ID, NOM, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, NUMERO_ISBN) values (14,'Jane Austen', 5, '1813-09-21', 'Pride and Prejudice','507036822X');
insert into LIVRE (ID, NOM, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION, TITRE, NUMERO_ISBN) values (15,'Guy de Maupassant', 6, '1886-11-19', 'Le Horla','607036822X');

insert into EMPRUNT (ID, DATE_EMPRUNT, DATE_RETOUR, UTILISATEUR_ID) VALUES (1, '2022-10-01', '2023-01-13', 7);
insert into EMPRUNT (ID, DATE_EMPRUNT, DATE_RETOUR, UTILISATEUR_ID) VALUES (2, '2022-09-20', NULL, 7);
insert into EMPRUNT (ID, DATE_EMPRUNT, DATE_RETOUR, UTILISATEUR_ID) VALUES (3, '2022-10-09', NULL, 3);

insert into EMPRUNT_ITEM (EMPRUNT_ID, ITEM_ID) VALUES (1, 1);
insert into EMPRUNT_ITEM (EMPRUNT_ID, ITEM_ID) VALUES (2, 3);
insert into EMPRUNT_ITEM (EMPRUNT_ID, ITEM_ID) VALUES (3, 2);

alter sequence emprunt_sequence_generator restart with 100;
alter sequence item_sequence_generator restart with 100;
alter sequence utilisateur_sequence_generator restart with 100;
alter sequence role_sequence_generator restart with 100;