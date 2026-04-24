package com.google.firebase.sessions;

import S.InterfaceC0523i;
import android.content.Context;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory implements Factory<InterfaceC0523i> {
    private final V2.a appContextProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(V2.a aVar) {
        this.appContextProvider = aVar;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory create(V2.a aVar) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(aVar);
    }

    public static InterfaceC0523i sessionConfigsDataStore(Context context) {
        return (InterfaceC0523i) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.sessionConfigsDataStore(context));
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public InterfaceC0523i get() {
        return sessionConfigsDataStore((Context) this.appContextProvider.get());
    }
}
