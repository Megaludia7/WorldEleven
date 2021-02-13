public class MakeLeagueCup {
    private String cupName;
    private String date;
    private int teamsNumber;
    private Connection con;

    public MakeLeagueCup {
        this.cupName = "NewLeague";
        this.date = "2020/10/28";
        this.teamsNumber = 4;
    }
    
    public MakeLeagueCup(String cupName, String date, int teamsNumber, Connection con){
        this.cupName = cupName;
        this.date = date;
        this.teamsNumber = teamsNumber;
        this.con = con;
    }
    
    public void registerTeams(String teamName){
        PreparedStatement stmt = con.prepareStatement("insert into playingteamlist (cupname,teamname,teampower,point,goal,pointagainst) values (?,?,?,0,0,0);");
        stmt.setString(1,cupName);
        stmt.setString(2,teamName);
        stmt.setInt(3,0);
    }
            
        
        int numOfTeams = 8;
		int numOfTeamsAll = numOfTeams*2;
		int numOfGames = numOfTeams;
		int log = 3;
		//int log = (int) log(numOfGames)/log(2);
		//Teams which participate in this tounament
		int j = log;
		OneTeam[] teamList = new OneTeam[numOfTeamsAll];
		DemoGame[] gameList = new DemoGame[numOfGames];

		teamList[0] = new OneTeam("Brazil",90);
		teamList[1] = new OneTeam("France",89);
		teamList[2] = new OneTeam("Spain",91);
		teamList[3] = new OneTeam("Germany",90);
		teamList[4] = new OneTeam("England",90);
		teamList[5] = new OneTeam("Belgium",92);
		teamList[6] = new OneTeam("Italy",88);
		teamList[7] = new OneTeam("Argentena",91);

		for (int i=0;i<4;i++) {
			gameList[i] = new DemoGame(teamList[2*i],teamList[2*i+1]);
			gameList[i].fullTime();
			teamList[i+8] = gameList[i].winner();
			System.out.println(teamList[i+8].getTeamName());
		}

		for (int i=4;i<6;i++) {
			gameList[i] = new DemoGame(teamList[2*i],teamList[2*i+1]);
		}



		for (int i=4;i<6;i++) {
			gameList[i].fullTime();
		}

		OneTeam team9 = gameList[4].winner();
		System.out.println(team9.getTeamName());
		OneTeam team10 = gameList[5].winner();
		System.out.println(team10.getTeamName());

		gameList[6] = new DemoGame(team9,team10);
		gameList[6].fullTime();
		OneTeam team11 = gameList[6].winner();
		System.out.println(team11.getTeamName());
	}
}
