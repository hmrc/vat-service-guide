---
weight: 3
---

# Obligations and returns

Agents who have set up their clients for VAT (MTD) can submit their clients' VAT returns.

<a href="figures/agent-active.png" target="blank"><img src="figures/agent-active.png"
alt="Agent active process diagram" border="1px"; style="width:100px;" /></a>

<a href="figures/agent-active.png" target="blank">Open the agent process flow process diagram for obligations and returns in a new tab</a>

1. [Agent receives obligations and submits VAT return](#retrieve-obligations-and-submit-vat-return)
2. [Agent amends VAT return](#amend-vat-return)
3. [Client pays VAT bill or receives a repayment](#pay-vat-or-get-repayment)
4. [Agent notifies client’s change of circumstances](#notify-client-change-of-circumstances)
5. [Client views future obligations and previous returns in BTA](#view-future-obligations-and-previous-returns)


Businesses set up for VAT (MTD) can submit VAT returns.

<a href="figures/business-active.png" target="blank"><img src="figures/business-active.png"
alt="Business active process diagram" border="1px"; style="width:100px;" /></a>

<a href="figures/business-active.png" target="blank">Open the business process flow process diagram for obligations and returns in a new tab</a>

1. [Business receives obligations and submits VAT return](#retrieve-obligations-and-submit-vat-return)
2. [Business amends VAT return](#amend-vat-return)
3. [Business pays VAT bill or receives a repayment](#pay-vat-or-get-repayment)
4. [Business notifies change of circumstances](#notify-client-change-of-circumstances)
5. [Business views future obligations and previous returns in BTA](#view-future-obligations-and-previous-returns)

## Retrieve obligations and submit VAT return

This step uses the [VAT (MTD) API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0), and in particular, the following endpoints:

  * [Retrieve VAT obligations](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion)
  * [Submit VAT return for period](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_submit-vat-return-for-period_post_accordion)

<img src="figures/retrieve-obligations.png" alt="Retrieve obligations process diagram" border="1px"; style="width:680px;" />

<a href="figures/retrieve-obligations.png" target="blank">Open the retrieve VAT obligations process diagram in a new tab</a>

1. Mandatory: Business or agent uses their software to retrieve VAT obligations using the [VAT (MTD) API retrieve VAT obligations endpoint](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion).
2. Mandatory: Business or agent uses their software to submit a VAT return using the [VAT (MTD) API submit VAT return for period endpoint ](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_submit-vat-return-for-period_post_accordion).
3. Optionally, business or agent uses their software to retrieve VAT obligations again using the [VAT (MTD) API retrieve VAT obligations endpoint](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion) to see if the prior obligation has been met or to see the next obligation.

### Retrieve obligations in software

This API allows software to search for obligations based on a date range (start and end) and a status (open O, fulfilled F, or both) of the obligations.

If the status is:

  * fulfilled (F), the received date is included
  * open (O), the due date is used
  * left blank then you get both open and fulfilled obligations returned

It also gives the relevant period key associated with that specific obligation.

A new obligation is generated on the first day of the period, whether the previous obligation has been fulfilled or not. Software will be able to search for previous open and/or fulfilled obligations but will only be able to call the next obligation.

Note: MTD-VAT will be supporting more business or agent types throughout controlled go live and as they come on board this endpoint will return obligation information for businesses or agents that are on monthly, annual and other non standard staggers.

Note: Period keys should not be shown to the business or agent, these are for software use to ensure the return is recorded against the correct obligation.

### Example period keys for stagger types

**Monthly:**

18AD 30.04.2018

18AE 31.05.2018

18AF 30.06.2018

**Quarterly:**

18A1 30.04.2018

18A2 31.07.2018

18A3 31.10.2018

18A4 31.01.2019

Note we have not yet configured annual period keys as annual accounting is not in scope for MVP.

The period key is the ID code for the period that this obligation belongs to. The format is a string of four alphanumeric characters. Occasionally for special periods, the format includes a # symbol (e.g. #001), so the period key must be URL-encoded, for example 18AD, 18A1, %23001.

### Submit VAT return with declaration through software

This is the only POST endpoint. The data items required are the same as the current 9 Box return. The period key that is relevant to the obligation needs to be provided as part of the return.

HMRC also requires software to show their businesses or agents a declaration that they must confirm before the return is sent to HMRC, confirmation that this has been done is reflected by the “finalised” boolean being “true”. The return will not be accepted without this.

 > **Declaration text**

 > When you submit this VAT information you are making a legal declaration that the information is true and complete. A false declaration can result in prosecution.

## Amend VAT return

We would like software developers to give businesses and agents the option to make VAT payments at key points in their journey.

The [current process](https://www.gov.uk/government/publications/vat-notice-70045-how-to-correct-vat-errors-and-make-adjustments-or-claims/vat-notice-70045-how-to-correct-vat-errors-and-make-adjustments-or-claims#VAT-errors-submitted) for correcting errors on a submitted VAT Return remains:

  * If the net value of the errors is below £10,000, or between £10,000 and £50,000 and does not exceed 1% of the box 6 amount, the business or agent can adjust their current VAT Return (method 1)
  * If the net value of the errors is greater than that, the business or agent must notify HMRC in writing with full details of the errors (method 2)

A business or agent can choose to use method 2 and notify HMRC separately in any case.

Please ensure businesses and agents are made aware of these methods.

## Pay VAT or get repayment

We would like software developers to give businesses and agents the option to make VAT payments at key points in their journey.

There are multiple ways to pay a VAT bill, listed on GOV.UK at [Pay your VAT bill](https://www.gov.uk/pay-vat), each taking different amounts of time to clear. We advise software developers  to ask businesses and agents to visit that link so they can make a payment in the method that best suits them to meet the deadline.

With the arrival of MTD-VAT the contents of this GOV.UK page are subject to change. Likewise the URL may change in which case we will update the link above.

For businesses to see previous payments they’ve made to us, we would like software developers to encourage them to visit their Business Tax Account - login page is [https://www.tax.service.gov.uk/sign-in](https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account).

Using their Business Tax Account businesses can:

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

## Notify client change of circumstances

**Coming soon - see the VAT (MTD) roadmap for more details.**

We would like software developers to remind businesses to check and update their details with us.

They can do this by visiting their Business Tax Account. The login page is:
[https://www.tax.service.gov.uk/sign-in](https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account)  

Businesses can update a range of information, including addresses, telephone numbers, e-mail and business type.

Until MTD-VAT goes into Live service there will be a manual process in place whereby a business or agent can contact us directly for a manual change to be made to their details.

For exiting Controlled Go Live, functionality will be available for businesses or agents to make the most regular changes with more functionality being added up until Go Live early 2019.

## View future obligations and previous returns

Businesses may wish to view information in relation to their VAT. They may also like assurance, which may help them when managing their tax affairs. This will also include viewing their previous updates that we have received.

We encourage software developers to include these features within their products. Developers can also direct businesses to visit their Business Tax Account, the login page attached below:
[https://www.tax.service.gov.uk/sign-in](https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account)

From April 2018, if a business has volunteered for the pilot and signed up for MTD, they will have the option to use and view information within their Business Tax Account. This will include information such as: viewing their return, payment obligations and the option to link off from their Business Tax Account and make an online card payment.

Agents must use third party software to view their client’s future obligations and previous returns. This software will call the [Retrieve VAT obligations](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion) and [View VAT Return API endpoints](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_view-vat-return_get_accordion) to provide this information.

1. Business signs in to Gov Gateway account
2. Business views previous returns in BTA
3. Business views when their next return is due in BTA
4. Business views when their next payment is due and what they owe
5. Business selects how to pay and makes payments via BTA
