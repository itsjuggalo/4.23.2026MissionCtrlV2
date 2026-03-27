package com.google.android.gms.internal.p000authapi;

import I1.o;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.InterfaceC1169f;
import com.google.android.gms.common.api.internal.InterfaceC1178o;
import com.google.android.gms.common.internal.C1194e;

/* JADX INFO: loaded from: classes.dex */
final class zby extends a.AbstractC0178a {
    @Override // com.google.android.gms.common.api.a.AbstractC0178a
    public final /* synthetic */ a.f buildClient(Context context, Looper looper, C1194e c1194e, Object obj, InterfaceC1169f interfaceC1169f, InterfaceC1178o interfaceC1178o) {
        return new zbg(context, looper, (o) obj, c1194e, interfaceC1169f, interfaceC1178o);
    }
}
