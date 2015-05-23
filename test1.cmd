REM Run a simple test.
echo {"oname":"abc","ovalue":"Hello!"} > test.in
curl -v --data-binary "@test.in" -X POST -H "Accept: application/json" -H "Content-Type: application/json" http://localhost:8072/test
