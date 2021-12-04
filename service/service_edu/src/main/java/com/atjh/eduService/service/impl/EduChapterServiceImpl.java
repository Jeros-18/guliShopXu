package com.atjh.eduService.service.impl;

import com.atjh.eduService.entity.EduChapter;
import com.atjh.eduService.entity.EduVideo;
import com.atjh.eduService.entity.vo.ChapterVo;
import com.atjh.eduService.entity.vo.VideoVo;
import com.atjh.eduService.mapper.EduChapterMapper;
import com.atjh.eduService.service.EduChapterService;
import com.atjh.eduService.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author jahui
 * @since 2021-12-04
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    /**
     * 根据课程id查询章节、小节信息
     * @param courseId
     * @return
     */
    @Autowired
    private EduVideoService videoService;

    //根据课程id查询章节、小节信息
    @Override
    public List<ChapterVo> getChapterVideoById(String courseId) {
        //1根据courseId查询章节集合信息
        QueryWrapper<EduChapter> chapterWrapper = new QueryWrapper<>();
        chapterWrapper.eq("course_id",courseId);
        List<EduChapter> chapterList = baseMapper.selectList(chapterWrapper);
        //2根据courseId查询小节集合信息
        QueryWrapper<EduVideo> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("course_id",courseId);
        List<EduVideo> videoList = videoService.list(videoWrapper);
        //3遍历章节信息进行封装
        List<ChapterVo> chapterVideoList = new ArrayList<>();
        for (int i = 0; i <chapterList.size() ; i++) {
            EduChapter eduChapter = chapterList.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapter,chapterVo);
            chapterVideoList.add(chapterVo);
            //4遍历和此章节关联小节信息进行封装
            List<VideoVo> videoVos = new ArrayList<>();
            for (int m = 0; m < videoList.size(); m++) {
                EduVideo eduVideo = videoList.get(m);
                if(eduChapter.getId().equals(eduVideo.getChapterId())){
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(eduVideo,videoVo);
                    videoVos.add(videoVo);
                }
                chapterVo.setChildren(videoVos);
            }

        }

        return chapterVideoList;
    }


}
