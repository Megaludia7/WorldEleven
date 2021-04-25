import java.io.*;
import java.sql.*;

public class OneMatch {

	public static void main (String[] args)  throws Exception {

	    Connection con = null;
	    OneTeam[] teamList = new OneTeam[2];
		//String tournamentId = args[0];
		//String gameNumber = args[1];
		
	    try{
			//チーム名の取得
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
			// PreparedStatement st = con.prepareStatement("select name, power from nationlist where name in (select team_name_1 as teamname from tournament_game_list where game_number  = '?' union select team_name_2 as teamname from tournament_game_list where game_number  = '?'); ");
			PreparedStatement st = con.prepareStatement("select name, power from nationlist where name in (select team_name_1 as teamname from tournament_game_list where game_number  = '1' union select team_name_2 as teamname from tournament_game_list where game_number  = '1'); ");
			// st.setString(1,gameNumber);
			// st.setString(2,gameNumber);
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
			
			//次の組み合わせの設定
			PreparedStatement st2 = con.prepareStatement("select winner_name from tournament_game_list where game_number = '1'; ");
			ResultSet res2 = st2.executeQuery();
			while (res2.next()) {
				String nextGame = res2.getString("winner_name");
				System.out.println(nextGame);
				String[] nextGameList = nextGame.split(",");
				int nextGameGameNumber = Integer.parseInt(nextGameList[0]);
				String nextGameSide = nextGameList[1];
				System.out.println(nextGameGameNumber);
				System.out.println(nextGameSide);	
				PreparedStatement stUp = con.prepareStatement("update tournament_game_list set team_name_1 = 'aho' where game_number = '5' ; ");
				// stUp.setString(1,winnerTeamName);
				// stUp.setInt(2, nextGameGameNumber);
				int lines = stUp.executeUpdate();
				// System.out.println("結果：" + lines);
			}
		



	    } catch (SQLException e) {
			System.out.println("Failed");
	    }
	}
}
