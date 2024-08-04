package org.lvjiang.song.asong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.lvjiang.song.asong.entity.Test;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author van
 * @since 2024-07-04 22:26:20
 */
public interface ITestService extends IService<Test> {

    Boolean add(Test test);
}
