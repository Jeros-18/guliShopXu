package com.atjh.eduService.service;

import com.atjh.eduService.entity.EduChapter;
import com.atjh.eduService.entity.vo.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author jahui
 * @since 2021-12-04
 */
public interface EduChapterService extends IService<EduChapter> {

    /**
     * 根据课程id查询章节、小节信息
     * @param courseId
     * @return
     */
    List<ChapterVo> getChapterVideoById(String courseId);

}
