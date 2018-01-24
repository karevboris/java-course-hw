package com.netcracker.Service.DetailTestService;

import com.netcracker.DAO.DetailTestDAO.DetailTestDAO;
import com.netcracker.Entities.DetailTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DetailTestServiceImpl implements DetailTestService {
    @Autowired
    private DetailTestDAO dao;

    public void setDao(DetailTestDAO dao) {
        this.dao = dao;
    }

    public void add(DetailTest detailTest) {
        dao.create(detailTest);
    }

    public List<DetailTest> getAll() {
        return dao.getAll();
    }

    public void delete(DetailTest detailTest) {
        dao.delete(detailTest);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public DetailTest readById(Integer id) {
        return dao.readById(id);
    }

    public void update(DetailTest detailTest) {
        dao.update(detailTest);
    }
}
