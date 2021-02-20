package com.dheeraj.likesRepo.service;

import com.dheeraj.likesRepo.model.Like;
import com.dheeraj.likesRepo.model.LikeRequest;
import com.dheeraj.likesRepo.model.LikeResponse;

import reactor.core.publisher.Mono;

public interface LikeService {
    
    public Mono<Like> insert(Like like);

    public Mono<Like> update(Like like);

	public Mono<LikeResponse> findPaginatedLikesByParentId(String parentId, Integer size);

	public Mono<LikeResponse> findPaginatedLikesByParentId(String parentId, LikeRequest likeRequest);

}
