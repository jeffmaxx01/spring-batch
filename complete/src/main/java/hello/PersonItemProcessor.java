package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

  
    @Override
    public Person process(final Person person) throws Exception {
    	System.out.println("processor******* ");
        System.out.println("teste commit github3 ");
        System.out.println("teste commit github4 ");
        System.out.println("teste commit github5 ");
         System.out.println("teste commit github6 ");
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();
        System.out.println("teste commit eclipse2  ");
        System.out.println("teste commit eclipse3  ");
        System.out.println("teste commit eclipse4  ");
        System.out.println("teste commit eclipse5  ");

        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + "   )");

        return transformedPerson;
    }

}
