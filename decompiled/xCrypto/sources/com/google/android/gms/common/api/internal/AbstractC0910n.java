package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.C0909m;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0910n {
    public static C0909m a(Object obj, Looper looper, String str) {
        AbstractC0940s.l(obj, "Listener must not be null");
        AbstractC0940s.l(looper, "Looper must not be null");
        AbstractC0940s.l(str, "Listener type must not be null");
        return new C0909m(looper, obj, str);
    }

    public static C0909m.a b(Object obj, String str) {
        AbstractC0940s.l(obj, "Listener must not be null");
        AbstractC0940s.l(str, "Listener type must not be null");
        AbstractC0940s.f(str, "Listener type must not be empty");
        return new C0909m.a(obj, str);
    }
}
