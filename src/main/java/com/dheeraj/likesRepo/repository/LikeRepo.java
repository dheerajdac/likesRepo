package com.dheeraj.likesRepo.repository;

import java.util.List;

import com.dheeraj.likesRepo.model.Like;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepo extends CrudRepository<Like, String>{

	List<Like> findAllByParentId(String parentId);

	Slice<Like> findByParentId(String parentId, Pageable pageable);
    
}
