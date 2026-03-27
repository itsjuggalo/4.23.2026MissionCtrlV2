package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.internal.AbstractC1207s;
import m0.AbstractActivityC2221u;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1172i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10974a;

    public C1172i(Activity activity) {
        AbstractC1207s.l(activity, "Activity must not be null");
        this.f10974a = activity;
    }

    public final Activity a() {
        return (Activity) this.f10974a;
    }

    public final AbstractActivityC2221u b() {
        return (AbstractActivityC2221u) this.f10974a;
    }

    public final boolean c() {
        return this.f10974a instanceof Activity;
    }

    public final boolean d() {
        return this.f10974a instanceof AbstractActivityC2221u;
    }
}
