Feature: Demo person service SSN hystrix fallback cached and not cached

  @stresstestssnfallbackcached
  Scenario Outline: Performance stress test Search based on SSN
    Given I pass the header information for ssn stresstest
      | Content-Type | application/json |
    When client request POST "<ServiceURL>" with json data "<RequestFile>" with loadsize <loadsize>
    Then view the result for load testing

    Examples: 
      | ServiceURL          | RequestFile                  | ResponseFile                  | loadsize |
      | /demo/v1/person/ssn | ssnfallbackcachedone.Request | ssnfallbackcachedone.Response |      100 |