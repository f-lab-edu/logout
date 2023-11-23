DROP TABLE IF EXISTS review;
CREATE TABLE review(
    seq bigint auto_increment,
    star_rate int,
    contents varchar(200),
    user_id varchar(20) not null,
    hotel_no bigint not null,
    PRIMARY KEY (seq),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (hotel_no) REFERENCES hotel(hotel_no)
)