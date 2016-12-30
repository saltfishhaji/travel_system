drop table if exists apply;

drop table if exists city;

drop table if exists hotelstar;

drop table if exists ticket;

drop table if exists user;

drop table if exists vehicle;

drop table if exists account;

create table city
(
   cityname             char(30) not null,
   primary key (cityname)
);

create table hotelstar
(
   hotel                int not null,
   hotelprice           float(8,2) not null,
   primary key (hotel)
);

create table vehicle
(
   vehiclename          char(10) not null,
   primary key (vehiclename)
);

create table user
(
   userid               int not null AUTO_INCREMENT,
   checked              int not null default 0,
   username             char(30) not null,
   password             char(20) not null,
   post                 int not null,
   email                char(30) not null,
   gender               bool default null,
   phone                char(11) default null,
   primary key (userid)
);

create table ticket
(
   fromcity             char(30) not null,
   tocity               char(30) not null,
   vehicleid            char(10) not null,
   price                float(8,2) not null,
   primary key (fromcity, tocity, vehicleid),
   foreign key (fromcity) references city (cityname) on delete cascade on update cascade,
   foreign key (tocity) references city (cityname) on delete cascade on update cascade,
   foreign key (vehicleid) references vehicle (vehiclename) on delete cascade on update cascade
);

create table apply
(
   applyid              int not null AUTO_INCREMENT,
   userid               int not null,
   post                 int not null,
   startdate            date not null,
   days                 int not null,
   meal                 float(8,2) not null,
   hotel                int not null,
   budget               float(8,2) not null,
   computebudget        float(8,2) not null,
   bosscheck            int default 0,
   employercheck        int not null,
   applytime            datetime not null,
   ifaccount		int default 0;
   primary key (applyid),
   foreign key (hotel) references hotelstar (hotel) on delete cascade on update cascade,
   foreign key (tovehicle) references vehicle (vehiclename) on delete cascade on update cascade,
   foreign key (backvehicle) references vehicle (vehiclename) on delete cascade on update cascade,
   foreign key (start) references city (cityname) on delete cascade on update cascade,
   foreign key (destiny) references city (cityname) on delete cascade on update cascade,
   foreign key (userid) references user (userid) on delete cascade on update cascade
);


create table account
(
   applyid              int not null,
   userid               int not null,
   username  		char(30) not null,
   startdate            date not null,
   post                 int not null, 
   days                 int not null,
   extrapay             float(8,2),
   totalbudget          float(8,2) not null,
   computebudget        float(8,2) not null,
   hotelpay             float(8,2) not null,
   ticketpay            float(8,2) not null,
   mealpay              float(8,2) not null,
   adminmsg             char(140) not null,
   savings		float not null,
   foreign key (applyid) references apply (applyid) on delete cascade on update cascade,
   foreign key (userid) references user (userid) on delete cascade on update cascade
);
