package com.google.firebase.sessions;

import X0.j;
import Z2.i;
import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DoubleCheck;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.settings.LocalOverrideSettings_Factory;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher_Factory;
import com.google.firebase.sessions.settings.RemoteSettings_Factory;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.google.firebase.sessions.settings.SessionsSettings_Factory;
import com.google.firebase.sessions.settings.SettingsCache_Factory;

/* JADX INFO: loaded from: classes.dex */
public final class DaggerFirebaseSessionsComponent {

    public static final class Builder implements FirebaseSessionsComponent.Builder {
        private Context appContext;
        private i backgroundDispatcher;
        private i blockingDispatcher;
        private FirebaseApp firebaseApp;
        private FirebaseInstallationsApi firebaseInstallationsApi;
        private Provider<j> transportFactoryProvider;

        private Builder() {
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public FirebaseSessionsComponent build() {
            Preconditions.checkBuilderRequirement(this.appContext, Context.class);
            Preconditions.checkBuilderRequirement(this.backgroundDispatcher, i.class);
            Preconditions.checkBuilderRequirement(this.blockingDispatcher, i.class);
            Preconditions.checkBuilderRequirement(this.firebaseApp, FirebaseApp.class);
            Preconditions.checkBuilderRequirement(this.firebaseInstallationsApi, FirebaseInstallationsApi.class);
            Preconditions.checkBuilderRequirement(this.transportFactoryProvider, Provider.class);
            return new FirebaseSessionsComponentImpl(this.appContext, this.backgroundDispatcher, this.blockingDispatcher, this.firebaseApp, this.firebaseInstallationsApi, this.transportFactoryProvider);
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public /* bridge */ /* synthetic */ FirebaseSessionsComponent.Builder transportFactoryProvider(Provider provider) {
            return transportFactoryProvider((Provider<j>) provider);
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder appContext(Context context) {
            this.appContext = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder backgroundDispatcher(i iVar) {
            this.backgroundDispatcher = (i) Preconditions.checkNotNull(iVar);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder blockingDispatcher(i iVar) {
            this.blockingDispatcher = (i) Preconditions.checkNotNull(iVar);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder firebaseApp(FirebaseApp firebaseApp) {
            this.firebaseApp = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder firebaseInstallationsApi(FirebaseInstallationsApi firebaseInstallationsApi) {
            this.firebaseInstallationsApi = (FirebaseInstallationsApi) Preconditions.checkNotNull(firebaseInstallationsApi);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder transportFactoryProvider(Provider<j> provider) {
            this.transportFactoryProvider = (Provider) Preconditions.checkNotNull(provider);
            return this;
        }
    }

    public static final class FirebaseSessionsComponentImpl implements FirebaseSessionsComponent {
        private V2.a appContextProvider;
        private V2.a applicationInfoProvider;
        private V2.a backgroundDispatcherProvider;
        private V2.a eventGDTLoggerProvider;
        private V2.a firebaseAppProvider;
        private V2.a firebaseInstallationsApiProvider;
        private final FirebaseSessionsComponentImpl firebaseSessionsComponentImpl;
        private V2.a firebaseSessionsProvider;
        private V2.a localOverrideSettingsProvider;
        private V2.a remoteSettingsFetcherProvider;
        private V2.a remoteSettingsProvider;
        private V2.a sessionConfigsDataStoreProvider;
        private V2.a sessionDatastoreImplProvider;
        private V2.a sessionDetailsDataStoreProvider;
        private V2.a sessionFirelogPublisherImplProvider;
        private V2.a sessionGeneratorProvider;
        private V2.a sessionLifecycleServiceBinderImplProvider;
        private V2.a sessionsSettingsProvider;
        private V2.a settingsCacheProvider;
        private V2.a timeProvider;
        private V2.a transportFactoryProvider;
        private V2.a uuidGeneratorProvider;

        private void initialize(Context context, i iVar, i iVar2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<j> provider) {
            this.firebaseAppProvider = InstanceFactory.create(firebaseApp);
            Factory factoryCreate = InstanceFactory.create(context);
            this.appContextProvider = factoryCreate;
            this.localOverrideSettingsProvider = DoubleCheck.provider(LocalOverrideSettings_Factory.create(factoryCreate));
            this.backgroundDispatcherProvider = InstanceFactory.create(iVar);
            this.firebaseInstallationsApiProvider = InstanceFactory.create(firebaseInstallationsApi);
            V2.a aVarProvider = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory.create(this.firebaseAppProvider));
            this.applicationInfoProvider = aVarProvider;
            this.remoteSettingsFetcherProvider = DoubleCheck.provider(RemoteSettingsFetcher_Factory.create(aVarProvider, this.backgroundDispatcherProvider));
            V2.a aVarProvider2 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory.create(this.appContextProvider));
            this.sessionConfigsDataStoreProvider = aVarProvider2;
            V2.a aVarProvider3 = DoubleCheck.provider(SettingsCache_Factory.create(aVarProvider2));
            this.settingsCacheProvider = aVarProvider3;
            V2.a aVarProvider4 = DoubleCheck.provider(RemoteSettings_Factory.create(this.backgroundDispatcherProvider, this.firebaseInstallationsApiProvider, this.applicationInfoProvider, this.remoteSettingsFetcherProvider, aVarProvider3));
            this.remoteSettingsProvider = aVarProvider4;
            this.sessionsSettingsProvider = DoubleCheck.provider(SessionsSettings_Factory.create(this.localOverrideSettingsProvider, aVarProvider4));
            V2.a aVarProvider5 = DoubleCheck.provider(SessionLifecycleServiceBinderImpl_Factory.create(this.appContextProvider));
            this.sessionLifecycleServiceBinderImplProvider = aVarProvider5;
            this.firebaseSessionsProvider = DoubleCheck.provider(FirebaseSessions_Factory.create(this.firebaseAppProvider, this.sessionsSettingsProvider, this.backgroundDispatcherProvider, aVarProvider5));
            V2.a aVarProvider6 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory.create(this.appContextProvider));
            this.sessionDetailsDataStoreProvider = aVarProvider6;
            this.sessionDatastoreImplProvider = DoubleCheck.provider(SessionDatastoreImpl_Factory.create(this.backgroundDispatcherProvider, aVarProvider6));
            Factory factoryCreate2 = InstanceFactory.create(provider);
            this.transportFactoryProvider = factoryCreate2;
            V2.a aVarProvider7 = DoubleCheck.provider(EventGDTLogger_Factory.create(factoryCreate2));
            this.eventGDTLoggerProvider = aVarProvider7;
            this.sessionFirelogPublisherImplProvider = DoubleCheck.provider(SessionFirelogPublisherImpl_Factory.create(this.firebaseAppProvider, this.firebaseInstallationsApiProvider, this.sessionsSettingsProvider, aVarProvider7, this.backgroundDispatcherProvider));
            this.timeProvider = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory.create());
            V2.a aVarProvider8 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory.create());
            this.uuidGeneratorProvider = aVarProvider8;
            this.sessionGeneratorProvider = DoubleCheck.provider(SessionGenerator_Factory.create(this.timeProvider, aVarProvider8));
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public FirebaseSessions getFirebaseSessions() {
            return (FirebaseSessions) this.firebaseSessionsProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionDatastore getSessionDatastore() {
            return (SessionDatastore) this.sessionDatastoreImplProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionFirelogPublisher getSessionFirelogPublisher() {
            return (SessionFirelogPublisher) this.sessionFirelogPublisherImplProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionGenerator getSessionGenerator() {
            return (SessionGenerator) this.sessionGeneratorProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionsSettings getSessionsSettings() {
            return (SessionsSettings) this.sessionsSettingsProvider.get();
        }

        private FirebaseSessionsComponentImpl(Context context, i iVar, i iVar2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<j> provider) {
            this.firebaseSessionsComponentImpl = this;
            initialize(context, iVar, iVar2, firebaseApp, firebaseInstallationsApi, provider);
        }
    }

    private DaggerFirebaseSessionsComponent() {
    }

    public static FirebaseSessionsComponent.Builder builder() {
        return new Builder();
    }
}
