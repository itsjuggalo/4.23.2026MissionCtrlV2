package com.google.firebase.sessions;

import Z2.i;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.settings.SessionsSettings;

/* JADX INFO: loaded from: classes.dex */
public final class SessionFirelogPublisherImpl_Factory implements Factory<SessionFirelogPublisherImpl> {
    private final V2.a backgroundDispatcherProvider;
    private final V2.a eventGDTLoggerProvider;
    private final V2.a firebaseAppProvider;
    private final V2.a firebaseInstallationsProvider;
    private final V2.a sessionSettingsProvider;

    public SessionFirelogPublisherImpl_Factory(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5) {
        this.firebaseAppProvider = aVar;
        this.firebaseInstallationsProvider = aVar2;
        this.sessionSettingsProvider = aVar3;
        this.eventGDTLoggerProvider = aVar4;
        this.backgroundDispatcherProvider = aVar5;
    }

    public static SessionFirelogPublisherImpl_Factory create(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5) {
        return new SessionFirelogPublisherImpl_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static SessionFirelogPublisherImpl newInstance(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, SessionsSettings sessionsSettings, EventGDTLoggerInterface eventGDTLoggerInterface, i iVar) {
        return new SessionFirelogPublisherImpl(firebaseApp, firebaseInstallationsApi, sessionsSettings, eventGDTLoggerInterface, iVar);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public SessionFirelogPublisherImpl get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsProvider.get(), (SessionsSettings) this.sessionSettingsProvider.get(), (EventGDTLoggerInterface) this.eventGDTLoggerProvider.get(), (i) this.backgroundDispatcherProvider.get());
    }
}
