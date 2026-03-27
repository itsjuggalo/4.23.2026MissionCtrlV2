package com.google.firebase.sessions;

import X0.j;
import X2.AbstractC0769p;
import Z2.i;
import android.content.Context;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import i3.k;
import i3.q;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;
import l3.InterfaceC1591a;
import t3.I;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String LIBRARY_NAME = "fire-sessions";

    @Deprecated
    public static final String TAG = "FirebaseSessions";
    private static final Qualified<Context> appContext;
    private static final Qualified<I> backgroundDispatcher;
    private static final Qualified<I> blockingDispatcher;
    private static final Qualified<FirebaseApp> firebaseApp;
    private static final Qualified<FirebaseInstallationsApi> firebaseInstallationsApi;
    private static final Qualified<FirebaseSessionsComponent> firebaseSessionsComponent;
    private static final Qualified<j> transportFactory;

    public static final class Companion {

        /* JADX INFO: renamed from: com.google.firebase.sessions.FirebaseSessionsRegistrar$Companion$1, reason: invalid class name */
        public /* synthetic */ class AnonymousClass1 extends o implements q {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(4, U.a.class, "preferencesDataStore", "preferencesDataStore(Ljava/lang/String;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/properties/ReadOnlyProperty;", 1);
            }

            public final InterfaceC1591a invoke(String p02, T.b bVar, k p22, L p32) {
                r.f(p02, "p0");
                r.f(p22, "p2");
                r.f(p32, "p3");
                return U.a.a(p02, bVar, p22, p32);
            }
        }

        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final Qualified<Context> getAppContext() {
            return FirebaseSessionsRegistrar.appContext;
        }

        public final Qualified<I> getBackgroundDispatcher() {
            return FirebaseSessionsRegistrar.backgroundDispatcher;
        }

        public final Qualified<I> getBlockingDispatcher() {
            return FirebaseSessionsRegistrar.blockingDispatcher;
        }

        public final Qualified<FirebaseApp> getFirebaseApp() {
            return FirebaseSessionsRegistrar.firebaseApp;
        }

        public final Qualified<FirebaseInstallationsApi> getFirebaseInstallationsApi() {
            return FirebaseSessionsRegistrar.firebaseInstallationsApi;
        }

        public final Qualified<FirebaseSessionsComponent> getFirebaseSessionsComponent() {
            return FirebaseSessionsRegistrar.firebaseSessionsComponent;
        }

        public final Qualified<j> getTransportFactory() {
            return FirebaseSessionsRegistrar.transportFactory;
        }

        private Companion() {
        }
    }

    static {
        Qualified<Context> qualifiedUnqualified = Qualified.unqualified(Context.class);
        r.e(qualifiedUnqualified, "unqualified(Context::class.java)");
        appContext = qualifiedUnqualified;
        Qualified<FirebaseApp> qualifiedUnqualified2 = Qualified.unqualified(FirebaseApp.class);
        r.e(qualifiedUnqualified2, "unqualified(FirebaseApp::class.java)");
        firebaseApp = qualifiedUnqualified2;
        Qualified<FirebaseInstallationsApi> qualifiedUnqualified3 = Qualified.unqualified(FirebaseInstallationsApi.class);
        r.e(qualifiedUnqualified3, "unqualified(FirebaseInstallationsApi::class.java)");
        firebaseInstallationsApi = qualifiedUnqualified3;
        Qualified<I> qualified = Qualified.qualified(Background.class, I.class);
        r.e(qualified, "qualified(Background::cl…neDispatcher::class.java)");
        backgroundDispatcher = qualified;
        Qualified<I> qualified2 = Qualified.qualified(Blocking.class, I.class);
        r.e(qualified2, "qualified(Blocking::clas…neDispatcher::class.java)");
        blockingDispatcher = qualified2;
        Qualified<j> qualifiedUnqualified4 = Qualified.unqualified(j.class);
        r.e(qualifiedUnqualified4, "unqualified(TransportFactory::class.java)");
        transportFactory = qualifiedUnqualified4;
        Qualified<FirebaseSessionsComponent> qualifiedUnqualified5 = Qualified.unqualified(FirebaseSessionsComponent.class);
        r.e(qualifiedUnqualified5, "unqualified(FirebaseSessionsComponent::class.java)");
        firebaseSessionsComponent = qualifiedUnqualified5;
        try {
            Companion.AnonymousClass1.INSTANCE.getClass();
        } catch (NoClassDefFoundError unused) {
            Log.w(TAG, "Your app is experiencing a known issue in the Android Gradle plugin, see https://issuetracker.google.com/328687152\n\nIt affects Java-only apps using AGP version 8.3.2 and under. To avoid the issue, either:\n\n1. Upgrade Android Gradle plugin to 8.4.0+\n   Follow the guide at https://developer.android.com/build/agp-upgrade-assistant\n\n2. Or, add the Kotlin plugin to your app\n   Follow the guide at https://developer.android.com/kotlin/add-kotlin\n\n3. Or, do the technical workaround described in https://issuetracker.google.com/issues/328687152#comment3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseSessions getComponents$lambda$0(ComponentContainer componentContainer) {
        return ((FirebaseSessionsComponent) componentContainer.get(firebaseSessionsComponent)).getFirebaseSessions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseSessionsComponent getComponents$lambda$1(ComponentContainer componentContainer) {
        FirebaseSessionsComponent.Builder builder = DaggerFirebaseSessionsComponent.builder();
        Object obj = componentContainer.get(appContext);
        r.e(obj, "container[appContext]");
        FirebaseSessionsComponent.Builder builderAppContext = builder.appContext((Context) obj);
        Object obj2 = componentContainer.get(backgroundDispatcher);
        r.e(obj2, "container[backgroundDispatcher]");
        FirebaseSessionsComponent.Builder builderBackgroundDispatcher = builderAppContext.backgroundDispatcher((i) obj2);
        Object obj3 = componentContainer.get(blockingDispatcher);
        r.e(obj3, "container[blockingDispatcher]");
        FirebaseSessionsComponent.Builder builderBlockingDispatcher = builderBackgroundDispatcher.blockingDispatcher((i) obj3);
        Object obj4 = componentContainer.get(firebaseApp);
        r.e(obj4, "container[firebaseApp]");
        FirebaseSessionsComponent.Builder builderFirebaseApp = builderBlockingDispatcher.firebaseApp((FirebaseApp) obj4);
        Object obj5 = componentContainer.get(firebaseInstallationsApi);
        r.e(obj5, "container[firebaseInstallationsApi]");
        FirebaseSessionsComponent.Builder builderFirebaseInstallationsApi = builderFirebaseApp.firebaseInstallationsApi((FirebaseInstallationsApi) obj5);
        Provider<j> provider = componentContainer.getProvider(transportFactory);
        r.e(provider, "container.getProvider(transportFactory)");
        return builderFirebaseInstallationsApi.transportFactoryProvider(provider).build();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<? extends Object>> getComponents() {
        return AbstractC0769p.j(Component.builder(FirebaseSessions.class).name(LIBRARY_NAME).add(Dependency.required(firebaseSessionsComponent)).factory(new ComponentFactory() { // from class: com.google.firebase.sessions.c
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return FirebaseSessionsRegistrar.getComponents$lambda$0(componentContainer);
            }
        }).eagerInDefaultApp().build(), Component.builder(FirebaseSessionsComponent.class).name("fire-sessions-component").add(Dependency.required(appContext)).add(Dependency.required(backgroundDispatcher)).add(Dependency.required(blockingDispatcher)).add(Dependency.required(firebaseApp)).add(Dependency.required(firebaseInstallationsApi)).add(Dependency.requiredProvider(transportFactory)).factory(new ComponentFactory() { // from class: com.google.firebase.sessions.d
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return FirebaseSessionsRegistrar.getComponents$lambda$1(componentContainer);
            }
        }).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
