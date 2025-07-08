/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasicatatanharian.util;

/**
 *
 * @author hp
 */
import java.sql.*;

public class Koneksi {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:catatan.db"; // DB akan dibuat otomatis
            conn = DriverManager.getConnection(url);

            // Buat tabel jika belum ada
            String sqlCreate = "CREATE TABLE IF NOT EXISTS catatan (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "judul TEXT NOT NULL, " +
                    "deskripsi TEXT)";
            PreparedStatement pst = conn.prepareStatement(sqlCreate);
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}

