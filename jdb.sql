CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE,
    password VARCHAR(50),
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    email VARCHAR(30) UNIQUE,
    role_name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS books (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(30),
    author VARCHAR(30),
    copies INT(10),
    category_id INT,
    issued BOOLEAN
);

CREATE TABLE IF NOT EXISTS roles (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS categories (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS issues (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    book_title VARCHAR(30),
    borrower_id INT,
    borrower_name VARCHAR(30),
	staff_id INT,
    staff_name VARCHAR(30),
    issue_date DATE,
    return_date DATE
    
);
CREATE TABLE IF NOT EXISTS returns (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    borrower_id INT,
    borrower_name VARCHAR(30),
    staff_id INT,
    staff_name VARCHAR(30),
    issue_date DATE,
    return_date DATE
);

CREATE TABLE IF NOT EXISTS rates (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    book_id INT,
    score int
);