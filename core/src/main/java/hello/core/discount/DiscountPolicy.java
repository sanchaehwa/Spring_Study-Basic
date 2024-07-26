package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
        /**
         * @return 이 할인 대상 금액
         * ex) 1000원이 할인된 제품이면 1000원 return 해줌
         */
        int discount(Member member, int price);
}


