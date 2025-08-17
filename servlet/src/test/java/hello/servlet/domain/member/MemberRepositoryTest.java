package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void tearDown() {
        memberRepository.clear();
    }

    @Test
    void SaveTest() {
        // given
        Member member = new Member("hello", 20);

        // when
        Member save = memberRepository.save(member);

        // then
        assertThat(member).isEqualTo(save);
    }
    
    @Test
    void findAll() {
        // given
        Member member1 = new Member("hello", 20);
        Member member2 = new Member("hello", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> members = memberRepository.findAll();

        
        // then
        assertThat(members).hasSize(2);
        assertThat(members).contains(member1, member2);
    }
}