package com.atjh.eduService.controller;


import com.atjh.commonUtils.R;
import com.atjh.eduService.entity.vo.ChapterVo;
import com.atjh.eduService.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author jahui
 * @since 2021-12-04
 */
@Api(description = "章节管理")
@RestController
@RequestMapping("/eduService/edu-chapter")
@CrossOrigin
public class EduChapterController {
    @Autowired
    private EduChapterService chapterService;

    @ApiOperation(value = "根据课程id查询章节、小节信息")
    @GetMapping("getChapterVideoById/{courseId}")
    public R getChapterVideoById(@PathVariable String courseId){
        List<ChapterVo> characterList = chapterService.getChapterVideoById(courseId);
        return R.ok().data("characterList",characterList);

    }
}

