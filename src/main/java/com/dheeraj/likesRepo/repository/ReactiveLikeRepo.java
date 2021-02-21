package com.dheeraj.likesRepo.repository;

import com.dheeraj.likesRepo.model.Like;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface ReactiveLikeRepo extends ReactiveCassandraRepository<Like, String> {
    
    public Flux<Like> findAllByParentId(String parentId);
}
