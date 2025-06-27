---
title: VAT customer information | VAT (MTD) End-to-End Service Guide
weight: 25
---

# VAT customer information
<!--- Section owner: MTD Programme --->

Your software can use the VAT (MTD) API to retrieve information about a VAT customer. For example, it is possible to retrieve the customer's effective date of registration for VAT and also check whether the customer has entered the VAT Flat Rate Scheme.

Having the effective date of VAT registration will help developers add preventative measures into the software to stop ongoing claims to the first year 1% discount continuing after the first 12 months of VAT Registration.

<img src="figures/customer-information.svg" alt="Customer information process diagram" style="width:520px;" />

<a href="figures/customer-information.svg" target="blank">Open the customer information process diagram in a new tab</a>.

Specifically, the software should use this endpoint:

  * [Retrieve VAT customer information](/api-documentation/docs/api/service/vat-api/1.0/oas/page#tag/organisations/operation/RetrieveVATCustomerInformation)

All information that the endpoint returns has been provided from the customer to HMRC.
