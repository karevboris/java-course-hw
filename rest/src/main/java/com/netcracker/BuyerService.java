package com.netcracker;

import java.util.List;

public interface BuyerService {
    List<Buyer> getAll();
    Buyer getById(int id);
    void create(Buyer buyer);
    boolean deleteAll();
    boolean deleteById(int id);
}

