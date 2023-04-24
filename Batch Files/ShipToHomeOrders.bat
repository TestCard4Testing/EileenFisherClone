call title "Ship To Home order"
call cd C:\Users\rprasad01\Git\EileenFisher
call mvn -Dcucumber.filter.tags="@ShipToHome" test
pause
