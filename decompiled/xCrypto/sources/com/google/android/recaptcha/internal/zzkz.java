package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzkz extends zzlc {
    private final int zzc;

    public zzkz(byte[] bArr, int i4, int i5) {
        super(bArr);
        zzle.zzi(0, i5, bArr.length);
        this.zzc = i5;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final byte zza(int i4) {
        int i5 = this.zzc;
        if (((i5 - (i4 + 1)) | i4) >= 0) {
            return ((zzlc) this).zza[i4];
        }
        if (i4 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + i5);
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final byte zzb(int i4) {
        return ((zzlc) this).zza[i4];
    }

    @Override // com.google.android.recaptcha.internal.zzlc
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(((zzlc) this).zza, 0, bArr, 0, i6);
    }
}
