package com.example.perfecttwo.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // 저장소 만들기
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); // id, member 객체
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
