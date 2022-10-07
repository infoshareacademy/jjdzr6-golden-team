INSERT INTO roles(id, name) VALUES(1, 'ADMIN');
INSERT INTO roles(id, name) VALUES(2, 'USER');

INSERT INTO players (id, username, password, mail) VALUES (1, 'admin', '$2a$12$PmtdZ3Wt6zU3ANTZ8JNw7uOcxImnUBCGx2GEu23qeObn2xGIte7/e', 'mail1@example.com');
INSERT INTO players (id, username, password, mail) VALUES (2, 'user', '$2a$12$xSOa5WVh1pA8EZnIQ0ft.OzWQD.hz78WYic/lqCGfLkOFelGO.tt.', 'mail2@example.com');
INSERT INTO players (id, username, password, mail) VALUES (3, 'noRole', '$2a$12$naNjzPI3CsERhoQ1iIWscuXE/NI1OSbVD8C4FBqOe72yef6UCMue6', 'mail3@example.com');
INSERT INTO players (id, username, password, mail) VALUES (4, 'user2', '$2a$12$THVnshHUX64igghJX10mVe9N01l9Iygho5alhfgqAVOTFlBiD0Xbi', 'mail4@example.com');

INSERT INTO player_role_jointable (player_id, role_id) VALUES(1, 1);
INSERT INTO player_role_jointable (player_id, role_id) VALUES(1, 2);
INSERT INTO player_role_jointable (player_id, role_id) VALUES(2, 2);
INSERT INTO player_role_jointable (player_id, role_id) VALUES(4, 2);

INSERT INTO locations values (1,0,0,'Nowa Iwiczna');
INSERT INTO locations values (2,0,0,'Warszawa');
INSERT INTO locations values (3,0,0,'Łódź');
INSERT INTO locations values (4,0,0,'Kraków');

INSERT INTO games values (1, '2022-10-04 10:00:00',2,'Chess','BOARD',1,1);
INSERT INTO games values (2, '2022-10-05 12:00:00',10,'Basketball','SPORT',2,1);
INSERT INTO games values (3, '2022-10-09 10:00:00',22,'Football','SPORT',3,2);

INSERT INTO game_player_jointable values (1, 1);
INSERT INTO game_player_jointable values (1, 2);
INSERT INTO game_player_jointable values (2, 1);
INSERT INTO game_player_jointable values (3, 2);