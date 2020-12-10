CREATE TABLE ORDER_ITEM (
  ID INTEGER AUTO_INCREMENT  PRIMARY KEY,
  PRODUCT_CODE VARCHAR(250) NOT NULL,
  PRODUCT_NAME VARCHAR(250) NOT NULL,
  QUANTITY INTEGER DEFAULT NULL,
  ORDER_ID INTEGER NOT NULL,
  COST DECIMAL NOT NULL
);