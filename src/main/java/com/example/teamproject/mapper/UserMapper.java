package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.UserVO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public Integer checkEmail(String email);
    public Integer checkName(String name);
    public void insert(UserVO userVO);
    public int nameupdate(UserVO userVO);
    public UserVO find(String email);
    public UserVO login(String email);
    public int update(UserVO userVO);
    public Long get(String name);
    public UserVO getInfo(Long unum);
    public int delete(String email, String pw);

}