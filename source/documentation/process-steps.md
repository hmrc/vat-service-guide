# Process Steps

## Read campaign pages and guidance

__Coming soon - see the [VAT (MTD) roadmap](https://hmrc-devhub-cycle-32.herokuapp.com/documentation/docs/vat-roadmap) for more details.__

We continue to use GOV.UK as our main way to guide businesses and agents about government services and information, although we will not publish guidance about how to join the VAT pilot until we exit the Controlled Go Live period of the pilot and enter public beta. Initially, the guidance will:

  * signpost a few more detailed, task-based content pages on GOV.UK starting with:
    * an overview of MTD
    * choose software page
    * sign up

  * help build awareness about what MTD means for businesses and agents
  * signpost the route for customer support, including how software developers vendors can contact our HMRC teams
  * manage users' concerns if not eligible yet, or there's no legal requirement for them yet
  * help us manage the messages businesses and agents need to know over coming months and years - who is eligible, why signing up early might help you, when this will become mandatory and so on

As we make more functionality live, we’ll add more task-based guidance onto GOV.UK to ensure that businesses and agents can continue their journey. For example, 'Sign up to report VAT through software', 'Choose software' and so on.

As MTD becomes more mainstream, we will reduce campaign content and presence.

We would like software applications to make businesses and agents aware of the links to the guidance detailed above if they are interested in the service.

## Create agent services account and link existing VAT clients

An agent must create an Agent services account and connect it to their accounting software. The creation of the account is a one-off process that an agency must do to enable its agents to access Making Tax Digital through this one account and act for their clients.

The agent does this through their accounting software or from GOV.UK. The agent must:

  * create a new Government Gateway ID which will be the agency’s new Government Gateway ID and password. This will become the agency's user ID and password which is to access all our new HMRC services via accounting software
  * give information about the agency, which is held by us
  * receive an agent reference number, which is the number assigned to all their existing and new clients

1. Agent creates a new Government Gateway ID which becomes the agency's new Government Gateway ID and password.
2. Agent signs in to Government Gateway account with existing agent credentials
3. Agent identifies their agency with its SA UTR or CTR
4. Agent gives their details and email address
5. Agent saves user ID and gateway agent ID
6. Agent gives agency address
7. Agent checks details and creates account
8. Agent saves agent services account number

### Create an Agent services account

Live page [www.gov.uk/guidance/get-an-hmrc-agent-services-account](https://www.gov.uk/guidance/get-an-hmrc-agent-services-account)

For Partnerships or a Limited Liability Partnerships you will need to use your Partnership UTR, and not the UTR for each partner or LL partner.

After an agent creates an agent services account, they link their existing VAT clients to the account. When a client subscribes to MTD, the agent can:

  * view the client's data
  * submit updates to HMRC

To link their existing VAT clients to the agent services account the agent must:

  * sign in with each Government Gateway ID that is currently used to access HMRC online services. If an agent currently has ten Government Gateway IDs they must do this ten times.
  * submit their firm's SA or CT UTR and agent reference number. This links existing VAT clients linked to a particular Government Gateway ID to the new Agent services account.

We encourage software developers to ensure their agency customers are aware of the service and give links to more information.

1. Agent starts journey to to add existing clients
2. Agent signs in to Government Gateway account with agent credentials for existing clients
3. Agent enters agency account number and their SA UTR or CTR
4. Connection to existing clients is confirmed for that Government Gateway account
5. Agent repeats the process with next Government Gateway account that has existing clients until all clients are linked

## Agent links new VAT client

After an agency has created a new Agent services account, they must get authority from each new client they want to represent for MTD. To do this an agent must send a digital request to each new client. The client can accept or reject the request digitally.
To add a client:

1. The agent:
  * clicks the link for adding a client
  * gives the client’s information
  * sends a direct request to the client

2. The client:
  * receives email from the agent and clicks on the link to begin the process
  * logs in with Government Gateway account and completes identity checks
  * accepts or rejects the agent asking to represent them

3. The agent is updated with the client's response. If the client accepts, we disclose the client's MTDfB-VAT data to their agent.

**Insert diagram**

1. Agent signs into agent services account
2. Agent clicks on link to ask a client to authorise them
3. Agent chooses individual or organisation client type
4. Agent chooses what authorisation they need from client
5. Agent gives client's VRN and VAT registration date
6. Agent gets a unique link and sends it to their client in email
7. Client receives email from agent and clicks on the link to begin the process
8. Client logs in with Gov Gateway account and completes identity checks
9. Client confirms authorisation for agent to represent them

## Agent registers client for VAT (MTD)

### Agent signs up a client to VAT (MTD)

![Active](documentation/figures/agents-sign-up.png)


In April 2018 we delivered the sign-up service that enables existing VAT businesses to move to the VAT (MTD) service. A business that  wants to use VAT (MTD) must sign up before first use, even if they have already signed up for MTD for income tax.
Agents can sign up an existing client’s business. However, the creation of the agent account which is a one-off process must be completed to enable an agency to sign up their clients.

We will develop supporting content that allows a business to identify whether they need to:

  * register for tax and then sign up for MTD
  * sign up only

After a business signs up they are informed of their update obligations.

The sign-up service requests minimal information from the business such as e-mail address. It reuses information provided as part of identity checking.

We will enable customers to register and sign up through GOV.UK. Software developers can also link to the service from their software.

1. Agent signs in to Government Gateway account
2. Agent confirms VRN of client
3. Agent confirms client is sole trader or limited company
4. Agent confirms client details eg NINO/DOB for sole trader, CRN for limited company
5. Agent confirms client's email address
6. Client verifies their email address
7. Agent agrees to terms of participation for self and client
8. Agent waits 24 hours to see if client is approved to sign up

### Agent signs up a sole trader client to MTD for VAT
Agents must have already created an agent services account or we display this error message:

[inset text] The link to ‘Choose accounting software’ will remain inactive until VAT (MTD) leaves Controlled Go Live.

### Agent signs up a limited company client to VAT (MTD)
Agents must have already created an agent services account or we display this error message:

[inset text] The link to ‘Choose accounting software’ will remain inactive until VAT (MTD) leaves Controlled Go Live.

## Process step: business registers for VAT (MTD)

### Sole trader and limited company can sign up to MTD for VAT

1. Business signs in to Government Gateway account
2. Business confirms VRN
3. Business confirms whether it is sole trader or limited company
4. Business completes identity verification (if applicable)
5. If a Limited company, confirms its Company Registration Number
6. Business enters and verifies its email address
7. Business agrees to the terms of participation
8. Business waits 24 hours to see if it is approved to sign up

### Sole trader can sign up to MTD for VAT

If you have previously done this you will not be asked again.

Please Note: The link to ‘Choose accounting software’ will remain inactive until the point of leaving Controlled Go Live.

### Limited company able to sign up to VAT (MTD)

Please Note: The link to ‘Choose accounting software’ will remain inactive until the point of leaving Controlled Go Live.

## Business or agent chooses software

**Coming soon - see the VAT (MTD) roadmap for more details.**

We will publish a list of software applications that are VAT (MTD) compatible on GOV.UK so businesses and agents can choose what suits them.

See an example of this format being used for MTD Income Tax: [www.gov.uk/guidance/software-for-sending-income-tax-updates](https://www.gov.uk/guidance/software-for-sending-income-tax-updates).

We are considering the design of this page (see the early draft shown) working with the software industry.

We require that each application offered  to users complies with our Terms of Use [https://developer.service.hmrc.gov.uk/api-documentation/docs/terms-of-use](https://developer.service.hmrc.gov.uk/api-documentation/docs/terms-of-use) which must be accepted by software developers before we issue production credentials.

**Insert screenshot?**

This is a very early draft of what the software choices page may look like in the future, and continues to be user tested.

## Link software to HMRC

1. Third party software takes the business or the agent to the authorisation endpoint
2. Business or agent views grant authority start page for an overview of the process before starting
3. Business or agent signs in to their Government Gateway account.
4. Business or agent completes 2 step verification if applicable
5. Business or agent completes identity checks if applicable
6. Business or agent grants (or refuses) permission for the software to represent them with HMRC
5. Business or agent is returned to third party software

Businesses and agents using software that connects to Developer Hub APIs must give their software permission to interact with their data and HMRC. They authenticate directly with us using their Government Gateway account, and grant the software the authority to interact with HMRC on their behalf - for a set of functions called API [scopes](https://developer.service.hmrc.gov.uk/api-documentation/docs/reference-guide#scopes).

Agents must sign in with their Government Gateway agent services account user Agent ID which was generated as part of the [agent services account journey](process-steps.html#create-agent-services-account-and-link-existing-vat-clients).

We then issue an OAuth 2.0 access token that’s specific to the business or agent. The software must pass this access token in subsequent API requests as explained in authorisation of [user-restricted endpoints](https://developer.service.hmrc.gov.uk/api-documentation/docs/authorisation/user-restricted-endpoints).

## Retrieve obligations and submit VAT return

This step uses the [VAT (MTD) API](https://docs.google.com/document/d/1B5eOxmIu8bIspttCcguzF7cKtFg1dcau2WmpckLBxMo/edit#), and in particular, the following endpoints:

  * [Retrieve VAT obligations](https://www.qa.tax.service.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion)
  * [Submit VAT return for period](https://www.qa.tax.service.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_submit-vat-return-for-period_post_accordion)

**Insert diagram**

1. Business or agent uses their software to retrieve VAT obligations using the [VAT (MTD) API retrieve VAT obligations endpoint](https://www.qa.tax.service.gov.uk/api-documentation/docs/api/service/vat-api/1.0#_retrieve-vat-obligations_get_accordion).
2. Business or agent uses their software to submit a VAT return using the VAT (MTD) API submit VAT return for period endpoint.
3. Optionally, business or agent uses their software to retrieve VAT obligations again using the VAT (MTD) API retrieve VAT obligations endpoint to see if the prior obligation has been met or to see the next obligation.

### Business or agent can retrieve obligations in software

This API allows software to search for obligations based on a date range (start and end) and a status (open O, fulfilled F, or both) of the obligations.

If the status is:

  * fulfilled (F), the received date is included
  * open (O), the due date is used
  * left blank then you get both open and fulfilled obligations returned

It also gives the relevant period key associated with that specific obligation.

A new obligation is generated on the first day of the period, whether the previous obligation has been fulfilled or not. Software will be able to search for previous open and/or fulfilled obligations but will only be able to call the next obligation.

Note: MTD-VAT will be supporting more customer types throughout controlled go live and as they come on board this endpoint will return obligation information for customers that are on monthly, annual and other non standard staggers.

Note: Period keys should not be shown to the customer, these are for software use to ensure the return is recorded against the correct obligation.

### Example format period keys for stagger types

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

### Business or agent able to submit VAT return with declaration through software

This is the only POST endpoint. The data items required are the same as the current 9 Box return. The period key that is relevant to the obligation needs to be provided as part of the return.

HMRC also requires software to show their customers a declaration that they must confirm before the return is sent to HMRC, confirmation that this has been done is reflected by the “finalised” boolean being “true”. The return will not be accepted without this.

__Declaration text__

When you submit this VAT information you are making a legal declaration that the information is true and complete. A false declaration can result in prosecution.

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

For businesses to see previous payments they’ve made to us, we would like software developers to encourage them to visit their Business Tax Account - login page is [https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account](https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account).

Using their Business Tax Account businesses can:

  * check any VAT Direct Debit arrangements they have with us
  * make changes, or cancel their Direct Debit
  * set up a new Direct Debit instruction
  * make a corporate credit or debit card payment

This page will also provide details of our bank account for customers wanting to pay by Bacs, CHAPs or by faster payments.

### Agents

Agents can only make a payment via the unauthenticated (not logged in) route - https://www.tax.service.gov.uk/pay-online/vat. This link is accessible from the gov.uk guidance on 'Pay your VAT bill'.

### Repayments

Repayments to VAT businesses are made by:

1. Card – only if the last payment on record at the time the repayment is due is a card and all other relevant criteria is met. At this time we are only refunding Worldpay transactions back to card. Barclaycard transactions are being repaid by BACS or Payable Order. This process will continue until we have our new Barclaycard repay to card process in place.
2. BACS – to the business bank details held on file.
3. Payable Order – if no bank details are held on file.

In exceptional circumstances we repay by Chaps or Faster Payments but these type of repayments are normally associated with hardship, complaints, etc.

The business’ or agent’s repayment bank account details are only used for a BACS, Chaps or Faster Payment repayment.

## Notify client change of circumstances

__Coming soon - see the VAT (MTD) roadmap for more details.__

We would like software developers to remind businesses to check and update their details with us.

They can do this by visiting their Business Tax Account. The login page is:
[https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account](https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account)  

Businesses can update a range of information, including addresses, telephone numbers, e-mail and business type.

Until MTD-VAT goes into Live service there will be a manual process in place whereby a business or agent can contact us directly for a manual change to be made to their details.

For exiting Controlled Go Live, functionality will be available for businesses or agents to make the most regular changes with more functionality being added up until Go Live early 2019.

## View future obligations and previous returns

Businesses may wish to view information in relation to their VAT. They may also like assurance, which may help them when managing their tax affairs. This will also include viewing their previous updates that we have received.

We encourage software developers to include these features within their products. Developers can also direct businesses to visit their Business Tax Account, the login page attached below:
[https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account](https://www.tax.service.gov.uk/gg/sign-in?continue=/business-account)

From April 2018, if a business has volunteered for the pilot and signed up for MTD, they will have the option to use and view information within their Business Tax Account. This will include information such as: viewing their return, payment obligations and the option to link off from their Business Tax Account and make an online card payment.

Agents must use third party software to view their client’s future obligations and previous returns. This software will call the Retrieve VAT obligations and View VAT Return API endpoints to provide this information.

1. Business signs in to Gov Gateway account
2. Business views previous returns in BTA
3. Business views when their next return is due in BTA
4. Business views when their next payment is due and what they owe
5. Business selects how to pay and makes payments via BTA

### Business can view previous returns in BTA

### Business can view when their next return is due in BTA

### Business can view when their next payment is due, along with the ability to make payments via BTA

-------------------

## Paying penalties and interest

Existing penalties and notification methods will remain in place for businesses and agents:

  * Late registration - Factsheet CC/FS11
  * Late Filing - VAT Notice 700/50
  * Late Payment - VAT Notice 700/50
  * Inaccuracy penalties - Factsheet CC/FS7
  * Wrongdoing penalty - Factsheet CC/FS12
  * Retention of records - VAT Notice 700/21
  * Breaches of regulations - VAT Notice 700/21
  * Default interest - VAT Notice 700/43


## Appeals

The existing process for Appeals will remain in place. A business or agent may contact HMRC if they have a query about a tax decision. If they don’t understand the decision they can also get advice from HMRC or professional help.

## Unsubscribing a client from VAT (MTD)

Initially there is a manual process in place whereby a business or agent can contact our HMRC helpline to notify us they wish to unsubscribe from the service.

In the event that the business continues to be VAT registered, if necessary VAT returns can be submitted manually.

In time the manual process will be replaced by a digital process.


## Client breaks agent authority link

Client only de-authorisation

**Insert diagram**

1. Client signs in to Government Gateway account
2. Client manages their tax agents
3. Client removes authorisation from an agency
4. Client confirms removal of authorisation from that agency

### Agent breaks client link

This process will be provided by the agent’s Agent Services account.


## Process step: change of agent details
This will initially be the usual process, which can be used to remove the agent reference number and Government Gateway enrolment (HMRC-AS-AGENTS).

The scenario where this is needed is when an agency ceases trading.

If an agency no longer wants to participate in MTD, they can stop using their Government Gateway ID.We are currently working to include a digital journey as part of the wider change of circumstances solution.
