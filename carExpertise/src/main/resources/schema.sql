CREATE TABLE PUBLIC.car (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  licensePlate VARCHAR(255) NOT NULL UNIQUE,
  brand VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  production_year INTEGER NOT NULL,
  created_date DATE NOT NULL
);

CREATE TABLE PUBLIC.question (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  question VARCHAR(255) NOT NULL
);

CREATE TABLE PUBLIC.expertise_detail (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  question_id INTEGER,
  response boolean NOT NULL,
  comment VARCHAR(255),
  car_id INTEGER NOT NULL,
  created_date DATE NOT NULL,
  FOREIGN KEY (question_id) REFERENCES question(id),
  FOREIGN KEY (car_id) REFERENCES car(id)
);

CREATE TABLE PUBLIC.expertise_photo (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  expertise_detail_id INTEGER NOT NULL,
  url VARCHAR(255) NOT NULL,
  created_date DATE NOT NULL,
  FOREIGN KEY (expertise_detail_id) REFERENCES expertise_detail(id)
);


