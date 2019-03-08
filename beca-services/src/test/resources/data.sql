INSERT INTO login (id, username, password)
VALUES
(1, 'Javier', 'Rodriguez'),
(2, 'Barney', 'Rodriguez'),
(3, 'Cholos', 'Rodriguez'),
(4, 'Mem', 'Rodriguez'),
(5, 'Ese', 'Rodriguez'),
(6, 'Javier', 'Rodriguez'),
(7, 'Luis', 'Rodriguez');

COMMIT ;


INSERT INTO users (id, ds_name, ds_lastname, age, login)
VALUES
(1, 'Javier', 'Rodriguez', 4,1),
(2, 'Barney', 'Rodriguez', 4,2),
(3, 'Cholos', 'Rodriguez', 4,3),
(4, 'Mem', 'Rodriguez', 4,4),
(5, 'Ese', 'Rodriguez', 4,5),
(6, 'Javier', 'Rodriguez', 4,6),
(7, 'Luis', 'Rodriguez', 4,6);

COMMIT ;



SELECT COUNT (*) FROM users;

-- ALTER sequense users_id_seq restart with 10;