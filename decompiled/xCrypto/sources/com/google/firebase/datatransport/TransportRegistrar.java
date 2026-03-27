package com.google.firebase.datatransport;

import X0.j;
import Y0.a;
import a1.u;
import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    public static /* synthetic */ j a(ComponentContainer componentContainer) {
        u.f((Context) componentContainer.get(Context.class));
        return u.c().g(a.f5654g);
    }

    public static /* synthetic */ j b(ComponentContainer componentContainer) {
        u.f((Context) componentContainer.get(Context.class));
        return u.c().g(a.f5655h);
    }

    public static /* synthetic */ j c(ComponentContainer componentContainer) {
        u.f((Context) componentContainer.get(Context.class));
        return u.c().g(a.f5655h);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(j.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: l2.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return TransportRegistrar.c(componentContainer);
            }
        }).build(), Component.builder(Qualified.qualified(LegacyTransportBackend.class, j.class)).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: l2.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return TransportRegistrar.b(componentContainer);
            }
        }).build(), Component.builder(Qualified.qualified(TransportBackend.class, j.class)).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: l2.c
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return TransportRegistrar.a(componentContainer);
            }
        }).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
