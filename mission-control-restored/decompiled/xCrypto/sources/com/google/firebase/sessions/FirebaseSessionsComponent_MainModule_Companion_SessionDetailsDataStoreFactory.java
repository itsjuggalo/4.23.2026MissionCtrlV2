package com.google.firebase.sessions;

import S.InterfaceC0523i;
import android.content.Context;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory implements Factory<InterfaceC0523i> {
    private final V2.a appContextProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(V2.a aVar) {
        this.appContextProvider = aVar;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory create(V2.a aVar) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(aVar);
    }

    public static InterfaceC0523i sessionDetailsDataStore(Context context) {
        return (InterfaceC0523i) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.sessionDetailsDataStore(context));
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public InterfaceC0523i get() {
        return sessionDetailsDataStore((Context) this.appContextProvider.get());
    }
}
