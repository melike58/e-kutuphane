package com.jdbc;

import java.sql.*;

public class DatabaseOperations {
    
    private static Connection getConnection() throws Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ELibraryDatabase;integratedSecurity=true");

        return conn;
    }
    
    private static boolean strIsAllNull(String str[]) {
        
        for(int i=0;i<10;i++) {
            
            if(str[i]!=null)
                return false;
        }
        
        return true;
    }

    public static void insertIntoUSERS(String USER_NICK, String USER_NAME, String USER_LNAME, String USER_MAIL, String USER_PASS, String USER_PHONE) throws Exception {

        Connection conn=getConnection();
        PreparedStatement st=conn.prepareStatement("insert into USERS(USER_NICK, USER_NAME, USER_LNAME, USER_MAIL, USER_PASS, USER_PHONE, USER_PENALTY)"
                        + " values(?, ?, ?, ?, ?, ?, ?)");

        st.setString(1, USER_NICK);
        st.setString(2, USER_NAME);
        st.setString(3, USER_LNAME);
        st.setString(4, USER_MAIL);
        st.setString(5, USER_PASS);
        st.setString(6, USER_PHONE);
        st.setInt(7, 0);

        st.executeUpdate();

        st.close();
        conn.close();
    }

    public static boolean userIsValid(String USER_MAIL, String USER_PASS) throws Exception {

        Connection conn=getConnection();
        Statement st=conn.createStatement();

        ResultSet rs=st.executeQuery("select USER_ID from USERS where USER_MAIL='"+USER_MAIL+"' and USER_PASS='"+USER_PASS+"'");

        boolean result=rs.next();

        conn.close();
        st.close();

        return result;
    }
    
    public static int getUSER_IDByMail(String USER_MAIL) throws Exception{
        
        Connection conn=getConnection();
        Statement st=conn.createStatement();
        
        ResultSet rs=st.executeQuery("select USER_ID from USERS where USER_MAIL='"+USER_MAIL+"'");
        rs.next();
        
        return rs.getInt("USER_ID");
    }

    public static boolean mailIsValid(String USER_MAIL) throws Exception{

        Connection conn=getConnection();
        Statement st=conn.createStatement();

        ResultSet rs=st.executeQuery("select USER_ID from USERS where USER_MAIL='"+USER_MAIL+"'");

        boolean result=rs.next();

        conn.close();
        st.close();

        return result;
    }

    public static void alterUSER_PASS(String USER_MAIL, String USER_PASS) throws Exception {

        Connection conn=getConnection();
        PreparedStatement st=conn.prepareStatement("update USERS set USER_PASS=? where USER_MAIL=?");

        st.setString(1, USER_PASS);
        st.setString(2, USER_MAIL);

        st.executeUpdate();

        conn.close();
        st.close();
    }

    public static String[] getBookInfo(int BOOK_ID) throws Exception{

        Connection conn=getConnection();
        Statement st=conn.createStatement();

        String str[]=new String[7];

        ResultSet rs=st.executeQuery("select BOOK_NAME, BOOK_WRITER, BOOK_PUBLISHER, BOOK_CATEGORY, BOOK_PCOUNT, BOOK_INFO, BOOK_COVER_PATH from BOOKS where BOOK_ID="+BOOK_ID);

        rs.next();

        str[0]=rs.getString("BOOK_COVER_PATH");
        str[1]=rs.getString("BOOK_NAME");
        str[2]=rs.getString("BOOK_WRITER");
        str[3]=rs.getString("BOOK_PUBLISHER");
        str[4]=rs.getString("BOOK_CATEGORY");
        str[5]=String.valueOf(rs.getInt("BOOK_PCOUNT"));
        str[6]=rs.getString("BOOK_INFO");

        conn.close();
        st.close();

        return str;
    }

    public static String[] getUserInfo(int USER_ID) throws Exception{

        Connection conn=getConnection();
        Statement st=conn.createStatement();

        String str[]=new String[5];

        ResultSet rs=st.executeQuery("select USER_NICK, USER_NAME, USER_LNAME, USER_MAIL, USER_PHONE from USERS where USER_ID="+USER_ID);

        rs.next();

        str[0]=rs.getString("USER_NICK");
        str[1]=rs.getString("USER_NAME");
        str[2]=rs.getString("USER_LNAME");
        str[3]=rs.getString("USER_MAIL");
        str[4]=rs.getString("USER_PHONE");

        conn.close();
        st.close();

        return str;
    }
    
    public static void alterUserInfo(int USER_ID, String USER_NICK, String USER_NAME, String USER_LNAME, String USER_MAIL, String USER_PASS, String USER_PHONE) throws Exception{
        
        Connection conn=getConnection();
        PreparedStatement st=conn.prepareStatement("update USERS set USER_NICK=?, USER_NAME=?, USER_LNAME=?, USER_MAIL=?, USER_PASS=?, USER_PHONE=? where USER_ID=?");
        
        st.setString(1, USER_NICK);
        st.setString(2, USER_NAME);
        st.setString(3, USER_LNAME);
        st.setString(4, USER_MAIL);
        st.setString(5, USER_PASS);
        st.setString(6, USER_PHONE);
        st.setInt(7, USER_ID);
        
        st.executeUpdate();
        
        st.close();
        conn.close();
    }
    
    public static String[][] getBooksInUsageInfo(int USER_ID) throws Exception{
        
        Connection conn=getConnection();
        Statement st=conn.createStatement();
        
        ResultSet rs=st.executeQuery("select count(*) from RECORDS where RECORD_USER_ID="+USER_ID+" and RECORD_STATE=1");
        rs.next();
        int numberOfRows=rs.getInt("");
        
        if(numberOfRows==0)
            return null;
        
        rs=st.executeQuery("select RECORD_BOOK_ID from RECORDS where RECORD_USER_ID="+USER_ID+" and RECORD_STATE=1");
        
        String sqlQuery="select BOOK_COVER_PATH, BOOK_NAME, BOOK_WRITER, BOOK_ID, BOOK_PDF_PATH from BOOKS where ";
        String sqlQueryNumberOfRows="select count(*) from BOOKS where ";
        
        for(int i=0;i<numberOfRows-1;i++) {
            
            rs.next();
            sqlQuery+="BOOK_ID="+rs.getInt("RECORD_BOOK_ID")+" or ";
            sqlQueryNumberOfRows+="BOOK_ID="+rs.getInt("RECORD_BOOK_ID")+" or ";
        }
        
        rs.next();
        sqlQuery+="BOOK_ID="+rs.getInt("RECORD_BOOK_ID");
        sqlQueryNumberOfRows+="BOOK_ID="+rs.getInt("RECORD_BOOK_ID");

        rs=st.executeQuery(sqlQueryNumberOfRows);
        rs.next();
        numberOfRows=rs.getInt("");
        
        String str[][]=new String[numberOfRows][5];
        
        rs=st.executeQuery(sqlQuery);
        
        int i=0;
        
        while(rs.next()) {
            
            str[i][0]=rs.getString("BOOK_COVER_PATH");
            str[i][1]=rs.getString("BOOK_NAME");
            str[i][2]=rs.getString("BOOK_WRITER");
            str[i][3]=rs.getString("BOOK_ID");
            str[i][4]=rs.getString("BOOK_PDF_PATH");
            
            i++;
        }
        
        conn.close();
        st.close();
        
        return str;
    }
    
    public static String[][] getFilteredHomePage(String str[]) throws Exception{
        
        if(strIsAllNull(str))
            return getDefaultHomePage();
        
        Connection conn=getConnection();
        Statement st=conn.createStatement();
        
        String sqlQuery="select BOOK_COVER_PATH, BOOK_NAME, BOOK_WRITER, BOOK_ID from BOOKS where ";
        String sqlQueryNumberOfRows="select count(*) from BOOKS where ";
        
        for(int i=0;i<10;i++) {
            
            switch(i) {
                
                case 0:
                    
                    if(str[0]!=null) {
                        
                        sqlQuery+="BOOK_CATEGORY='Fantastik' or ";
                        sqlQueryNumberOfRows+="BOOK_CATEGORY='Fantastik' or ";
                    }
                    
                    break;
                    
                case 1:
                    
                    if(str[1]!=null) {
                        
                        sqlQuery+="BOOK_CATEGORY='Gerilim' or ";
                        sqlQueryNumberOfRows+="BOOK_CATEGORY='Gerilim' or ";
                    }
                    
                    break;
                    
                case 2:
                    
                    if(str[2]!=null) {
                        
                        sqlQuery+="BOOK_CATEGORY='Polisiye' or ";
                        sqlQueryNumberOfRows+="BOOK_CATEGORY='Polisiye' or ";
                    }
                    
                    break;
                    
                case 3:
                    
                    if(str[3]!=null) {
                        
                        sqlQuery+="BOOK_CATEGORY='Romantik' or ";
                        sqlQueryNumberOfRows+="BOOK_CATEGORY='Romantik' or ";
                    }
                    
                    break;
                    
                case 4:
                    
                    if(str[4]!=null) {
                        
                        sqlQuery+="BOOK_PUBLISHER='Altın Kitaplar' or ";
                        sqlQueryNumberOfRows+="BOOK_PUBLISHER='Altın Kitaplar' or ";
                    }
                    
                    break;
                    
                case 5:
                    
                    if(str[5]!=null) {
                        
                        sqlQuery+="BOOK_PUBLISHER='İthaki' or ";
                        sqlQueryNumberOfRows+="BOOK_PUBLISHER='İthaki' or ";
                    }
                    
                    break;
                    
                case 6:
                    
                    if(str[6]!=null) {
                        
                        sqlQuery+="BOOK_PUBLISHER='Pegasus' or ";
                        sqlQueryNumberOfRows+="BOOK_PUBLISHER='Pegasus' or ";
                    }
                    
                    break;
                    
                case 7:
                    
                    if(str[7]!=null) {
                        
                        sqlQuery+="BOOK_PUBLISHER='Martı' or ";
                        sqlQueryNumberOfRows+="BOOK_PUBLISHER='Martı' or ";
                    }
                    
                    break;
                    
                case 8:
                    
                    if(str[8]!=null) {
                        
                        sqlQuery+="BOOK_PUBLISHER='Gollancz' or ";
                        sqlQueryNumberOfRows+="BOOK_PUBLISHER='Gollancz' or ";
                    }
                    
                    break;
                    
                case 9:
                    
                    if(str[9]!=null) {
                        
                        sqlQuery+="BOOK_PUBLISHER='Kyrhos' or ";
                        sqlQueryNumberOfRows+="BOOK_PUBLISHER='Kyrhos' or ";
                    }
                    
                    break;
            }
        }
        
        sqlQuery+="BOOK_ID=-1";
        sqlQueryNumberOfRows+="BOOK_ID=-1";
        
        ResultSet rs=st.executeQuery(sqlQueryNumberOfRows);
        rs.next();
        int numberOfRows=rs.getInt("");
        
        rs=st.executeQuery(sqlQuery);
        
        String str0[][]=new String[numberOfRows][4];
        int i=0;
        
        while(rs.next()) {
            
            str0[i][0]=rs.getString("BOOK_COVER_PATH");
            str0[i][1]=rs.getString("BOOK_NAME");
            str0[i][2]=rs.getString("BOOK_WRITER");
            str0[i][3]=String.valueOf(rs.getInt("BOOK_ID"));
            
            i++;
        }
        
        conn.close();
        st.close();
        
        return str0;
    }
    
    public static String[][] getDefaultHomePage() throws Exception{
        
        Connection conn=getConnection();
        Statement st=conn.createStatement();
        
        ResultSet rs=st.executeQuery("select count(*) from BOOKS");
        rs.next();
        int numberOfRows=rs.getInt("");
        
        rs=st.executeQuery("select BOOK_COVER_PATH, BOOK_NAME, BOOK_WRITER, BOOK_ID from BOOKS");
        
        String str0[][]=new String[numberOfRows][4];
        int i=0;
        
        while(rs.next()) {
            
            str0[i][0]=rs.getString("BOOK_COVER_PATH");
            str0[i][1]=rs.getString("BOOK_NAME");
            str0[i][2]=rs.getString("BOOK_WRITER");
            str0[i][3]=String.valueOf(rs.getInt("BOOK_ID"));
            
            i++;
        }
        
        conn.close();
        st.close();
        
        return str0;
    }
    
    public static String getUserPENALTY(int USER_ID) throws Exception{
        
        Connection conn=getConnection();
        Statement st=conn.createStatement();
        
        ResultSet rs=st.executeQuery("select USER_PENALTY from USERS where USER_ID="+USER_ID);
        rs.next();
        
        String str=String.valueOf(rs.getInt("USER_PENALTY"));
        
        st.close();
        conn.close();
        
        return str;
    }
    
    public static void resetPENALTY(int USER_ID) throws Exception{
        
        Connection conn=getConnection();
        PreparedStatement st=conn.prepareStatement("update USERS set USER_PENALTY=0 where USER_ID="+USER_ID);
        
        st.executeUpdate();
        
        st.close();
        conn.close();
    }
    
    public static void createRecord(int USER_ID, int BOOK_ID) throws Exception{
        
        Connection conn=getConnection();
        PreparedStatement st=conn.prepareStatement("insert into RECORDS(RECORD_USER_ID, RECORD_BOOK_ID, RECORD_STATE) values("+USER_ID+", "+BOOK_ID+", 1)");
        
        st.executeUpdate();
        
        st.close();
        conn.close();
    }
    
    public static void submitBook(int USER_ID, int BOOK_ID) throws Exception{
        
        Connection conn=getConnection();
        PreparedStatement st=conn.prepareStatement("update RECORDS set RECORD_STATE=0 where RECORD_USER_ID="+USER_ID+" and RECORD_BOOk_ID="+BOOK_ID);
        
        st.executeUpdate();
        
        st.close();
        conn.close();
    }
}
