package com.google.android.recaptcha.internal;

import android.app.Application;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class zziw extends s implements Function0 {
    public static final zziw zza = new zziw();

    public zziw() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws zzbd {
        int i7 = zzav.zza;
        Object objZzb = zzau.zza().zzb(Application.class.getName().hashCode());
        if (objZzb != null) {
            return (Application) objZzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, null);
    }
}
