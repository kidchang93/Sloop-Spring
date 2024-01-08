package kr.co.sloop.study.repository;

import kr.co.sloop.study.domain.StudyGroupDTO;

import java.util.HashMap;
import java.util.List;

public interface StudyGroupRepository {
    List<StudyGroupDTO> getAllStudyGroupList();

    int insertNewStudyGroup(StudyGroupDTO studyGroupDTO);

    int create4boards(int studyGroupIdx);

    List<HashMap<String, Object>> getSecondCategoryRegionMap();

    StudyGroupDTO getStudyGroupByGroupCode(String studyGroupCode);

    int updateStudyGroup(StudyGroupDTO studyGroupDTO);

}
