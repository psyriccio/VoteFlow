/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psyriccio.voteflow.api.jaxb;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.eclipse.persistence.jaxb.JAXBContext;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import psyriccio.voteflow.Main;

/**
 *
 * @author psyriccio
 */
public class JAXBContextDescriptor {

    final private JAXBContext context;
    final private Unmarshaller unmarshaller;
    final private Marshaller marshaller;

    public JAXBContextDescriptor(String pkg) {
        Reflections reflections = new Reflections(
                ConfigurationBuilder.build()
                .addUrls(ClasspathHelper.forPackage(pkg))
                .forPackages(pkg)
                .filterInputsBy((str) -> str.startsWith(pkg + "."))
        );
        Set<Class<? extends BaseObj>> jaxbClasses = reflections.getSubTypesOf(BaseObj.class);
        Class[] classes = jaxbClasses.stream()
                .filter((clz) -> clz.getName().endsWith("Impl"))
                .collect(Collectors.toList())
                .toArray(new Class[1]);

        String classesStr = "";
        for (Class cl : classes) {
            classesStr += classesStr.isEmpty() ? cl.getName() : ", " + cl.getName();
        }
        Main.log.info("Creating JAXB-context {} for classes: {}", pkg, classesStr);

        try {
            this.context = (JAXBContext) JAXBContextFactory.createContext(classes, new HashMap());
            this.unmarshaller = this.context.createUnmarshaller();
            this.marshaller = this.context.createMarshaller();
        } catch (JAXBException ex) {
            Main.log.error("Exception: {}", ex);
            throw new RuntimeException(ex);
        }
    }

    public String marshall(Object obj) {
        StringWriter str = new StringWriter();
        try {
            marshaller.marshal(obj, str);
        } catch (JAXBException ex) {
            Main.log.error("Exception: {}", ex);
        }
        return str.toString();
    }

    public Object unmarshall(String str) {
        try {
            return unmarshaller.unmarshal(new StringReader(str));
        } catch (JAXBException ex) {
            Main.log.error("Exception: {}", ex);
        }
        return null;
    }

}
