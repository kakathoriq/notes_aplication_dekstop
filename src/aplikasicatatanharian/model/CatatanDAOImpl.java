/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasicatatanharian.model;

/**
 *
 * @author hp
 */

import aplikasicatatanharian.util.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatatanDAOImpl implements CatatanDAO {

    @Override
    public List<Catatan> getAll() {
        List<Catatan> list = new ArrayList<>();
        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM catatan")) {

            while (rs.next()) {
                Catatan c = new Catatan();
                c.setId(rs.getInt("id"));
                c.setJudul(rs.getString("judul"));
                c.setDeskripsi(rs.getString("deskripsi"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(Catatan catatan) {
        try (Connection conn = Koneksi.getConnection()) {
            String sql = "INSERT INTO catatan(judul, deskripsi) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, catatan.getJudul());
            pst.setString(2, catatan.getDeskripsi());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Catatan catatan) {
        try (Connection conn = Koneksi.getConnection()) {
            String sql = "UPDATE catatan SET judul=?, deskripsi=? WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, catatan.getJudul());
            pst.setString(2, catatan.getDeskripsi());
            pst.setInt(3, catatan.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = Koneksi.getConnection()) {
            String sql = "DELETE FROM catatan WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

