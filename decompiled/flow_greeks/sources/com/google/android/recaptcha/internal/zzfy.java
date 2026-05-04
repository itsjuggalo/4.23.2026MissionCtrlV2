package com.google.android.recaptcha.internal;

import dd.r;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.t;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
        Collection collectionK;
        if (!t.b(method.getName(), this.zzb)) {
            return false;
        }
        zztf zztfVarZzf = zzti.zzf();
        if (objArr != null) {
            collectionK = new ArrayList(objArr.length);
            for (Object obj2 : objArr) {
                zztg zztgVarZzf = zzth.zzf();
                zztgVarZzf.zzw(obj2.toString());
                collectionK.add((zzth) zztgVarZzf.zzk());
            }
        } else {
            collectionK = r.k();
        }
        zztfVarZzf.zze(collectionK);
        zzti zztiVar = (zzti) zztfVarZzf.zzk();
        o oVar = this.zza;
        byte[] bArrZzd = zztiVar.zzd();
        oVar.invoke(objArr, zzkh.zzh().zzi(bArrZzd, 0, bArrZzd.length));
        return true;
    }
}
