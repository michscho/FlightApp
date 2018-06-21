package Data.Database;
import java.sql.*;
import java.util.ArrayList;


public class DataManager {


    public static ResultSet connector(String sqlQuerry, Boolean isRequest){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://insta.nissen.im/FlightDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false&user=FlightAppUser&password=12345678";


        if (isRequest) {
            try {
                conn = DriverManager.getConnection(url);
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlQuerry);

            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }

        }
        else {
            try{
                conn = DriverManager.getConnection(url);
                stmt = conn.createStatement();
                stmt.executeUpdate(sqlQuerry);
            }
            catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }

        return rs;
    }

    /**
     * @return true wenn das passwort richtig ist, sonst false (auch wenn es keinen User gibt)
     */
    public static boolean checkPassword(String username, String password) throws Exception{
        ResultSet rs = null;
        rs = connector("SELECT password FROM User where username = '"+username+"';", true);

        if (rs.next()) {
            if (rs.getString("password").equals(password)){
                return true;
            }
        }
        return false;
    }

    public static boolean resetPassword(String username, String oldPassword, String newPassword) throws Exception{
        if (checkPassword(username, oldPassword)) {
            connector("UPDATE User SET password = '"+newPassword+"' WHERE username = '"+username+"';",false);
            return true;
        }
        return false;
    }

    public static void safeFlightData(String destination, String departure, String departureTime, double duration, int numOfStops, String gate) {
        connector("INSERT INTO FlightInfo VALUES (NULL, '"+destination+"', '"+departure+"', '"+departureTime+
                "', "+duration+", "+numOfStops+", "+gate+");", false);
    }

    public static void safeBookedFlights(int flightid, int userid, int ecoBus, int review, String currentStatus, double price){
        connector("INSERT INTO BookedFlights VALUES (NULL, "+flightid+", "+userid+", "+ecoBus+", "+review+", "+currentStatus+", "+price+");", false);
    }

    /**
     * @param value zu was soll das atribut geupdated werden
     * @param nameToUpdate welches atribut soll geupdated werden
     * @param bookid an welcher bookid soll geupdated werden
     */
    public static void updateBookedFlights(String value, String nameToUpdate, int bookid){
        connector("UPDATE bookedFlights SET "+nameToUpdate+" = '"+value+"' WHERE bookid = '"+bookid+"';",false);
    }

    public static void updateFlightInfo(String value, String nameToUpdate, int flightid){
        connector("UPDATE FlightInfo SET "+nameToUpdate+" = '"+value+"' WHERE bookid = '"+flightid+"';",false);
    }

    /**
     * @return true wenn der User angelegt werden konnte, sonst false
     */
    public static boolean safeUserData(String username, String password) throws Exception{
        ResultSet rs = connector("SELECT EXISTS(SELECT * FROM User WHERE username = '"+username+"') as UserExists;", true);

        if (rs.next() && rs.getInt("UserExists") == 1){
            return false;
        }
        connector("INSERT INTO User VALUES (NULL, '"+username+"', '"+password+"');", false);
        return true;
    }


    // TODO @Michi, ich weiß nicht wie du das in der Main ingebunden hast und wenn ich
    // TODO rausnehme dann gibt es einen error, das also bei dir bitte anpassen
    // TODO die äquivalente mathode dazu ist *checkPassword*

    public static String[] loadUserData() {
        return null;
    }

    public static ArrayList<String[]> flightData(String username) throws Exception{

        ResultSet rs = null;
        ArrayList<String[]> returnList = new ArrayList<String[]>();

        rs = connector("select FlightInfo.*, BookedFlights.* from BookedFlights, User, FlightInfo where BookedFlights.flightid = FlightInfo.flightid and User.username = '"+username+"';", true);

        while (rs.next()){
            String[] tmp = new String[11];
            //FlightInfo
            int flightid = rs.getInt("flightid");
            String destination = rs.getString("destination");
            String departure = rs.getString("departure");
            Date departureTime = rs.getDate("departureTime");
            float duration = rs.getFloat("duration");
            int numOfStops = rs.getInt("numOfStops");
            String gate = rs.getString("gate");
            //BookedFlights
            int ecoBus = rs.getInt("ecoBus");
            int review = rs.getInt("review");
            String currentStatus = rs.getString("currentStatus");
            double price = rs.getDouble("price");

            tmp[0] = flightid+"";
            tmp[1] = destination;
            tmp[2] = departure;
            tmp[3] = departureTime.toString();
            tmp[4] = duration+"";
            tmp[5] = numOfStops+"";
            tmp[6] = gate;
            tmp[7] = ecoBus+"";
            tmp[8] = review+"";
            tmp[9] = currentStatus;
            tmp[10] = price+"";

            returnList.add(tmp);
        }

        return returnList;
    }


    //TODO: @Michi
    public static String[] loadFlightData() {
        return null;
    }
}



