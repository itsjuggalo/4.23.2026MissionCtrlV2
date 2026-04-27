package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class SessionGenerator_Factory implements Factory<SessionGenerator> {
    private final V2.a timeProvider;
    private final V2.a uuidGeneratorProvider;

    public SessionGenerator_Factory(V2.a aVar, V2.a aVar2) {
        this.timeProvider = aVar;
        this.uuidGeneratorProvider = aVar2;
    }

    public static SessionGenerator_Factory create(V2.a aVar, V2.a aVar2) {
        return new SessionGenerator_Factory(aVar, aVar2);
    }

    public static SessionGenerator newInstance(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        return new SessionGenerator(timeProvider, uuidGenerator);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public SessionGenerator get() {
        return newInstance((TimeProvider) this.timeProvider.get(), (UuidGenerator) this.uuidGeneratorProvider.get());
    }
}
