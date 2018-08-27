package hello.step;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import hello.Person;

@Component
public class StepWriter {
	
	@Bean
	 public JdbcBatchItemWriter<Person> gravacao(DataSource dataSource) {
	    	System.out.println("writer******2");
	        return new JdbcBatchItemWriterBuilder<Person>()
	            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	            .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
	            .dataSource(dataSource)
	            .build();
	    }

}
