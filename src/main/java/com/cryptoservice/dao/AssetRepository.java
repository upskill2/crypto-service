package com.cryptoservice.dao;

import com.cryptoservice.dao.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

    public void findByName(String name);

}
