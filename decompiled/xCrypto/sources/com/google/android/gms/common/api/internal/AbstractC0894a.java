package com.google.android.gms.common.api.internal;

import android.app.Activity;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0894a {
    public static final AbstractC0894a a(Activity activity) {
        return new I(B.a(activity));
    }

    public abstract AbstractC0894a b(Runnable runnable);
}
