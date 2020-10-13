package dict_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.*;
import java.util.logging.Logger;

public class database {
    public Connection conn;
    public Statement pst;
    public database() {

        try {
            Class.forName("org.sqlite.JDBC");
            try {
                this.conn = DriverManager.getConnection("jdbc:sqlite:dict_hh.db");
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pst = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param word
     * @return
     * @throws SQLException
     */
    public ArrayList getSuggestWord(String word) throws SQLException {
        ArrayList<String> result = new ArrayList<String>();
        String query = "select * from av where word like '" +word + "%';";
        ResultSet str = this.pst.executeQuery(query);
        while(str.next()){
            result.add(str.getString("word"));
        }
        return result;
    }

    public String getLookup(String word) throws SQLException{
        String query = "select * from av where word = '" + word + "';";
        ResultSet str = this.pst.executeQuery(query);
        String result = str.getString("html");
        return result;
    }

    public void addWordToDict(String query){
        try {
            this.pst.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
