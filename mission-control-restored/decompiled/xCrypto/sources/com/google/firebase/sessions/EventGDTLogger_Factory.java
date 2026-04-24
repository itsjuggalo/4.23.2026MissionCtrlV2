package com.google.firebase.sessions;

import X0.j;
import com.google.firebase.inject.Provider;
import com.google.firebase.sessions.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class EventGDTLogger_Factory implements Factory<EventGDTLogger> {
    private final V2.a transportFactoryProvider;

    public EventGDTLogger_Factory(V2.a aVar) {
        this.transportFactoryProvider = aVar;
    }

    public static EventGDTLogger_Factory create(V2.a aVar) {
        return new EventGDTLogger_Factory(aVar);
    }

    public static EventGDTLogger newInstance(Provider<j> provider) {
        return new EventGDTLogger(provider);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public EventGDTLogger get() {
        return newInstance((Provider) this.transportFactoryProvider.get());
    }
}
