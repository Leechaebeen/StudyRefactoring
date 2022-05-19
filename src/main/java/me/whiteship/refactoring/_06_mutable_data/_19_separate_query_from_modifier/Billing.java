package me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier;

/** 리팩토링 19. 질의 함수와 변경 함수 분리하기 Separate Query from Modifier
 * - "눈에 띌만한" 사이드 이펙트 없이 값을 조회할 수 있는 메소드는 테스트하기도 쉽고, 메소드를 이동하기도 편하다.
 * - 명령-조회 분리(command-query separate) 규칙
 *      - 어떤 값을 리턴하는 함수는 사이드 이펙트가 없어야 한다.
 * - "눈에 띌만한 (observable) 사이드 이펙트"
 *      - 가령, 캐시는 중요한 객체 상태 변화는 아니다.
 *        따라서 어떤 메소드 호출로 인해, 캐시 데이터를 변경하더라도 분리할 필요는 없다.
 * */
// getter setter 처럼 구분하기
public class Billing {

    private Customer customer;

    private EmailGateway emailGateway;

    public Billing(Customer customer, EmailGateway emailGateway) {
        this.customer = customer;
        this.emailGateway = emailGateway;
    }

    public double getTotalOutstanding() {
        return customer.getInvoices().stream()
                .map(Invoice::getAmount)
                .reduce((double) 0, Double::sum);
    }

    public void sendBill() {
        emailGateway.send(formatBill(customer));
    }

    private String formatBill(Customer customer) {
        return "sending bill for " + customer.getName();
    }
}
