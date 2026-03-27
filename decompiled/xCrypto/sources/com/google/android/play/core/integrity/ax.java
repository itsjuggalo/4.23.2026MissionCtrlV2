package com.google.android.play.core.integrity;

import X1.AbstractC0747h;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static aw f10116a;

    public static synchronized aw a(Context context) {
        try {
            if (f10116a == null) {
                u uVar = new u(null);
                uVar.a(AbstractC0747h.a(context));
                f10116a = uVar.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10116a;
    }
}
