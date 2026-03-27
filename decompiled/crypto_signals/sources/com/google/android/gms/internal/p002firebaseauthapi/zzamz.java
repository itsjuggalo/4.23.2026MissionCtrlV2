package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzamz implements zzamk {
    private final zzamm zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzamz(zzamm zzammVar, String str, Object[] objArr) {
        this.zza = zzammVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i6 = 13;
        int i7 = 1;
        while (true) {
            int i8 = i7 + 1;
            char cCharAt2 = str.charAt(i7);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i6);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i6;
                i6 += 13;
                i7 = i8;
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamk
    public final zzamm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamk
    public final zzamy zzb() {
        int i = this.zzd;
        return (i & 1) != 0 ? zzamy.PROTO2 : (i & 4) == 4 ? zzamy.EDITIONS : zzamy.PROTO3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamk
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
