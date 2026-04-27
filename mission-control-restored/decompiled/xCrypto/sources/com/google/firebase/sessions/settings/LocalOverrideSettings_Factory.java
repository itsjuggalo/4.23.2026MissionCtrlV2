package com.google.firebase.sessions.settings;

import V2.a;
import android.content.Context;
import com.google.firebase.sessions.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class LocalOverrideSettings_Factory implements Factory<LocalOverrideSettings> {
    private final a appContextProvider;

    public LocalOverrideSettings_Factory(a aVar) {
        this.appContextProvider = aVar;
    }

    public static LocalOverrideSettings_Factory create(a aVar) {
        return new LocalOverrideSettings_Factory(aVar);
    }

    public static LocalOverrideSettings newInstance(Context context) {
        return new LocalOverrideSettings(context);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public LocalOverrideSettings get() {
        return newInstance((Context) this.appContextProvider.get());
    }
}
