package com.tubes11.apotekerreal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tubes11.apotekerreal.model.Doctor;

public class DoctorDAO {
    private static Connection connection;

    // Constructor
    public DoctorDAO(Connection connection) {
        DoctorDAO.connection = connection;
    }

    public static void addDoctor(Doctor doctor) throws SQLException{
        PreparedStatement statement = null;

        try{
            // Insert Doctor
            String doctorQuery = "INSERT INTO doctor (idDoctor, nameDoctor, spesialis) VALUES (?,?,?)";
            statement = connection.prepareStatement(doctorQuery, statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, 0);
            statement.setString(2, doctor.getDoctorName());
            statement.setString(3, doctor.getSpecialization());
            statement.executeUpdate();

            // get the generated idDoctor value
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idDoctor = generatedKeys.getInt(1);
                doctor.setIdDoctor(idDoctor);

                // Insert Scedule
                String sceduleQuery = "INSERT INTO jadwal (idJadwal, idDoctor, jadwal) VALUES (?,?,?)";
                statement = connection.prepareStatement(sceduleQuery);
                statement.setInt(1, doctor.getIdDoctor());
                statement.setInt(2, doctor.getIdDoctor());
                statement.setString(3, doctor.getDoctorScedule());
                statement.executeUpdate();
            }
            
        } catch (SQLException e){
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

    public List<Doctor> getDoctorById (int idDoctor) throws SQLException{
        List<Doctor> doctorsList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String quary = "SELECT * FROM doctor WHERE idDoctor = ?";
            statement = connection.prepareStatement(quary);
            statement.setInt(1, idDoctor);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setIdDoctor(resultSet.getInt("idDoctor"));
                doctor.setDoctorName(resultSet.getString("nameDoctor"));
                doctor.setSpecialization(resultSet.getString("spesialis"));
                doctor.setDoctorScedule(resultSet.getString("jadwal"));
                doctorsList.add(doctor);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            if (resultSet != null) {
                try{
                    resultSet.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            } if (statement != null) {
                try{
                    statement.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        } return doctorsList;
    }
}
