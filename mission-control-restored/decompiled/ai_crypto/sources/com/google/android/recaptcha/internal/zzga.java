package com.google.android.recaptcha.internal;

import F5.AbstractC0551i;
import F5.AbstractC0556n;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.internal.r;

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
        List listG;
        if (!r.b(method.getName(), this.zzb)) {
            return false;
        }
        zzfz zzfzVar = this.zza;
        if (objArr == null || (listG = AbstractC0551i.c(objArr)) == null) {
            listG = AbstractC0556n.g();
        }
        zzfzVar.zzb(listG);
        return true;
    }
}
