import java.io.*;
import java.sql.*;

public class OneMatch2 {

	public static void main (String[] args)  throws Exception {

	    Connection con = null;
	    OneTeam[] teamList = new OneTeam[2];
		//String tournamentId = args[0];
		//String gameNumber = args[1];
		
	    try{
			//チーム名の取得
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
		
			//次の組み合わせの設定
			PreparedStatement st2 = con.prepareStatement("select winner_name from tournament_game_list where game_number = '1'; ");
			ResultSet res2 = st2.executeQuery();
			// String nextGame = res2.getString("winner_name");
			// System.out.println(nextGame);


	    } catch (SQLException e) {
			System.out.println("Failed");
	    }
	}
}
