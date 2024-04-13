package com.management.hostelease.services;

import com.management.hostelease.model.Mess;
import java.util.List;

public interface MessService {
    Mess addMess(Mess mess);
    List<Mess> getAllMesses();
    Mess getMessById(int id);
    void deleteMess(int id);
}
