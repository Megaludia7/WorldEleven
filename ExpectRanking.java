import java.sql.*;

public class ExpectRanking {
    public static void main (String[] args)  throws Exception {
        Connection con = null;
        String[] teamNameList = new String[6];
        OneTeam[] teamList = new OneTeam[6];
        String[][] gamePairList = new String[9][2];
        Integer[][] combinationList = new Integer[3][3];
        combinationList[0][0] = 1;
        combinationList[0][1] = 0;
        combinationList[1][0] = 0;
        combinationList[1][1] = 1;
        combinationList[2][0] = 0;
        combinationList[2][1] = 0;

        for (Integer[] integers : combinationList) {
            integers[2] = integers[0] - integers[1];
        }
        

        teamList[0] = new OneTeam("China",0,0,-4);
        teamList[1] = new OneTeam("Japan",3,1,0);
        // teamList[1] = new OneTeam("Japan",3,1,0);
        // teamList[1] = new OneTeam("Japan",3,1,0);
        // teamList[1] = new OneTeam("Japan",3,1,0);
        // teamList[1] = new OneTeam("Japan",3,1,0);

        gamePairList[0][0] = "China";
        gamePairList[0][1] = "Japan";

        try {

        }
    }
}
