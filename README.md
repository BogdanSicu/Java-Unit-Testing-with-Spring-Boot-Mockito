# Java-Unit-Testing-with-Spring-Boot-Mockito
- Udemy course link: https://www.udemy.com/course/learn-unit-testing-with-spring-boot
- Github course link: https://github.com/in28minutes/spring-unit-testing-with-junit-and-mockito

## Things learned
### Section 2
- Stubs:
  - A Stub is a "dummy" implementation of a class / method that we need in order to test another (ex: we implement the interface "Calculate" because it is used in our class "Calculator")
  - Stubs aren't the best option for mocking implementations because we need to add 1 of them for each data we want (ex: maybe we want to have 2 tests, 1 where a list is populated and another one where a list is empty, this would require 2 stubs or multiple return scenarios for the method)
  - the stubs are pretty difficult to maintain because when we change an interface that is implemented by the stubs, we would need to modify the stub as well

- Mockito:
  - Mockito solves the problem of the Stubs by just setting up the return instead of needing to implement the actual class ex:
    - {
      - SomeDataService dataServiceMock = mock(SomeDataService.class);
      - when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
    - }
  - by using the method above it is easier to maintain the tests as we are not dependent on any addition to an interface (if somebody adds a method to an interface we don't have to implement it)

### Section 3
