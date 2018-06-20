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

                return rs;

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


    public static boolean checkPassword(String user, String pw) throws Exception{
        ResultSet rs = null;
        rs = connector("SELECT password FROM User where username = '"+user+"'", true);

        if (rs.next()) {
            if (rs.getString("password").equals(pw)){
                return true;
            }
        }
        return false;
    }

    public static void safeUserData(String userName, String password) {
        connector("insert into User Values (NULL, '"+userName+"', '"+password+"');", false);
    }

    public static void safeFlightData(String destination, String departure, String departureTime, double duration) {
        connector("insert into FlightInfo Values (NULL, '"+destination+"', '"+departure+"', '"+departureTime+"', "+duration+");", false);
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

        rs = connector("select FlightInfo.* from BookedFlights, User, FlightInfo where BookedFlights.flightid = FlightInfo.flightid and User.username = '"+username+"';", true);

        while (rs.next()){
            String[] tmp = new String[5];

            int flightid = rs.getInt("flightid");
            String destination = rs.getString("destination");
            String departure = rs.getString("departure");
            Date departureTime = rs.getDate("departureTime");
            float duration = rs.getFloat("duration");

            tmp[0] = flightid+"";
            tmp[1] = destination;
            tmp[2] = departure;
            tmp[3] = departureTime.toString();
            tmp[4] = duration+"";

            returnList.add(tmp);
        }

        return returnList;
    }


    //TODO: @Michi
    public static String[] loadFlightData() {
        return null;
    }

}
