package com.teprotejo.repository;

import com.teprotejo.entity.CAI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CAIRepository extends JpaRepository<CAI,Long>
{

    List<CAI> findByCity(String city);

}
