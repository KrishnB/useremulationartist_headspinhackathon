# Headspin Hackathon ![](https://github.com/KrishnB/useremulationartist_headspinhackathon/workflows/Headspin%20Hackathon%20Automation%20CI/badge.svg)

A code base for headspin hackathon 

![](docs/run.gif)

## Setup

#### Build Project:
From terminal run
```$xslt
./gradlew build
```
#### Run tests: 

##### UI:

```$xslt
./gradlew runTests
```

##### UI on firefox:

```$xslt
./gradlew runTests -Dbrowser=firefox
```

##### Headless:

```$xslt
./gradlew runTests -Dtarget=headless
```

##### Headspin:

```$xslt
./gradlew runTests -Dtarget=headspin
```

#### View Report
You can find report in path

`build/reports/allure-report/index.html`

#### View Logs
Logs are captured per test, these can be found in below path
`logs/*.log`

## Stack

| Category       | Value          |
| -------------- | ---------------|
| Language       | Java, Groovy   | 
| BuildTool      | Gradle         | 
| Reporting      | Allure         | 
| DI             | Guice          | 
| TestFramework  | TestNG         | 
| Environments   | dev            | 

## Framework Supports

| OS        | Browsers |Run Modes| Screenshots            |Parallelism|
| --------- | ---------|---------|------------------------|-----------|
| Mac       | Chrome   | UI      | On every click and type| Yes       |
| Linux     | Firefox  | Headless| On Test Failure        | Yes       |
| Windows   |          | Headspin|                        | No        |

## Scenarios Covered
* Make a hotel booking

## Approach

Brief description on some of the important packages.

### Clients
This is a pre-check to verify if the site up, we make an api call to get the app state.
This avoids lazy test failures.


### Components
All pages are built as a group of components which are reusable across applications.

* UserSectionComponent : This covers the header section of homepage
* Menu Component : This covers the various mmt offerings  
* Planner
    * HotelBookingPlannerComponent
* Filters
    * PricePerNightBookingFilterComponent
    *UserRatingBookingFilterComponent
    
This approach helps when the site has lot of moving pieces and refactoring is easy.

### Data
All data is modeled as a business entity 

* Site => Global entity, keeps a track of all site details, like title etc
* Customer
* Booking


### Assertions

All assertions are part of the model itself.

This approach helps in validation business data easily

Eg:

```$java
    public void assertThatSiteIsUp() {
         assertThat(title).startsWith(siteTitle);
     }
```

```$xslt
    public void assertHotelNameIsCorrect(String hotelName) {
        assertThat(this.hotelName).isEqualTo(hotelName);
    }
```

### Screenshots

Framework captures screenshot on below actions to build test timeline
* Click
* Type

Framework also capture screenshot at the time of test failure

## P.S
These approaches are pointers of how the solution can be taken  forward.
You can read more about the framework from [Wiki](https://github.com/KrishnB/useremulationartist_headspinhackathon/wiki)


