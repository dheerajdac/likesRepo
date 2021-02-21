package com.dheeraj.likesRepo.serviceImpl;

import com.dheeraj.likesRepo.model.Like;
import com.dheeraj.likesRepo.model.LikeRequest;
import com.dheeraj.likesRepo.model.LikeResponse;
import com.dheeraj.likesRepo.repository.LikeRepo;
import com.dheeraj.likesRepo.repository.ReactiveLikeRepo;
import com.dheeraj.likesRepo.service.LikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepo repo;

    @Autowired
    ReactiveLikeRepo reactiveLikeRepo;

    @Override
    public Mono<Like> insert(Like like) {
        return this.reactiveLikeRepo.insert(like);
    }

    @Override
    public Mono<Like> update(Like like) {
        return this.update(like);
    }

    @Override
    public Mono<LikeResponse> findPaginatedLikesByParentId(String parentId, Integer size) {
        LikeResponse response = new LikeResponse();
        Slice<Like> slice = this.repo.findByParentId(parentId, CassandraPageRequest.of(0, size));
        response.setData(slice.getContent());
        response.setPageState(((CassandraPageRequest) slice.getPageable()).getPagingState());
        Mono<LikeResponse> mono = Mono.just(response);
        return mono;
    }

    @Override
    public Mono<LikeResponse> findPaginatedLikesByParentId(String parentId, LikeRequest likeRequest) {
        LikeResponse response = new LikeResponse();
        CassandraPageRequest pageState = CassandraPageRequest.of(PageRequest.of(0, likeRequest.getSize()), likeRequest.getPageState());
        Slice<Like> slice = this.repo.findByParentId(parentId, pageState);
        response.setData(slice.getContent());
        response.setPageState(((CassandraPageRequest) slice.getPageable()).getPagingState());
        Mono<LikeResponse> mono = Mono.just(response);
        return mono;
    }
    
}
