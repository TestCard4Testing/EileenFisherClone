Feature: Scenarios to place orders

Background:
Given I open the application
Then I am on home page
And I accept all Cookies

@OrderPlacementCC @ShipToHome
Scenario Outline: Placing orders with Credit card as payment method
When I search "<Product>" and add to the cart
And I checkout product as guest user
And I enter Shipping "<Address>" details on the Shipping page
And I click on the nextPaymentButton
And I enter "<Card>" details on the Billing page
And I click on the reviewAndPlaceOrderButton
And I click on the placeOrderButton
Then I save order details
Examples:
|Product|Address|Card|PayPal|
|Product1|US|VISA|Paypal|


@OrderPlacementPayPal @ShipToHome
Scenario Outline: Placing orders with PayPal as payment method
When I search "<Product>" and add to the cart
And I checkout product as guest user
And I enter Shipping "<Address>" details on the Shipping page
And I click on the nextPaymentButton
And I click on the payPalButton
And I enter paypal login details of "<PayPal>"
Then I save order details
Examples:
|Product|Address|Card|PayPal|
|Product1|US|VISA|Paypal|


@PickUp  @PickUpCC
Scenario Outline: Placing Pick up instore order with PayPal as payment method
When I search "<Product>" and add to the cart
And I click on pickUpRadioButton
And I checkout product as guest user
And I enter "<PickUp>" Details
And I click on the nextPaymentButton
And I enter billing "<Address>" details
And I click on the payPalButton
And I enter paypal login details of "<PayPal>"
Then I save order details

Examples:
|Product|Address|Card|PayPal|PickUp|Address|
|Product1|US|VISA|Paypal|PickUpDetails|US|

@PickUp @PickUpPayPal
Scenario Outline: Placing Pick up instore order Credit card as payment method
When I search "<Product>" and add to the cart
And I click on pickUpRadioButton
And I checkout product as guest user
And I enter "<PickUp>" Details
And I click on the nextPaymentButton
And I enter billing "<Address>" details
And I enter "<Card>" details on the Billing page
And I click on the reviewAndPlaceOrderButton
And I click on the placeOrderButton
Then I save order details

Examples:
|Product|Address|Card|PayPal|PickUp|Address|
|Product1|US|VISA|Paypal|PickUpDetails|US|

@PickUp @PickUpPayPal
Scenario Outline: Placing Pick up instore order Credit card as payment method
When I search "<Product>" and add to the cart
And I click on pickUpRadioButton
And I checkout product as guest user
And I enter "<PickUp>" Details
And I click on the nextPaymentButton
And I enter billing "<Address>" details
And I enter "<Card>" details on the Billing page
And I click on the reviewAndPlaceOrderButton
And I click on the placeOrderButton
Then I save order details

Examples:
|Product|Address|Card|PayPal|PickUp|Address|
|Product1|US|VISA|Paypal|PickUpDetails|US|

