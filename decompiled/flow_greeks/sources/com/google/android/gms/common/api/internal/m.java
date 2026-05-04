package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static l a(Object obj, Looper looper, String str) {
        com.google.android.gms.common.internal.s.l(obj, "Listener must not be null");
        com.google.android.gms.common.internal.s.l(looper, "Looper must not be null");
        com.google.android.gms.common.internal.s.l(str, "Listener type must not be null");
        return new l(looper, obj, str);
    }

    public static l.a b(Object obj, String str) {
        com.google.android.gms.common.internal.s.l(obj, "Listener must not be null");
        com.google.android.gms.common.internal.s.l(str, "Listener type must not be null");
        com.google.android.gms.common.internal.s.f(str, "Listener type must not be empty");
        return new l.a(obj, str);
    }
}
