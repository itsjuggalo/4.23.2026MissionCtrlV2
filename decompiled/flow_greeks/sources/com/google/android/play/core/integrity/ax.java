package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static aw f5933a;

    public static synchronized aw a(Context context) {
        try {
            if (f5933a == null) {
                u uVar = new u(null);
                uVar.a(n6.h.a(context));
                f5933a = uVar.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5933a;
    }
}
