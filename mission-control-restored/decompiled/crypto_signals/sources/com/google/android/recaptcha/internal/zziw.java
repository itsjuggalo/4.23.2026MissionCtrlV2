package com.google.android.recaptcha.internal;

import R4.a;
import android.app.Application;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class zziw extends k implements a {
    public static final zziw zza = new zziw();

    public zziw() {
        super(0);
    }

    @Override // R4.a
    public final Object invoke() throws zzbd {
        int i = zzav.zza;
        Object objZzb = zzau.zza().zzb(735120228);
        if (objZzb != null) {
            return (Application) objZzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, null);
    }
}
