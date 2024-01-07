package kr.co.sloop.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberAuthDTO {
    private int memberAuthIdx;  // 권한의 idx
    private int memberIdx;      // 외래키
    private String authority;
}
