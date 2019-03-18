
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    public class Database {
        private static Connection conn = null;
        private static Statement sment = null;
        private static ResultSet rs = null;

        final static String host = "mysql.stud.ntnu.no";
        final static String user = "catherix_db";
        final static String passwd = "hodepute";
        final static String name = "catherix_treningsdagbok";
        public Database() {
        }

        public static Statement getStatement() {
            return sment;
        }

        public static void connect() {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + name + "?" + "user=" + user + "&password=" + passwd );
                sment = conn.createStatement();
            } catch (SQLException var1) {
                System.out.println("SQLException: " + var1.getMessage());
            }

        }

        public static void disconnect() {
            try {
                conn.close();
            } catch (SQLException var1) {
                System.out.println("SQLException: " + var1.getMessage());
            }

        }

        public static void printOvelser() {
            connect();

            try {
                rs = sment.executeQuery("select * from agnesr_Treningsdb.Øvelse");
                System.out.println("ID  Navn");
                System.out.println("-------------------");

                while(rs.next()) {
                    System.out.println(rs.getString(1) + "          " + rs.getString(2));
                }
            } catch (SQLException var1) {
                var1.printStackTrace();
            }

            disconnect();
        }

        public static void addTreningsokt(Treningsokt var0) throws SQLException {
            throw new Error("Unresolved compilation problems: \n\tThe method setString(int, String) in the type PreparedStatement is not applicable for the arguments (int, int)\n\tThe method setString(int, String) in the type PreparedStatement is not applicable for the arguments (int, int)\n\tThe method setString(int, String) in the type PreparedStatement is not applicable for the arguments (int, int)\n");
        }

        public static void addOvelse(Ovelse ovelse/*, int ovelsesgruppe*/) throws SQLException {
            connect();
            String sql = "INSERT INTO agnesr_Treningsdb.Ovelse\n(ID, Navn)\nVALUES(?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ovelse.getId());
            statement.setString(2, ovelse.getNavn());
            //legg til i øvelsesid til øvelsesgruppe
            statement.executeUpdate();
            disconnect();
        }

        public static void addApparatOvelse(ApparatOvelse apparatOvelse) throws SQLException {
            connect();
            String sql = "INSERT INTO agnesr_Treningsdb.Ovelse\n(ID, Navn, Antall Kilo, Antall Sett, ApparatID)\nVALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, apparatOvelse.getId());
            statement.setString(2, apparatOvelse.getNavn());
            statement.setInt(3, apparatOvelse.getAntallKilo());
            statement.setInt(4, apparatOvelse.getAntallSett());
            statement.setInt(5, apparatOvelse.getApparatID());
            statement.executeUpdate();
            disconnect();
        }

        public static void addFriOvelse(FriOvelse friOvelse) throws SQLException {
            connect();
            String sql = "INSERT INTO øvelse (ID, navn) VALUES(?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, friOvelse.getId());
            statement.setString(2, friOvelse.getNavn());
            statement.executeUpdate();
            sql = "INSERT INTO friøvelse (ID, beskrivelse) VALUES(?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, friOvelse.getId());
            statement.setString(2, friOvelse.getBeskrivelse());
            statement.executeUpdate();
            disconnect();
        }

        public static void addOvelsesgruppe(Ovelsesgruppe ovelsesgruppe) throws SQLException {
            connect();
            String sql = "INSERT INTO agnesr_Treningsdb.Ovelse\n(ID, Navn, Beskrivelse)\nVALUES(?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ovelsesgruppe.getId());
            statement.setString(2, ovelsesgruppe.getNavn());
            statement.setString(3, ovelsesgruppe.getBeskrivelse());
            statement.executeUpdate();
            disconnect();
        }

        public static void addApparat(Apparat apparat) throws SQLException {
            connect();
            String sql = "INSERT INTO agnesr_Treningsdb.Ovelse\n(ID, Navn, beskrivels)\nVALUES(?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, apparat.getId());
            statement.setString(2, apparat.getNavn());
            statement.setString(3, apparat.getBeskrivelse());
            statement.executeUpdate();
            disconnect();
        }

        public static void addOvelseTilOkt(int ID, Treningsokt treningsokt) throws SQLException {
            connect();
            String sql = "INSERT INTO agnesr_treningsdb.øktBestårAv\n(ID, dato, tidspunkt)\nVALUES(?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ID);
            statement.setDate(2, treningsokt.getDato());
            statement.setString(3, treningsokt.getTidspunkt());
            statement.executeUpdate();
            disconnect();
        }
    }