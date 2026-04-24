package com.google.firebase.appcheck.debug;

import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.appcheck.debug.FirebaseAppCheckDebugRegistrar;
import com.google.firebase.appcheck.debug.internal.DebugAppCheckProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseAppCheckDebugRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-app-check-debug";

    public static /* synthetic */ DebugAppCheckProvider a(Qualified qualified, Qualified qualified2, Qualified qualified3, ComponentContainer componentContainer) {
        return new DebugAppCheckProvider((FirebaseApp) componentContainer.get(FirebaseApp.class), (Provider<InternalDebugSecretProvider>) componentContainer.getProvider(InternalDebugSecretProvider.class), (Executor) componentContainer.get(qualified), (Executor) componentContainer.get(qualified2), (Executor) componentContainer.get(qualified3));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        final Qualified qualified = Qualified.qualified(Lightweight.class, Executor.class);
        final Qualified qualified2 = Qualified.qualified(Background.class, Executor.class);
        final Qualified qualified3 = Qualified.qualified(Blocking.class, Executor.class);
        return Arrays.asList(Component.builder(DebugAppCheckProvider.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.optionalProvider((Class<?>) InternalDebugSecretProvider.class)).add(Dependency.required((Qualified<?>) qualified)).add(Dependency.required((Qualified<?>) qualified2)).add(Dependency.required((Qualified<?>) qualified3)).factory(new ComponentFactory() { // from class: j2.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return FirebaseAppCheckDebugRegistrar.a(qualified, qualified2, qualified3, componentContainer);
            }
        }).build(), LibraryVersionComponent.create(LIBRARY_NAME, "18.0.0"));
    }
}
