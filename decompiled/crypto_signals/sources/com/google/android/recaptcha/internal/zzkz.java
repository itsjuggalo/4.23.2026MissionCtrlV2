package com.google.android.recaptcha.internal;

import a3.d;

/* JADX INFO: loaded from: classes.dex */
final class zzkz extends zzlc {
    private final int zzc;

    public zzkz(byte[] bArr, int i, int i6) {
        super(bArr);
        zzle.zzi(0, i6, bArr.length);
        this.zzc = i6;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final byte zza(int i) {
        int i6 = this.zzc;
        if (((i6 - (i + 1)) | i) >= 0) {
            return ((zzlc) this).zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(d.f(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(d.h("Index > length: ", i, i6, ", "));
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final byte zzb(int i) {
        return ((zzlc) this).zza[i];
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
    public final void zze(byte[] bArr, int i, int i6, int i7) {
        System.arraycopy(((zzlc) this).zza, 0, bArr, 0, i7);
    }
}
