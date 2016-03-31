package br.com.velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class GerarClasse {

	
	public static void main(String[] args) {
		/*  first, get and initialize an engine  */
	    VelocityEngine ve = new VelocityEngine();
	    
	    ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	    
	    ve.init();
	    
	    /*  organize our data  */
	    List<Map> list = new ArrayList<Map>();
	    Map<String,String> map = new HashMap();
	    map.put("type", "String");
	    map.put("name", "nome");
	    map.put("nameCaptalized", "Nome");
	    list.add( map );
	    
	    map = new HashMap();
	    map.put("type", "int");
	    map.put("name", "idade");
	    map.put("nameCaptalized", "Idade");
	    list.add( map );
	    
	    /*  add that list to a VelocityContext  */
	    VelocityContext context = new VelocityContext();
	    context.put("attrList", list);
	    context.put("name", "ClasseVelocity");
	    /*  get the Template  */
	    Template t = ve.getTemplate( "templates/classe.vm" );
	    /*  now render the template into a Writer  */
	    StringWriter writer = new StringWriter();
	    t.merge( context, writer );
	    /* use the output in your email body */
	    
	    System.out.println( writer.toString());
	}
}
