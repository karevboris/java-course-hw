package com.netcracker.Service.DetailTestService;

import com.netcracker.Entities.DetailTest;

import java.util.List;

public interface DetailTestService {
    DetailTest add(DetailTest detailTest);
    void delete(DetailTest detailTest);
    List<DetailTest> getAll();
    void deleteById(Integer id);
    DetailTest readById(Integer id);
    DetailTest update(DetailTest detailTest);
}
