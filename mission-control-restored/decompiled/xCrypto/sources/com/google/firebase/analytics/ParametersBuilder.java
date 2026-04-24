package com.google.firebase.analytics;

import android.os.Bundle;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ParametersBuilder {
    private final Bundle zza = new Bundle();

    public final Bundle getBundle() {
        return this.zza;
    }

    public final void param(String key, double d4) {
        r.f(key, "key");
        this.zza.putDouble(key, d4);
    }

    public final void param(String key, long j4) {
        r.f(key, "key");
        this.zza.putLong(key, j4);
    }

    public final void param(String key, Bundle value) {
        r.f(key, "key");
        r.f(value, "value");
        this.zza.putBundle(key, value);
    }

    public final void param(String key, String value) {
        r.f(key, "key");
        r.f(value, "value");
        this.zza.putString(key, value);
    }

    public final void param(String key, Bundle[] value) {
        r.f(key, "key");
        r.f(value, "value");
        this.zza.putParcelableArray(key, value);
    }
}
