// import java.io.*;
import java.sql.*;

public class OneLeagueMatch {

	public static void main (String[] args)  throws Exception {

	    Connection con = null;
	    OneTeam[] teamList = new OneTeam[2];
		String leagueId = args[0];
		System.out.println("第一引数" + leagueId);//Log
		String gameNumber = args[1];
		// パラメータチェック実施
		
	    try{
			//チーム名の取得
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
			PreparedStatement st = con.prepareStatement("select team_name as name, team_power as power, win_times, draw_times, lost_times, score, lost_score from league_team_list where team_code in (select team_code_1 as teamcode from league_game_list where game_number  = ? union select team_code_2 as teamname from league_game_list where game_number  = ?); ");
			st.setString(1,gameNumber);
			st.setString(2,gameNumber);
			ResultSet res = st.executeQuery();
			// すでに行われている試合、チーム名が入っていない試合に対してエラー処理を追加
			int i = 0;
			while (res.next()) {
				String name = res.getString("name");
				System.out.println("第一引数" + name);//Log
				teamList[i] = new OneTeam(name,res.getInt("power"),res.getInt("win_times"),res.getInt("draw_times"),res.getInt("lost_times"),res.getInt("score"),res.getInt("lost_score"));
				i = i + 1;
			}
			LeagueGame oneGame = new LeagueGame(teamList[0], teamList[1]);

			// 試合の実施
			oneGame.fullTime();
			String winnerTeamName = oneGame.winnerName();
			System.out.println(winnerTeamName);//Log
			System.out.println(teamList[0].getScore());//Log
			System.out.println(teamList[1].getScore());//Log
			// 試合結果を記録する
			oneGame.setResult();

			// チームの結果を記録する
			// String sqlUp = "update league_team_list set win_point = '3',win_times = '1', score = ? where l_id = 'NA4A202106' and team_name = ? ;";

			String resSQL ="update league_team_list set win_times = ?, draw_times = ?, lost_times = ?, score = ?, lost_score = ? where l_id = 'NA4A202106' and team_name = ? ;";
			PreparedStatement stUp1 = con.prepareStatement(resSQL);
			stUp1.setInt(1,teamList[0].getWinTimes());
			stUp1.setInt(2,teamList[0].getDrawTimes());
			stUp1.setInt(3,teamList[0].getLostTimes());
			stUp1.setInt(4,teamList[0].getTotalScore());
			stUp1.setInt(5,teamList[0].getTotalLostScore());
			stUp1.setString(6, teamList[0].getTeamName());
			PreparedStatement stUp2 = con.prepareStatement(resSQL);
			stUp2.setInt(1,teamList[1].getWinTimes());
			stUp2.setInt(2,teamList[1].getDrawTimes());
			stUp2.setInt(3,teamList[1].getLostTimes());
			stUp2.setInt(4,teamList[1].getTotalScore());
			stUp2.setInt(5,teamList[1].getTotalLostScore());
			stUp2.setString(6, teamList[1].getTeamName());

			int lines = stUp1.executeUpdate();
			int lines2 = stUp2.executeUpdate();
			System.out.println("結果：" + lines + "結果：" + lines2);//Log
			// // 次の組み合わせの
			// PreparedStatement st2 = con.prepareStatement("select winner_name from tournament_game_list where game_number = ? ; ");
			// st2.setInt(1,gameNumber);
			// ResultSet res2 = st2.executeQuery();
			// while (res2.next()) {
			// 	String nextGame = res2.getString("winner_name");
			// 	System.out.println(nextGame);//Log
			// 	String[] nextGameList = nextGame.split(",");
			// 	int nextGameGameNumber = Integer.parseInt(nextGameList[0]);
			// 	int nextGameSide = Integer.parseInt(nextGameList[1]);
			// 	System.out.println(nextGameGameNumber);//Log
			// 	System.out.println(nextGameSide);//Log	
			// 	// 決勝戦の場合の処理 優勝チーム名の記載など
			// 	String sqlUp;
			// 	if (nextGameSide == 1) {
			// 		sqlUp = "update tournament_game_list set team_name_1 = ? where game_number = ? ; ";
			// 	} else {
			// 		sqlUp = "update tournament_game_list set team_name_2 = ? where game_number = ? ; ";
			// 	}
			// 	PreparedStatement stUp = con.prepareStatement(sqlUp);
			// 	stUp.setString(1,winnerTeamName);
			// 	stUp.setInt(2, nextGameGameNumber);
			// 	int lines = stUp.executeUpdate();
			// 	System.out.println("結果：" + lines);//Log
			// }
	    } catch (SQLException e) {
			System.out.println("Failed");
	    }
	}
}
