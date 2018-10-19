package com.freelycar.saas.project.repository;

import com.freelycar.saas.project.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangwei - Toby
 * @date 2018/10/17
 * @email toby911115@gmail.com
 */
public interface StoreRepository extends JpaRepository<Store,String> {
}