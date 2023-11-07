CREATE TABLE review(
                       id SERIAL PRIMARY KEY,
                       name TEXT NOT NULL,
                       dorm_Name TEXT NOT NULL,
                       description TEXT NOT NULL,
                       date TEXT NOT NULL,
                       rating INT NOT NULL

)