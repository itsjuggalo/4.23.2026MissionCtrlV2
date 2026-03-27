package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzalp implements zzalm {
    private static <E> zzalc<E> zzc(Object obj, long j4) {
        return (zzalc) zzanp.zze(obj, j4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
    public final <L> List<L> zza(Object obj, long j4) {
        zzalc zzalcVarZzc = zzc(obj, j4);
        if (zzalcVarZzc.zzc()) {
            return zzalcVarZzc;
        }
        int size = zzalcVarZzc.size();
        zzalc zzalcVarZza = zzalcVarZzc.zza(size == 0 ? 10 : size << 1);
        zzanp.zza(obj, j4, zzalcVarZza);
        return zzalcVarZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
    public final void zzb(Object obj, long j4) {
        zzc(obj, j4).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.firebase-auth-api.zzalc, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
    public final <E> void zza(Object obj, Object obj2, long j4) {
        zzalc zzalcVarZzc = zzc(obj, j4);
        ?? Zzc = zzc(obj2, j4);
        int size = zzalcVarZzc.size();
        int size2 = Zzc.size();
        ?? r02 = zzalcVarZzc;
        r02 = zzalcVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZzc = zzalcVarZzc.zzc();
            ?? Zza = zzalcVarZzc;
            if (!zZzc) {
                Zza = zzalcVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r02 = Zza;
        }
        if (size > 0) {
            Zzc = r02;
        }
        zzanp.zza(obj, j4, (Object) Zzc);
    }
}
