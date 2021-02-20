package com.dheeraj.likesRepo.model;

import java.nio.ByteBuffer;

import lombok.Data;

@Data
public class LikeRequest {

    Integer size;

    ByteBuffer pageState;
    
}
