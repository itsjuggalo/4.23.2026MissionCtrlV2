package com.google.firebase.sessions;

import S.InterfaceC0523i;
import V.e;
import X0.j;
import Z2.i;
import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.Binds;
import com.google.firebase.sessions.dagger.BindsInstance;
import com.google.firebase.sessions.dagger.Component;
import com.google.firebase.sessions.dagger.Module;
import com.google.firebase.sessions.dagger.Provides;
import com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher;
import com.google.firebase.sessions.settings.LocalOverrideSettings;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.google.firebase.sessions.settings.SettingsProvider;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
@Component(modules = {MainModule.class})
public interface FirebaseSessionsComponent {

    @Component.Builder
    public interface Builder {
        @BindsInstance
        Builder appContext(Context context);

        @BindsInstance
        Builder backgroundDispatcher(@Background i iVar);

        @BindsInstance
        Builder blockingDispatcher(@Blocking i iVar);

        FirebaseSessionsComponent build();

        @BindsInstance
        Builder firebaseApp(FirebaseApp firebaseApp);

        @BindsInstance
        Builder firebaseInstallationsApi(FirebaseInstallationsApi firebaseInstallationsApi);

        @BindsInstance
        Builder transportFactoryProvider(Provider<j> provider);
    }

    @Module
    public interface MainModule {
        public static final Companion Companion = Companion.$$INSTANCE;

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final String TAG = "FirebaseSessions";

            private Companion() {
            }

            @Provides
            public final ApplicationInfo applicationInfo(FirebaseApp firebaseApp) {
                r.f(firebaseApp, "firebaseApp");
                return SessionEvents.INSTANCE.getApplicationInfo(firebaseApp);
            }

            @SessionConfigsDataStore
            @Provides
            public final InterfaceC0523i sessionConfigsDataStore(Context appContext) {
                r.f(appContext, "appContext");
                return e.c(e.f5282a, new T.b(FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1.INSTANCE), null, null, new FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$2(appContext), 6, null);
            }

            @SessionDetailsDataStore
            @Provides
            public final InterfaceC0523i sessionDetailsDataStore(Context appContext) {
                r.f(appContext, "appContext");
                return e.c(e.f5282a, new T.b(FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$1.INSTANCE), null, null, new FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$2(appContext), 6, null);
            }

            @Provides
            public final TimeProvider timeProvider() {
                return TimeProviderImpl.INSTANCE;
            }

            @Provides
            public final UuidGenerator uuidGenerator() {
                return UuidGeneratorImpl.INSTANCE;
            }
        }

        @Binds
        CrashlyticsSettingsFetcher crashlyticsSettingsFetcher(RemoteSettingsFetcher remoteSettingsFetcher);

        @Binds
        EventGDTLoggerInterface eventGDTLoggerInterface(EventGDTLogger eventGDTLogger);

        @Binds
        @LocalOverrideSettingsProvider
        SettingsProvider localOverrideSettings(LocalOverrideSettings localOverrideSettings);

        @RemoteSettingsProvider
        @Binds
        SettingsProvider remoteSettings(RemoteSettings remoteSettings);

        @Binds
        SessionDatastore sessionDatastore(SessionDatastoreImpl sessionDatastoreImpl);

        @Binds
        SessionFirelogPublisher sessionFirelogPublisher(SessionFirelogPublisherImpl sessionFirelogPublisherImpl);

        @Binds
        SessionLifecycleServiceBinder sessionLifecycleServiceBinder(SessionLifecycleServiceBinderImpl sessionLifecycleServiceBinderImpl);
    }

    FirebaseSessions getFirebaseSessions();

    SessionDatastore getSessionDatastore();

    SessionFirelogPublisher getSessionFirelogPublisher();

    SessionGenerator getSessionGenerator();

    SessionsSettings getSessionsSettings();
}
