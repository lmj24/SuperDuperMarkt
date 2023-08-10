INSERT INTO type (id, name)
VALUES
    (1, 'Wein'),
    (2, 'Käse'),
    (3, 'Obst'),
    (4, 'Milch');

INSERT INTO article (name, quality, expiration_date, price, type_id)
VALUES
    ('Bio Wein', 40, '2023-09-18', 4.99, 1),
    ('Tilsiter', 60, '2023-08-31', 2.99, 2),
    ('Birnen', 80, '2023-08-19', 1.49, 3),
    ('Bio Milch 3,5%', 90, '2023-09-02', 1.19, 4);
