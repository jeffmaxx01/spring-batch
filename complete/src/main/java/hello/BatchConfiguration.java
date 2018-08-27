package hello;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
    private Environment env;


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    
   
    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }
    
    @Bean   
    public DataSource dataSource() {
    	
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
   	System.out.println("teste*************************" +env.getProperty("spring.datasource.url"));
		dataSource.setUrl("jdbc:hsqldb:hsql://localhost:9001/treinamento-batch");
		dataSource.setUsername("SA");
		dataSource.setPassword("");
		return dataSource;
    	
		//return null;
   
    	
    	
    }

  
    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JdbcCursorItemReader<Person> reader, JdbcBatchItemWriter<Person> writer) {
        return stepBuilderFactory.get("step1")
            .<Person, Person> chunk(10)
            .reader(reader)
            .processor(processor())
            .writer(writer)
            .build();
    }
    // end::jobstep[]
}
