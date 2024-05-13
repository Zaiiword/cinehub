INSERT INTO app_user (name, first_name, mail, language, password, role, accout_created, last_connection, profile_picture)
VALUES 
('Doe', 'John', 'john.doe@example.com', 'English', 'password123', 'admin', '2022-01-01', '2022-01-02', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Smith', 'Jane', 'jane.smith@example.com', 'French', 'password456', 'user', '2022-01-03', '2022-01-04', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Johnson', 'Robert', 'robert.johnson@example.com', 'Spanish', 'password789', 'admin', '2022-01-05', '2022-01-06', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Williams', 'Michael', 'michael.williams@example.com', 'German', 'password1011', 'user', '2022-01-07', '2022-01-08', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Brown', 'Sarah', 'sarah.brown@example.com', 'Italian', 'password1213', 'admin', '2022-01-09', '2022-01-10', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Jones', 'Jessica', 'jessica.jones@example.com', 'English', 'password1415', 'user', '2022-01-11', '2022-01-12', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Miller', 'Christopher', 'christopher.miller@example.com', 'French', 'password1617', 'admin', '2022-01-13', '2022-01-14', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Davis', 'Jennifer', 'jennifer.davis@example.com', 'Spanish', 'password1819', 'user', '2022-01-15', '2022-01-16', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Wilson', 'Brian', 'brian.wilson@example.com', 'German', 'password2021', 'admin', '2022-01-17', '2022-01-18', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Anderson', 'Emily', 'emily.anderson@example.com', 'Italian', 'password2223', 'user', '2022-01-19', '2022-01-20', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png'),
('Dekeister', 'clément', 'admin', 'German', '$2a$12$uM09p9hjtvjQqZf14klQ9.JfGt2GPO5iX3F9vXFRX43npwuX3F/D.', 'admin', '2022-01-17', '2022-01-18', 'https://fr.web.img6.acsta.net/c_80_80/commons/v9/common/empty/empty_avatar.png');


INSERT INTO movie (name, duration, rating, directors, actors, synopsis, trailer, poster, released, production_country, imdb_id)
VALUES
('Dune', 155, 5, 'Denis Villeneuve', 'Timothée Chalamet, Rebecca Ferguson, Oscar Isaac', 'A noble family becomes embroiled in a war for control over the galaxy s most valuable asset while its heir becomes troubled by visions of a dark future.', 'https://www.youtube.com/embed/gHt8tCHbB2M', 'https://fr.web.img5.acsta.net/c_310_420/pictures/21/08/10/12/20/4633954.jpg', '2020-09-15', 'USA', 'tt1160419'),
('Dune: Part Two', 165, 3, 'Denis Villeneuve', 'Timothée Chalamet, Zendaya, Rebecca Ferguson', 'The journey of Paul Atreides continues as he unites with Chani and the Fremen while facing new enemies in a quest to change the future.', 'https://www.youtube.com/embed/kF1WyiTZFTk', 'https://fr.web.img2.acsta.net/c_310_420/pictures/24/01/26/10/18/5392835.jpg', '2023-10-20', 'USA', 'tt1272436'),

('Oppenheimer', 150, 4, 'Christopher Nolan', 'Cillian Murphy, Emily Blunt, Robert Downey Jr.', 'The story of J. Robert Oppenheimer and his role in the development of the atomic bomb.', 'https://www.youtube.com/embed/uYPbbksJxIg', 'https://fr.web.img3.acsta.net/c_310_420/pictures/23/05/26/16/52/2793170.jpg', '2023-07-21', 'USA', 'tt11291274'),

('The Batman', 176, 3, 'Matt Reeves', 'Robert Pattinson, Zoë Kravitz, Paul Dano', 'In his second year of fighting crime, Batman uncovers corruption in Gotham City that connects to his own family while facing a serial killer known as the Riddler.', 'https://www.youtube.com/embed/mqqft2x_Aa4', 'https://fr.web.img3.acsta.net/c_310_420/pictures/22/02/16/17/42/3125788.jpg', '2022-03-04', 'USA', 'tt1877830'),

('Joker', 122, 5, 'Todd Phillips', 'Joaquin Phoenix, Robert De Niro, Zazie Beetz', 'In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime.', 'https://www.youtube.com/embed/t433PEQGErc', 'https://fr.web.img4.acsta.net/c_310_420/pictures/19/09/03/12/02/4765874.jpg', '2019-10-04', 'USA', 'tt7286456'),

('Interstellar', 169, 4, 'Christopher Nolan', 'Matthew McConaughey, Anne Hathaway, Jessica Chastain', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity s survival.', 'https://www.youtube.com/embed/zSWdZVtXT7E', 'https://fr.web.img5.acsta.net/c_310_420/pictures/14/09/24/12/08/158828.jpg', '2014-11-07', 'USA, UK', 'tt0816692');

INSERT INTO review (user_id, movie_id, content, rating) 
VALUES 
(1, 1, 'Great movie', 5),
(2, 1, 'Awesome movie', 4.5),
(1, 1, 'Great movie', 5),
(2, 1, 'Awesome movie', 4),
(3, 1, 'Epic storytelling', 5), 
(4, 2, 'Mind-blowing sequel', 5),
(5, 2, 'A worthy continuation', 4),
(6, 2, 'Disappointing compared to the first', 3),
(7, 3, 'Intense and gripping', 4),
(8, 3, 'Intriguing portrayal of Oppenheimer', 4),
(9, 3, 'Slow pacing, but worth it', 3),
(10, 4, 'Dark and gritty, a must-watch', 5),
(1, 4, 'Solid performance from Pattinson', 4),
(2, 4, 'Expected more from the storyline', 3),
(3, 5, 'Joaquin Phoenix is exceptional', 5),
(4, 5, 'Disturbing yet captivating', 5),
(5, 5, 'Haunting portrayal of a descent into madness', 4),
(6, 6, 'Mind-bending and emotional', 5),
(7, 6, 'Visually stunning', 4),
(8, 6, 'Conceptually ambitious', 4);


UPDATE movie m
SET rating = (
    SELECT AVG(r.rating)
    FROM review r
    WHERE r.movie_id = m.id
)
WHERE EXISTS (
    SELECT 1
    FROM review r
    WHERE r.movie_id = m.id
);

INSERT INTO genre (name) VALUES ('Science Fiction'), ('Drame'), ('Thriller'), ('Action'), ('Horreur'), ('Comédie'), ('Crime');

-- Insérer des genres pour chaque film
INSERT INTO movie_genre (movie_id, genre_id) VALUES 
(1, 1), (1, 2), (1, 4), -- Dune : Science Fiction, Drame, Action
(2, 1), (2, 2), (2, 4), -- Dune: Part Two : Science Fiction, Drame, Action
(3, 2), (3, 7), -- Oppenheimer : Drame, Action, Crime
(4, 3), (4, 7), (4, 4), -- The Batman : Thriller, Crime, Action
(5, 3), (5, 5),         -- Joker : Thriller, Horreur
(6, 1), (6, 2), (6, 4); -- Interstellar : Science Fiction, Drame, Action
