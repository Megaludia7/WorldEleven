import java.io.*;
import java.sql.*;

public class OneMatch {

	public static void main (String[] args)  throws Exception {

		// String subject1 = args[0];
		// System.out.println(subject1);
	    Connection con = null;
	    int numOfTeams = 3;
	    // int numOfTeamsAll = numOfTeams*2;
	    // int numOfGames = numOfTeams;
	    // int log = 3;
	    // //int log = (int) log(numOfGames)/log(2);
		// //Teams which participate in this tounament
	    // int j = log;
	    OneTeam[] teamList = new OneTeam[2];
	    // DemoGame[] gameList = new DemoGame[numOfGames];
	    
	    // teamList[0] = new OneTeam("Brazil",90);
	    // teamList[1] = new OneTeam("France",89);
	    // teamList[2] = new OneTeam("Spain",91);
	    // teamList[3] = new OneTeam("Germany",90);
	    // teamList[4] = new OneTeam("England",90);
	    // teamList[5] = new OneTeam("Belgium",92);
	    // teamList[6] = new OneTeam("Italy",88);
	    // teamList[7] = new OneTeam("Argentena",91);
	    
		
	    try{
			con = DriverManager.getConnection("jdbc:mysql://localhost/worldeleven", "root", "mysql");
			PreparedStatement st = con.prepareStatement("select name, power from nationlist where name in (select team_name_1 as teamname from tournament_game_list where game_number  = '1' union select team_name_2 as teamname from tournament_game_list where game_number  = '1'); ");
			//numOfTeams = 1;
			//st.setInt(1,numOfTeams);
			ResultSet res = st.executeQuery();
			System.out.println("get");

			int i = 0;
			while (res.next()) {
				String name = res.getString("name");
				int power = res.getInt("power");
				System.out.println("Team is " + name +", that power is " + power + ".");
				teamList[i] = new OneTeam(name,power);
				i = i + 1;
			}
			DemoGame oneGame = new DemoGame(teamList[0], teamList[1]);
			oneGame.fullTime();
			String winnerTeamName = oneGame.winnerName();
			System.out.println(winnerTeamName);
	    } catch (SQLException e) {
			System.out.println("Failed");
	    }
	}
}
