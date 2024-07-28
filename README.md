## Environmental Requirements

- **Java**: Zulu 17
- **Chrome**: tested on 126.0.6478.183

## Building the Project

To build the project, run:

```bash
./gradlew build -x test
```

## Running Tests

To run the tests, use:

```bash
./gradlew test
```

### Filtering Tests

To filter tests by tag, for example, by the SMOKE tag, use:

```bash
./gradlew test -Dtest.layers=smoke
```

- Available tags are regress and smoke. 
- If no tag is specified, all tests will be executed. 
- If an invalid tag is provided, an exception will be thrown.

### Choosing an Environment

To select an environment, use:

```bash
./gradlew test -Denvironment=dev
```

- Available environments are dev (default) and prod. 
- The environment affects the URL of the staging server. 
- If an invalid environment is specified, an exception will be thrown.
