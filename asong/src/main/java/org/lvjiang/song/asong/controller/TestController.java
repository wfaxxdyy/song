package org.lvjiang.song.asong.controller;

import org.lvJiang.song.common.model.Request;
import org.lvJiang.song.common.model.Response;
import org.lvjiang.song.asong.entity.Test;
import org.lvjiang.song.asong.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author van
 * @since 2024-07-04 22:26:20
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService iTestService;

    @PostMapping("/add")
    public Response<Boolean> add(@RequestBody Request<Test> test) {
        return Response.success(iTestService.add(test.getData()));
    }
}
