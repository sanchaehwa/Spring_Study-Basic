package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //동시성의 이슈가 있을 수 있지만 단슨 개발 목적으로 씀.
    /* 여기서 말하는 동시성의 문제가 여러 스레드가 동시에 sotre에 접근하거나 수정할때
    memberRepository.save(new Member(1L, "John"));
    memberRepository.save(new Member(2L, "Jane"));
    동시에 save 매소드를 호출함으로써 저장하려고 하는데 이렇게 되면 sotre 상태 예측 못함 (저장되었는지 아닌지) 이게 동시성 문제의 하나의 예임.
    * */
    @Override
    public void save(Member member) {
            store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
