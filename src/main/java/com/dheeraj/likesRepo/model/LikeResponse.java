package com.dheeraj.likesRepo.model;

import java.nio.ByteBuffer;
import java.util.List;

import lombok.Data;

@Data
public class LikeResponse {

    List<Like> data;

    ByteBuffer pageState;
}
