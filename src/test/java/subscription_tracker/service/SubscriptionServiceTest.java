package subscription_tracker.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import subscription_tracker.entity.BillingCycle;
import subscription_tracker.entity.Subscription;
import subscription_tracker.repository.SubscriptionRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {

    List<Subscription> subsMockedList = new ArrayList<>();

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @InjectMocks
    private SubscriptionService subscriptionService;

    @Test
    public void testMonthlySpendCalc(){

        Subscription sub1 = new Subscription();
        sub1.setId(1);
        sub1.setCost(BigDecimal.valueOf(12));
        sub1.setBillingCycle(BillingCycle.MONTHLY);
        sub1.setName("Disney+");

        subsMockedList.add(sub1);

        Subscription sub2 = new Subscription();
        sub2.setId(2);
        sub2.setCost(BigDecimal.valueOf(58));
        sub2.setBillingCycle(BillingCycle.YEARLY);
        sub2.setName("Amazon Prime");

        subsMockedList.add(sub2);

        Subscription sub3 = new Subscription();
        sub3.setId(3);
        sub3.setCost(BigDecimal.valueOf(2.50));
        sub3.setBillingCycle(BillingCycle.WEEKLY);
        sub3.setName("Playstation Plus");

        subsMockedList.add(sub3);

        Mockito.when(subscriptionRepository.findAll()).thenReturn(subsMockedList);

        assertEquals(BigDecimal.valueOf(27.66),subscriptionService.calculateMonthlySpend());

    }



}
