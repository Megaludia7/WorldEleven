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
	    // OneTeam[] teamList = new OneTeam[numOfTeamsAll];
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
			PreparedStatement st = con.prepareStatement("select * from nationlist;");
			//numOfTeams = 1;
			//st.setInt(1,numOfTeams);
			ResultSet res = st.executeQuery();
			System.out.println("get");
			while (res.next()) {
				String name = res.getString("name");
				System.out.println("Team is " + name);	
			}
	    } catch (SQLException e) {
			System.out.println("Failed");
	    }
	}
}
