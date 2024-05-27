package com.tubes11.apotekerreal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tubes11.apotekerreal.model.Doctor;;


public class DoctorDAO {
    private Connection conn;
    
    // Constructor
    public DoctorDAO(Connection conn){
        this.conn = conn;
    }

    public List<Doctor> getAllDoctors() throws SQLException{
        List<Doctor> doctorsList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try{
            String sql = "SELECT * FROM doctor";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setIdDoctor(rs.getInt("idDoctor"));
                doctor.setName(rs.getString("nameDoctor"));

                doctorsList.add(doctor);
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
        return doctorsList;
    }

    public List<Doctor> getDoctorById(int idDocter){
        List<Doctor> doctorsList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM doctor WHERE idDoctor = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idDocter);
            rs = statement.executeQuery();

            if (rs.next()) {
                Doctor doctor = new Doctor(idDocter, sql, sql, null);
                doctor.setIdDoctor(rs.getInt("idDoctor"));
                doctor.setName(rs.getString("nameDoctor"));
                doctorsList.add(doctor);
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
                return doctorsList;
        }
    
    public void addDoctor(Doctor doctor) throws SQLException{
        PreparedStatement statement = null;
        try{
            String sql = "INSERT INTO doctor (nameDoctor, spesialis) VALUES (?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialization());
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

    public void deleteDoctor(int idDocter) throws SQLException{
        PreparedStatement statement = null;
        try{
            String sql = "DELETE FROM doctor WHERE idDoctor = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idDocter);
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

    public static void addNewDoctor(Doctor data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNewDoctor'");
    }
    }
