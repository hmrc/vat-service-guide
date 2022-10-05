---
title: Hints for using the VAT API | VAT (MTD) End-to-End Service Guide
weight: 7
---

# Hints for using the VAT API
<!--- Section owner: MTD Programme --->

By displaying appropriate prompts, MTD software could help customers to meet their VAT obligations on time. It could also support them to minimise their penalty position if they do fail to meet their obligation deadlines.

## Late Submission Penalties

In January 2023, HMRC is introducing a new points-based system for late submissions. It is designed to be more lenient to those who make the occasional slip-up, whilst still penalising those who repeatedly avoid their obligations.

The following hints will help you to build appropriate prompts into your software to assist customers to submit their VAT returns on time, preventing them from getting a late submission penalty. For customers who have submitted VAT returns late, the prompts will encourage them to submit future VAT returns on time in order to reset their points total to zero.

<table>
    <tr>
        <th>Scenario</th>
        <th>Prompt required</th>
        <th>API endpoints to use</th>
    </tr>
    <tr>
        <td>Prior to VAT return due date</td>
        <td>Notify the customer when a VAT return is due, and inform them of their late submission penalty position if they fail to submit on time (i.e. the customer will receive a penalty point or a £200 fine).</td>
        <td><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20obligations">Retrieve VAT obligations</a> - to find out when the next VAT return is due.</p><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20penalties%20[test%20only]">Retrieve VAT penalties</a> - to see the current late submission penalty position, and hence whether the customer will receive a penalty point or a fine if they make a late submission.</p></td>
    </tr>
    <tr>
        <td>Customer submits a VAT return late</td>
        <td>Notify the customer that they have received a penalty point or they have received a £200 fine. Inform them of their points total.</td>
        <td><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20penalties%20[test%20only]">Retrieve VAT penalties</a></td>
    </tr>
    <tr>
        <td>Customer has penalty points</td>
        <td><p>Inform the customer, prior to each VAT return submission due date, how submitting the VAT return on time will get them closer to resetting their penalty points to zero.</p><p>Also, remind the customer to submit any outstanding VAT returns.</p></td>
        <td><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20obligations">Retrieve VAT obligations</a> - to find out when the next VAT return is due.</p><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20penalties%20[test%20only]">Retrieve VAT penalties</a> - call this (prior to using the <a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Submit%20VAT%20return%20for%20period">Submit VAT return for period</a> endpoint) to see whether the individual or organisation currently has any penalty points. If they have, then prompt the customer that they can get closer to resetting their penalty points if they submit the next VAT return on time.</p><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20obligations">Retrieve VAT obligations</a> - to see any open VAT returns, and remind the customer to submit them.</p></td>
    </tr>

</table>

## Late Payment Penalties

In January 2023, HMRC is introducing late payment penalties that will be charged at different rates based on when the payment is received. This will make the penalties more proportionate to the length of time that the payment is outstanding.

The following hints will help you to build appropriate prompts into your software to assist customers to submit their payments on time, and if they do not pay on time these will support customers in minimising their penalty position.

<table>
    <tr>
        <th>Scenario</th>
        <th>Prompt required</th>
        <th>API endpoints to use</th>
    </tr>
    <tr>
        <td>Prior to payment due date</td>
        <td>Remind the customer of the upcoming payment due date.</td>
        <td><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20liabilities">Retrieve VAT liabilities</a> - to get payment due dates.</td>
    </tr>
    <tr>
        <td>Customer does not pay on or before due date</td>
        <td><p>Three days after the payment due date, notify the customer that they must pay (or agree to a payment plan) within 15 days of the due date, otherwise they will receive a late payment penalty.</p><p>Inform the customer that late payment interest will be due from the date that the amount was outstanding, to the date that it is paid in full.</p></td>
        <td><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20liabilities">Retrieve VAT liabilities</a> - to get payment due dates for any liabilities with due dates that fall between 3 and 15 days ago, which also have an outstanding amount against them (outstandingAmount).</td>
    </tr>
    <tr>
        <td>Customer has not paid 15 days after due date</td>
        <td>16 days after the payment due date, notify the customer that they have incurred a first late payment penalty at 2%. To stop that being increased to another 2%, they must pay (or agree to a payment plan) within 30 days of the due date.</td>
        <td><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20penalties%20[test%20only]">Retrieve VAT penalties</a> - to get details of new late payment penalties, and to show the amount of unpaid tax at day 16 (LPP1LRCalculationAmount).</td>
    </tr>
    <tr>
        <td>Customer has not paid 30 days after due date</td>
        <td><p>Notify the customer that they have received a first late payment penalty at 2% of what was outstanding at day 15, plus 2% of what is still outstanding at day 30. Inform the customer that they will now be receiving a second late payment penalty, calculated daily at a rate of 4% per year for the duration of the outstanding balance.</p><p>Until the customer pays, keep reminding them, at set intervals, of the outstanding debt and that the second penalty is still accruing.</p></td>
        <td><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20penalties%20[test%20only]">Retrieve VAT penalties</a> - to get details of the amount of unpaid tax at day 16 (LPP1LRCalculationAmount) and also the amount of unpaid tax at day 31 (LPP1HRCalculationAmount).</p><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20penalties%20[test%20only]">Retrieve VAT penalties</a> - call this periodically, to see the number of days for which the second late payment penalty has accrued (LPP2Days), the amount that has accrued (penaltyAmountAccruing) and the amount that is yet to be paid (penaltyAmountOutstanding).</p><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20financial%20details%20[test%20only]">Retrieve financial details</a> - call this to see further financial information relating to the penalty.</p></td>
    </tr>
</table>

## Period of familiarisation

To give customers time to get used to the Late Payment changes, HMRC won’t be charging a late payment penalty for the first year from 1 Jan 2023 until 31 December 2023 if the customer pays in full within 30 days of the payment due date.

The following hints will help you to build appropriate prompts into your software to assist customers pay on time and minimise their late penalty position throughout the period of familiarisation.

<table>
    <tr>
        <th>Scenario</th>
        <th>Prompt required</th>
        <th>API endpoints to use</th>
    </tr>
    <tr>
        <td>Prior to payment due date</td>
        <td>Remind the customer of the upcoming payment due date.</td>
        <td><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20liabilities">Retrieve VAT liabilities</a> - to get payment due dates.</td>
    </tr>
    <tr>
        <td>Customer does not pay on or before due date</td>
        <td><p>Three days after the payment due date, notify the customer that they must pay (or agree to a payment plan) within 30 days of the due date, otherwise they will receive a late payment penalty.</p><p>Inform the customer that late payment interest will be due from the date that the amount was outstanding, to the date that it is paid in full.</p></td>
        <td><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20liabilities">Retrieve VAT liabilities</a> - to get payment due dates for any liabilities with due dates that fall between 3 and 30 days ago, which also have an outstanding amount against them (outstandingAmount).</td>
    </tr>
    <tr>
        <td>Customer has not paid 30 days after due date</td>
        <td><p>Notify the customer that they have received a first late payment penalty at 2% of what was outstanding at day 15, plus 2% of what is still outstanding at day 30. Inform the customer that they will now be receiving a second late payment penalty, calculated daily at a rate of 4% per year for the duration of the outstanding balance.</p><p>Until the customer pays, keep reminding them, at set intervals, of the outstanding debt and that the second penalty is still accruing.</p></td>
        <td><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20penalties%20[test%20only]">Retrieve VAT penalties</a> - to get details of the amount of unpaid tax at day 16 (LPP1LRCalculationAmount) and also the amount of unpaid tax at day 31 (LPP1HRCalculationAmount).</p><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20penalties%20[test%20only]">Retrieve VAT penalties</a> - call this periodically, to see the number of days for which the second late payment penalty has accrued (LPP2Days), the amount that has accrued (penaltyAmountAccruing) and the amount that is yet to be paid (penaltyAmountOutstanding).</p><p><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20financial%20details%20[test%20only]">Retrieve financial details</a> - call this to see further financial information relating to the penalty.</p></td>
    </tr>
    <tr>
        <td>Just prior to the period of familiarisation ending</td>
        <td>Inform customers that the period of familiarisation is ending, and they will now have up to 15 days after the due date to make payment. Otherwise, they will be subject to late payment penalties.</td>
        <td><a href="https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0#Retrieve%20VAT%20liabilities">Retrieve VAT liabilities</a> - optionally, call this to get upcoming payment due dates that will fall after the period of familiarisation has ended.</td> 
    </tr>
</table> 
