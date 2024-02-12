
DROP TABLE IF EXISTS `sales_record_has_stock_record`;
DROP TABLE IF EXISTS `stock_record`;
DROP TABLE IF EXISTS `sales_record`;
DROP TABLE IF EXISTS `sale_type`;
DROP TABLE IF EXISTS `retailer`;
DROP TABLE IF EXISTS `grn`;
DROP TABLE IF EXISTS `supplier`;
DROP TABLE IF EXISTS `item`;
DROP TABLE IF EXISTS `login_history`;
DROP TABLE IF EXISTS `cost_record`;
DROP TABLE IF EXISTS `cost_item`;
DROP TABLE IF EXISTS `cost_category`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `user_info`;
DROP TABLE IF EXISTS `user_type`;



CREATE TABLE `category` (
                            `category_id` int(11) NOT NULL AUTO_INCREMENT,
                            `name` varchar(45) NOT NULL,
                            `created_on` datetime DEFAULT NULL,
                            `created_by` int(11) DEFAULT NULL,
                            `updated_on` datetime DEFAULT NULL,
                            `updated_by` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `cost_category` (
                                 `cost_category_id` int(11) NOT NULL AUTO_INCREMENT,
                                 `name` varchar(45) DEFAULT NULL,
                                 `desc` varchar(225) DEFAULT NULL,
                                 `created_by` varchar(45) DEFAULT NULL,
                                 `created_on` datetime DEFAULT NULL,
                                 `last_updated_by` varchar(45) DEFAULT NULL,
                                 `last_updated_on` datetime DEFAULT NULL,
                                 PRIMARY KEY (`cost_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cost_item` (
                             `cost_item_id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(45) DEFAULT NULL,
                             `created_by` varchar(45) DEFAULT NULL,
                             `last_updated_by` varchar(45) DEFAULT NULL,
                             `created_on` datetime DEFAULT NULL,
                             `updated_on` datetime DEFAULT NULL,
                             PRIMARY KEY (`cost_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cost_record` (
                               `cost_record_id` int(11) NOT NULL AUTO_INCREMENT,
                               `cost` decimal(19,2) DEFAULT '0.00',
                               `date_time` datetime DEFAULT NULL,
                               `created_by` varchar(45) DEFAULT NULL,
                               `last_updated_by` varchar(45) DEFAULT NULL,
                               `cost_category_cost_category_id` int(11) NOT NULL,
                               `cost_item_cost_item_id` int(11) NOT NULL,
                               PRIMARY KEY (`cost_record_id`),
                               KEY `fk_cost_record_cost_category1_idx` (`cost_category_cost_category_id`),
                               KEY `fk_cost_record_cost_item1_idx` (`cost_item_cost_item_id`),
                               CONSTRAINT `fk_cost_record_cost_category1` FOREIGN KEY (`cost_category_cost_category_id`) REFERENCES `cost_category` (`cost_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                               CONSTRAINT `fk_cost_record_cost_item1` FOREIGN KEY (`cost_item_cost_item_id`) REFERENCES `cost_item` (`cost_item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `supplier` (
                            `supplier_id` int(11) NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) NOT NULL,
                            `address` varchar(225) DEFAULT NULL,
                            `email` varchar(45) DEFAULT 'null',
                            `contact_no` varchar(15) DEFAULT 'null',
                            `created_by` int(11) DEFAULT NULL,
                            `created_on` datetime DEFAULT NULL,
                            `updated_by` int(11) DEFAULT NULL,
                            `updated_on` datetime DEFAULT NULL,
                            PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `item` (
                        `item_id` int(11) NOT NULL AUTO_INCREMENT,
                        `item_code` varchar(45) NOT NULL,
                        `name` varchar(45) NOT NULL,
                        `packing_size` int(11) DEFAULT '0',
                        `unit_of_measurement` varchar(45) DEFAULT NULL,
                        `category_category_id` int(11) NOT NULL,
                        `created_on` datetime DEFAULT NULL,
                        `created_by` int(11) DEFAULT NULL,
                        `updated_on` datetime DEFAULT NULL,
                        `updated_by` int(11) DEFAULT NULL,
                        PRIMARY KEY (`item_id`),
                        KEY `fk_item_category1_idx` (`category_category_id`),
                        CONSTRAINT `fk_item_category1` FOREIGN KEY (`category_category_id`) REFERENCES `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `grn` (
                       `grn_id` int(11) NOT NULL AUTO_INCREMENT,
                       `buying_price` decimal(19,2) DEFAULT NULL,
                       `received_quantity` int(11) NOT NULL DEFAULT '0',
                       `item_item_id` int(11) NOT NULL,
                       `supplier_supplier_id` int(11) NOT NULL,
                       `batch_no` int(11) NOT NULL DEFAULT '1' COMMENT 'Should be Unique to each batch No',
                       PRIMARY KEY (`grn_id`),
                       KEY `fk_grn_item1_idx` (`item_item_id`),
                       KEY `fk_grn_supplier1_idx` (`supplier_supplier_id`),
                       CONSTRAINT `fk_grn_item1` FOREIGN KEY (`item_item_id`) REFERENCES `item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                       CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `retailer` (
                            `retailer_id` int(11) NOT NULL AUTO_INCREMENT,
                            `name` varchar(225) NOT NULL,
                            `address` varchar(225) DEFAULT 'null',
                            `contact_no` varchar(15) DEFAULT 'null',
                            `email` varchar(45) DEFAULT 'null',
                            `created_by` int(11) DEFAULT NULL,
                            `created_on` datetime DEFAULT NULL,
                            `updated_by` int(11) DEFAULT NULL,
                            `updated_on` datetime DEFAULT NULL,
                            PRIMARY KEY (`retailer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `sale_type` (
                             `sale_type_id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(45) NOT NULL,
                             PRIMARY KEY (`sale_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `sales_record` (
                                `sales_record_id` int(11) NOT NULL AUTO_INCREMENT,
                                `created_by` int(11) DEFAULT NULL,
                                `created_on` datetime DEFAULT NULL,
                                `updated_by` int(11) DEFAULT NULL,
                                `updated_on` datetime DEFAULT NULL,
                                `sale_type_sale_type_id` int(11) NOT NULL,
                                `retailer_retailer_id` int(11) NOT NULL,
                                PRIMARY KEY (`sales_record_id`),
                                KEY `fk_sales_record_sale_type1_idx` (`sale_type_sale_type_id`),
                                KEY `fk_sales_record_retailer1_idx` (`retailer_retailer_id`),
                                CONSTRAINT `fk_sales_record_retailer1` FOREIGN KEY (`retailer_retailer_id`) REFERENCES `retailer` (`retailer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                CONSTRAINT `fk_sales_record_sale_type1` FOREIGN KEY (`sale_type_sale_type_id`) REFERENCES `sale_type` (`sale_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `stock_record` (
                                `stock_record_id` int(11) NOT NULL AUTO_INCREMENT,
                                `selling_price` decimal(19,2) NOT NULL DEFAULT '0.00',
                                `balance_in_hand` int(11) NOT NULL DEFAULT '0',
                                `damaged_quantity` int(11) DEFAULT '0',
                                `created_by` varchar(45) DEFAULT 'null',
                                `last_updated_by` varchar(45) DEFAULT 'null',
                                `created_on` datetime DEFAULT NULL,
                                `last_updated_on` datetime DEFAULT NULL,
                                `grn_grn_id` int(11) NOT NULL,
                                PRIMARY KEY (`stock_record_id`),
                                KEY `fk_stock_record_grn1_idx` (`grn_grn_id`),
                                CONSTRAINT `fk_stock_record_grn1` FOREIGN KEY (`grn_grn_id`) REFERENCES `grn` (`grn_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `sales_record_has_stock_record` (
                                                 `sales_with_stock_id` int(11) NOT NULL AUTO_INCREMENT,
                                                 `sales_record_id` int(11) NOT NULL,
                                                 `stock_record_id` int(11) NOT NULL,
                                                 `sold_price` double NOT NULL,
                                                 `sold_quantity` int(11) NOT NULL,
                                                 `gross_sale` double DEFAULT '0',
                                                 `discount` double DEFAULT '0',
                                                 `created_on` datetime DEFAULT NULL,
                                                 `created_by` int(11) DEFAULT NULL,
                                                 `updated_on` datetime DEFAULT NULL,
                                                 `updated_by` int(11) DEFAULT NULL,
                                                 PRIMARY KEY (`sales_with_stock_id`),
                                                 KEY `fk_sales_record_has_stock_record_stock_record1_idx` (`stock_record_id`),
                                                 KEY `fk_sales_record_has_stock_record_sales_record1_idx` (`sales_record_id`),
                                                 CONSTRAINT `fk_sales_record_has_stock_record_sales_record1` FOREIGN KEY (`sales_record_id`) REFERENCES `sales_record` (`sales_record_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                                 CONSTRAINT `fk_sales_record_has_stock_record_stock_record1` FOREIGN KEY (`stock_record_id`) REFERENCES `stock_record` (`stock_record_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `user_type` (
                             `user_type_id` int(11) NOT NULL AUTO_INCREMENT,
                             `Name` varchar(255) NOT NULL,
                             PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `user_info` (
                             `user_id` int(11) NOT NULL DEFAULT '0',
                             `first_name` varchar(45) NOT NULL,
                             `last_name` varchar(45) DEFAULT NULL,
                             `email` varchar(45) NOT NULL,
                             `contactNo` varchar(45) DEFAULT NULL,
                             `is_email_verified` tinyint(4) DEFAULT '0',
                             `created_by` int(11) DEFAULT NULL,
                             `created_on` datetime DEFAULT NULL,
                             `updated_by` int(11) DEFAULT NULL,
                             `updated_on` datetime DEFAULT NULL,
                             `user_type_user_type_id` int(11) NOT NULL,
                             `password` varchar(100) DEFAULT NULL,
                             `current_session` varchar(100) DEFAULT NULL COMMENT 'Session value which is currently in used',
                             PRIMARY KEY (`user_id`),
                             KEY `fk_user_info_user_type1_idx` (`user_type_user_type_id`),
                             CONSTRAINT `fk_user_info_user_type1` FOREIGN KEY (`user_type_user_type_id`) REFERENCES `user_type` (`user_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `login_history` (
                                 `login_info_id` int(11) NOT NULL,
                                 `dateTime` datetime DEFAULT NULL,
                                 `user_info_user_id` int(11) NOT NULL,
                                 `action` varchar(100) DEFAULT NULL,
                                 `used_session` varchar(100) DEFAULT NULL,
                                 `login_action_result` varchar(45) DEFAULT '0',
                                 PRIMARY KEY (`login_info_id`),
                                 KEY `fk_login_info_user_info1_idx` (`user_info_user_id`),
                                 CONSTRAINT `fk_login_info_user_info1` FOREIGN KEY (`user_info_user_id`) REFERENCES `user_info` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


