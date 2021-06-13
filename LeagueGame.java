import java.util.Random;

public class LeagueGame {
	private OneTeam team1,team2;

	public LeagueGame (OneTeam team1,OneTeam team2) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1.setScore(0);
		this.team2.setScore(0);
	}

	public void onePlay() {
		Random random = new Random();
		int power1;
		int power2;
		power1 = team1.getTeamPower();
		power2 = team2.getTeamPower();
		power1 += random.nextInt(5);
		power2 += random.nextInt(5);

		if (power1 > power2) {
			team1.setScore(team1.getScore() + 1);
		} else if (power1 < power2) {
			team2.setScore(team1.getScore() + 1);
		}
	}

	public void setResultScore (int score1, int score2) {
		team1.setTotalScore(team1.getTotalScore()+score1);
		team2.setTotalScore(team2.getTotalScore()+score2);
		team1.setTotalLostScore(team1.getTotalLostScore()+score2);
		team2.setTotalLostScore(team2.getTotalLostScore()+score1);
		
	}

	public void fullTime() {
		System.out.println(team1.getTeamName() + "-" + team2.getTeamName());
		for (int i=0;i<5;i++) {
			onePlay();
		}
	}
	
	public void setResult () {
		int score1 = team1.getScore();
		int score2 = team2.getScore();
		System.out.println(score1 + "-" + score2);
		setResultScore(score1, score2);
		
		if (score1 > score2)  {
			team1.setWinTimes(team1.getWinTimes()+1);
			team2.setLostTimes(team2.getLostTimes()+1);
		} else if (score1 < score2 ) {
			team2.setWinTimes(team2.getWinTimes()+1);
			team1.setLostTimes(team1.getLostTimes()+1);
		} else {
			team1.setDrawTimes(team1.getDrawTimes()+1);
			team2.setDrawTimes(team2.getDrawTimes()+1);
		}
	}

	public String winnerName () {
		int score1 = team1.getScore();
		int score2 = team2.getScore();

		System.out.println(score1 + "-" + score2);
		if (score1 > score2)  {
			return team1.getTeamName();
		} else if (score1 < score2 ) {
			return team2.getTeamName();
		} else {
			return "DRAW";
		}
	}



}
