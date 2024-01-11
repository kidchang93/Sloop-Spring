package kr.co.sloop.postAssignment.controller;


import kr.co.sloop.post.domain.SearchDTO;
import kr.co.sloop.post.service.SearchServiceImpl;
import kr.co.sloop.postAssignment.domain.PostAssignmentDTO;
import kr.co.sloop.postAssignment.service.PostAssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/postassignment")
public class PostAssignmentController {
    private final PostAssignmentService postAssignmentService; // 과제 게시판 service
    private final SearchServiceImpl searchServiceImpl; // 페이징 + 검색


    // 글 목록 조회
    // /postassignment/list?page={현재페이지}&searchType={검색유형}&keyword={검색어}
    @GetMapping("/list")
    public String listForum(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                            @RequestParam(value = "searchType", defaultValue = "0", required = false) int searchType,
                            @RequestParam(value = "keyword", defaultValue = "", required = false) String keyword,
                            Model model){
        // 게시판 idx
        // [*****] 쿼리 스트링으로 가져오도록 수정
        // [*****] public String List(@PathVariable("boardIdx") int boardIdx)
        int boardIdx = 2;

        // 검색어 앞뒤 공백 제거
        keyword = keyword.trim();

        // 검색 + 페이징을 위한 객체
        // boardType 2 [*****]
        SearchDTO searchDTO = searchServiceImpl.initialize(boardIdx, page, searchType, keyword, 2);
        model.addAttribute("searchDTO", searchDTO);

        ArrayList<PostAssignmentDTO> postAssignmentDTOList = postAssignmentService.list(searchDTO);
        model.addAttribute("postAssignmentDTOList", postAssignmentDTOList);

        return "postAssignment/list";
    }

    // 글 작성하기
    @GetMapping("/write")
    public String writeForm(Model model){
        PostAssignmentDTO postAssignmentDTO = new PostAssignmentDTO();
        model.addAttribute("postAssignmentDTO", postAssignmentDTO);
        return "postAssignment/write";
    }

    // 글 작성하기
    @PostMapping("/write")
    public String write(@ModelAttribute("postAssignmentDTO") PostAssignmentDTO postAssignmentDTO){
        // 문자열 -> sql.Timestamp 형식으로 변환
        Timestamp assignmentEndDate = Timestamp.valueOf(postAssignmentDTO.getAssignmentEndDateString() + ":00");
        postAssignmentDTO.setAssignmentEndDate(assignmentEndDate);



        return "redirect:/postassignment/list";
        // return "redirect:postassignment/detail?postIdx=" + postIdx;
    }

    // 실험 페이지
    @GetMapping("/test")
    public String test(Model model){
        PostAssignmentDTO postAssignmentDTO = new PostAssignmentDTO();
        //postAssignmentDTO.setCategoryPostIdx(1);
        model.addAttribute("postAssignmentDTO", postAssignmentDTO);
        return "postAssignment/write_datepicker";
    }

}
