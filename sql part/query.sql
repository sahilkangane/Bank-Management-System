create database bankSystem;
use bankSystem;
create table signup(FORMNO varchar(30),NAME varchar(30),FATHER_NAME varchar(30),DOB varchar(30),GENDER varchar(30),EMAIL varchar(50),MARTIAL_STATUS varchar(30),ADDRESS varchar(100),CITY varchar(30),PINCODE varchar(30),STATE varchar(50));
select * from signup;
desc signup;

create table signup2(FORMNO varchar(30),RELIGION varchar(30),CATEGORY varchar(30),INCOME varchar(30),EDUCATION varchar(30),OCCUPATION varchar(50),PAN varchar(30),AADHAR varchar(30),SENIORCITIZEN varchar(30),EXISTINGACCOUNT varchar(30));
select * from signup2;

create table signup3(FORMNO varchar(30),ACCOUNT_TYPE varchar(40),CARD_NUMBER varchar (30),PIN varchar(30),FACILITY varchar(200));
select * from signup3;

create table login (FORMNO varchar(30),CARD_NUMBER varchar (50), PIN varchar (30));
select * from login;

create table bank (PIN varchar(10) , DATE varchar(50) , TYPE varchar(20) , AMOUNT varchar(20));
select * from bank;

 




