package com.spring.ai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.ai.entity.QueryEntity;
import java.lang.String;

public interface QueryRepository extends JpaRepository<QueryEntity, Long>{
	@Query(value="SELECT * FROM query ORDER BY queryid DESC limit ?1", 
			nativeQuery = true)
	List<QueryEntity> loadQuery(int limit);
	List<QueryEntity> findFirst10ByQueryContainingIgnoreCaseOrderByQueryidDesc(String query);

}
