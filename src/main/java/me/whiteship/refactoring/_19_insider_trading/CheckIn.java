package me.whiteship.refactoring._19_insider_trading;

import java.time.LocalDate;

/**
 * 냄새 19. 내부자 거래 Insider Trading
 * - 어떤 모듈이 다른 모듈의 내부 정보를 지나치게 많이 알고 있는 코드 냄새.
 *   그로인해 지나치게 강한 결합도(coupling)가 생길 수 있다.
 * - 적절한 모듈로 "함수 옮기기(Move Function)"와 "필드 옮기기(Move Field)" 를 사용해서 결합도를 낮출 수 있다.
 * - 여러 모듈이 자주 사용하는 공통적인 기능은 새로운 모듈을 만들어 잘 관리하거나, "위임 숨기기(Hide Delegate)" 를 사용해
 *   특정 모듈의 중재자처럼 사용할 수도 있다.
 * - 상속으로 인한 결합도를 줄일 때는 "슈퍼클래스 또는 서브클래스를 위임의 ㅈ"
 * */
public class CheckIn {

    public boolean isFastPass(Ticket ticket) {
        LocalDate earlyBirdDate = LocalDate.of(2022, 1, 1);
        return ticket.isPrime() && ticket.getPurchasedDate().isBefore(earlyBirdDate);
    }
}
