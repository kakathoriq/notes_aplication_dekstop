/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasicatatanharian.model;

/**
 *
 * @author hp
 */

import java.util.List;

public interface CatatanDAO {
    public List<Catatan> getAll();
    public void insert(Catatan catatan);
    public void update(Catatan catatan);
    public void delete(int id);
}

