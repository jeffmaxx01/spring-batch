package hello.step;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import hello.Person;

@Component
public class StepReader {
	
	
	@Bean
	public JdbcCursorItemReader<Person> leitura(DataSource dataSource) {
    	System.out.println("reader2");
        return new JdbcCursorItemReaderBuilder<Person>()
            .name("personItemReader")
            .dataSource(dataSource)
            .saveState(false)
            .sql("select * from people")
            .rowMapper(new BeanPropertyRowMapper<Person>(Person.class)) 
            .build();
    }
	

}
