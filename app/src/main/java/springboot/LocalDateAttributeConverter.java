package springboot;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Converts LocalDate to String and vice versa for database storage.
 * 
 * This is necessary because I can't get JDBC to parse LocalDate correctly
 * from the "yyyy-MM-dd" format in the database.
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, String> 
{
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String convertToDatabaseColumn(LocalDate date) {
        return (date != null ? date.format(FORMATTER) : null);
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        return (dbData != null ? LocalDate.parse(dbData, FORMATTER) : null);
    }
}

