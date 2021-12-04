package com.atjh.eduService.mapper;

import com.atjh.eduService.entity.EduCourse;
import com.atjh.eduService.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author jahui
 * @since 2021-11-28
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    /**
     * 根据课程id查询课程发布信息
     * @param id
     * @return
     */
    CoursePublishVo getCoursePublishById(String id);
}
