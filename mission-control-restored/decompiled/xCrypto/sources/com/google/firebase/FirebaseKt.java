package com.google.firebase;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;
import t3.AbstractC1831o0;
import t3.I;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseKt {
    public static final FirebaseApp app(Firebase firebase, String name) {
        r.f(firebase, "<this>");
        r.f(name, "name");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(name);
        r.e(firebaseApp, "getInstance(name)");
        return firebaseApp;
    }

    private static final /* synthetic */ <T extends Annotation> Component<I> coroutineDispatcher() {
        r.k(4, "T");
        Component.Builder builder = Component.builder(Qualified.qualified(Annotation.class, I.class));
        r.k(4, "T");
        Component.Builder builderAdd = builder.add(Dependency.required((Qualified<?>) Qualified.qualified(Annotation.class, Executor.class)));
        r.j();
        Component<I> componentBuild = builderAdd.factory(new ComponentFactory() { // from class: com.google.firebase.FirebaseKt.coroutineDispatcher.1
            @Override // com.google.firebase.components.ComponentFactory
            public final I create(ComponentContainer componentContainer) {
                r.k(4, "T");
                Object obj = componentContainer.get(Qualified.qualified(Annotation.class, Executor.class));
                r.e(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return AbstractC1831o0.a((Executor) obj);
            }
        }).build();
        r.e(componentBuild, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return componentBuild;
    }

    public static final FirebaseApp getApp(Firebase firebase) {
        r.f(firebase, "<this>");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        r.e(firebaseApp, "getInstance()");
        return firebaseApp;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        r.f(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        r.e(options, "Firebase.app.options");
        return options;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        r.f(firebase, "<this>");
        r.f(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options) {
        r.f(firebase, "<this>");
        r.f(context, "context");
        r.f(options, "options");
        FirebaseApp firebaseAppInitializeApp = FirebaseApp.initializeApp(context, options);
        r.e(firebaseAppInitializeApp, "initializeApp(context, options)");
        return firebaseAppInitializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options, String name) {
        r.f(firebase, "<this>");
        r.f(context, "context");
        r.f(options, "options");
        r.f(name, "name");
        FirebaseApp firebaseAppInitializeApp = FirebaseApp.initializeApp(context, options, name);
        r.e(firebaseAppInitializeApp, "initializeApp(context, options, name)");
        return firebaseAppInitializeApp;
    }
}
