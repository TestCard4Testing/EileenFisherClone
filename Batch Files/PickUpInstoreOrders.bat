call title "Pick Up In Store orders"
call cd C:\Users\rprasad01\Git\EileenFisher
call mvn -Dcucumber.filter.tags="@ShipToHome or @Login" test
::call mvn -Dbopis=true -Dcucumber.filter.tags="@Run" test
pause