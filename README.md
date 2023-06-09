# HospitalApp

## About This Project:

This repository describes a Java Database Connectivity (JDBC) project portraying a simple hospital.
The project follows a JDBC architecture that includes a JDBC Data Access Layer (DAL) with associated
Data Access Objects (DAOs).

#### Continuous Integration (CI)

This project deploys automatic testing by using the `Surefire Plugin` for Maven to run unit tests
and GitHub Actions to automatically build and test the Java Maven package. Every time code changes
are pushed to the repository or a pull request is made, GitHub Actions is triggered to run tests and
ensure that the code is working as expected. Successful builds and tests are indicated next to the
commit ID with a :white_check_mark: while failed builds or tests are marked :x:.

The maven.yml file in the `.github/workflows` directory of this repository contains the
configuration for GitHub Actions to run the tests.

The tests are composed of class unit tests using TestNG and are located in `src/test/java/`. By
employing automatic testing, we can catch issues early in the development process and ensure that
our code is always working as expected. This helps to maintain the quality of the code and make sure
that the project is stable and reliable.

## Iter-6

### Task

Requirements

- Add Factory, Abstract Factory, Builder, Listener, Facade, Decorator, Proxy, Strategy, MVC patterns
  to your current project. (confirm assignments with your mentors)
    - The `models/DecoratedPatient` class acts as a decorator for the `Patient` class, extending its
      functionality by adding the ability to store and retrieve a list of medical records.
    - Building on top of `models/DecoratedPatient`, adherence to the MVC design pattern realized in
      implementing Model (`Patient`, `DecoratedPatient`, `MedicalRecord`), View (`EntityView`
      , `DecoratedPatientView`), and Controller (`EntityController`, `DecoratedPatientController`)
      components.
- Refactor code for the current project to satisfy SOLID principles.
    - Single Responsibility Principle
        - Examples found in all DAOs, Controllers, Service classes have single responsibilities
    - Open/Closed Principle
        - Use of interfaces like `IEntityService` and abstracted classes like `EntityDAO` allows for
          easy extension of functionality without modifying existing code.
    - Liskov Substitution Principle
        - Adherence to interfaces like `IEntityDAO` used in `AbstractDAOFactory` to allow for return
          of either MYBATIS or jdbc dao types.
    - Interface Segregation Principle
        - Methods enforced by interfaces are specific and focused while cohesive to the underlying
          package structure.
    - Dependency Inversion Principle
        - The high-level Service layer is loosely coupled to underlying DAO layer and allows for
          flexibility in switching database access. Additionally, Abstract classes like `IEntityDAO`
          and `IEntityService` are largely used as the underlying implementation which also
          encourages loose coupling and the ability to switch implementations.

## Iter-5

### Task

Requirements

- Add MyBatis DAOs to the existing hierarchy with the same requirements. Choose any XML or interface
  mapping.
    - MyBatis DAOs are located in `com/laba/dal/mybatisDAOs` and include all daos for the hierarchy.
    - XML mapping was used are located at `src/main/resources/mybatis/mappers`.
        - Mappers were generated using XML writer `MyBatisXmlMapperGenerator.java` and `DBMapper`
          both found in the directory `utils/mybatis/`.
- Switch service classes to MyBatis.
    - The service layer classes were modified to accept a DaoType enum parameter, allowing them to
      utilize either `DaoType.JDBC` or `DaoType.MYBATIS`. This enhancement enables the switching
      between different DAO implementations and each DAO implementation is associated with its
      respective DAO interface through type declarations.
        - DAOs for MyBatis are located in the directory `com/laba/dal/mybatisDAOs`.

## Iter-4

### Task

Requirements

- Create one Json file for at least 5 classes from the hierarchy.
    - `com/laba/utils/json/JacksonUtil.java` implements `dbMapToJson()` to create a Json file that
      represents all classes in the hospital db. In the `main` method, a demo is provided that
      generates a json representation of a patient with medical records which is exported to the
      export folder.
- Add Jackson’s annotation to the hierarchy. Date, List, and complex objects should be covered.
    - Jackson annotations are included for each model in the `models`
      package. `utils/json/DateAdapterJSON.java` adapts `java.sql.Date`
      and `utils/json/TimeAdapterJSON.java` adapts `java.sql.time` types for Jackson
      annotations. `Patient` has a field for a list of complex object `MedicalRecord`s and is
      annotated.
- Parse JSON using Jackson.
    - `com/laba/utils/json/JacksonUtil.java` implements `fromJsonString()` which deserializes a Json
      string into an object. This method is tested in  `testFromJsonString()` in the associated test
      class.

## Iter-3

### Task

Requirements

- Add JAXB annotations to the hierarchy. Date, List, and complex objects should be covered.
    - JAXB annotations are included for each model in the `models`
      package. `utils/xml/jaxb/DateAdapter.java` adapts `java.sql.Date`
      and `utils/xml/jaxb/TimeAdapter.java` adapts `java.sql.time` types for JAXB annotations.
- Parse XML using JAXB.
    - `utils/xml/jaxb/JAXBUtil.java` implements `unmarshallOne(File file, Class<?> clazz)` to parse
      thru an XML file and return appropriate objects. This is demonstrated in `Main`
      with `marshallOneXmlOut()` and associated test
      class `src/test/.../utils/xml/jaxb/JAXBUtilTest.java`.

## Iter-2

### Task

Requirements

- Create one XML file and XSD schema for at least 5 classes from the below hierarchy.
    - XML and XSD Schema were created for all current classes from the hierarchy and are located
      within `src/main/resources/XML/`
- Validate XML file using XSD schema and assigned parser.
    - `/utils/XMLValidator.java` contains static method `isValidXML(File, File)` that returns true
      if the xml file is validated against the xsd file. This operation is performed in `Main` and
      in `src/test/.../utils/XMLValidatorTest.java`
- Parse XML file using one of the parsers from the title.
    - `/utils/XMLParser.java` contains static method `domParserToLogger(File)` that logs all
      element's names and values contained in the given xml file
      while `domParserByElementToLogger(File, String)` logs all element's name and values given an
      element name. Both operations are tested in `Main` if the xsd file is validated against the
      schema.

## Iter-1

### Task

Requirements

- Build hierarchy for Schema from the below course.
    - The project follows a JDBC architecture that includes a JDBC Data Access Layer (DAL) with
      associated Data Access Objects (DAOs) representing the following schema diagram below.
    - ![HospitalDbDiagram](media/HospitalDbDiagram.png)
- Create DAO classes with necessary interfaces, abstract classes, and Generics. DAO should be
  scalable and flexible to support another framework and another database as well. All CRUD
  operations should be supported using JDBC. Use connection pool from the below block.
    - All DAOs extend from generalized and abstracted `EntityDAO` that implements the `IEntityDAO`
      interface. This interface enforces CRUD operations and is supported by all DAOs that extend
      from the `EntityDAO` object.
    - `utils/ConnectionPool` implements a connection pool that manages connections obtained from the
      JDBC Data Access Layer.
    - Each connection in the DAL is implemented as a transaction that will rollback if an exception
      is encountered, otherwise the transaction is committed and the connection is closed.
- Implement Service layer with necessary abstraction to be able to switch between databases and
  frameworks.
    - A Service Layer is implemented that indirectly access each DAO in the DAL through
      the `DAOFactory` using the `getJDBCDAO` method to allow for access to JDBC DAO
      implementations. Abstraction and the ability to switch between databases and frameworks can be
      further realized by implementing different get methods specified by the desired database or
      framework.