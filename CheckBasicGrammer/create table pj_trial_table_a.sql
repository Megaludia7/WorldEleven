create table pj_trial_table_a (
    pk1 varchar(20) NOT NULL,
    pk2 varchar(20) NOT NULL,
    pk3 varchar(20) NOT NULL,
    pk4 varchar(20) NOT NULL,
    rev_number varchar(12),
    check_date varchar(20),
    only_a int,
    PRIMARY KEY(pk1,pk2,pk3,pk4)
)
create table pj_trial_table_b (
    pk1 varchar(20) NOT NULL,
    pk2 varchar(20) NOT NULL,
    pk3 varchar(20) NOT NULL,
    pk4 varchar(20) NOT NULL,
    pk_status varchar(12),
    check_date varchar(20),
    only_b int,
    PRIMARY KEY(pk1,pk2,pk3,pk4)
)