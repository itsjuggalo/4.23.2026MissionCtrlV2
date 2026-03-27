package com.google.android.play.core.integrity;

import F2.AbstractC0470h;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static aw f11899a;

    public static synchronized aw a(Context context) {
        try {
            if (f11899a == null) {
                u uVar = new u(null);
                uVar.a(AbstractC0470h.a(context));
                f11899a = uVar.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f11899a;
    }
}
