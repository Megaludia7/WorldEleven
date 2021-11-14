// import java.io.*;

public class OneMatchKai {

	public static void main (String[] args)  throws Exception {

		String tournamentId = args[0];
		System.out.println("第一引数" + tournamentId);//Log
		int gameNumber = Integer.parseInt(args[1]);

	    try{
			PlayOneTournamentGame playOneTournamentGame = new PlayOneTournamentGame(tournamentId, gameNumber);
			playOneTournamentGame.setGame();
			// String winnerTeamName = playOneTournamentGame.getWinnerTeamName();
			OneTeam winnerTeam = playOneTournamentGame.getWinnerTeam();
			playOneTournamentGame.registarScore();
			System.out.println("Winner : " + winnerTeam.getTeamName());

			SetNextGame setNextGame = new SetNextGame(winnerTeam.getTeamName(), gameNumber);
			boolean aho = setNextGame.setNextTournamentGame();
			System.out.println(aho);
	    } catch (Exception e) {
			System.out.println("Failed");
	    }
	}
}
