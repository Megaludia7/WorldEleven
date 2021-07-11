t_id        | varchar(30) | utf8mb4_0900_ai_ci | YES  |     | NULL    |       | select,insert,update,references |         |
| game_number | int         | NULL               | YES  |     | NULL    |       | select,insert,update,references |         |
| team_name_1 | varchar(30) | utf8mb4_0900_ai_ci | YES  |     | NULL    |       | select,insert,update,references |         |
| team_name_2 | varchar(30) | utf8mb4_0900_ai_ci | YES  |     | NULL    |       | select,insert,update,references |         |
| score_1     | int         | NULL               | YES  |     | NULL    |       | select,insert,update,references |         |
| score_2     | int         | NULL               | YES  |     | NULL    |       | select,insert,update,references |         |
| pkscore_1   | int         | NULL               | YES  |     | NULL    |       | select,insert,update,references |         |
| pkscore_2   | int         | NULL               | YES  |     | NULL    |       | select,insert,update,references |         |
| winner_name | varchar(30) | utf8mb4_0900_ai_ci | YES  |     | NULL    |       | select,insert,update,references |         |


create table league_game_list 
(
    l_id varchar(30) NOT NUll,
    game_number varchar(3) NOT NULL,
    team_code_1 varchar(3) NOT NULL,
    team_code_2 varchar(3) NOT NULL,
    score_1 int,
    score_2 int,
    primary key(l_id, game_number)
)



insert into league_game_list 
    (l_id, game_number, team_code_1, team_code_2) 
values
    ('NA4A202106', '1-1', '001', '002');

insert into league_game_list 
    (l_id, game_number, team_code_1, team_code_2) 
values
    ('NA4A202106', '1-2', '003', '004');

insert into league_game_list 
    (l_id, game_number, team_code_1, team_code_2) 
values
    ('NA4A202106', '2-1', '001', '003');

insert into league_game_list 
    (l_id, game_number, team_code_1, team_code_2) 
values
    ('NA4A202106', '2-2', '002', '004');

insert into league_game_list 
    (l_id, game_number, team_code_1, team_code_2) 
values
    ('NA4A202106', '3-1', '001', '004');

insert into league_game_list 
    (l_id, game_number, team_code_1, team_code_2) 
values
    ('NA4A202106', '3-2', '002', '003');

create table league_team_list 
(
    l_id varchar(30) NOT NUll,
    team_name varchar(30) NOT NULL,
    team_code varchar(3) NOT NULL,
    win_point int DEFAULT 0,
    win_times int DEFAULT 0,
    draw_times int DEFAULT 0,
    lost_times int DEFAULT 0,
    score int DEFAULT 0,
    lost_score int DEFAULT 0,
    primary key(l_id, team_name)
)
insert into league_team_list
    (l_id, team_name, team_code)
values
    ('NA4A202106', 'Brazil','001');
insert into league_team_list
    (l_id, team_name, team_code)
values
    ('NA4A202106', 'France','002');
insert into league_team_list
    (l_id, team_name, team_code)
values
    ('NA4A202106', 'Italy','003');
insert into league_team_list
    (l_id, team_name, team_code)
values
    ('NA4A202106', 'Germany','004');

ALTER TABLE league_team_list ADD team_power int NOT NULL;

update league_team_list set win_point = '3',win_times = '1', score = ? where l_id = 'NA4A202106' and team_name = ? ;