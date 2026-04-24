package com.google.firebase;

import X2.AbstractC0769p;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;
import t3.AbstractC1831o0;
import t3.I;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        Component componentBuild = Component.builder(Qualified.qualified(Background.class, I.class)).add(Dependency.required((Qualified<?>) Qualified.qualified(Background.class, Executor.class))).factory(new ComponentFactory() { // from class: com.google.firebase.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1
            @Override // com.google.firebase.components.ComponentFactory
            public final I create(ComponentContainer componentContainer) {
                Object obj = componentContainer.get(Qualified.qualified(Background.class, Executor.class));
                r.e(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return AbstractC1831o0.a((Executor) obj);
            }
        }).build();
        r.e(componentBuild, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Component componentBuild2 = Component.builder(Qualified.qualified(Lightweight.class, I.class)).add(Dependency.required((Qualified<?>) Qualified.qualified(Lightweight.class, Executor.class))).factory(new ComponentFactory() { // from class: com.google.firebase.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$2
            @Override // com.google.firebase.components.ComponentFactory
            public final I create(ComponentContainer componentContainer) {
                Object obj = componentContainer.get(Qualified.qualified(Lightweight.class, Executor.class));
                r.e(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return AbstractC1831o0.a((Executor) obj);
            }
        }).build();
        r.e(componentBuild2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Component componentBuild3 = Component.builder(Qualified.qualified(Blocking.class, I.class)).add(Dependency.required((Qualified<?>) Qualified.qualified(Blocking.class, Executor.class))).factory(new ComponentFactory() { // from class: com.google.firebase.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3
            @Override // com.google.firebase.components.ComponentFactory
            public final I create(ComponentContainer componentContainer) {
                Object obj = componentContainer.get(Qualified.qualified(Blocking.class, Executor.class));
                r.e(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return AbstractC1831o0.a((Executor) obj);
            }
        }).build();
        r.e(componentBuild3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Component componentBuild4 = Component.builder(Qualified.qualified(UiThread.class, I.class)).add(Dependency.required((Qualified<?>) Qualified.qualified(UiThread.class, Executor.class))).factory(new ComponentFactory() { // from class: com.google.firebase.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$4
            @Override // com.google.firebase.components.ComponentFactory
            public final I create(ComponentContainer componentContainer) {
                Object obj = componentContainer.get(Qualified.qualified(UiThread.class, Executor.class));
                r.e(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return AbstractC1831o0.a((Executor) obj);
            }
        }).build();
        r.e(componentBuild4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return AbstractC0769p.j(componentBuild, componentBuild2, componentBuild3, componentBuild4);
    }
}
