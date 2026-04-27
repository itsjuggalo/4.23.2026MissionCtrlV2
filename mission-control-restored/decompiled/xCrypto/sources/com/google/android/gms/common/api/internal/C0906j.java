package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.fragment.app.AbstractActivityC0832u;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0906j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9798a;

    public C0906j(Activity activity) {
        AbstractC0940s.l(activity, "Activity must not be null");
        this.f9798a = activity;
    }

    public final Activity a() {
        return (Activity) this.f9798a;
    }

    public final AbstractActivityC0832u b() {
        return (AbstractActivityC0832u) this.f9798a;
    }

    public final boolean c() {
        return this.f9798a instanceof Activity;
    }

    public final boolean d() {
        return this.f9798a instanceof AbstractActivityC0832u;
    }
}
