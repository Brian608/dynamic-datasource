package org.feather.dynamicdatasource.api;


import lombok.RequiredArgsConstructor;
import org.feather.dynamicdatasource.domain.SysUser;
import org.feather.dynamicdatasource.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author feather
 * @since 2023-08-09
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    private  final ISysUserService sysUserService;

    @GetMapping("/list")
    public void getList(){
        List<SysUser> sysUserList = sysUserService.testDs1();
        sysUserList.forEach(System.out::println);
        List<SysUser> sysUserList1 = sysUserService.testDs2();
        sysUserList1.forEach(System.out::println);
    }

    @PostMapping("/save")
    public void save(){
        sysUserService.testInsertDs1();
        sysUserService.testInsertDs2();
    }

}

