# Java-Unit-Testing-with-Spring-Boot-Mockito
- Udemy course link: https://www.udemy.com/course/learn-unit-testing-with-spring-boot
- Github course link: https://github.com/in28minutes/spring-unit-testing-with-junit-and-mockito
- Limitations of Mockito: https://github.com/mockito/mockito/wiki/FAQ
- We can overcome the limitations of Mockito by using PowerMock

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
  - a mock does not retain the behavior (code) of the original class
  - we can also inject the mock by using the following approach -> this way we don't need to setup the mock with mock(SomeDataService.class) as before
    - @ExtendWith(MockitoExtension.class) // @RunWith(MockitoJUnitRunner.class) for JUnit 4
    - class SomeBusinessInjectMockTest {
    - @InjectMocks
    - SomeBusinessImpl business = new SomeBusinessImpl();
    - @Mock
    - SomeDataService dataServiceMock;
    - }
  - we can use "verify" to check for how many times a method is called -> ex: verify(mock, times(2)).get(anyInt());
  - we can check what argument is passed to a method. This is called argument capturing and can be done like this:
    - mock.add("something");
    - ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    - verify(mock).add(captor.capture());
    - assertEquals("something", captor.getValue());
- Spy:
  - compared to a mock, the spy retains the behavior (code) of the original class -> it uses the real class
  - it is useful for when we don't have access to a class but we want to check what is going on there

### Section 3
- In order to test requests we need to use MockMvc
  - in order to @AutoWire MockMvc:
    - for JUnit 4 we need to add @WebMvcTest(HelloWorldController.class) and @RunWith(SpringRunner.class) on top of the test class
    - for JUnit 5 we need to add @ExtendWith(SpringExtension.class) and @WebMvcTest on top of the test class
- We can use "andExpect" instdea of asserts, ex:
  - {
    - RequestBuilder request = MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON);
    -
    - MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
    - .andExpect(content().json("{\"name\": \"Ball\",\"id\" :1,\"price\":10,\"quantity\":100}")).andReturn();
  - }
- In order to test JPA/Hibernate repositories we need to add @DataJpaTest on top of the testing class
- Integration testing:
  - For integration testing we need to add the following on top of the testing class:
    - For JUnit 4 -> @RunWith(SpringRunner.class) @SpringBootTest
    - For JUnit 5 -> we need just the @SpringBootTest
    - If we are launching a web app we need to change the @SpringBootTest to @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
  - The integration testing class launches the entire application
  - We can still mock classes if we want to replace things inside the integration test
- HamcrestMatchers is a useful library for writing readable asserts, ex: assertThat(myListOfNumbers, hasSize(3));
