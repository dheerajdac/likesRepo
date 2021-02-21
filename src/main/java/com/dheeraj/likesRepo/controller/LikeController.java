package com.dheeraj.likesRepo.controller;


import com.dheeraj.likesRepo.model.Like;
import com.dheeraj.likesRepo.model.LikeRequest;
import com.dheeraj.likesRepo.model.LikeResponse;
import com.dheeraj.likesRepo.repository.LikeRepo;
import com.dheeraj.likesRepo.repository.ReactiveLikeRepo;
import com.dheeraj.likesRepo.service.LikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/like")
public class LikeController {
    
    @Autowired
    LikeService service;
    
    @Autowired
    LikeRepo repo;

    @Autowired
    ReactiveLikeRepo reactiveRepo;

    @PostMapping("")
    public Mono<Like> addLike(@RequestBody Like like) {
        return this.service.insert(like);
    }

    @GetMapping("/{parentId}")
    public Flux<Like> getLikes(@PathVariable String parentId){
        return this.reactiveRepo.findAllByParentId(parentId);
    }

    @GetMapping("/{parentId}/pageState/{size}")
    public Mono<LikeResponse> getLikes(@PathVariable String parentId, @PathVariable Integer size) {
        return this.service.findPaginatedLikesByParentId(parentId, size);
    }

    @PostMapping("/{parentId}/pageState")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<LikeResponse> getLikes(@PathVariable String parentId, @RequestBody LikeRequest likeRequest) {
        return this.service.findPaginatedLikesByParentId(parentId, likeRequest);
    }

}
