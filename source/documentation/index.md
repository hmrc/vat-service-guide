---
weight: 1
---

# VAT (MTD) End-to-End Service Guide

This guide explains how you can integrate your software with our APIs to submit VAT returns under Making Tax Digital for VAT. It shows how the APIs fit into various end-to-end user journeys.

## Overview

VAT (MTD) requires VAT registered businesses with taxable turnover above the VAT registration threshold to:

* keep records in digital form
* file their VAT Returns using software (via our [VAT (MTD) API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/))

The frequency of submitting a VAT Return (annually, quarterly or monthly) does not change under MTD.

For more details see [VAT Notice 700/22](https://www.gov.uk/government/publications/vat-notice-70022-making-tax-digital-for-vat). In particular, [section 7](https://www.gov.uk/government/publications/vat-notice-70022-making-tax-digital-for-vat/vat-notice-70022-making-tax-digital-for-vat#examples-of-where-a-digital-link-is-required) shows the various options for software integration.


## End-to-end user journeys

These journeys show examples of use. Journeys for businesses and agents are broken down into:

  * [VAT (MTD) set up activities](documentation/set-up.html#set-up)
  * [retrieving VAT (MTD) obligations, submitting returns and paying bills](documentation/obligations.html#obligations-and-returns)
  * [paying VAT (MTD) penalties and interest or appealing](documentation/penalties.html#penalties-and-appeals)
  * [VAT (MTD) close down activities](documentation/close-down.html#close-down)

## Related API documentation

  * [VAT (MTD) REST API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/vat-api/1.0)
  * [Create Test User API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/api-platform-test-user/1.0)
