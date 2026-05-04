package com.google.android.gms.common.api.internal;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5581a;

    public i(Activity activity) {
        com.google.android.gms.common.internal.s.l(activity, "Activity must not be null");
        this.f5581a = activity;
    }

    public final boolean a() {
        return this.f5581a instanceof androidx.fragment.app.u;
    }

    public final boolean b() {
        return this.f5581a instanceof Activity;
    }

    public final Activity c() {
        return (Activity) this.f5581a;
    }

    public final androidx.fragment.app.u d() {
        return (androidx.fragment.app.u) this.f5581a;
    }
}
