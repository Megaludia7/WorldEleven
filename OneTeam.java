
public class OneTeam {

	private int teamPower;
	private String teamName;
	private int score;
	private int winTimes;
	private int drawTimes;
	private int lostTimes;
	private int totalScore;
	private int totalLostScore;

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

	public OneTeam (String teamName,int teamPower, int winTimes, int drawTimes, int lostTimes, int totalScore, int totalLostScore) {
		this.teamName = teamName;
		this.teamPower = teamPower;
		this.winTimes = winTimes;
		this.drawTimes = drawTimes;
		this.lostTimes = lostTimes;
		this.totalScore = totalScore;
		this.totalLostScore = totalLostScore;

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

	public int getWinTimes() {
		return winTimes;
	}
	public void setWinTimes(int winTimes) {
		this.winTimes = winTimes;
	}

	public int getDrawTimes() {
		return drawTimes;
	}
	public void setDrawTimes(int drawTimes) {
		this.drawTimes = drawTimes;
	}

	public int getLostTimes() {
		return lostTimes;
	}
	public void setLostTimes(int lostTimes) {
		this.lostTimes = lostTimes;
	}

	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getTotalLostScore() {
		return totalLostScore;
	}
	public void setTotalLostScore(int totalLostScore) {
		this.totalLostScore = totalLostScore;
	}



}
