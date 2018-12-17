---
weight: 3
---

# Obligations and returns

## Agent journey overview

Agents who have set up their clients for VAT (MTD) can submit their clients' VAT Returns.

<a href="figures/agent-active.png" target="blank"><img src="figures/agent-active.png"
alt="Agent active process diagram" border="1px"; style="width:520px;" /></a>

<a href="figures/agent-active.png" target="blank">Open the agent process flow process diagram for obligations and returns in a new tab</a>.

1. [Agent receives client's obligations and submits a VAT return](#receive-obligations-and-submit-a-vat-return)
2. [Agent amends client's VAT return](#amend-a-vat-return)
3. [Agent pays client's VAT bill or receives a repayment](#pay-vat-or-get-a-repayment)
4. [Agent notifies client’s change of circumstances](#notify-a-change-of-circumstances)
5. [Client views their future obligations and previous returns in their Business Tax Account (BTA)](#view-future-obligations-and-previous-returns)

## Business journey overview

Businesses set up for VAT (MTD) can submit VAT Returns.

<a href="figures/business-active.png" target="blank"><img src="figures/business-active.png"
alt="Business active process diagram" border="1px"; style="width:520px;" /></a>

<a href="figures/business-active.png" target="blank">Open the business process flow process diagram for obligations and returns in a new tab</a>.

1. [Business receives obligations and submits VAT Return](#receive-obligations-and-submit-a-vat-return)
2. [Business amends a VAT Return](#amend-a-vat-return)
3. [Business pays a VAT bill or receives a repayment](#pay-vat-or-get-a-repayment)
4. [Business notifies a change of circumstances](#notify-a-change-of-circumstances)
5. [Business views future obligations and previous returns in its Business Tax Account (BTA)](#view-future-obligations-and-previous-returns)

## Receive obligations and submit a VAT Return

Your software should use the [VAT (MTD) API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0) to do this - specifically the following endpoints:

  * [Retrieve VAT obligations](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion)
  * [Submit VAT return for period](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_submit-vat-return-for-period_post_accordion)

<img src="figures/retrieve-obligations.png" alt="Retrieve obligations process diagram" border="1px"; style="width:680px;" />

<a href="figures/retrieve-obligations.png" target="blank">Open the retrieve VAT obligations process diagram in a new tab</a>.

1. Mandatory: Business or agent uses their software to retrieve VAT obligations using the [VAT (MTD) API retrieve VAT obligations endpoint](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion).
2. Mandatory: Business or agent uses their software to submit a VAT return using the [VAT (MTD) API submit VAT return for period endpoint ](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_submit-vat-return-for-period_post_accordion).
3. Optional: Business or agent uses their software to retrieve VAT obligations again using the [VAT (MTD) API retrieve VAT obligations endpoint](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion) to see if the prior obligation is met or to see the next obligation.

### Retrieve obligations in software

This API endpoint allows software to search for obligations based on a start and end date range and an obligation status - O for open, F for fulfilled, or blank for both.

If the status is:

  * fulfilled - the response includes the received date
  * open - the response includes the due date
  * blank - the response includes both open and fulfilled obligations

The response also includes the relevant period key associated with each specific obligation.

A new obligation is generated on the first day of the period, whether the previous obligation is fulfilled or not. Software can search for previous open or fulfilled obligations but can only call the next obligation.

Note 1: VAT MTD will support more business and agent types throughout Controlled Go Live. As they are supported, this endpoint will return obligation information for businesses or agents that are on monthly, annual and other non-standard staggers.

Note 2: Period keys should not be shown to the business or agent, these are for software use to ensure the return is recorded against the correct obligation.

### Example period keys for stagger types

**Monthly:**

18AD 30.04.2018<br/>
18AE 31.05.2018<br/>
18AF 30.06.2018

**Quarterly:**

18A1 30.04.2018<br/>
18A2 31.07.2018<br/>
18A3 31.10.2018<br/>
18A4 31.01.2019

Note we have not yet configured annual period keys as annual accounting is not in scope for MVP.

The period key is the ID code for the period that this obligation belongs to. The format is a string of four alphanumeric characters. Occasionally for special periods, the format includes a # symbol (e.g. #001), so the period key must be percent-encoded, for example 18AD, 18A1, %23001.

### Submit a VAT Return with a declaration through software

This is the only POST API endpoint. The data items required are the same as the current 9 Box return. The period key that is relevant to the obligation needs to be provided as part of the return.

We require your software to show your businesses or agents a declaration that they must confirm before it sends the return to us at HMRC. Software should tell us that the business or agent confirmed this declaration by setting the “finalised” boolean to “true” in the VAT (MTD) API call. We will not accept the VAT Return without this.

 > **Declaration text to use when a business confirms submission**

 > When you submit this VAT information you are making a legal declaration that the information is true and complete. A false declaration can result in prosecution.
 
 > **Declaration text to use when an agent confirms the submission**

 > I confirm that my client has received a copy of the information contained in this return and approved the information as being correct and complete to the best of their knowledge and belief.

## View previously submitted VAT Return

Your software can retrieve returns submitted up to four years previously using the VAT (MTD) API:

1. Find the period key for the VAT Return you wish to retrieve, using the retrieve [VAT obligations endpoint](/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion) (/organisations/vat/{vrn}/obligations) with the status field set to F to see all fulfilled obligations within a date range, or left blank to see both open and fulfilled obligations.

2. Use the period key with the view [VAT Returns endpoint](/docs/api/service/vat-api/1.0#_view-vat-return_get_accordion)  (/organisations/vat/{vrn}/returns/{periodKey}) to retrieve the required VAT Return.

Your software cannot retrieve returns filed before business or agents joined VAT (MTD) through the VAT (MTD) API. 

## Amend a VAT Return

We would like software developers to give businesses and agents the option to make VAT payments at key points in their journey.

The [current process](https://www.gov.uk/government/publications/vat-notice-70045-how-to-correct-vat-errors-and-make-adjustments-or-claims/vat-notice-70045-how-to-correct-vat-errors-and-make-adjustments-or-claims#VAT-errors-submitted) for correcting errors on a submitted VAT Return remains:

  * If the net value of the errors is below £10,000, or between £10,000 and £50,000 and does not exceed 1% of the box 6 amount, the business or agent can adjust their current VAT Return (method 1)
  * If the net value of the errors is greater than that, the business or agent must notify HMRC in writing with full details of the errors (method 2)

A business or agent can choose to use method 2 and notify HMRC separately in any case.

We encourage you to make businesses and agents aware of these methods.

## Pay VAT or get a repayment

We would like software developers to give businesses and agents the option to make VAT payments at key points in their journey.

There are multiple ways to pay a VAT bill, listed on GOV.UK at [Pay your VAT bill](https://www.gov.uk/pay-vat), each taking different amounts of time to clear. We advise software developers to ask businesses and agents to visit that link so they can make a payment in the method that best suits them to meet the deadline.

With the arrival of VAT (MTD) the contents of this GOV.UK page are subject to change. Likewise the URL may change in which case we will update the link above.

For businesses to see previous payments they’ve made to us, we would like software developers to encourage them to visit their Business Tax Account (BTA) - login page is [https://www.tax.service.gov.uk/sign-in](https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account).

Using their BTA businesses can:

  * check any VAT Direct Debit arrangements they have with us
  * make changes, or cancel their Direct Debit
  * set up a new Direct Debit instruction
  * make a corporate credit or debit card payment

This page will also provide details of our bank account for businesses or agents wanting to pay by Bacs, CHAPs or by faster payments.

### Agents

Agents can only make a payment via the unauthenticated (not logged in) route - [https://www.tax.service.gov.uk/pay-online/vat](https://www.tax.service.gov.uk/pay-online/vat). This link is accessible from the gov.uk guidance on ['Pay your VAT bill'](https://www.gov.uk/pay-vat).

### Repayments

Repayments to VAT businesses are made by:

1. Card – only if the last payment on record at the time the repayment is due is a card and all other relevant criteria is met. At this time we are only refunding Worldpay transactions back to card. Barclaycard transactions are being repaid by BACS or Payable Order. This process will continue until we have our new Barclaycard repay to card process in place.
2. BACS – to the business bank details held on file.
3. Payable Order – if no bank details are held on file.

In exceptional circumstances we repay by Chaps or Faster Payments but these type of repayments are normally associated with hardship, complaints, etc.

The business’ or agent’s repayment bank account details are only used for a BACS, Chaps or Faster Payment repayment.

## Notify a change of circumstances

We encourage you to remind businesses to check and update their details with us.

They can do this by visiting their Business Tax Account. The login page is:
[https://www.tax.service.gov.uk/sign-in](https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account)  

Businesses can update a range of information, including addresses, telephone numbers, e-mail and business type.

Until VAT (MTD) goes into Live service there will be a manual process in place whereby a business or agent can contact us directly for a manual change to be made to their details.

Functionality will be available for businesses or agents to make the most regular changes - with more functionality being added up until Go Live early 2019.

## View future obligations and previous returns

Businesses may wish to view information in relation to their VAT. They may also like assurance, which may help them when managing their tax affairs. This will also include viewing their previous updates that we have received.

We encourage software developers to include these features within their products. Developers can also direct businesses to visit their Business Tax Account (BTA), the login page attached below:
[https://www.tax.service.gov.uk/sign-in](https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account)

From April 2018, if a business has volunteered for the pilot and signed up for MTD, they will have the option to use and view information within their BTA. This will include information such as: viewing their return, payment obligations and the option to link off from their BTA and make an online card payment.

Agents must use third party software to view their client’s future obligations and previous returns. This software will call the [Retrieve VAT obligations](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion) and [View VAT Return API endpoints](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_view-vat-return_get_accordion) to provide this information.

<img src="figures/future-obligations.png" alt="Future obligations process diagram" border="1px"; style="width:520px;" />

<a href="figures/future-obligations.png" target="blank">Open the future obligations process diagram in a new tab</a>.

1. Business signs in to Gov Gateway account
2. Business views previous returns in BTA
3. Business views when their next return is due in BTA
4. Business views when their next payment is due and what they owe
5. Business selects how to pay and makes payments via BTA
