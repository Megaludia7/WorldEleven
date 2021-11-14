// import java.io.*;
import java.sql.*;

public class SetNextGame {
	private String winnerTeamName;
	private int gameNumber;

	public SetNextGame(String winnerTeamName,int gameNumber) {
		this.winnerTeamName = winnerTeamName;
		this.gameNumber = gameNumber;
	}

	public boolean setNextTournamentGame() {

	    Connection con = null;
	    try{
			// 次の組み合わせの設定
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
			PreparedStatement st2 = con.prepareStatement("select winner_name from tournament_game_list where game_number = ? ; ");
			st2.setInt(1,this.gameNumber);
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
				stUp.setString(1,this.winnerTeamName);
				stUp.setInt(2, nextGameGameNumber);
				int lines = stUp.executeUpdate();
				System.out.println("結果：" + lines);//Log
			}
			return true;
	    } catch (SQLException e) {
			System.out.println("Failed");
			return false;
	    }
	}
}
