package com.netcracker.DAO.DetailTestDAO;

import com.netcracker.Entities.DetailTest;

import java.util.List;

public interface DetailTestDAO {
    List<DetailTest> getAll();
    DetailTest create(DetailTest detailTest);
    void delete(DetailTest detailTest);
    void deleteById(Integer id);
    DetailTest readById(Integer id);
    DetailTest update(DetailTest detailTest);
}
