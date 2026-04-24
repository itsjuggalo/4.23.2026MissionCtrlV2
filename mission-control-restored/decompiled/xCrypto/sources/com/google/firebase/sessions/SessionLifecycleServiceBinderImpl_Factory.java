package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class SessionLifecycleServiceBinderImpl_Factory implements Factory<SessionLifecycleServiceBinderImpl> {
    private final V2.a appContextProvider;

    public SessionLifecycleServiceBinderImpl_Factory(V2.a aVar) {
        this.appContextProvider = aVar;
    }

    public static SessionLifecycleServiceBinderImpl_Factory create(V2.a aVar) {
        return new SessionLifecycleServiceBinderImpl_Factory(aVar);
    }

    public static SessionLifecycleServiceBinderImpl newInstance(Context context) {
        return new SessionLifecycleServiceBinderImpl(context);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public SessionLifecycleServiceBinderImpl get() {
        return newInstance((Context) this.appContextProvider.get());
    }
}
