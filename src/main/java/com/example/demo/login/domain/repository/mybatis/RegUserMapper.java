package com.example.demo.login.domain.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.login.domain.model.RegUser;

@Mapper
public interface RegUserMapper {
	
	@Select("SELECT user_id AS userId,"
			+ " password,"
			+ " user_name AS userName,"
			+ " role"
			+ " FROM m_user"
			+ " WHERE user_id = #{userId}")
	public RegUser selectByUserId(String userId);
				
}
