delete from reservation where id > 0;
INSERT INTO reservation (id, car_id, end_date, price, start_date, user_id)
VALUES
(1,1,'2017-12-20 23:34',450.00,'2017-12-19 23:34',1),
(2,2,'2017-12-30 23:34',375.00,'2017-12-24 23:34',1),
(3,3,'2017-12-15 23:34',690.00,'2017-12-10 23:34',2),
(4,3,'2018-01-16 23:34',690.00,'2018-01-10 23:34',2),
(5,3,'2018-03-20 23:34',690.00,'2018-03-10 23:34',2),
(6,3,'2018-04-02 23:34',690.00,'2018-04-01 23:34',2),
(7,3,'2018-04-04 23:34',690.00,'2018-04-03 23:34',2),
(8,3,'2018-04-06 23:34',690.00,'2018-04-05 23:34',2),
(9,3,'2018-04-08 23:34',690.00,'2018-04-07 23:34',2);
SELECT * FROM reservation;