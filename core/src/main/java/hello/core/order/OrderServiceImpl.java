package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository ;
    //MemoryMeberRepository(구체적인 클래스 의존) DIP 원칙 준수를 위해 추상화(MemberRepository) 에 의존 해야함.
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();(고정 금액 할인 제공)
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();(비율 할인 제공 : 10프로 할인)
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
