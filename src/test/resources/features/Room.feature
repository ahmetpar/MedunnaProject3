Feature: test api



  @RoomGet
  Scenario: Rooms api with GET request / Room api testi

    Given kullanici roomlar icin get request yapar
    And kullanici gelen room datayi deserialize eder
    Then kullanici room datasini validate eder


    
    @RoomPost
    Scenario: post request validation
      
      

