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

  ('Blade Runner 2049', 164, 4.5, 'Denis Villeneuve', 'Ryan Gosling, Harrison Ford, Ana de Armas',
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
   'https://www.youtube.com/embed/ByXuk9QqQkk','https://fr.web.img4.acsta.net/r_1920_1080/img/73/46/7346b5efd3b418856fd519ddd738a0a7.jpg', '2001-07-20', 'Japan', 'tt0245729'),

  ('The Social Network', 120, 5, 'David Fincher', 'Jesse Eisenberg, Andrew Garfield, Justin Timberlake', 'The story of the founding of Facebook and the legal battles that followed.', 'https://www.youtube.com/embed/lB95KLmpLR4', 'https://fr.web.img3.acsta.net/r_1920_1080/medias/nmedia/18/78/52/54/19465989.jpg', '2010-10-01', 'USA', 'tt1285016'),
  ('Forrest Gump', 142, 5, 'Robert Zemeckis', 'Tom Hanks, Robin Wright, Gary Sinise', 'The life of Forrest Gump, a simple man who finds himself in extraordinary situations throughout the latter half of the 20th century.', 'https://www.youtube.com/embed/bLvqoHBptjg', 'https://fr.web.img2.acsta.net/r_1920_1080/img/1f/67/1f677a264b39daec1e5d4dc2214190b3.jpg', '1994-07-06', 'USA', 'tt0109830'),
  ('The Green Mile', 189, 5, 'Frank Darabont', 'Tom Hanks, Michael Clarke Duncan, David Morse', 'The story of a man with supernatural healing powers on death row.', 'https://www.youtube.com/embed/Ki4haFrqSrw', 'https://fr.web.img4.acsta.net/r_1920_1080/medias/nmedia/18/66/15/78/19254683.jpg', '1999-12-10', 'USA', 'tt0120689'),
  ('The Silence of the Lambs', 118, 5, 'Jonathan Demme', 'Jodie Foster, Anthony Hopkins, Scott Glenn', 'A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.', 'https://www.youtube.com/embed/W6Mm8Sbe__o', 'https://fr.web.img6.acsta.net/r_1920_1080/img/5e/92/5e9243ee9515d125986262871dc0aa4f.jpg', '1991-02-14', 'USA', 'tt0102926'),
  ('Goodfellas', 146, 5, 'Martin Scorsese', 'Robert De Niro, Ray Liotta, Joe Pesci', 'The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.', 'https://www.youtube.com/embed/2ilzidi_J8Q', 'https://fr.web.img6.acsta.net/r_1920_1080/img/7e/0a/7e0ac404e7d93034be875d336ccbfd12.jpg', '1990-09-19', 'USA', 'tt0099685'),
  ('Schindler s List', 195, 5, 'Steven Spielberg', 'Liam Neeson, Ben Kingsley, Ralph Fiennes', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.', 'https://www.youtube.com/embed/JdRGC-w9syA', 'https://fr.web.img5.acsta.net/r_1920_1080/img/fd/dc/fddc74e3d3009b20d58b5800448d61b6.jpg', '1994-12-15', 'USA', 'tt0108052'),
  ('Se7en', 127, 5, 'David Fincher', 'Morgan Freeman, Brad Pitt, Kevin Spacey', 'Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.', 'https://www.youtube.com/embed/znmZoVkCjpI', 'https://fr.web.img6.acsta.net/r_1920_1080/img/0f/f8/0ff84ea3639ab128d9060621e04e9336.jpg', '1995-02-08', 'USA', 'tt0114369'),
  ('The Departed', 151, 5, 'Martin Scorsese', 'Leonardo DiCaprio, Matt Damon, Jack Nicholson', 'An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.', 'https://www.youtube.com/embed/auYbpnEwBBg', 'https://fr.web.img6.acsta.net/r_1920_1080/medias/nmedia/18/36/21/63/18663442.jpg', '2006-10-06', 'USA', 'tt0407887'),
  ('The Pianist', 150, 5, 'Roman Polanski', 'Adrien Brody, Thomas Kretschmann, Frank Finlay', 'A Polish Jewish musician struggles to survive the destruction of the Warsaw ghetto of World War II.', 'https://www.youtube.com/embed/BFwGqLa_oAo', 'https://fr.web.img3.acsta.net/r_1920_1080/medias/nmedia/00/02/46/23/affiche.jpg', '2002-09-25', 'France, Poland, Germany, UK', 'tt0253474'),
  ('Saving Private Ryan', 169, 5, 'Steven Spielberg', 'Tom Hanks, Matt Damon, Tom Sizemore', 'Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.', 'https://www.youtube.com/embed/zwhP5b4tD6g', 'https://fr.web.img2.acsta.net/r_1920_1080/img/35/9c/359c830da91d28fc90050d4f72938669.jpg', '1998-07-24', 'USA', 'tt0120815'),
  ('The Grand Budapest Hotel', 99, 5, 'Wes Anderson', 'Ralph Fiennes, F. Murray Abraham, Mathieu Amalric', 'The adventures of Gustave H, a legendary concierge at a famous European hotel between the wars, and Zero Moustafa, the lobby boy who becomes his most trusted friend.', 'https://www.youtube.com/embed/1Fg5iWmQjwk', 'https://fr.web.img6.acsta.net/r_1920_1080/img/3b/f5/3bf5ede1c6d3f3bcb8e6341a31f32d2b.jpg', '2014-03-26', 'Germany, USA', 'tt2278388'),

('La La Land', 128, 5, 'Damien Chazelle', 'Ryan Gosling, Emma Stone, Rosemarie DeWitt', 'While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.', 'https://www.youtube.com/embed/0pdqf4P9MB8', 'https://fr.web.img6.acsta.net/r_1920_1080/img/bd/74/bd749e995bec15ccab2ce53461f5a16d.jpg', '2017-01-25', 'USA, Hong Kong', 'tt3783958'),

('Eternal Sunshine of the Spotless Mind', 108, 5, 'Michel Gondry', 'Jim Carrey, Kate Winslet, Tom Wilkinson', 'When their relationship turns sour, a couple undergoes a medical procedure to have each other erased from their memories.', 'https://www.youtube.com/embed/c2e-bj6qy8Y', 'https://fr.web.img6.acsta.net/r_1920_1080/img/45/9d/459d43f477d3e857d4c054b569da0b97.jpg', '2004-03-17', 'USA', 'tt0338013'),

('The Truman Show', 103, 5, 'Peter Weir', 'Jim Carrey, Ed Harris, Laura Linney', 'An insurance salesman discovers his whole life is actually a reality TV show.', 'https://www.youtube.com/embed/loTIzXAS7v4', 'https://fr.web.img2.acsta.net/r_1920_1080/pictures/16/06/14/12/15/330151.jpg', '1998-06-03', 'USA', 'tt0120382'),

('Spider-Man', 121, 5, 'Sam Raimi', 'Tobey Maguire, Kirsten Dunst, Willem Dafoe', 'When bitten by a genetically modified spider, a nerdy, shy, and awkward high school student gains spider-like abilities that he eventually must use to fight evil as a superhero after tragedy befalls his family.', 'https://www.youtube.com/embed/O7zvehDxttM', 'https://fr.web.img5.acsta.net/r_1920_1080/medias/nmedia/00/00/00/33/spiderman.jpg', '2002-05-01', 'USA', 'tt0145487');


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
(3, 14, 'Tarantino s unique style is on full display in this genre-bending masterpiece.', 4.5),
(6, 15, 'A dark and disturbing film that will stay with you long after the credits roll.', 5),
(9, 15, 'A powerful exploration of masculinity and societal norms.', 4),
(4, 16, 'A beautiful and imaginative animated film that is perfect for all ages.', 5),
(7, 16, 'A heartwarming story about a young girl s journey through the spirit world.', 5),
(1, 17, 'A gripping and visually stunning film with a thought-provoking storyline.', 4.5),
(2, 17, 'Denis Villeneuve delivers another masterpiece with Blade Runner 2049. The cinematography is breathtaking.', 5),
(3, 17, 'A worthy successor to the original Blade Runner. Ryan Gosling delivers a standout performance.', 4.5),
(4, 18, 'Forrest Gump is a timeless classic that never fails to tug at the heartstrings. Tom Hanks is exceptional in the lead role.', 5),
(5, 18, 'An emotional rollercoaster from start to finish. Forrest Gump is a must-watch for any movie lover.', 4.5),
(6, 18, 'A heartwarming and inspirational journey through American history. Tom Hanks is brilliant as always.', 5),
(7, 18, 'Forrest Gump is a cinematic gem that touches the soul. A must-watch for any movie lover.', 5),
(8, 19, 'An emotionally powerful film with stellar performances. Michael Clarke Duncan is unforgettable in his role.', 4.5),
(9, 19, 'The Green Mile is a moving story that stays with you long after the credits roll. A true cinematic masterpiece.', 5),
(10, 19, 'A gripping and emotionally charged film that explores themes of redemption and humanity.', 4.5),
(11, 19, 'The Green Mile is a touching and thought-provoking film that leaves a lasting impression.', 4.5),
(1, 20, 'A suspenseful and chilling thriller with outstanding performances from Jodie Foster and Anthony Hopkins.', 5),
(2, 20, 'The Silence of the Lambs is a masterpiece of psychological horror. Anthony Hopkins iconic portrayal of Hannibal Lecter is unforgettable.', 5),
(3, 20, 'A tense and atmospheric film that keeps you on the edge of your seat until the very end.', 4.5),
(4, 20, 'The Silence of the Lambs is a gripping psychological thriller that will leave you breathless.', 4.5),
(5, 21, 'Goodfellas is a gritty and intense portrayal of the mafia lifestyle. Robert De Niro and Joe Pesci deliver standout performances.', 5),
(6, 21, 'A riveting crime drama with powerhouse performances and Martin Scorsese s masterful direction.', 4.5),
(7, 21, 'Goodfellas is a modern classic that expertly blends drama, violence, and dark humor.', 5),
(8, 21, 'A gripping and stylish film that immerses you in the world of organized crime.', 4.5),
(9, 22, 'Schindler s List is a harrowing and powerful film that showcases the resilience of the human spirit.', 5),
(10, 22, 'Steven Spielberg delivers a haunting and poignant portrayal of one man s quest to save lives during one of humanity s darkest periods.', 5),
(11, 22, 'A heartbreaking and unforgettable film that serves as a reminder of the atrocities of the Holocaust.', 4.5),
(5, 22, 'Schindler s List is a cinematic masterpiece that will leave a lasting impact on audiences worldwide.', 5),
(1, 23, 'Se7en is a chilling and atmospheric thriller with a shocking twist ending. Brad Pitt and Morgan Freeman deliver standout performances.', 5),
(2, 23, 'David Fincher crafts a dark and suspenseful film that keeps you guessing until the very end.', 4.5),
(3, 23, 'Se7en is a gripping and intense thriller that explores the darkest depths of the human psyche.', 5),
(4, 23, 'A disturbing and thought-provoking film that lingers in your mind long after it s over.', 4.5),
(5, 24, 'The Departed is a tense and gripping crime thriller with an all-star cast. Leonardo DiCaprio and Matt Damon deliver standout performances.', 5),
(6, 24, 'Martin Scorsese delivers another masterpiece with The Departed. The tension is palpable, and the twists keep you guessing until the very end.', 4.5),
(7, 24, 'The Departed is a riveting and suspenseful film that will keep you on the edge of your seat from start to finish.', 5),
(8, 24, 'A thrilling and unpredictable ride that showcases Martin Scorsese s mastery of the crime genre.', 4.5),
(9, 25, 'The Pianist is a haunting and emotional film that captures the horrors of the Holocaust with heartbreaking authenticity.', 5),
(10, 25, 'Adrien Brody delivers a powerhouse performance in Roman Polanski s gripping and unforgettable film.', 5),
(11, 25, 'A moving and poignant portrayal of survival and hope in the face of unimaginable adversity.', 4.5),
(6, 25, 'The Pianist is a cinematic triumph that leaves a profound impact on audiences long after the credits roll.', 5),
(1, 26, 'Saving Private Ryan is a visceral and emotionally powerful film that captures the brutality of war with stunning realism.', 5),
(2, 26, 'Steven Spielberg delivers an unforgettable cinematic experience with Saving Private Ryan. Tom Hanks delivers a career-defining performance.', 4.5),
(3, 26, 'A gripping and emotionally resonant film that pays tribute to the sacrifices of those who served in World War II.', 5),
(4, 26, 'Saving Private Ryan is a timeless classic that showcases the heroism and humanity of the Greatest Generation.', 4.5),
(5, 27, 'An absolute delight from start to finish. The quirky characters and whimsical storytelling make this film a joy to watch.', 5),
(6, 27, 'Wes Anderson s unique visual style and attention to detail shine in The Grand Budapest Hotel. A must-see for fans of offbeat cinema.', 4.5),
(7, 28, 'La La Land is a modern classic that reinvigorates the musical genre. Emma Stone and Ryan Gosling have incredible chemistry on screen.', 5),
(8, 28, 'A beautiful love letter to Los Angeles and the magic of Hollywood. The music and dance sequences are simply mesmerizing.', 5),
(9, 29, 'Eternal Sunshine of the Spotless Mind is a thought-provoking exploration of love, memory, and human connection. A true masterpiece.', 4),
(10, 29, 'Jim Carrey delivers a career-best performance in this mind-bending and emotionally resonant film. Michel Gondry s direction is exceptional.', 4.5),
(11, 30, 'The Truman Show is a thought-provoking satire that raises questions about reality, freedom, and the nature of entertainment. Jim Carrey is outstanding in the lead role.', 5),
(1, 30, 'Peter Weir s direction and Jim Carrey s performance make The Truman Show a captivating and unforgettable cinematic experience.', 4.5),
(2, 31, 'Spider-Man is a thrilling and action-packed superhero film that perfectly captures the spirit of the character. Tobey Maguire shines in the lead role.', 5),
(3, 31, 'Sam Raimi s Spider-Man is a nostalgic favorite for many, with its iconic scenes and memorable moments. A must-watch for comic book fans.', 4.5);


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

-- Insérer des genres
INSERT INTO genre (name) VALUES 
('Science Fiction'), ('Drama'), ('Thriller'), ('Action'), ('Crime'), ('Adventure'), ('Animation'), 
('Fantasy'), ('War'), ('Biography'), ('Comedy'), ('Romance');

-- Insérer des genres pour chaque film
INSERT INTO movie_genre (movie_id, genre_id)
VALUES
  (1, 1), (1, 2), (1, 6), -- Dune : Science Fiction, Drame, Aventure
  (2, 1), (2, 2), (2, 6), -- Dune: Part Two : Science Fiction, Drame, Aventure
  (3, 2), (3, 5), (3, 6), -- Oppenheimer : Drame, Crime, Aventure
  (4, 3), (4, 5), (4, 4), -- The Batman : Thriller, Crime, Action
  (5, 3), (5, 5), -- Joker : Thriller, Crime
  (6, 1), (6, 2), (6, 4), -- Interstellar : Science Fiction, Drame, Action
  (7, 2), -- The Shawshank Redemption : Drame
  (8, 2), (8, 5), -- The Godfather : Drame, Crime
  (9, 6), (9, 2), (9, 8), -- The Lord of the Rings: The Return of the King : Aventure, Drame, Fantasy
  (10, 2), (10, 5), -- The Dark Knight : Drame, Crime
  (11, 1), (11, 2), -- Inception : Science Fiction, Drame
  (12, 1), (12, 2), (12, 4), -- The Matrix : Science Fiction, Drame, Action
  (13, 1), (13, 2), (13, 4), -- Blade Runner 2049 : Science Fiction, Drame, Action
  (14, 2), (14, 5), (14, 1), -- Pulp Fiction : Drame, Crime, Science Fiction
  (15, 2), (15, 4), (15, 3), -- Fight Club : Drame, Action, Thriller
  (16, 6), (16, 7), (16, 8), -- Spirited Away : Aventure, Animation, Fantasy 
  (17, 2),  -- The Social Network : Drame
  (18, 2), (18, 6), -- Forrest Gump : Drame, Adventure
  (19, 2), (19, 8), -- The Green Mile : Drame, Fantasy
  (20, 3), (20, 5),  -- The Silence of the Lambs : Thriller, Crime
  (21, 5), (21, 3), -- Goodfellas : Crime, Thriller
  (22, 5), (22, 10), -- Schindler's List : Crime, Biography
  (23, 3), (23, 5), -- Se7en : Thriller, Crime
  (24, 5), (24, 10), -- The Departed : Crime, Biography
  (25, 2), (25, 10), (25, 9), -- The Pianist : Drame, Biography, War
  (26, 9),  -- Saving Private Ryan : War
  (27, 11), (27, 6), -- The Grand Budapest Hotel : Comedy, Aventure
  (28, 12), -- La La Land : Romance
  (29, 2), (29, 12), -- Eternal Sunshine of the Spotless Mind : Drame, Romance
  (30, 11), (30, 6), -- The Truman Show : Comédie, Aventure
  (31, 4), (31, 6), (31, 1); -- Spider-Man (2002) : Action, Aventure, Fantastique




