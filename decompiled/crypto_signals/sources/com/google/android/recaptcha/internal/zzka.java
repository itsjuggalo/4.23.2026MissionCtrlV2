package com.google.android.recaptcha.internal;

import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzka extends zzjr {
    private final MessageDigest zza;
    private final int zzb;
    private boolean zzc;

    public /* synthetic */ zzka(MessageDigest messageDigest, int i, zzkb zzkbVar) {
        this.zza = messageDigest;
        this.zzb = i;
    }

    private final void zzc() {
        zzjf.zze(!this.zzc, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override // com.google.android.recaptcha.internal.zzjr
    public final void zza(byte[] bArr, int i, int i6) {
        zzc();
        this.zza.update(bArr, 0, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzjx
    public final zzjv zzb() {
        zzc();
        this.zzc = true;
        int i = this.zzb;
        if (i == this.zza.getDigestLength()) {
            byte[] bArrDigest = this.zza.digest();
            int i6 = zzjv.zzb;
            return new zzju(bArrDigest);
        }
        byte[] bArrCopyOf = Arrays.copyOf(this.zza.digest(), i);
        int i7 = zzjv.zzb;
        return new zzju(bArrCopyOf);
    }
}
