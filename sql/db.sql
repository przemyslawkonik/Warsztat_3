CREATE TABLE group(
	id INT AUTO_INCREMENT,
	name VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE user(
	id INT AUTO_INCREMENT,
	username VARCHAR(255),
	email VARCHAR(255) UNIQUE,
	password VARCHAR(245),
	group_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY(group_id) REFERENCES group(id) ON DELETE CASCADE
);

CREATE TABLE exercise(
	id INT AUTO_INCREMENT,
	title VARCHAR(255),
	description TEXT,
	PRIMARY KEY(id)
);

CREATE TABLE solution(
	id INT AUTO_INCREMENT,
	created DATETIME DEFAULT NOW(),
	updated DATETIME,
	description TEXT,
	exercise_id INT,
	user_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY(exercise_id) REFERENCES exercise(id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES user(id) ON DELETE CASCADE
);