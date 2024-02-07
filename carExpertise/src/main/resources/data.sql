INSERT INTO PUBLIC.car (licensePlate, brand, model, production_year, created_date)
VALUES ('34ABC123', 'Toyota', 'Camry', 2020, CURDATE());

INSERT INTO PUBLIC.car (licensePlate, brand, model, production_year, created_date)
VALUES ('34DEF456', 'Honda', 'Civic', 2022, CURDATE());

INSERT INTO PUBLIC.question (question)
VALUES ('Multimedyada problem var mı?');

INSERT INTO PUBLIC.question (question)
VALUES ('Ruhsatta eksiklik var mı?');

INSERT INTO PUBLIC.question (question)
VALUES ('Aküde eksiklik veya problem var mı?');

INSERT INTO PUBLIC.expertise_detail (question_id, response, comment, car_id, created_date)
VALUES (1, true, 'Ses butonu bozuk.', 1, CURDATE());

INSERT INTO PUBLIC.expertise_detail (question_id, response, comment, car_id, created_date)
VALUES (2, false, null, 1, CURDATE());

INSERT INTO PUBLIC.expertise_detail (question_id, response, comment, car_id, created_date)
VALUES (3, false, null, 1, CURDATE());

INSERT INTO PUBLIC.expertise_detail (question_id, response, comment, car_id, created_date)
VALUES (1, false, null, 2, CURDATE());

INSERT INTO PUBLIC.expertise_detail (question_id, response, comment, car_id, created_date)
VALUES (2, true, 'Ruhsat eksik.', 2, CURDATE());

INSERT INTO PUBLIC.expertise_detail (question_id, response, comment, car_id, created_date)
VALUES (3, false, null, 2, CURDATE());

INSERT INTO PUBLIC.expertise_photo (expertise_detail_id, url, created_date)
VALUES (1, 'https://www.tiktakkirala.com/cmsfiles/sliders/tiktak-neo-1.png', CURDATE());

INSERT INTO PUBLIC.expertise_photo (expertise_detail_id, url, created_date)
VALUES (5, 'https://www.tiktakkirala.com/cmsfiles/sliders/tiktak-neo-1.png', CURDATE());