---
title: VAT (MTD) End-to-End Service Guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with VAT API for Making Tax Digital.
---

# VAT (MTD) end-to-end service guide

**Version 7.1** issued 12 December 2023
***

This guide explains how you can integrate your software with our APIs to submit VAT returns under Making Tax Digital for VAT. It shows how the APIs fit into various end-to-end user journeys. It is intended to help software developers, designers, product owners or business analysts understand how your software needs to interact with HMRC systems.

## Overview
<!-- Section owner: MTD Programme -->

VAT (MTD) requires VAT registered businesses with taxable turnover above the VAT registration threshold to:

* keep records in digital form
* file their VAT Returns using software (via our [VAT (MTD) API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/))

The frequency of submitting a VAT Return (annually, quarterly or monthly) does not change under MTD.

For more details see [VAT Notice 700/22](https://www.gov.uk/government/publications/vat-notice-70022-making-tax-digital-for-vat). In particular, [section 7](https://www.gov.uk/government/publications/vat-notice-70022-making-tax-digital-for-vat/vat-notice-70022-making-tax-digital-for-vat#examples-of-where-a-digital-link-is-required) shows the various options for software integration.

## Production approvals process for VAT (MTD)

Our key objectives for VAT (MTD) are to:

* ensure customers have a streamlined end-to-end journey and software that supports everything a business customer needs to do to meet their VAT obligations
* safeguard customer data and protect HMRC systems against fraud and criminal attack

This section of the guide explains the features your product must include before production credentials are sought, together with features you should consider building into your products.

### Minimum functionality standards

The minimum required functionality is as follows:

* A software product must submit the fraud prevention header data required by law.
* A VAT (MTD) product must allow the customer to:
    * Retrieve VAT obligations using the VAT (MTD) API [Retrieve VAT obligations](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/RetrieveVATobligations) endpoint.
    * Submit a VAT return using the VAT (MTD) API [Submit VAT return for period](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/SubmitVATreturnforperiod) endpoint.

The following endpoints are also available. These are **optional**. However, we do recommend that you include them to support your customers’ needs.

* Retrieve VAT obligations again using the VAT (MTD) API [Retrieve VAT obligations](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/RetrieveVATobligations) endpoint to check if the VAT Return has met the current obligation - or to see the next obligation.
* Retrieve returns submitted up to four years previously by using the VAT (MTD) [View VAT return](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/ViewVATReturn) endpoint.
* Retrieve VAT liabilities by calling the VAT (MTD) API [Retrieve VAT liabilities](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/RetrieveVATliabilities) endpoint.
* Retrieve VAT payments by calling the VAT (MTD) API [Retrieve VAT payments](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/RetrieveVATpayments) endpoint.
* Retrieve details of the penalties that have been applied to a VAT account by using the VAT (MTD) [Retrieve VAT penalties](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/RetrieveVATpenalties) endpoint.
* Retrieve the financial details relating to a penalty by using the VAT (MTD) [Retrieve financial details](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/Retrievefinancialdetails) endpoint.

### Fraud Prevention Headers

You must supply fraud prevention header information for all our APIs, before approval can be granted and production credentials issued.

HMRC must see evidence of fraud prevention headers being sent and be satisfied as to their level of accuracy.

Please use the [Test Fraud Prevention Headers API](/api-documentation/docs/api/service/txm-fph-validator-api/) to check headers submitted by your application meet the latest version of the [Fraud Prevention Headers specification](/guides/fraud-prevention/).

### Testing requirements

The following endpoints are required to be tested to cover the VAT reporting:

1. Use the [Create Test User API](/api-documentation/docs/api/service/api-platform-test-user/1.0) to create a test user who is an ‘organisation’ to generate test credentials (you will be provided with a test VAT Registration Number (VRN) and User ID and Password details).
2. Use the VAT (MTD) API [Retrieve VAT obligations](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/RetrieveVATobligations) endpoint to return obligation periods (this will return a canned response in the sandbox environment).
3. Use the VAT (MTD) API [Submit VAT return for period](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/SubmitVATreturnforperiod) endopint to submit the return for the open obligation period.
4. We would also need to see testing to any of the other optional endpoints, if these are to be utilised by the software.

Developers need to:

* consider developing guidelines within the software for relevant users, including a reference to HMRC user interface journeys for customers and agents (you can find examples of the flow for both Agents and Businesses, in the ‘[Set up](/guides/vat-mtd-end-to-end-service-guide/documentation/set-up.html)’ section of this guide)
* use APIs as efficiently as possible to prevent hitting the [rate limit](/api-documentation/docs/reference-guide#rate-limiting)
* build relevant error responses, so that the software can deal with exceptions
* when authorising software, please make it clear to your users, that the correct VAT (MTD) gateway organisation account credentials, or Agent Services Account credentials, need to be used when logging into the system.

<div class="govuk-warning-text">
  <span class="govuk-warning-text__icon" aria-hidden="true">!</span>
  <strong class="govuk-warning-text__text">
    <span class="govuk-warning-text__assistive">Warning</span>
Once all the above steps have been completed, please contact <a href="mailto:SDSTeam@hmrc.gov.uk">SDSTeam@hmrc.gov.uk</a> within 2 weeks of completing your API testing, to enable us to view the data within our logs. It takes 10 working days to advise of the outcome. When you contact us, we will then ask you to complete 2 questionnaires, before checking your Fraud Prevention Header and VAT (MTD) API testing.
  </strong>
</div>

## Terms of use

You must comply with our [terms of use](/api-documentation/docs/terms-of-use). You must accept the terms of use before we can issue you with production credentials.

## Software choices

HMRC publishes a [list of compatible software](https://www.gov.uk/guidance/find-software-thats-compatible-with-making-tax-digital-for-vat) for VAT (MTD) on GOV.UK. Software providers may request to be added to this list when they have completed the necessary steps in the [Production approvals process for VAT (MTD)](#production-approvals-process-for-vat-mtd) section.

Your software can be added to this page if you provide a product for retail/commercial use.

Once production access has been granted, we also request that you make a live submission (and provide us with the VAT Registration Number to allow us to check this), before you can be added to the software choices page.

## End-to-end user journeys
<!--- Section owner: MTD Programme --->

These journeys show examples of use. Journeys for businesses and agents are broken down into:

  * [VAT (MTD) set up activities](documentation/set-up.html#set-up)
  * [retrieving VAT (MTD) obligations, submitting returns and paying bills](documentation/obligations.html#obligations-and-returns)
  * [paying VAT (MTD) penalties and interest or appealing](documentation/penalties.html#penalties-and-appeals)
  * [VAT (MTD) close down activities](documentation/close-down.html#close-down)

## Related API documentation
<!--- Section owner: MTD Programme --->

  * [VAT (MTD) REST API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0)
  * [Create Test User API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/api-platform-test-user/1.0)

## Changelog
<!--- Section owner: MTD Programme --->

### Version 7.1

12 December 2023

* Added new [Production approvals process for VAT (MTD)](#production-approvals-process-for-vat-mtd), [Terms of use](#terms-of-use) and [Software choices](#software-choices) sections.
* Updated the [Customer support model](documentation/customer-support.html) section.

### Version 7.0

10 October 2022

* Updated [Penalties and appeals](documentation/penalties.html) section to reflect forthcoming penalty reform
* Added [Hints for using the VAT API](documentation/hints.html)
