package org.lvjiang.song.asong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lvjiang.song.asong.entity.Test;
import org.lvjiang.song.asong.mapper.TestMapper;
import org.lvjiang.song.asong.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author van
 * @since 2024-07-04 22:26:20
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Override
    public Boolean add(Test test) {
        return save(test);
    }
}
