-- Drop user first if they exist
DROP USER if exists 'ttcnNhom2'@'%' ;

-- Now create user with prop privileges
CREATE USER 'ttcnNhom2'@'%' IDENTIFIED BY 'ttcnNhom2';

GRANT ALL PRIVILEGES ON * . * TO 'ttcnNhom2'@'%';


-- drop database
DROP SCHEMA IF EXISTS `ttcn_nhom2`;

-- create database
CREATE SCHEMA `ttcn_nhom2`;
	