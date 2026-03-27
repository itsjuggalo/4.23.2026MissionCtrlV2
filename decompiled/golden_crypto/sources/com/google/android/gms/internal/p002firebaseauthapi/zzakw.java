package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakw implements zzakx {
    private static <E> zzakn<E> zzc(Object obj, long j) {
        return (zzakn) zzana.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakx
    public final <L> List<L> zza(Object obj, long j) {
        zzakn zzaknVarZzc = zzc(obj, j);
        if (zzaknVarZzc.zzc()) {
            return zzaknVarZzc;
        }
        int size = zzaknVarZzc.size();
        zzakn zzaknVarZza = zzaknVarZzc.zza(size == 0 ? 10 : size << 1);
        zzana.zza(obj, j, zzaknVarZza);
        return zzaknVarZza;
    }

    zzakw() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakx
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.firebase-auth-api.zzakn] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.firebase-auth-api.zzakn, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakx
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzakn zzaknVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzaknVarZzc.size();
        int size2 = Zzc.size();
        ?? r0 = zzaknVarZzc;
        r0 = zzaknVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZzc = zzaknVarZzc.zzc();
            ?? Zza = zzaknVarZzc;
            if (!zZzc) {
                Zza = zzaknVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r0 = Zza;
        }
        if (size > 0) {
            Zzc = r0;
        }
        zzana.zza(obj, j, (Object) Zzc);
    }
}
