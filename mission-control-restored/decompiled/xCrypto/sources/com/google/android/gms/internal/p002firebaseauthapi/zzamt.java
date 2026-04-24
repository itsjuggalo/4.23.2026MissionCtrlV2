package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzamt implements zzama {
    private final zzamc zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzamt(zzamc zzamcVar, String str, Object[] objArr) {
        this.zza = zzamcVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i4 = cCharAt & 8191;
        int i5 = 13;
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char cCharAt2 = str.charAt(i6);
            if (cCharAt2 < 55296) {
                this.zzd = i4 | (cCharAt2 << i5);
                return;
            } else {
                i4 |= (cCharAt2 & 8191) << i5;
                i5 += 13;
                i6 = i7;
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzama
    public final zzamc zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzama
    public final zzamo zzb() {
        int i4 = this.zzd;
        return (i4 & 1) != 0 ? zzamo.PROTO2 : (i4 & 4) == 4 ? zzamo.EDITIONS : zzamo.PROTO3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzama
    public final boolean zzc() {
        return (this.zzd & 2) == 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
