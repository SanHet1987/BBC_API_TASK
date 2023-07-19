@Smoke
Feature:Automation Rest Api on Music Tracks and MetaData

  Background:
    Given I create a new media endpoint
    When  I send valid GET request

  Scenario Outline: As a user, want to verify status code and response time
    Then  The status code should be <statusCode>
    And   Verify response time <responseTime>

    Examples:
      | statusCode | responseTime |
      | 200        | 1000         |

  Scenario: As a user, want to verify field Id and segment_type
    Then  Id field should not be null or empty String
    And   Segment Type field should be always Music

  Scenario: As a user, want to Verify primary field in title_list
    Then  Verify primary field under title list is not null or empty String

  Scenario: As a user, want to verify, now_playing field in offset
    Then  Verify only second, now_playing field in offset as true

  Scenario: Verify the headers value
    Then  Verify response header value for date

