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
    public DoctorDAO() {
        connection = Connector.getConnection();
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

    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> doctorList = new ArrayList<>();
        String query = "SELECT `d`.`nameDoctor`, `d`.`spesialis`, `j`.`jadwal`" + "FROM `doctor` `d`" + "JOIN `jadwal` `j` ON `d`.`idDoctor` = `j`.`idDoctor`";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorName(resultSet.getString("nameDoctor"));
                doctor.setSpecialization(resultSet.getString("spesialis"));
                doctor.setDoctorScedule(resultSet.getString("jadwal"));
                doctor.setSelected(false); // initialize selected field to false
                doctorList.add(doctor);
            }
            statement.close();
            resultSet.close();

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    public List<String> getAllSchedules() throws SQLException {
        List<String> scheduleList = new ArrayList<>();
        String query = "SELECT jadwal FROM jadwal";
    
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
    
            while (resultSet.next()) {
                String schedule = resultSet.getString("jadwal");
                scheduleList.add(schedule);
            }
            statement.close();
            resultSet.close();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    public Doctor getDoctorByName(String name) throws SQLException {
        String query = "SELECT * FROM doctor JOIN jadwal ON doctor.idDoctor = jadwal.idDoctor WHERE doctor.nameDoctor = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        Doctor doctor = null;
        if (resultSet.next()) {
            doctor = new Doctor();
            doctor.setIdDoctor(resultSet.getInt("idDoctor"));
            doctor.setDoctorName(resultSet.getString("nameDoctor"));
            doctor.setSpecialization(resultSet.getString("spesialis"));
            doctor.setDoctorScedule(resultSet.getString("jadwal"));
        }
        resultSet.close();
        statement.close();
        return doctor;
    }

    public void deleteDoctor(Doctor doctor) {
        // First, remove all records from the jadwal table that reference this doctor
        String query = "DELETE FROM jadwal WHERE idDoctor =?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, doctor.getIdDoctor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        // Then, delete the doctor
        query = "DELETE FROM doctor WHERE idDoctor =?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, doctor.getIdDoctor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getAllDoctorsNames() throws SQLException {
        List<String> doctorList = new ArrayList<>();
        String query = "SELECT nameDoctor FROM doctor";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                doctorList.add(resultSet.getString("nameDoctor"));
            }
            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorList;
    }
}
