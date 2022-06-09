Feature: comparar laptops en "https://www.gadgetsnow.com/compare-laptops"

  Scenario: comparar 2 laptops y guardar tabla summary en excel
    Given ir al sitio "https://www.gadgetsnow.com/compare-laptops"
    And agregar laptop "Lenovo E41-80" y "Lenovo B40-80"
    And click button "compare"
    Then guardar datos de tabla "Summary" en excel