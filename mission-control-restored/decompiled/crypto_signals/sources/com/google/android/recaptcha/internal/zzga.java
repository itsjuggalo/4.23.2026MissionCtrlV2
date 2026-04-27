package com.google.android.recaptcha.internal;

import H4.g;
import H4.p;
import java.lang.reflect.Method;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class zzga extends zzfx {
    private final zzfz zza;
    private final String zzb;

    public zzga(zzfz zzfzVar, String str, Object obj) {
        super(obj);
        this.zza = zzfzVar;
        this.zzb = str;
    }

    @Override // com.google.android.recaptcha.internal.zzfx
    public final boolean zza(Object obj, Method method, Object[] objArr) {
        if (!j.a(method.getName(), this.zzb)) {
            return false;
        }
        this.zza.zzb(objArr != null ? g.c0(objArr) : p.f577a);
        return true;
    }
}
