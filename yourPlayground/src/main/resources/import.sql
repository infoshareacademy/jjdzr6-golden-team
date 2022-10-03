INSERT INTO roles(id, name) VALUES(1, 'ADMIN');
INSERT INTO roles(id, name) VALUES(2, 'USER');

INSERT INTO players (id, username, password, mail) VALUES (1, 'admin', '{bcrypt}$2a$10$PZomtrVYYPi4dB0vm5HYDOHib.O/WLXHmY41f4iHKKPCVdEDLJUvW', 'mail1@example.com');
INSERT INTO players (id, username, password, mail) VALUES (2, 'user', '{bcrypt}$2a$10$ZKhlcv0ki4chQZhiUGupM.50BUfDavDXPfmHsn3np.IcA26IO8fSC', 'mail2@example.com');
INSERT INTO players (id, username, password, mail) VALUES (3, 'noRole', '{bcrypt}$2a$10$ZKhlcv0ki4chQZhiUGupM.50BUfDavDXPfmHsn3np.IcA26IO8fSC', 'mail3@example.com');
INSERT INTO players (id, username, password, mail) VALUES (4, 'user2', '{bcrypt}$2a$10$ZKhlcv0ki4chQZhiUGupM.50BUfDavDXPfmHsn3np.IcA26IO8fSC', 'mail4@example.com');

INSERT INTO player_role_jointable (player_id, role_id) VALUES(1, 1);
INSERT INTO player_role_jointable (player_id, role_id) VALUES(1, 2);
INSERT INTO player_role_jointable (player_id, role_id) VALUES(2, 2);
INSERT INTO player_role_jointable (player_id, role_id) VALUES(4, 2);

INSERT INTO locations values (1,0,0,'Nowa Iwiczna');
INSERT INTO locations values (2,0,0,'Warszawa');
INSERT INTO locations values (3,0,0,'Łódź');
INSERT INTO locations values (4,0,0,'Kraków');

INSERT INTO games values (1, '2022-10-04 10:00:00',2,'Szachy','BOARD',1,1);
INSERT INTO games values (2, '2022-10-05 12:00:00',10,'Koszykówka','SPORT',2,1);
INSERT INTO games values (3, '2022-10-09 10:00:00',22,'Piłka nożna','SPORT',3,2);

INSERT INTO game_player_jointable values (1, 1);
INSERT INTO game_player_jointable values (1, 2);
INSERT INTO game_player_jointable values (2, 1);
INSERT INTO game_player_jointable values (3, 2);