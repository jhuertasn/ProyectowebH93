package com.example.proyectoweb_h93.repository;

import com.example.proyectoweb_h93.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository <RolEntity,Integer> {

}
