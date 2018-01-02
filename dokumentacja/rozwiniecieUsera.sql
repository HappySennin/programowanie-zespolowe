ALTER TABLE `db_rentapp`.`app_user` 
ADD COLUMN `is_super_user` bit(1) NULL AFTER `password`;