Zaimplementować wydajną usługę REST, której zadaniem będzie odbieranie i zapisywanie informacji o pozycjach (geolokalizacji)
z urządzeń mobilnych np. telefon/lokalizator GPS.
Przykład formatu danych z urządzeń: {'deviceId':'12345', 'latitiude': 505430, 'longitude': 1423412}.


testy jednostkowe rozwiązania,

W tym zadaniu wykorzystałem baze danych H2 do której zapisuje informacje o pozycjach geolokalizacyjnych.
Encja lokalizacji posiada pole Id któro jest generowane automatycznie oraz długość i szerokość geograficzna.
Długość i szerokość jest walidowana za pomocą @min, @max z biblioteki javax.validation.constraints.
Stworzyłem kontroler z dwoma endpointami, pierwszy służy do zapisywania lokalizaji w bazie
Drugi endpoint służy do wyświetlania wszystkich lokalizacji. Metody serwisu działają 
dziei interfejsowi GpsRepository który rozszerza interfejs JpaRepository. W projekcie używałem lombooka ze względu na czytelność
oraz Swaggera do testowania endpointów
