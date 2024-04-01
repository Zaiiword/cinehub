INSERT INTO app_user (name, first_name, mail, language, password, role, accout_created, last_connection, profile_picture)
VALUES 
('Doe', 'John', 'john.doe@example.com', 'English', 'password123', 'admin', '2022-01-01', '2022-01-02', 'profile_picture_url1'),
('Smith', 'Jane', 'jane.smith@example.com', 'French', 'password456', 'user', '2022-01-03', '2022-01-04', 'profile_picture_url2'),
('Johnson', 'Robert', 'robert.johnson@example.com', 'Spanish', 'password789', 'admin', '2022-01-05', '2022-01-06', 'profile_picture_url3'),
('Williams', 'Michael', 'michael.williams@example.com', 'German', 'password1011', 'user', '2022-01-07', '2022-01-08', 'profile_picture_url4'),
('Brown', 'Sarah', 'sarah.brown@example.com', 'Italian', 'password1213', 'admin', '2022-01-09', '2022-01-10', 'profile_picture_url5'),
('Jones', 'Jessica', 'jessica.jones@example.com', 'English', 'password1415', 'user', '2022-01-11', '2022-01-12', 'profile_picture_url6'),
('Miller', 'Christopher', 'christopher.miller@example.com', 'French', 'password1617', 'admin', '2022-01-13', '2022-01-14', 'profile_picture_url7'),
('Davis', 'Jennifer', 'jennifer.davis@example.com', 'Spanish', 'password1819', 'user', '2022-01-15', '2022-01-16', 'profile_picture_url8'),
('Wilson', 'Brian', 'brian.wilson@example.com', 'German', 'password2021', 'admin', '2022-01-17', '2022-01-18', 'profile_picture_url9'),
('Anderson', 'Emily', 'emily.anderson@example.com', 'Italian', 'password2223', 'user', '2022-01-19', '2022-01-20', 'profile_picture_url10');


INSERT INTO movie (name, duration, rating, directors, actors, synopsis, trailer, poster, genres, released, production_country, imdb_id)
VALUES
('Dune', 155, 5, 'Denis Villeneuve', 'Timothée Chalamet, Rebecca Ferguson, Oscar Isaac', 'A noble family becomes embroiled in a war for control over the galaxy s most valuable asset while its heir becomes troubled by visions of a dark future.', 'https://www.youtube.com/watch?v=gHt8tCHbB2M&pp=ygUFZHVuZSA%3D', 'https://fr.web.img5.acsta.net/c_310_420/pictures/21/08/10/12/20/4633954.jpg', 'Sci-Fi, Adventure', '2020-09-15', 'USA', 'tt1160419'),
('Dune: Part Two', 165, 3, 'Denis Villeneuve', 'Timothée Chalamet, Zendaya, Rebecca Ferguson', 'The journey of Paul Atreides continues as he unites with Chani and the Fremen while facing new enemies in a quest to change the future.', 'https://www.youtube.com/watch?v=kF1WyiTZFTk', 'https://fr.web.img2.acsta.net/c_310_420/pictures/24/01/26/10/18/5392835.jpg', 'Sci-Fi, Adventure', '2023-10-20', 'USA', 'tt1272436'),

('Oppenheimer', 150, 4, 'Christopher Nolan', 'Cillian Murphy, Emily Blunt, Robert Downey Jr.', 'The story of J. Robert Oppenheimer and his role in the development of the atomic bomb.', 'https://www.youtube.com/watch?v=uYPbbksJxIg&pp=ygUTb3BwZW5oZWltZXIgdHJhaWxlcg%3D%3D', 'https://fr.web.img3.acsta.net/c_310_420/pictures/23/05/26/16/52/2793170.jpg', 'Biography, Drama', '2023-07-21', 'USA', 'tt11291274'),

('The Batman', 176, 3, 'Matt Reeves', 'Robert Pattinson, Zoë Kravitz, Paul Dano', 'In his second year of fighting crime, Batman uncovers corruption in Gotham City that connects to his own family while facing a serial killer known as the Riddler.', 'https://www.youtube.com/watch?v=mqqft2x_Aa4&pp=ygUSdGhlIGJhdG1hbiB0cmFpbGVy', 'https://fr.web.img3.acsta.net/c_310_420/pictures/22/02/16/17/42/3125788.jpg', 'Action, Crime, Drama', '2022-03-04', 'USA', 'tt1877830'),

('Joker', 122, 5, 'Todd Phillips', 'Joaquin Phoenix, Robert De Niro, Zazie Beetz', 'In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime.', 'https://www.youtube.com/watch?v=t433PEQGErc', 'https://fr.web.img4.acsta.net/c_310_420/pictures/19/09/03/12/02/4765874.jpg', 'Crime, Drama, Thriller', '2019-10-04', 'USA', 'tt7286456'),

('Interstellar', 169, 4, 'Christopher Nolan', 'Matthew McConaughey, Anne Hathaway, Jessica Chastain', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity s survival.', 'https://www.youtube.com/watch?v=zSWdZVtXT7E', 'https://www.allocine.fr/video/player_gen_cmedia=19548515&cfilm=114782.html', 'Adventure, Drama, Sci-Fi', '2014-11-07', 'USA, UK', 'tt0816692');
