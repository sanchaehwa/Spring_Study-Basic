package hello.core.member;
//구현객체 선택 과정
public class MemberServiceImpl implements MemberService {
   //Class : MemberServiceImpl 는 memberRepository 인터페이스 구현체로 MemoryRepository 를 사용하기로 결정. (=> 구현 객체 선택과정)
     private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
