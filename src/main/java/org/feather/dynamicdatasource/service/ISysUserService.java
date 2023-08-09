package org.feather.dynamicdatasource.service;

import org.feather.dynamicdatasource.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feather
 * @since 2023-08-09
 */
public interface ISysUserService extends IService<SysUser> {

    List<SysUser> testDs1();


    List<SysUser> testDs2();

    void testInsertDs1();

    void testInsertDs2();



}
