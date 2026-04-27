package com.google.android.gms.internal.fido;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.internal.C0430h;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends a {
    @Override // com.google.android.gms.common.api.a
    public final /* synthetic */ g buildClient(Context context, Looper looper, C0430h c0430h, Object obj, m mVar, n nVar) {
        return new zzp(context, looper, c0430h, mVar, nVar);
    }
}
