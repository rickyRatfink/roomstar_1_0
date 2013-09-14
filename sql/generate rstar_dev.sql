CREATE TABLE `address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_type_id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `line1` varchar(60) NOT NULL,
  `line2` varchar(60) DEFAULT NULL,
  `co` varchar(40) DEFAULT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `org_name` varchar(50) DEFAULT NULL,
  `contact_phone` varchar(20) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `address_type` (
  `address_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_type_desc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`address_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `amentity` (
  `amentity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `total_quantity_available` int(11) DEFAULT NULL,
  PRIMARY KEY (`amentity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `country` (
  `iso` char(2) NOT NULL,
  `label` varchar(80) NOT NULL,
  `printable_name` varchar(80) NOT NULL,
  `iso3` char(3) DEFAULT NULL,
  `numcode` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`iso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `suffix` varchar(45) DEFAULT NULL,
  `creation_date` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `rewards_number` varchar(20) DEFAULT NULL,
  `organization` varchar(60) DEFAULT NULL,
  `notes` mediumtext CHARACTER SET latin1,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (
  `employee_id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `middle_name` varchar(30) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `creation_date` varchar(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `last_login` varchar(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `rate_type` (
  `rate_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `value` double NOT NULL,
  PRIMARY KEY (`rate_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `reservation` (
  `reservation_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) NOT NULL,
  `room_type_id` bigint(20) NOT NULL,
  `rate_type_id` bigint(20) NOT NULL,
  `voucher_code` varchar(20) DEFAULT NULL,
  `rewards_number` varchar(20) DEFAULT NULL,
  `notes` mediumtext CHARACTER SET latin1,
  `creation_date` varchar(20) DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `last_updated_date` varchar(20) DEFAULT NULL,
  `last_updated_by` varchar(20) DEFAULT NULL,
  `check_in_date` varchar(20) DEFAULT NULL,
  `check_out_date` varchar(20) DEFAULT NULL,
  `nights` int(11) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `reservation_amentity` (
  `reservation_id` bigint(20) NOT NULL,
  `amentity_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `reservation_message` (
  `reservation_message_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reservation_id` bigint(20) NOT NULL,
  `message` mediumtext CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`reservation_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `level` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `room_amentity` (
  `room_amentity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_inventory_id` bigint(20) NOT NULL,
  `amentity_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_amentity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `room_inventory` (
  `room_inventory_id` bigint(20) NOT NULL,
  `room_type_id` bigint(20) NOT NULL,
  `display_number` varchar(20) DEFAULT NULL,
  `display_name` varchar(50) DEFAULT NULL,
  `floor_level` int(11) DEFAULT NULL,
  `adjoining_room` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`room_inventory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `room_inventory_status` (
  `room_inventory_status_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_inventory_id` bigint(20) NOT NULL,
  `room_status_type_id` bigint(20) NOT NULL,
  `creation_date` varchar(20) NOT NULL,
  `created_by` varchar(20) NOT NULL,
  PRIMARY KEY (`room_inventory_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `room_rate` (
  `room_rate_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL,
  `rate_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_rate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `room_status_type` (
  `room_status_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`room_status_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `room_type` (
  `room_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `description` mediumtext CHARACTER SET latin1,
  PRIMARY KEY (`room_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` char(40) NOT NULL,
  `value` char(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

