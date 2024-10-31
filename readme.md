# Finally got Springboot working with SQLite!

## Handling `LocalDate` in SQLite
`LocalDateAttributeConverter` - JPA Attribute Converter for parsing `LocalDate` from `String` stored as yyyy-MM-dd in SQLite database.

## Still get exceptions on startup
Not sure why this happens, and it does not seem to cause problems. The `DataSourceConfig` theoretically should get rid of this, but it does not help.

## `@Column` annotation does not work
The only way not to convert column names to snake_case is to set

`spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl` 

in `application.properties`. I could not get `@Column` to work for telling one column to use a specific name. This is because my database says `ratingDate` rather than `rating_date`. The other option would be to change the database, but I wanted to show how to work with an existing database without changing it.

## Still not sure about application.properties
Right now we use `org.hibernate.community.dialect.SQLiteDialect` but GPT Sensei seemed to think that `org.hibernate.dialect.SQLiteDialect` was also an option and could be made to work. I think the long-term solution is to switch everything to H2, but I wanted to show how to work with SQLite since that is what we use in the Datbases course.