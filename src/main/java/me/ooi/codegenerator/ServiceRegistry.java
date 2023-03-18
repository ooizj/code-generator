package me.ooi.codegenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author jun.zhao
 */
public class ServiceRegistry {

    public static final ServiceRegistry INSTANCE = new ServiceRegistry();


    private NameConverter nameConverter;

    private List<TypeResolver> typeResolvers;
    private List<ContextWriter> contextWriters;


    public ServiceRegistry() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        nameConverter = getService(NameConverter.class, cl);

        typeResolvers = new ArrayList<>();
        Iterable<TypeResolver> typeResolversIt = ServiceLoader.load(TypeResolver.class, cl);
        for (TypeResolver interceptor : typeResolversIt) {
            typeResolvers.add(interceptor);
        }

        contextWriters = new ArrayList<>();
        Iterable<ContextWriter> contextWritersIt = ServiceLoader.load(ContextWriter.class, cl);
        for (ContextWriter interceptor : contextWritersIt) {
            contextWriters.add(interceptor);
        }

    }


    public NameConverter getNameConverter() {
        return nameConverter;
    }

    public List<TypeResolver> getTypeResolvers() {
        return typeResolvers;
    }

    public List<ContextWriter> getContextWriters() {
        return contextWriters;
    }

    private <S> S getService(Class<S> clazz, ClassLoader cl) {
        ServiceLoader<S> sl = ServiceLoader.load(clazz, cl);
        Iterator<S> it = sl.iterator();
        if( it.hasNext() ) {
            return it.next();
        }else {
            return null;
        }
    }
}
