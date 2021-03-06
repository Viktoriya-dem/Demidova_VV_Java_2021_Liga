CREATE TABLE IF NOT EXISTS reserves(
                                       id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                                       date DATE,
                                       active boolean,
                                       user_id INT,
                                       FOREIGN KEY (user_id) REFERENCES users(id)
    );