package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.C1175l;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1176m {
    public static C1175l a(Object obj, Looper looper, String str) {
        AbstractC1207s.l(obj, "Listener must not be null");
        AbstractC1207s.l(looper, "Looper must not be null");
        AbstractC1207s.l(str, "Listener type must not be null");
        return new C1175l(looper, obj, str);
    }

    public static C1175l.a b(Object obj, String str) {
        AbstractC1207s.l(obj, "Listener must not be null");
        AbstractC1207s.l(str, "Listener type must not be null");
        AbstractC1207s.f(str, "Listener type must not be empty");
        return new C1175l.a(obj, str);
    }
}
