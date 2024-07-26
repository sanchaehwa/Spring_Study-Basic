package hello.core.beanfind;


import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
//import static org.assertj.core.api.Assertions.*;

//import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //System.out.println("memberService = " + memberService);
       //System.out.println("memberService.getClass() = " + memberService.getClass());
        //검증단계
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean( MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    } //MemberService : 인터페이스로 조회하면 인터페이스의 구현체가 대상이됨
    @Test
    @DisplayName("구체 타입으로 조회")
    void  findBeanByName2() {
        MemberServiceImpl   memberService =  ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        //구현에 의존(역할에 의존해야하기에 좋지 않은 코드임) 구현에 의존한다 .. 이게 뭔말인지도
    }
    //조회가 안되었을때를 가정하여 Test를 만들어야함
    @Test
    @DisplayName("빈 이름으로 조회가 안된 경우")
    void findBeanByNameX() {
//        ac.getBean("xxxxxxx",MemberService.class);
        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class); //에러가 나오는데 xxxx로 등록한 빈이 없기 때문에 에러가 뜸
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class) ); //ac.getBean("xxxxx", MemberService.class) 로직실행하면 Nosuch 에러가 생겨야한다는것.
    }
}
