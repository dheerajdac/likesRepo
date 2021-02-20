package com.dheeraj.likesRepo.repository;

import com.dheeraj.likesRepo.model.Like;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface LikeRepo extends ReactiveCassandraRepository<Like, String>{

	Flux<Like> findAllByParentId(String parentId);

	Slice<Like> findAllByParentId(String parentId, Pageable pageable);
    
}
