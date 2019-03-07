INSERT INTO users (id, ds_name, ds_lastname, age)
VALUES
(1, 'Javier', 'Rodriguez', 4),
(2, 'Barney', 'Rodriguez', 4),
(3, 'Cholos', 'Rodriguez', 4),
(4, 'Mem', 'Rodriguez', 4),
(5, 'Ese', 'Rodriguez', 4),
(6, 'Javier', 'Rodriguez', 4),
(7, 'Luis', 'Rodriguez', 4);

COMMIT ;

SELECT COUNT (*) FROM users;

-- ALTER sequense users_id_seq restart with 10;