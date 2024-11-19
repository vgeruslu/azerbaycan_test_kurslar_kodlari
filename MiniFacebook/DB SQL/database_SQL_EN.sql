
CREATE TABLE tbl_user (
  user_ID int(11) NOT NULL AUTO_INCREMENT,
  email_address varchar(50) NOT NULL,
  first_name varchar(20) NULL,
  last_name varchar(20) NULL,
  password varchar(20) NULL,
  
  PRIMARY KEY (user_ID)
) ;

CREATE TABLE tbl_friends (
  user_ID1 int(11) NOT NULL,
  user_ID2 int(11) NOT NULL,
  
  PRIMARY KEY (user_ID1, user_ID2),
  FOREIGN KEY (user_ID1) REFERENCES tbl_user (user_ID),
  FOREIGN KEY (user_ID2) REFERENCES tbl_user (user_ID)
) ;


CREATE TABLE tbl_post (
  post_ID int(11) NOT NULL AUTO_INCREMENT,
  user_ID int(11) NOT NULL,
  dateTime datetime NOT NULL,
  description text NOT NULL,
	
  PRIMARY KEY (post_ID),
  FOREIGN KEY (user_ID) REFERENCES tbl_user (user_ID)
) ;

