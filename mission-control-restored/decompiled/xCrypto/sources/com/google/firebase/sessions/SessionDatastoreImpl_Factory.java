package com.google.firebase.sessions;

import S.InterfaceC0523i;
import Z2.i;
import com.google.firebase.sessions.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class SessionDatastoreImpl_Factory implements Factory<SessionDatastoreImpl> {
    private final V2.a backgroundDispatcherProvider;
    private final V2.a dataStoreProvider;

    public SessionDatastoreImpl_Factory(V2.a aVar, V2.a aVar2) {
        this.backgroundDispatcherProvider = aVar;
        this.dataStoreProvider = aVar2;
    }

    public static SessionDatastoreImpl_Factory create(V2.a aVar, V2.a aVar2) {
        return new SessionDatastoreImpl_Factory(aVar, aVar2);
    }

    public static SessionDatastoreImpl newInstance(i iVar, InterfaceC0523i interfaceC0523i) {
        return new SessionDatastoreImpl(iVar, interfaceC0523i);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public SessionDatastoreImpl get() {
        return newInstance((i) this.backgroundDispatcherProvider.get(), (InterfaceC0523i) this.dataStoreProvider.get());
    }
}
