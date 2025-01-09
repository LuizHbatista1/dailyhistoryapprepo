ALTER TABLE roles ALTER COLUMN user_id DROP NOT NULL;
INSERT INTO roles (role_id , name ) VALUES (1 , 'ADMIN') ;
INSERT INTO roles (role_id , name ) VALUES (2 , 'BASIC') ;