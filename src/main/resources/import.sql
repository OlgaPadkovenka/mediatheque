insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION,TITRE) values (1,'Kanye West', 125, 20,'2003-12-02','The college Dropout');
insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION,TITRE) values (2,'Jay Z', 120, 54,'2003-11-14','The Black Album');
insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION,TITRE) values (3,'Aaliyah', 73, 18,'1996-08-13','One in a million');
insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION,TITRE) values (4,'D Angelo', 78, 13,'2000-01-25','Voodoo');
insert into CD (ID, NOM, DUREE, NOMBRE_D_EXEMPLAIRES, DATE_DE_PARUTION,TITRE) values (5,'Nas', 60, 18,'2006-12-19','HipHop is Dead');

insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (1,'Fleurisse','Atangana','bkzion@hotmail.fr','laforce');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (2,'Sylvie','Wagner','syzion@hotmail.fr','lesecret');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (3,'Roger','Smith','smithrog@hotmail.fr','unpassword');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (4,'Erik','Jackson','jacksEr@hotmail.fr','unknown');
insert into UTILISATEUR (ID, NOM, PRENOM, EMAIL, MOT_DE_PASSE) values (5,'Daniela','Sagna','sagnaD@hotmail.fr','flawless');

insert into EMPRUNT (ID, DATE_EMPRUNT, DATE_RETOUR, UTILISATEUR_ID) VALUES (1, '2022-10-01', null, 1);
insert into EMPRUNT (ID, DATE_EMPRUNT, DATE_RETOUR, UTILISATEUR_ID) VALUES (2, '2022-09-20', null, 2);
insert into EMPRUNT (ID, DATE_EMPRUNT, DATE_RETOUR, UTILISATEUR_ID) VALUES (3, '2022-10-09', null, 3);

insert into EMPRUNT_CD (EMPRUNT_ID, CD_ID) VALUES (1, 1);
insert into EMPRUNT_CD (EMPRUNT_ID, CD_ID) VALUES (2, 2);
insert into EMPRUNT_CD (EMPRUNT_ID, CD_ID) VALUES (3, 3);
