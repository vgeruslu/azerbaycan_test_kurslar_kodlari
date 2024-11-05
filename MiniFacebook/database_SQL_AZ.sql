
CREATE TABLE tbl_istifadəçi (
  istifadəçi_ID int(11) NOT NULL AUTO_INCREMENT,
  elektron_poçt_address varchar(50) NOT NULL,
  ad varchar(20) NULL,
  soy_ad varchar(20) NULL,
  şifrə varchar(20) NULL,
  
  PRIMARY KEY (istifadəçi_ID)
) ;

CREATE TABLE tbl_dostlar (
  istifadəçi_ID1 int(11) NOT NULL,
  istifadəçi_ID2 int(11) NOT NULL,
  
  PRIMARY KEY (istifadəçi_ID1, istifadəçi_ID2),
  FOREIGN KEY (istifadəçi_ID1) REFERENCES tbl_istifadəçi (istifadəçi_ID),
  FOREIGN KEY (istifadəçi_ID2) REFERENCES tbl_istifadəçi (istifadəçi_ID)
) ;


CREATE TABLE tbl_paylaşım (
  post_ID int(11) NOT NULL AUTO_INCREMENT,
  istifadəçi_ID int(11) NOT NULL,
  tarix_saat datetime NOT NULL,
  təsvir text NOT NULL,
	
  PRIMARY KEY (post_ID),
  FOREIGN KEY (istifadəçi_ID) REFERENCES tbl_istifadəçi (istifadəçi_ID)
) ;

