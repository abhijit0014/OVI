package com.spring.ai.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.ai.entity.QueryResponseViewEntity;
import java.lang.Long;

public interface QRViewRepository extends JpaRepository<QueryResponseViewEntity, Long>{

	List<QueryResponseViewEntity> findByQueryid(Long queryid);
	@Query(value="SELECT * FROM query_response_view \r\n" + 
			"	WHERE MATCH (query)\r\n" + 
			"	AGAINST (?1 IN NATURAL LANGUAGE MODE) limit 10", 
			nativeQuery = true)	
	List<QueryResponseViewEntity> getByQuery(String query);
	@Query(value="SELECT * FROM query_response_view WHERE query =?1", 
			nativeQuery = true)	
	List<QueryResponseViewEntity> getByQueryDirectMatch(String query);	

}
