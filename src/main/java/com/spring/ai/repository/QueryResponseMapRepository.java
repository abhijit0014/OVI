package com.spring.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.ai.entity.QueryResponseMapEntity;
import java.lang.Long;
import java.util.List;

import javax.transaction.Transactional;

public interface QueryResponseMapRepository extends JpaRepository<QueryResponseMapEntity, Long>{
	List<QueryResponseMapEntity> findByQueryid(Long queryid);
	@Modifying
	@Transactional
	@Query(value="delete from query_response_map where queryid=?1 and responseid=?2",
			nativeQuery = true)
	void removeResponse(Long qid, Long rid);
}
