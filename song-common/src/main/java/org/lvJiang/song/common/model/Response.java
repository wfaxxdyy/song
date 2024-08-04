package org.lvJiang.song.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一出参
 * @param <T>
 */
@Data
public class Response<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<T>(200, "success", data);
    }

    public static <T> Response<T> success() {
        return new Response<T>(200, "success", null);
    }

    public static <T> Response<T> error(String msg) {
        return new Response<T>(500, msg, null);
    }

    public static <T> Response<T> error() {
        return new Response<T>(500, "error", null);
    }

    public static <T> Response<T> error(String msg, T data) {
        return new Response<T>(500, msg, data);
    }

    public static <T> Response<T> error(int code, String msg) {
        return new Response<T>(code, msg, null);
    }

    public static <T> Response<T> error(int code, String msg, T data) {
        return new Response<T>(code, msg, data);
    }
}
