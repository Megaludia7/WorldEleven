public class OneTeam {

	private int teamPower;
	private String teamName;
	private int score;

	public OneTeam(String teamName) {
		this.teamName = teamName;
		this.teamPower = 50;
		this.score = 0;
	}

	public OneTeam (String teamName,int teamPower) {
		this.teamName = teamName;
		this.teamPower = teamPower;
		this.score = 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTeamPower() {
		return teamPower;
	}

	public void setTeamPower(int teamPower) {
		this.teamPower = teamPower;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}



}
