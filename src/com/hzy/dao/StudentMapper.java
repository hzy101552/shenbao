package com.hzy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzy.pojo.Files;
import com.hzy.pojo.Project;
import com.hzy.pojo.Student;


public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    //List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    void updateStudentinfo(Student student);
    
    void addProjectinfo(Project project);
    
    List<Project> findProject();

    List<Project> findmyProjects(Integer snumber);
    
    int findTotalCount();
    
    List<Project> findProductList(@Param("pagenu")int index,@Param("pagesize")int currentCount);
    
    Project findProjectXiang(String project_name);
    
    List<Files> findFiles();
    
    void insertFile(Files files);
}
