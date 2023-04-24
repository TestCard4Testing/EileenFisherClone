call title "Pick Up In Store orders"
call cd C:\Users\rprasad01\Git\EileenFisher
call mvn -Dbopis=true -Dcucumber.filter.tags="@PickUp" test
call mvn -Dcucumber.filter.tags="@ShipToHome or @Login" test
pause