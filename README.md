# Reproducer for lazy loading bug
https://hibernate.atlassian.net/browse/HHH-17750

## Run test
`mvn install`

Or from IDE:
* tests are in [LazyLoadingTest.java](src%2Ftest%2Fjava%2Forg%2Facme%2FLazyLoadingTest.java)
* org.acme.LazyLoadingTest#testEntityBHasLazyA is failing,
* all other tests pass
