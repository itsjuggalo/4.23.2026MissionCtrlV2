package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzami implements zzamf {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final int zza(int i10, Object obj, Object obj2) {
        zzamg zzamgVar = (zzamg) obj;
        if (zzamgVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzamgVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Object zzb(Object obj) {
        return zzamg.zza().zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Object zzc(Object obj) {
        ((zzamg) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Map<?, ?> zzd(Object obj) {
        return (zzamg) obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Map<?, ?> zze(Object obj) {
        return (zzamg) obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final boolean zzf(Object obj) {
        return !((zzamg) obj).zzd();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final zzamd<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final Object zza(Object obj, Object obj2) {
        zzamg zzamgVarZzb = (zzamg) obj;
        zzamg zzamgVar = (zzamg) obj2;
        if (!zzamgVar.isEmpty()) {
            if (!zzamgVarZzb.zzd()) {
                zzamgVarZzb = zzamgVarZzb.zzb();
            }
            zzamgVarZzb.zza(zzamgVar);
        }
        return zzamgVarZzb;
    }
}
