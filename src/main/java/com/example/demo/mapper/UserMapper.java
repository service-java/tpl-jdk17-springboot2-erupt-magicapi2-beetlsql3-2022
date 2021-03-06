package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.beetl.sql.core.page.PageRequest;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Template;

import java.util.List;


/*
*
* @Date 2022-04-09
*/
public interface UserMapper extends BaseMapper<User> {

    @Template("""
select
-- @pageTag(){
  ${cols}
-- @}
from user
        """)
    PageResult<User> pageUserCols(PageRequest pageRequest, String cols);

    List<User> selectUser(User user);
}