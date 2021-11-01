// import java.io.*;
import java.sql.*;

public class OneMatch {

	public static void main (String[] args)  throws Exception {

	    Connection con = null;
	    OneTeam[] teamList = new OneTeam[2];
		String tournamentId = args[0];
		System.out.println("第一引数" + tournamentId);//Log
		int gameNumber = Integer.parseInt(args[1]);
		
	    try{
			//チーム名の取得
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
			PreparedStatement st = con.prepareStatement("select name, power from nationlist where name in (select team_name_1 as teamname from tournament_game_list where game_number  = ? union select team_name_2 as teamname from tournament_game_list where game_number  = ?); ");
			st.setInt(1,gameNumber);
			st.setInt(2,gameNumber);
			ResultSet res = st.executeQuery();
			// すでに行われている試合、チーム名が入っていない試合に対してエラー処理を追加
			int i = 0;
			while (res.next()) {
				String name = res.getString("name");
				int power = res.getInt("power");
				teamList[i] = new OneTeam(name,power);
				i = i + 1;
			}
			DemoGame oneGame = new DemoGame(teamList[0], teamList[1]);

			// 試合の実施
			oneGame.fullTime();
			String winnerTeamName = oneGame.winnerName();
			System.out.println(winnerTeamName);//Log
			// 試合結果を記録する
			
			// 次の組み合わせの設定
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
