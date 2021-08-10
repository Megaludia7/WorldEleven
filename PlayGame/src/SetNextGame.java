// import java.io.*;
import java.sql.*;

public class SetNextGame {

	public bool setNextGame (String winnerTeamName, int gameNumber)  throws Exception {

	    Connection con = null;
	    OneTeam[] teamList = new OneTeam[2];		
	    try{
			// 次の組み合わせの設定
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
			PreparedStatement st2 = con.prepareStatement("select winner_name from tournament_game_list where game_number = ? ; ");
			st2.setInt(1,gameNumber);
			ResultSet res2 = st2.executeQuery();
			while (res2.next()) {
				String nextGame = res2.getString("winner_name");
				System.out.println(nextGame);//Log
				String[] nextGameList = nextGame.split(",");
				int nextGameGameNumber = Integer.parseInt(nextGameList[0]);
				int nextGameSide = Integer.parseInt(nextGameList[1]);
				System.out.println(nextGameGameNumber);//Log
				System.out.println(nextGameSide);//Log	
				// 決勝戦の場合の処理 優勝チーム名の記載など
				String sqlUp;
				if (nextGameSide == 1) {
					sqlUp = "update tournament_game_list set team_name_1 = ? where game_number = ? ; ";
				} else {
					sqlUp = "update tournament_game_list set team_name_2 = ? where game_number = ? ; ";
				}
				PreparedStatement stUp = con.prepareStatement(sqlUp);
				stUp.setString(1,winnerTeamName);
				stUp.setInt(2, nextGameGameNumber);
				int lines = stUp.executeUpdate();
				System.out.println("結果：" + lines);//Log
			}
	    } catch (SQLException e) {
			System.out.println("Failed");
	    }
	}
}
