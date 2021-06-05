select name, power 
from 
    nationlist 
where name in 

(select team_name 
from 
     league_team_list
where team_code in 
    (
        select 
            team_code_1 as team_code 
        from 
            tournament_game_list 
        where 
            game_number  = ? 
        union
        select 
            team_code_2 as team_code 
        from 
            tournament_game_list 
        where 
            game_number  = ?
    )
);