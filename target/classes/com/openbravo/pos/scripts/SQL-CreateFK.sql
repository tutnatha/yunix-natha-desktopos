--    uniCenta oPOS - Touch Friendly Point Of Sale
--    Copyright (C) 2009-2015 uniCenta
--    http://sourceforge.net/projects/unicentaopos
--
--    This file is part of uniCenta oPOS.
--
--    uniCenta oPOS is free software: you can redistribute it and/or modify
--    it under the terms of the GNU General Public License as published by
--    the Free Software Foundation, either version 3 of the License, or
--    (at your option) any later version.
--
--    uniCenta oPOS is distributed in the hope that it will be useful,
--    but WITHOUT ANY WARRANTY; without even the implied warranty of
--    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--    GNU General Public License for more details.
--
--    You should have received a copy of the GNU General Public License
--    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

ALTER TABLE PEOPLE ADD CONSTRAINT PEOPLE_FK_1 FOREIGN KEY (ROLE) REFERENCES ROLES(ID);
ALTER TABLE CUSTOMERS ADD CONSTRAINT CUSTOMERS_TAXCAT FOREIGN KEY (TAXCATEGORY) REFERENCES TAXCUSTCATEGORIES(ID);
ALTER TABLE CATEGORIES ADD CONSTRAINT CATEGORIES_FK_1 FOREIGN KEY (PARENTID) REFERENCES CATEGORIES(ID);
ALTER TABLE TAXES ADD CONSTRAINT TAXES_CAT_FK FOREIGN KEY (CATEGORY) REFERENCES TAXCATEGORIES(ID);
ALTER TABLE TAXES ADD CONSTRAINT TAXES_CUSTCAT_FK FOREIGN KEY (CUSTCATEGORY) REFERENCES TAXCUSTCATEGORIES(ID);
ALTER TABLE TAXES ADD CONSTRAINT TAXES_TAXES_FK FOREIGN KEY (PARENTID) REFERENCES TAXES(ID);
ALTER TABLE ATTRIBUTEVALUE ADD CONSTRAINT ATTVAL_ATT FOREIGN KEY (ATTRIBUTE_ID) REFERENCES ATTRIBUTE(ID) ON DELETE CASCADE;
ALTER TABLE ATTRIBUTEUSE ADD CONSTRAINT ATTUSE_SET FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID) ON DELETE CASCADE;
ALTER TABLE ATTRIBUTEUSE ADD CONSTRAINT ATTUSE_ATT FOREIGN KEY (ATTRIBUTE_ID) REFERENCES ATTRIBUTE(ID);
ALTER TABLE ATTRIBUTESETINSTANCE ADD CONSTRAINT ATTSETINST_SET FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID) ON DELETE CASCADE;
ALTER TABLE ATTRIBUTEINSTANCE ADD CONSTRAINT ATTINST_SET FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID) ON DELETE CASCADE;
ALTER TABLE ATTRIBUTEINSTANCE ADD CONSTRAINT ATTINST_ATT FOREIGN KEY (ATTRIBUTE_ID) REFERENCES ATTRIBUTE(ID);
ALTER TABLE PRODUCTS ADD CONSTRAINT PRODUCTS_FK_1 FOREIGN KEY (CATEGORY) REFERENCES CATEGORIES(ID);
ALTER TABLE PRODUCTS ADD CONSTRAINT PRODUCTS_TAXCAT_FK FOREIGN KEY (TAXCAT) REFERENCES TAXCATEGORIES(ID);
ALTER TABLE PRODUCTS ADD CONSTRAINT PRODUCTS_ATTRSET_FK FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID);
ALTER TABLE PRODUCTS_CAT ADD CONSTRAINT PRODUCTS_CAT_FK_1 FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID);
ALTER TABLE PRODUCTS_COM ADD CONSTRAINT PRODUCTS_COM_FK_1 FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID);
ALTER TABLE PRODUCTS_COM ADD CONSTRAINT PRODUCTS_COM_FK_2 FOREIGN KEY (PRODUCT2) REFERENCES PRODUCTS(ID);
ALTER TABLE STOCKDIARY ADD CONSTRAINT STOCKDIARY_FK_1 FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID);
ALTER TABLE STOCKDIARY ADD CONSTRAINT STOCKDIARY_ATTSETINST FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID);
ALTER TABLE STOCKDIARY ADD CONSTRAINT STOCKDIARY_FK_2 FOREIGN KEY (LOCATION) REFERENCES LOCATIONS(ID);
ALTER TABLE STOCKLEVEL ADD CONSTRAINT STOCKLEVEL_PRODUCT FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID);
ALTER TABLE STOCKLEVEL ADD CONSTRAINT STOCKLEVEL_LOCATION FOREIGN KEY (LOCATION) REFERENCES LOCATIONS(ID);
ALTER TABLE STOCKCURRENT ADD CONSTRAINT STOCKCURRENT_FK_1 FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID);
ALTER TABLE STOCKCURRENT ADD CONSTRAINT STOCKCURRENT_ATTSETINST FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID);
ALTER TABLE STOCKCURRENT ADD CONSTRAINT STOCKCURRENT_FK_2 FOREIGN KEY (LOCATION) REFERENCES LOCATIONS(ID);
ALTER TABLE RECEIPTS ADD CONSTRAINT RECEIPTS_FK_MONEY FOREIGN KEY (MONEY) REFERENCES CLOSEDCASH(MONEY);
ALTER TABLE TICKETS ADD CONSTRAINT TICKETS_FK_ID FOREIGN KEY (ID) REFERENCES RECEIPTS(ID);
ALTER TABLE TICKETS ADD CONSTRAINT TICKETS_FK_2 FOREIGN KEY (PERSON) REFERENCES PEOPLE(ID);
ALTER TABLE TICKETS ADD CONSTRAINT TICKETS_CUSTOMERS_FK FOREIGN KEY (CUSTOMER) REFERENCES CUSTOMERS(ID);
ALTER TABLE TICKETLINES ADD CONSTRAINT TICKETLINES_FK_TICKET FOREIGN KEY (TICKET) REFERENCES TICKETS(ID);
ALTER TABLE TICKETLINES ADD CONSTRAINT TICKETLINES_FK_2 FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID);
ALTER TABLE TICKETLINES ADD CONSTRAINT TICKETLINES_ATTSETINST FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID);
ALTER TABLE TICKETLINES ADD CONSTRAINT TICKETLINES_FK_3 FOREIGN KEY (TAXID) REFERENCES TAXES(ID);
ALTER TABLE PAYMENTS ADD CONSTRAINT PAYMENTS_FK_RECEIPT FOREIGN KEY (RECEIPT) REFERENCES RECEIPTS(ID);
ALTER TABLE TAXLINES ADD CONSTRAINT TAXLINES_TAX FOREIGN KEY (TAXID) REFERENCES TAXES(ID);
ALTER TABLE TAXLINES ADD CONSTRAINT TAXLINES_RECEIPT FOREIGN KEY (RECEIPT) REFERENCES RECEIPTS(ID);
ALTER TABLE PLACES ADD CONSTRAINT PLACES_FK_1 FOREIGN KEY (FLOOR) REFERENCES FLOORS(ID);
ALTER TABLE RESERVATION_CUSTOMERS ADD CONSTRAINT RES_CUST_FK_1 FOREIGN KEY (ID) REFERENCES RESERVATIONS(ID);
ALTER TABLE RESERVATION_CUSTOMERS ADD CONSTRAINT RES_CUST_FK_2 FOREIGN KEY (CUSTOMER) REFERENCES CUSTOMERS(ID);
ALTER TABLE LEAVES ADD CONSTRAINT lEAVES_PPLID FOREIGN KEY (PPLID) REFERENCES PEOPLE(ID);
ALTER TABLE SHIFT_BREAKS ADD CONSTRAINT SHIFT_BREAKS_BREAKID FOREIGN KEY (BREAKID) REFERENCES BREAKS(ID);
ALTER TABLE SHIFT_BREAKS ADD CONSTRAINT SHIFT_BREAKS_SHIFTID FOREIGN KEY (SHIFTID) REFERENCES SHIFTS(ID);