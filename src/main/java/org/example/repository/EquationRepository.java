package org.example.repository;

import org.example.entity.Equation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquationRepository {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/mathhelper";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";

    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveEquation(String equation) {


        String sql = "INSERT INTO equations (equation_string) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, equation);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.getCause().printStackTrace();
        }
    }

    public List<Equation> findEquationsByRoot(double root) {

        List<Equation> equations = new ArrayList<>();

        String sql = "SELECT e.id, e.equation_string FROM equations e " +
                "JOIN roots r ON e.id = r.equation_id " +
                "WHERE r.value = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, root);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Equation equation = new Equation();
                    equation.setId(resultSet.getInt("id"));
                    equation.setEquation(resultSet.getString("equation_string"));
                    equations.add(equation);
                }
            }
        } catch (SQLException e) {
            e.getCause().printStackTrace();
        }

        return equations;
    }

    public void saveRoot(double root) {

        String sql = "INSERT INTO roots (value) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, root);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
