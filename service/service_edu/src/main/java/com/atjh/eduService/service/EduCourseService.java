package com.atjh.eduService.service;

import com.atjh.eduService.entity.EduCourse;
import com.atjh.eduService.entity.vo.CourseInfoForm;
import com.atjh.eduService.entity.vo.CoursePublishVo;
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
     * @return
     */
    String addCourseInfo(CourseInfoForm courseInfoForm);

    /**
     * 根据id获取课程信息
     * @param id
     * @return
     */
    CourseInfoForm getCourseInfoById(String id);

    /**
     * 修改课程信息
     * @param courseInfoForm
     */
    void updateCourseInfo(CourseInfoForm courseInfoForm);

    /**
     * 根据课程id查询课程发布信息
     * @param id
     * @return
     */
    CoursePublishVo getCoursePublishById(String id);
}
