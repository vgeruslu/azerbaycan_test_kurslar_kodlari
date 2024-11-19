
DROP DATABASE IF EXISTS mini_facebook;
CREATE DATABASE mini_facebook;
USE mini_facebook;
------------------------------------------------------------------------
CREATE TABLE tbl_istifadəçi (
  epoçt varchar(50) NOT NULL PRIMARY KEY, -- username -di və şəkil_fayl_ismi
  şifrə varchar(20) NOT NULL,
  ad varchar(20) NOT NULL,
  soyad varchar(20) NOT NULL
) ;
------------------------------------------------------------------------
CREATE TABLE tbl_dostluq_münasibətləri (
  istifadəçi1_epoçt varchar(50) NOT NULL,
  istifadəçi2_epoçt varchar(50) NOT NULL,
  dəvət_qəbul_olunub 	tinyint(1) NOT NULL,
  
  PRIMARY KEY (istifadəçi1_epoçt, istifadəçi2_epoçt),
  FOREIGN KEY (istifadəçi1_epoçt) REFERENCES tbl_istifadəçi (epoçt),
  FOREIGN KEY (istifadəçi2_epoçt) REFERENCES tbl_istifadəçi (epoçt)
) ;
------------------------------------------------------------------------
CREATE TABLE tbl_paylaşım (
  post_id int(11) NOT NULL AUTO_INCREMENT,
  paylaşım_mətni text NOT NULL,
  tarix_saat datetime NOT NULL,
  istifadəçi_epoçt varchar(50) NOT NULL,
	
  PRIMARY KEY (post_id),
  FOREIGN KEY (istifadəçi_epoçt) REFERENCES tbl_istifadəçi (epoçt)
) ;
------------------------------------------------------------------------



INSERT INTO `tbl_istifadəçi` (`epoçt`, `şifrə`, `ad`, `soyad`) VALUES
    ('leyla@gmail.com', '123', 'Leyla', 'Qulamoğlu'),
    ('nimtac@gmail.com', '123', 'Nimtac', 'Qulamqızı'),
    ('qulam@gmail.com', '123', 'Qulam', 'Eldaroğlu'),
    ('yusif@gmail.com', '123', 'Yusif', 'Qulamoğlu');
