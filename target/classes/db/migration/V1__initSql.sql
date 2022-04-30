-- Airport

INSERT INTO public.airport (airport_name,city_name,short_code) VALUES
	 ('Sân bay quốc tế Nội Bài','Hà Nội','HAN'),
	 ('Sân bay quốc tế Cát Bì','Hải Phòng','HPH'),
	 ('Sân bay Điện Biên Phủ','Điện Biên','DIN'),
	 ('Sân Bay Thọ Xuân','Thanh Hóa','THD'),
	 ('Sân bay quốc tế Vinh','Nghệ An','VII'),
	 ('Sân bay Đồng Hới','Quảng Bình','VDH'),
	 ('Sân bay quốc tế Phú Bài','Thừa Thiên Huế','HUI'),
	 ('Sân bay quốc tế Đà Nẵng','Đà Nẵng','DAD'),
	 ('Sân bay quốc tế Chu Lai','Quảng Nam','VCL'),
	 ('Sân bay Phù Cát','Bình Định','UIH');
INSERT INTO public.airport (airport_name,city_name,short_code) VALUES
	 ('Sân bay Tuy Hòa','Phú Yên','TBB'),
	 ('Sân bay quốc tế Cam Ranh','Khánh Hòa','CXR'),
	 ('Sân bay Buôn Ma Thuột','Đắk Lắk','BMV'),
	 ('Sân bay Liên Khương','Lâm Đồng','DLI'),
	 ('Sân bay Pleiku','Gia Lai','PXU'),
	 ('Sân bay quốc tế Tân Sơn Nhất','Thành phố Hồ Chí Minh','SGN'),
	 ('Sân bay Cà Mau','Cà Mau','CAH'),
	 ('Sân bay Côn Đảo','Bà Rịa - Vũng Tàu','VCS'),
	 ('Sân bay quốc tế Cần Thơ','Cần Thơ','VCA'),
	 ('Sân bay Rạch Giá','Kiên Giang','VKG');
INSERT INTO public.airport (airport_name,city_name,short_code) VALUES
	 ('Sân bay quốc tế Vân Đồn','Quảng Ninh','VDO');

-- Credit Card

INSERT INTO public.credit_card (balance,card_number,cvv,card_code,card_name) VALUES
	 (50000.0,'79927398713','898',NULL,NULL),
	 (50000.0,'5485660097282127','898',NULL,NULL);

-- Flight

INSERT INTO public.flight (arrival_time,departure_time,destination_airport_id,flight_status,origin_airport_id,root_price,flight_number) VALUES
	 ('2022-05-09 13:00:00','2022-05-09 08:30:00',5,0,8,101.0,'VN151'),
	 ('2022-05-10 13:00:00','2022-05-10 08:30:00',5,0,8,101.0,'VN151'),
	 ('2022-05-11 13:00:00','2022-05-11 08:30:00',5,0,8,101.0,'VN151'),
	 ('2022-05-12 13:00:00','2022-05-12 08:30:00',5,0,8,101.0,'VN151'),
	 ('2022-05-13 13:00:00','2022-05-13 08:30:00',5,0,8,101.0,'VN151'),
	 ('2022-05-14 13:00:00','2022-05-14 08:30:00',5,0,8,101.0,'VN151'),
	 ('2022-05-13 13:00:00','2022-05-13 08:30:00',8,0,5,101.0,'VN151'),
	 ('2022-05-12 13:00:00','2022-05-12 08:30:00',8,0,5,101.0,'VN151'),
	 ('2022-05-11 13:00:00','2022-05-11 08:30:00',8,0,5,101.0,'VN151'),
	 ('2022-05-10 13:00:00','2022-05-10 08:30:00',8,0,5,101.0,'VN151');
INSERT INTO public.flight (arrival_time,departure_time,destination_airport_id,flight_status,origin_airport_id,root_price,flight_number) VALUES
	 ('2022-05-09 13:00:00','2022-05-09 08:30:00',8,0,5,101.0,'VN151'),
	 ('2022-05-14 13:00:00','2022-05-14 08:30:00',8,0,5,101.0,'VN151'),
	 ('2022-05-15 09:30:00','2022-05-15 07:50:00',8,0,1,128.09,'VN6075'),
	 ('2022-05-15 16:15:00','2022-05-15 14:50:00',8,0,1,110.66,'VN6075'),
	 ('2022-05-16 16:15:00','2022-05-16 14:50:00',8,0,1,110.66,'VN6075'),
	 ('2022-05-16 09:30:00','2022-05-16 07:50:00',8,0,1,128.09,'VN6075'),
	 ('2022-05-09 13:00:00','2022-05-09 08:30:00',18,0,8,128.09,'VN6075'),
	 ('2022-05-09 13:45:00','2022-05-09 09:15:00',18,0,8,128.09,'VN6075');

-- User

INSERT INTO public.t_user (pass_word,"role",user_name) VALUES
	 ('$2a$10$2U7jTK1hMSxAVRyWWcbgFOhnqHzZis3sG0apiZM3pI/D7whMVjn0G',1,'admin');
