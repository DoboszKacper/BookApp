CREATE TABLE books (
    book_id     INT PRIMARY KEY NOT NULL,
    title       TEXT NOT NULL,
    author      TEXT NOT NULL,
	imgId		INT NOT NULL,
    year        INTEGER NOT NULL,
	description TEXT
);

INSERT INTO books (book_id, title, author, imgID , year) 
VALUES (1, 'A Game of Thrones', 'George R. R. Martin',1, 2003),
       (2, 'A Clash of Kings', 'George R. R. Martin',2, 2003),
       (3, 'A Storm of Swords', 'George R. R. Martin',3, 2003),
       (4, 'Harry Potter and the Sorcerer''s Stone', 'J.K. Rowling',4, 1999),
       (5, 'A Dance with Dragons', 'George R. R. Martin',5, 2013),
	   (6, 'This Young Monster', 'Charlie Fox',6, 2003),
       (7, 'Atonement', 'Ian McEwan',7, 2000),
       (8, 'White Teeth', ' White Teeth',8, 2000),
       (9, ' The Road', 'Cormac McCarthy',9, 2000),
       (10, ' The Corrections', 'Jonathan Franzen',10, 2000),
	   (11, ' The Sense of an Ending', 'Julian Barnes',11, 2010),
       (12, 'Gone Girl', 'Gillian Flynn',12, 2011);