package com.freelycar.saas.project.repository;

import com.freelycar.saas.project.entity.ProjectType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author tangwei - Toby
 * @date 2018/10/18
 * @email toby911115@gmail.com
 */
public interface ProjectTypeRepository extends JpaRepository<ProjectType, String> {


    @Query(value = "select * from projectType where id != :id and storeId = :storeId and delStatus = 0 and name = :name", nativeQuery = true)
    List<ProjectType> checkRepeatName(String id, String name,String storeId);

    @Query(value = "select * from projectType where storeId = :storeId and delStatus = 0 and name = :name", nativeQuery = true)
    List<ProjectType> checkRepeatName(String name,String storeId);

    Page<ProjectType> findAllByDelStatusAndStoreIdOrderByCreateTimeAsc(boolean delStatus, String storeId, Pageable pageable);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update projectType set delStatus = 1 where id=:id", nativeQuery = true)
    int delById(String id);

    List<ProjectType> findByIdIn(Set<String> id);

}
