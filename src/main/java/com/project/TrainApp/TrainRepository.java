package com.project.TrainApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository  extends JpaRepository<Train, Integer>
{
    Train findById(int id);
    List<Train> findAll();
}
