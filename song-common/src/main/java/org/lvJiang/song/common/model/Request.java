package org.lvJiang.song.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一入参
 * @param <T>
 */
@Data
public class Request<T> implements Serializable {
    private T data;

    private String cookie;
    private String ip;
    private Integer clientType;
    private Integer userId;
    private String token;
}
