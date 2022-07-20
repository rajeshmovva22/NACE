package com.nace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nace.entity.NACEDetails;

@Repository
public interface NACEDetailsRepository extends JpaRepository<NACEDetails, Long>{

}
