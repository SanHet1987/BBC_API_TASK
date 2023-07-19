Feature: Manual Test Api on Music Tracks and MetaData

  Background:
    Given I create a new media endpoint
    When  I send valid GET request

  Scenario:As a user,want to verify type field
    Then verify the type field should not be null or empty
    And  verify type field should always be "music_track"

  Scenario: As a user, want to verify tertiary field in title_list
    Then verify tertiary field is always null

  Scenario: As a user, want to verify start and end fields in offset
    Then  verify "start" field is always less than "end" field

  Scenario: As a user,want to verify label field in offset
    Then  verify "label" field in offset is always null

  Scenario: As a user,want to verify Uri for Apple music is not null
    Then  verify label "apple music"
    And   Uri for apple music should not be null
    And   Verify Uri should always contain "apple" word in it

  Scenario Outline:As a user,want to verify Headers values
    Then verify The header Content-Type as a <Content>
    And  X-RateLimit-Limit as a <X-RateLimit>

    Examples:
      |           Content|  X-RateLimit|
      |  application/json|           60|
