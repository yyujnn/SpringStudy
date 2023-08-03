package com.program.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.program.entity.Music;
import com.program.entity.SearchCriteria;


public interface BroadCastMapper {

	public Music getRatingData(SearchCriteria cri);
	
	public ArrayList<Music> getMonthData(String name);

	public Music getAgeData(String name);

	@Select("SELECT FIXING_CAST_NM,CAST_NM FROM MUSIC WHERE PROGRAM_NM = #{name}")
	public ArrayList<Music> getCastName(String name);
	
}
