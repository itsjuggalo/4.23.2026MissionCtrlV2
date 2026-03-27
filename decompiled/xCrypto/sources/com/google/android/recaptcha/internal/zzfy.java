package com.google.android.recaptcha.internal;

import X2.AbstractC0769p;
import i3.o;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class zzfy extends zzfx {
    private final o zza;
    private final String zzb;

    public zzfy(o oVar, String str, Object obj) {
        super(obj);
        this.zza = oVar;
        this.zzb = str;
    }

    @Override // com.google.android.recaptcha.internal.zzfx
    public final boolean zza(Object obj, Method method, Object[] objArr) {
        Collection collectionG;
        if (!r.b(method.getName(), this.zzb)) {
            return false;
        }
        zztf zztfVarZzf = zzti.zzf();
        if (objArr != null) {
            collectionG = new ArrayList(objArr.length);
            for (Object obj2 : objArr) {
                zztg zztgVarZzf = zzth.zzf();
                zztgVarZzf.zzw(obj2.toString());
                collectionG.add((zzth) zztgVarZzf.zzk());
            }
        } else {
            collectionG = AbstractC0769p.g();
        }
        zztfVarZzf.zze(collectionG);
        zzti zztiVar = (zzti) zztfVarZzf.zzk();
        o oVar = this.zza;
        byte[] bArrZzd = zztiVar.zzd();
        oVar.invoke(objArr, zzkh.zzh().zzi(bArrZzd, 0, bArrZzd.length));
        return true;
    }
}
