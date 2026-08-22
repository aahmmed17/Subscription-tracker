package subscription_tracker.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="subscriptions")
public class Subscription {

    public Subscription(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subscription_Name", length = 100, nullable = false, unique = false)
    private String name;

    private BigDecimal cost;

    @Enumerated(EnumType.STRING)
    private BillingCycle billingCycle;

    private LocalDate nextRenewalDate;

    @Enumerated(EnumType.STRING)
    private SubscriptionCategory subCategory;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;


    //Getters, setters and constructor vvv

    // ID get + set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Subscription name get + set
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    //Subscription name Get + Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Billing Cycle get + set
    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(BillingCycle billingCycle) {
        this.billingCycle = billingCycle;
    }

    // Renew Date get + set
    public LocalDate getNextRenewalDate() {
        return nextRenewalDate;
    }

    public void setNextRenewalDate(LocalDate nextRenewalDate) {
        this.nextRenewalDate = nextRenewalDate;
    }

    //Subscription Category get + set
    public SubscriptionCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubscriptionCategory subCategory) {
        this.subCategory = subCategory;
    }

    //Notes get + set
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    //User get + set
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
