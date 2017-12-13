package com.netcracker.Service.DetailTestService;

import com.netcracker.Entities.DetailTest;

import java.util.List;

public interface DetailTestService {
    void add(DetailTest detailTest);
    void delete(DetailTest detailTest);
    List<DetailTest> getAll();
    void deleteById(Integer id);
    DetailTest readById(Integer id);
    void update(DetailTest detailTest);
}
