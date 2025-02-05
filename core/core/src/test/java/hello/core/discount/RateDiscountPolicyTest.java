package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {
    
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야함")
    void vip_o() {
        // given
        Member member = new Member(1L, "MeberVIP", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        
        assertThat(discount).isEqualTo(10000 * 10 / 100);
    }
    
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되면 안됨")
    void vip_x() {
        // given
        Member member = new Member(2L, "MeberBasic", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(0);
    }

}
