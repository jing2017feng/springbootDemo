INSERT INTO user(id, name, age) SELECT 1, 'test', 99 FROM DUAL WHERE NOT EXISTS(SELECT id FROM user WHERE id = 1);
