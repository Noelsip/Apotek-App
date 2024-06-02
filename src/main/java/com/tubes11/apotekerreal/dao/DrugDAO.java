package com.tubes11.apotekerreal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tubes11.apotekerreal.model.Drug;

public class DrugDAO {
    private static Connection conn;

    // Constructor
    public DrugDAO() {
        conn = Connector.getConnection();
    }

    // Create
    public static void addDrug(Drug drug) throws SQLException {
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO drug (idDrug, drugName, drugAmmont, drugPrice) VALUES (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, drug.getIdDrug());
            statement.setString(2, drug.getNamaObat());
            statement.setInt(3, drug.getJumlahObat());
            statement.setDouble(4, drug.getHargaObat());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Read
    public List<Drug> getAllDrugs() throws SQLException {
        List<Drug> drugsList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM drug";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Drug drug = new Drug();
                drug.setNamaObat(rs.getString("drugName"));
                drug.setJumlahObat(rs.getInt("drugAmmont"));
                drug.setHargaObat(rs.getDouble("drugPrice"));
                drugsList.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return drugsList;
    }

    public List<Drug> getDrugByName(String namaObat) {
        List<Drug> drugsList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM drug WHERE drugName = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, namaObat);
            rs = statement.executeQuery();

            if (rs.next()) {
                Drug drug = new Drug();
                drug.setNamaObat(rs.getString("drugName"));
                drug.setHargaObat(rs.getDouble("drugPrice"));
                drug.setJumlahObat(rs.getInt("drugAmmont"));
                drugsList.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return drugsList;
    }

    // Update
    public void updateDrug(Drug drug) throws SQLException {
        PreparedStatement statement = null;
        try {
            String sql = "UPDATE drug SET drugPrice = ? WHERE drugName = ?";
            statement = conn.prepareStatement(sql);
            statement.setDouble(1, drug.getHargaObat());
            statement.setString(2, drug.getNamaObat());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Delete
    public static void deleteDrug(String namaObat) throws SQLException {
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM drug WHERE drugName = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, namaObat);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}