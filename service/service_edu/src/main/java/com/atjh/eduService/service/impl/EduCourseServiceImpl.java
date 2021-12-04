package com.atjh.eduService.service.impl;

import com.atjh.baseService.handler.GuliException;
import com.atjh.eduService.entity.EduCourse;
import com.atjh.eduService.entity.EduCourseDescription;
import com.atjh.eduService.entity.vo.CourseInfoForm;
import com.atjh.eduService.entity.vo.CoursePublishVo;
import com.atjh.eduService.mapper.EduCourseMapper;
import com.atjh.eduService.service.EduCourseDescriptionService;
import com.atjh.eduService.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.EntityDeclaration;

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
    public String addCourseInfo(CourseInfoForm courseInfoForm) {
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

        return courseId;
    }

    /**
     * 根据id获取课程信息
     * @param id
     * @return
     */
    @Override
    public CourseInfoForm getCourseInfoById(String id) {
        // 1.根据id查询课程信息
        EduCourse eduCourse = baseMapper.selectById(id);
        // 2.封装课程信息
        CourseInfoForm courseInfoForm = new CourseInfoForm();
        BeanUtils.copyProperties(eduCourse,courseInfoForm);
        // 3.根据id查询课程描述信息
        EduCourseDescription courseDescription = courseDescriptionService.getById(id);
        // 4.封装课程描述
        courseDescription.setDescription(courseDescription.getDescription());
        return courseInfoForm;
    }

    /**
     * 修改课程信息
     * @param courseInfoForm
     */
    @Override
    public void updateCourseInfo(CourseInfoForm courseInfoForm) {
        // 1.复制课程数据
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm, eduCourse);
        // 2，更新课程数据
        int update = baseMapper.updateById(eduCourse);
        if (update==0) {
            throw new GuliException(20001,"修改课程失败");
        }
        // 4 更新课程描述
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setId(courseInfoForm.getId());
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescriptionService.updateById(courseDescription);
    }

    //根据课程id查询课程发布信息
    @Override
    public CoursePublishVo getCoursePublishById(String id) {
        CoursePublishVo coursePublishVo =
                baseMapper.getCoursePublishById(id);
        return coursePublishVo;
    }

}
