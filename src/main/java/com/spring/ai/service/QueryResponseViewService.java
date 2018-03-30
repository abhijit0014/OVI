package com.spring.ai.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.spring.ai.entity.QueryResponseViewEntity;
import com.spring.ai.repository.QRViewRepository;

@Service
public class QueryResponseViewService {
	
	private final QRViewRepository qrViewRepository;
	public QueryResponseViewService(QRViewRepository qrViewRepository) {
		this.qrViewRepository = qrViewRepository;
	}

	public List<QueryResponseViewEntity> getByQueryid(Long id) {
		return qrViewRepository.findByQueryid(id);
	}

	public List<QueryResponseViewEntity> getPartialResponseByQuery(String query) {
		return qrViewRepository.getByQuery(query);
	}
	
	public List<QueryResponseViewEntity> getByQueryDirectMatch(String query) {
		return qrViewRepository.getByQueryDirectMatch(query);
	}	
}
