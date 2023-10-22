SET @@foreign_key_checks = 0;

TRUNCATE TABLE hotel;

INSERT INTO hotel (hotel_no, createdAt, modifiedAt, check_in, check_out, grade, hotel_name, hotel_type, location, star_rate_average, owner_no)
VALUES (1, '2023-10-23 00:00:00', '2023-10-23 00:00:00', '15:00', '11:00', 5, 'A호텔', '호텔', '서울', 5.0, 1);
INSERT INTO hotel (hotel_no, createdAt, modifiedAt, check_in, check_out, grade, hotel_name, hotel_type, location, star_rate_average, owner_no)
VALUES (2, '2023-10-23 00:00:00', '2023-10-23 00:00:00', '15:00', '11:00', 5, 'B호텔', '호텔', '서울', 5.0, 1);
INSERT INTO hotel (hotel_no, createdAt, modifiedAt, check_in, check_out, grade, hotel_name, hotel_type, location, star_rate_average, owner_no)
VALUES (3, '2023-10-23 00:00:00', '2023-10-23 00:00:00', '15:00', '11:00', 5, 'A호텔', '민박', '서울', 5.0, 1);
INSERT INTO hotel (hotel_no, createdAt, modifiedAt, check_in, check_out, grade, hotel_name, hotel_type, location, star_rate_average, owner_no)
VALUES (4, '2023-10-23 00:00:00', '2023-10-23 00:00:00', '15:00', '11:00', 5, 'A호텔', '호텔', '대전', 5.0, 1);
INSERT INTO hotel (hotel_no, createdAt, modifiedAt, check_in, check_out, grade, hotel_name, hotel_type, location, star_rate_average, owner_no)
VALUES (5, '2023-10-23 00:00:00', '2023-10-23 00:00:00', '15:00', '11:00', 4, 'A호텔', '호텔', '서울', 5.0, 1);

SET @@foreign_key_checks = 1;