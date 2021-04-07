import java.io.*;
import java.sql.*;

public class OneMatch {

	public static void main (String[] args)  throws Exception {

	    Connection con = null;
	    OneTeam[] teamList = new OneTeam[2];
		
	    try{
			//チーム名の取得
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
			PreparedStatement st = con.prepareStatement("select name, power from nationlist where name in (select team_name_1 as teamname from tournament_game_list where game_number  = '1' union select team_name_2 as teamname from tournament_game_list where game_number  = '1'); ");
			ResultSet res = st.executeQuery();
			int i = 0;
			while (res.next()) {
				String name = res.getString("name");
				int power = res.getInt("power");
				teamList[i] = new OneTeam(name,power);
				i = i + 1;
			}
			DemoGame oneGame = new DemoGame(teamList[0], teamList[1]);

			//試合の実施
			oneGame.fullTime();
			String winnerTeamName = oneGame.winnerName();
			System.out.println(winnerTeamName);

	    } catch (SQLException e) {
			System.out.println("Failed");
	    }
	}
}
