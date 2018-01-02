delete from app_user where id > 0;
INSERT INTO `db_rentapp`.`app_user`
(`id`,
`is_super_user`,
`login`,
`password`)
VALUES
(1,0,'user','$10$du4MhGEPyx567aWPZFUYae2Tp7ajNTBfc5NcV2a1xXv0dXdFAA6sS'),
(2,0,'bot','$10$XlH1AdILVzobeVmCntTMeOOGt9mODzw2/loBoNUOmWhUezn0dovZ2'),
(3,1,'admin','$10$XlH1AdILVzobeVmCntTMeOOGt9mODzw2/loBoNUOmWhUezn0dovZ2');
#takie same hasła co loginy
SELECT * FROM db_rentapp.app_user;