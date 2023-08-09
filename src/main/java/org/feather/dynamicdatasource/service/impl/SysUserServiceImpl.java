package org.feather.dynamicdatasource.service.impl;

import org.feather.dynamicdatasource.annotation.TargetDataSource;
import org.feather.dynamicdatasource.constants.DataSourceNames;
import org.feather.dynamicdatasource.domain.SysUser;
import org.feather.dynamicdatasource.mapper.SysUserMapper;
import org.feather.dynamicdatasource.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feather
 * @since 2023-08-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public List<SysUser> testDs1() {
        return this.getBaseMapper().selectList(null);

    }

    @TargetDataSource(DataSourceNames.DS2)
    @Override
    public   List<SysUser> testDs2() {
        return  this.getBaseMapper().selectList(null);
    }

    @Override
    public void testInsertDs1() {
        SysUser sysUser=new SysUser();
        sysUser.setName("王五");
        sysUser.setBirthday(new Date());
        sysUser.setSex(1);
        this.save(sysUser);
    }

    @TargetDataSource(DataSourceNames.DS2)
    @Override
    public void testInsertDs2() {
        SysUser sysUser=new SysUser();
        sysUser.setName("赵六");
        sysUser.setBirthday(new Date());
        sysUser.setSex(2);
        this.save(sysUser);
    }

}
