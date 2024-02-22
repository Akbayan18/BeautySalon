package kz.baibalaeva.success;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop", "postgres", "qwerty123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean addSalon(Salon salon){
        int rows=0;
        try {
            PreparedStatement stmt=connection.prepareStatement("insert into salon (hair, price, master) values (?, ?, ?)");
        stmt.setString(1, salon.getHair());
        stmt.setInt(2, salon.getPrice());
        stmt.setString(3, salon.master);
        rows= stmt.executeUpdate();
        stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows>0;
    }

    public static ArrayList<Salon> getAllSalon(){
        ArrayList<Salon> list =new ArrayList<>();
        try {
            PreparedStatement stmt= connection.prepareStatement("select * from salon");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Salon salon1=new Salon();
                salon1.setId(resultSet.getLong("id"));
                salon1.setHair(resultSet.getString("hair"));
                salon1.setPrice(resultSet.getInt("price"));
                salon1.setMaster(resultSet.getString("master"));
                list.add(salon1);

            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static Salon getSalon(Long id){
        Salon salon =null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from salon where id=?");
        stmt.setLong(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()){
            salon = new Salon();
            salon.setId(resultSet.getLong("id"));
            salon.setHair(resultSet.getString("hair"));
            salon.setPrice(resultSet.getInt("price"));
            salon.setMaster(resultSet.getString("master"));
        }
        stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salon;
    }

    public static boolean updateSalon(Salon salon){
        int rows=0;
        try {
            PreparedStatement stmt = connection.prepareStatement("update salon set hair=?, price=?, master=?   where id=?");
        stmt.setString(1, salon.getHair());
        stmt.setInt(2, salon.getPrice());
        stmt.setString(3, salon.master);
        stmt.setLong(4, salon.getId());
        rows= stmt.executeUpdate();
        stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows>0;
    }

    public static boolean deleteSalon(Long id){
        int rows=0;
        try {
            PreparedStatement stmt=connection.prepareStatement("delete from salon where id=?");
        stmt.setLong(1, id);
        rows=stmt.executeUpdate();
        stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return rows>0;
    }

}
