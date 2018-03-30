package com.spring.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.ai.entity.RememberEntity;
import java.lang.String;
import java.util.List;

public interface RememberRepository extends JpaRepository<RememberEntity, Long> {
	@Query(value="SELECT * FROM remember \r\n" + 
			"	WHERE MATCH (data)\r\n" + 
			"	AGAINST (?1 IN NATURAL LANGUAGE MODE) limit 3", 
			nativeQuery = true)		
	List<RememberEntity> findByData(String data);
}
