package com.atjh.eduService.service;

import com.atjh.eduService.entity.EduCourse;
import com.atjh.eduService.entity.vo.CourseInfoForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author jahui
 * @since 2021-11-28
 */
public interface EduCourseService extends IService<EduCourse> {

    /**
     * 添加课程信息
     * @param courseInfoForm
     */
    void addCourseInfo(CourseInfoForm courseInfoForm);
}
