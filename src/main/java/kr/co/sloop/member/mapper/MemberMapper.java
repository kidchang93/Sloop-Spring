package kr.co.sloop.member.mapper;

import kr.co.sloop.member.domain.MemberDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface MemberMapper {

    int signup(MemberDTO memberDTO);

    MemberDTO login(MemberDTO memberDTO);

    MemberDTO findByMemberEmail(String loginEmail);

    List<MemberDTO> findMemberList(Model model);

    MemberDTO findByMemberNickname(String memberNickname);

    int update(MemberDTO memberDTO);

    MemberDTO findByIdx(int memberIdx);

    int deleteByUser(int memberIdx);
}
