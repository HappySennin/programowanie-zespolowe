delete from car where id > 0;
ALTER TABLE `db_rentapp`.`car` 
ADD COLUMN `URL` VARCHAR(500) NULL DEFAULT NULL AFTER `type_name`;
insert into car (id,brand_name,model_name,power,price,type_name, URL)
values (1,'Mazda','Mazda 6','184 HP',450.0,'Sedan','http://cdn1.autoexpress.co.uk/sites/autoexpressuk/files/styles/article_main_image/public/1_mazda_front_cornering.jpg?itok=a52tpC1a'),
(2,'Honda','Accord','189 HP',375.0,'Sedan','https://media.ed.edmunds-media.com/honda/accord/2017/ot/2017_honda_accord_LIFE1_ot_1110162_1280.jpg'),
(3,'Audi','A8','333 HP',690.0,'Sedan','https://buyersguide.caranddriver.com/media/assets/submodel/7701.jpg'),
(4,'Chevrolet','SS','415 HP',750.40,'Sedan', 'http://www.chevrolet.com/content/dam/chevrolet/na/us/english/index/vehicles/2017/performance/ss-sedan/mov/01-images/2017-ss-performance-01.jpg?imwidth=1200'),
(5,'Kia','Stinger','365 HP',620.55,'Sedan','http://bi.gazeta.pl/im/5c/3c/14/z21217628IE,Kia-Stinger.jpg'),
(6,'Mercedes-Benz','S-class','463 HP',1099.99,'Sedan', 'https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/788x525/quality/85/https://s.aolcdn.com/commerce/autodata/images/USC40MBC783A021001.jpg'),
(7,'Audi','Q7','252 HP',740.63,'SUV','https://hips.hearstapps.com/amv-prod-cad-assets.s3.amazonaws.com/images/10q2/339155/2011-audi-q7-photo-341327-s-original.jpg'),
(8,'Porsche','Cayenne','440 HP',1020.49,'SUV','https://s.aolcdn.com/commerce/autodata/images/USC60PRS011A021001_2.jpg'),
(9,'Chevrolet','Traverse','310 HP',481.67,'SUV','https://media.ed.edmunds-media.com/chevrolet/traverse/2017/ot/2017_chevrolet_traverse_LIFE1_ot_207172_1280.jpg'),
(10,'Volvo','XC90','250 HP',364.13,'SUV','https://assets.volvocars.com/pl/~/media/shared-assets/images/galleries/new-cars/new-xc90/landing/story-grid/grid2_vcc08428.jpg?w=376'),
(11,'BMW','X1','228 HP',742.16,'SUV','https://media.ed.edmunds-media.com/bmw/x1/2017/oem/2017_bmw_x1_4dr-suv_xdrive28i_rq_oem_3_1280.jpg'),
(12,'Volkswagen','Crafter','140 HP',1605.36,'Truck','https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/VW_Crafter_2.0_TDI_Facelift.JPG/1200px-VW_Crafter_2.0_TDI_Facelift.JPG'),
(13,'Fiat','Ducato L2H2','130 HP',1352.64,'Truck','https://otomotopl-imagestmp.akamaized.net/images_otomotopl/851417721_2_1080x720_metalik-dodaj-zdjecia.jpg'),
(14,'Iveco','Daily','180 HP',1942.46,'Truck','https://www.iveco.com/Common/PublishingImages/iveco-daily-e6/van/promo/new-daily-promotion.jpg'),
(15,'Audi','R8 Coupe Trims','540 HP',2500.00,'Sport','https://s.aolcdn.com/commerce/autodata/images/CAC70AUC171A021001.jpg'),
(16,'Mercedes-Benz','Maybach','463 HP',1300.00,'Luxury','https://www.mercedes-benz.com/wp-content/uploads/sites/3/2017/08/00-mercedes-benz-vehicles-vision-mercedes-maybach-6-cabriolet-3400x1440.jpg');

select * from car