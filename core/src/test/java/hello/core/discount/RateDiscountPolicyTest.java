package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest  {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인적용 확인")
    void vip_o() {
        //given
        Member member = new Member(1L, "John", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 100000);
        //then
        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP 할인이 적용되지 않는다")
    void vip_x() {
        //given
        Member member = new Member(2L, "Yeong", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 100000);
        //then
        assertThat(discount).isEqualTo(1000);

    }
}