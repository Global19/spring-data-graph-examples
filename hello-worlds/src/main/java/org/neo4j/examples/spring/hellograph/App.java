package org.neo4j.examples.spring.hellograph;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world(s)!
 * <p/>
 * An example application for exploring Spring Data Graph.
 */
public class App
{

    public static void main( String[] args )
    {
    	
        ConfigurableApplicationContext applicationContext =  
        	new ClassPathXmlApplicationContext( "/spring/helloWorldContext.xml");

        GraphBackedGalaxy galaxy = applicationContext.getBean(GraphBackedGalaxy.class);

        Iterable<World> worlds = galaxy.makeSomeWorlds();

        World homeWorld = worlds.iterator().next();
        System.out.println("At home on: " + homeWorld);

        World foundHomeWorld = galaxy.findWorldNamed( homeWorld.getName() );
        System.out.println( "found home world: " + foundHomeWorld );

        Iterable<World> worldsBeyond = galaxy.exploreWorldsBeyond( homeWorld );
        System.out.println( "found worlds beyond: " + worldsBeyond );

        applicationContext.close();
        
    }

}
