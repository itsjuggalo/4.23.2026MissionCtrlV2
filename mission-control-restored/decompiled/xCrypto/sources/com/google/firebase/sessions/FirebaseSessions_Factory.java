package com.google.firebase.sessions;

import Z2.i;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.settings.SessionsSettings;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseSessions_Factory implements Factory<FirebaseSessions> {
    private final V2.a backgroundDispatcherProvider;
    private final V2.a firebaseAppProvider;
    private final V2.a lifecycleServiceBinderProvider;
    private final V2.a settingsProvider;

    public FirebaseSessions_Factory(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4) {
        this.firebaseAppProvider = aVar;
        this.settingsProvider = aVar2;
        this.backgroundDispatcherProvider = aVar3;
        this.lifecycleServiceBinderProvider = aVar4;
    }

    public static FirebaseSessions_Factory create(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4) {
        return new FirebaseSessions_Factory(aVar, aVar2, aVar3, aVar4);
    }

    public static FirebaseSessions newInstance(FirebaseApp firebaseApp, SessionsSettings sessionsSettings, i iVar, SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        return new FirebaseSessions(firebaseApp, sessionsSettings, iVar, sessionLifecycleServiceBinder);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public FirebaseSessions get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (SessionsSettings) this.settingsProvider.get(), (i) this.backgroundDispatcherProvider.get(), (SessionLifecycleServiceBinder) this.lifecycleServiceBinderProvider.get());
    }
}
