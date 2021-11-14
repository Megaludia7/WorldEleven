
// import java.io.*;
import java.sql.*;

public class PlayOneTournamentGame {

	private String tournamentId;
	private int gameNumber;
	private DemoGame demoGame;

	public PlayOneTournamentGame(String tournamentId, int gameNumber) {
		this.tournamentId = tournamentId;
		this.gameNumber = gameNumber;
		this.demoGame = null;
	}

	public void setGame() {
	    Connection con = null;
	    OneTeam[] teamList = new OneTeam[2];
		// パラメータチェック実施
		// int gameNumber = 1;
		
	    try{
			//チーム名の取得
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
			PreparedStatement st = con.prepareStatement("select name, power from nationlist where name in (select team_name_1 as teamname from tournament_game_list where game_number  = ? union select team_name_2 as teamname from tournament_game_list where game_number  = ?); ");
			st.setInt(1,this.gameNumber);
			st.setInt(2,this.gameNumber);
			ResultSet res = st.executeQuery();

			// すでに行われている試合、チーム名が入っていない試合に対してエラー処理を追加
			int i = 0;
			while (res.next()) {
				String name = res.getString("name");
				int power = res.getInt("power");
				System.out.println(power);
				teamList[i] = new OneTeam(name,power);
				i = i + 1;
			}
			this.demoGame = new DemoGame(teamList[0], teamList[1]);
	    } catch (SQLException e) {
			System.err.println("failed");
	    }
	}

	public String getWinnerTeamName() {
		demoGame.fullTime();
		return demoGame.winnerName();
	}

	public OneTeam getWinnerTeam() {
		demoGame.fullTime();
		return demoGame.winner();
	}

	public void registarScore() {
	    Connection con = null;

	    try{			
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
			PreparedStatement st = con.prepareStatement("update tournament_game_list set score_1 = ?, score_2 = ? where t_id = ? and game_number = ?; ");
			st.setInt(1,this.demoGame.team1.getScore());
			st.setInt(2,this.demoGame.team2.getScore());
			st.setString(3,this.tournamentId);
			st.setInt(4,this.gameNumber);

			int lines = st.executeUpdate();
			System.out.println("結果：" + lines);//Log
		} catch (SQLException e) {
			System.err.println("failed");
	    }

	}

}
