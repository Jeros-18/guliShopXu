package com.atjh.eduService.service.impl;

import com.atjh.baseService.handler.GuliException;
import com.atjh.eduService.entity.EduCourse;
import com.atjh.eduService.entity.EduCourseDescription;
import com.atjh.eduService.entity.vo.CourseInfoForm;
import com.atjh.eduService.mapper.EduCourseMapper;
import com.atjh.eduService.service.EduCourseDescriptionService;
import com.atjh.eduService.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author jahui
 * @since 2021-11-28
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {


    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    //添加课程信息
    @Override
    public void addCourseInfo(CourseInfoForm courseInfoForm) {
        //1添加课程信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if(insert==0){
            throw  new GuliException(20001,"创建课程失败");
        }
        //2获取课程id
        String courseId = eduCourse.getId();
        //3添加课程描述信息
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setId(courseId);
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescriptionService.save(courseDescription);

    }

}
