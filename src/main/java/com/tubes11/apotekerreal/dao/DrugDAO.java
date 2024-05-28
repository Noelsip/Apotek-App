package com.tubes11.apotekerreal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tubes11.apotekerreal.model.Doctor;
import com.tubes11.apotekerreal.model.Drug;;


public class DrugDAO {
     private Connection conn;
    
    // Constructor
    public DrugDAO(Connection conn){
        this.conn = conn;
    }

    public List<Drug> getAllDrugs() throws SQLException{
        List<Drug> drugsList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try{
            String sql = "SELECT * FROM drug";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Drug drug = new Drug();
                drug.setNamaObat(rs.getString("drugName"));
                drug.setJumlahObat(rs.getInt("drugAmount"));
                drug.setHargaObat(rs.getDouble("drugPrice"));

                drugsList.add(drug);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if (rs != null) {
                try{
                    rs.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try{
                    statement.close();
                    } catch(SQLException e){
                        e.printStackTrace();
                }
            }
        }
        return drugsList;
    }

    public List<Drug> getDrugByName(String namaObat){
        List<Drug> drugsList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM drug WHERE namaObat = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, namaObat);
            rs = statement.executeQuery();

            if (rs.next()) {
                Drug drug = new Drug(namaObat,null,null);
                drug.setNamaObat(rs.getString("drugName"));
                drug.setJumlahObat(rs.getInt("drugAmount"));
                drug.setHargaObat(rs.getDouble("drugPrice"));
                drugsList.add(drug);
            }
            }catch(SQLException e){
                e.printStackTrace();
                } finally{
                    if (rs != null) {
                        try{
                            rs.close();
                        } catch(SQLException e){
                            e.printStackTrace();
                        }
                    }
                    if (statement != null) {
                        try{
                            statement.close();
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                    }
                }
                return drugsList;
        }
    
    public void addDrug(Drug drug) throws SQLException{
        PreparedStatement statement = null;
        try{
            String sql = "INSERT INTO drug (jumlahObat, hargaObat) VALUES (?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, drug.getJumlahObat(drug.getNamaObat()));
            statement.setDouble(2, drug.getHargaObat());
            statement.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            } finally{
                if (statement != null) {
                    try{
                        statement.close();
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }

    public static void deleteDrug(String namaObat) throws SQLException{
        PreparedStatement statement = null;
        try{
            String sql = "DELETE FROM drug WHERE namaObat = ?";
            // statement = conn.prepareStatement(sql);
            statement.setString(1, namaObat);
            statement.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            } finally{
                if (statement != null) {
                    try{
                        statement.close();
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        public static void addNewDrug(Drug data) {
            throw new UnsupportedOperationException("Unimplemented method 'addNewDrug'");
        }
}
