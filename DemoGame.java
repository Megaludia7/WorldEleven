// package playgame.modules;
import java.util.Random;


public class DemoGame {
	private OneTeam team1,team2;
	private String teamName1,teamName2;

	public DemoGame (OneTeam team1,OneTeam team2) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1.setScore(0);
		this.team2.setScore(0);
	}

	//テスト用クラス
	public DemoGame (String teamName1,String teamName2) {
		this.team1 = new OneTeam(teamName1,39);
		this.team2 = new OneTeam(teamName2,59);
	}

	public void onePlay() {
		Random random = new Random();
		int power1, power2;
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

	public void fullTime() {
		System.out.println(team1.getTeamName() + "-" + team2.getTeamName());
		for (int i=0;i<5;i++) {
			onePlay();
		}
	}
	
	public OneTeam winner () {
		int score1 = team1.getScore();
		int score2 = team2.getScore();

		System.out.println(score1 + "-" + score2);
		if (score1 > score2)  {
			return team1;
		} else if (score1 < score2 ) {
			return team2;
		} else {
			return team1;
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
