package com.google.firebase.analytics;

import android.os.Bundle;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class ParametersBuilder {
    private final Bundle zza = new Bundle();

    public final Bundle getBundle() {
        return this.zza;
    }

    public final void param(String key, double d8) {
        AbstractC2304t.f(key, "key");
        this.zza.putDouble(key, d8);
    }

    public final void param(String key, long j8) {
        AbstractC2304t.f(key, "key");
        this.zza.putLong(key, j8);
    }

    public final void param(String key, Bundle value) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        this.zza.putBundle(key, value);
    }

    public final void param(String key, String value) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        this.zza.putString(key, value);
    }

    public final void param(String key, Bundle[] value) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(value, "value");
        this.zza.putParcelableArray(key, value);
    }
}
