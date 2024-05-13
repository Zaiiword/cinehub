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

('Interstellar', 169, 4, 'Christopher Nolan', 'Matthew McConaughey, Anne Hathaway, Jessica Chastain', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity s survival.', 'https://www.youtube.com/embed/zSWdZVtXT7E', 'https://fr.web.img5.acsta.net/c_310_420/pictures/14/09/24/12/08/158828.jpg', '2014-11-07', 'USA, UK', 'tt0816692'),

('The Shawshank Redemption', 142, 5, 'Frank Darabont', 'Tim Robbins, Morgan Freeman', 'A banker is sentenced to life in Shawshank prison for the murder of his wife, though he didn t commit the crime. He turns to a fellow inmate for help in coping with prison life and finding redemption.', 'https://www.youtube.com/embed/PLl99DlL6b4', 'https://fr.web.img4.acsta.net/r_1920_1080/pictures/bzp/01/11736.jpg', '1994-09-23', 'USA', 'tt0111161'),

('The Godfather', 175, 5, 'Francis Ford Coppola', 'Marlon Brando, Al Pacino, James Caan', 'The story of the Corleone family under patriarch Vito Corleone, focusing on the transformation of his youngest son, Michael, from reluctant family outsider to ruthless mafia boss.', 'https://www.youtube.com/embed/UaVTIH8mujA', 'https://fr.web.img3.acsta.net/r_1920_1080/medias/nmedia/18/91/63/78/20155809.jpg', '1972-03-24', 'USA', 'tt0000001'),

('The Lord of the Rings: The Return of the King', 201, 5, 'Peter Jackson', 'Elijah Wood, Viggo Mortensen, Ian McKellen', 'Gandalf and Aragorn lead the remaining forces of Good in a desperate stand against Sauron s dark armies as Frodo and Sam journey to Mordor to destroy the One Ring.', 'https://www.youtube.com/embed/r5X-hFf6Bwo', 'https://fr.web.img2.acsta.net/r_1920_1080/pictures/bzp/01/39187.jpg', '2003-12-17', 'New Zealand, USA', 'tt0166984'),

('The Dark Knight', 152, 4.5, 'Christopher Nolan', 'Christian Bale, Heath Ledger, Aaron Eckhart', 'With the Joker wreaking havoc on Gotham City, Batman must face a difficult ethical choice to ultimately save the city.', 'https://www.youtube.com/embed/EXeTwQWrcwY', 'https://fr.web.img2.acsta.net/r_1920_1080/medias/nmedia/18/63/97/89/18949761.jpg', '2008-07-18', 'USA, UK', 'tt0468569'),

('Inception', 148, 4.5, 'Christopher Nolan', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page', 'A professional thief who steals corporate secrets through use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.', 'https://www.youtube.com/embed/YoHD9XEInc0', 'https://fr.web.img6.acsta.net/r_1920_1080/medias/nmedia/18/72/34/14/19476652.jpg', '2010-07-16', 'USA, UK', 'tt1375666'),

('The Matrix', 136, 4.5, 'Lana Wachowski, Lilly Wachowski', 'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss',
   'A computer hacker learns that the world he lives in is actually a computer simulation and fights to escape it.',
   'https://www.youtube.com/embed/vKQi3bBA1y8', 'https://fr.web.img4.acsta.net/c_310_420/medias/04/34/49/043449_af.jpg', '1999-03-31', 'USA', 'tt0133693'),

  ('Blade Runner 2049', 164, 4.8, 'Denis Villeneuve', 'Ryan Gosling, Harrison Ford, Ana de Armas',
   'A young blade runner discovers a secret that could throw humanity into chaos.',
   'https://www.youtube.com/embed/gCcx85zbxz4', 'https://fr.web.img6.acsta.net/r_1920_1080/pictures/17/08/25/11/58/463146.jpg', '2017-10-06', 'USA', 'tt1856101'),

  ('Pulp Fiction', 154, 4.6, 'Quentin Tarantino', 'John Travolta, Samuel L. Jackson, Uma Thurman',
   'Several stories of crime, violence, and redemption intertwine in a series of vignettes.',
   'https://www.youtube.com/embed/tGpTpVyI_OQ', 'https://fr.web.img5.acsta.net/r_1920_1080/img/b4/39/b43957f0957ae59beb251567e1c65c29.jpg', '1994-09-23', 'USA', 'tt0110912'),

  ('Fight Club', 139, 4.3, 'David Fincher', 'Brad Pitt, Edward Norton, Helena Bonham Carter',
   'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into something much, much more.',
   'https://www.youtube.com/embed/BdJKm16Co6M', 'https://fr.web.img6.acsta.net/r_1920_1080/img/23/b7/23b757ce995171ae05ba7449c67a47dc.jpg', '1999-10-15', 'USA', 'tt0120915'),

  ('Spirited Away', 125, 4.9, 'Hayao Miyazaki', 'Rumi Hiiragi, Mari Nakatsu, Yasuko Sawada',
   'A young girl wanders into the spirit world and must find a way to free herself and her parents.',
   'https://www.youtube.com/embed/ByXuk9QqQkk','https://fr.web.img4.acsta.net/r_1920_1080/img/73/46/7346b5efd3b418856fd519ddd738a0a7.jpg', '2001-07-20', 'Japan', 'tt0245729');
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
(8, 6, 'Conceptually ambitious', 4),
(1, 7, 'A timeless classic that never gets old. The story is gripping and the characters are unforgettable.', 5),
(2, 7, 'A masterpiece of filmmaking. The acting, directing, and writing are all top-notch.', 5),
(3, 8, 'An epic gangster story that will keep you on the edge of your seat.', 5),
(4, 8, 'Marlon Brando is absolutely incredible in this film. One of the greatest performances of all time.', 4.5),
(5, 9, 'The perfect conclusion to an amazing trilogy. This movie is a must-see for any fan of fantasy.', 5),
(6, 9, 'The special effects in this movie are groundbreaking. They really take you to another world.', 4),
(7, 10, 'A dark and gritty superhero movie that will leave you thinking long after the credits roll.', 5),
(8, 10, 'Heath Ledger s performance as the Joker is one of the most iconic in cinema history.', 4.5),
(9, 11, 'A mind-bending sci-fi movie that will challenge your perception of reality.', 5),
(10, 11, 'Christopher Nolan is a genius. This movie is a must-see for any fan of his work.', 4.5),
(11, 12, 'A ground-breaking sci-fi film that explores complex philosophical themes.', 5),
(1, 12, 'Mind-blowing action sequences and a thought-provoking story.', 4.5),
(2, 13, 'A visually stunning sequel that expands on the original film s universe.', 5),
(5, 13, 'A worthy follow-up that lives up to the hype.', 4.5),
(8, 14, 'A cult classic with unforgettable characters and quotable dialogue.', 5),
(3, 14, 'Tarantino s unique style is on full display in this genre-bending masterpiece.', 4.8),
(6, 15, 'A dark and disturbing film that will stay with you long after the credits roll.', 5),
(9, 15, 'A powerful exploration of masculinity and societal norms.', 4),
(4, 16, 'A beautiful and imaginative animated film that is perfect for all ages.', 5),
(7, 16, 'A heartwarming story about a young girl s journey through the spirit world.', 5);


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

INSERT INTO genre (name) VALUES ('Science Fiction'), ('Drame'), ('Thriller'), ('Action'), ('Crime'), ('Aventure'), ('Animation');

-- Insérer des genres pour chaque film
INSERT INTO movie_genre (movie_id, genre_id)
VALUES
  (1, 1), (1, 2), (1, 4), -- Dune : Science Fiction, Drame, Action
  (2, 1), (2, 2), (2, 4), -- Dune: Part Two : Science Fiction, Drame, Action
  (3, 2), (3, 5), -- Oppenheimer : Drame, Action, Crime
  (4, 3), (4, 5), (4, 4), -- The Batman : Thriller, Crime, Action
  (5, 3), (5, 4), -- Joker : Thriller, Horreur
  (6, 1), (6, 2), (6, 4), -- Interstellar : Science Fiction, Drame, Action
  (7, 2), -- The Shawshank Redemption : Drame
  (8, 2), (8, 5), -- The Godfather : Drame, Crime
  (9, 5), (9, 2), -- The Lord of the Rings: The Return of the King : Aventure, Drame
  (10, 2), (10, 5), -- The Dark Knight : Drame, Crime
  (11, 1), (11, 2), -- Inception : Science Fiction, Drame
  (12, 1), (12, 2), (12, 4), -- The Matrix : Science Fiction, Drame, Action
  (13, 1), (13, 2), (13, 4), -- Blade Runner 2049 : Science Fiction, Drame, Action
  (14, 2), (14, 4), (14, 5), -- Pulp Fiction : Drame, Action
  (15, 2), (15, 4), -- Fight Club : Drame, Action
  (16, 1), (16, 2), (16, 6); -- Spirited Away : Science Fiction, Drame, Animation 
