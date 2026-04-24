package com.google.android.gms.internal.fido;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.C1194e;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends a.AbstractC0178a {
    @Override // com.google.android.gms.common.api.a.AbstractC0178a
    public final /* synthetic */ a.f buildClient(Context context, Looper looper, C1194e c1194e, Object obj, f.b bVar, f.c cVar) {
        return new zzp(context, looper, c1194e, bVar, cVar);
    }
}
