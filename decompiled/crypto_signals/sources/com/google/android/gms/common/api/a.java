package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.internal.InterfaceC0403f;
import com.google.android.gms.common.api.internal.InterfaceC0413p;
import com.google.android.gms.common.internal.C0430h;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends f {
    @Deprecated
    public g buildClient(Context context, Looper looper, C0430h c0430h, Object obj, m mVar, n nVar) {
        return buildClient(context, looper, c0430h, obj, (InterfaceC0403f) mVar, (InterfaceC0413p) nVar);
    }

    public g buildClient(Context context, Looper looper, C0430h c0430h, Object obj, InterfaceC0403f interfaceC0403f, InterfaceC0413p interfaceC0413p) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }
}
