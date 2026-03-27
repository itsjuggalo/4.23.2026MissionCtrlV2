package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
class zzlc extends zzlb {
    protected final byte[] zza;

    public zzlc(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzle) || zzd() != ((zzle) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzlc)) {
            return obj.equals(this);
        }
        zzlc zzlcVar = (zzlc) obj;
        int iZzj = zzj();
        int iZzj2 = zzlcVar.zzj();
        if (iZzj != 0 && iZzj2 != 0 && iZzj != iZzj2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzlcVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzlcVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzlcVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzlcVar.zza;
        zzlcVar.zzc();
        int i4 = 0;
        int i5 = 0;
        while (i4 < iZzd) {
            if (bArr[i4] != bArr2[i5]) {
                return false;
            }
            i4++;
            i5++;
        }
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public byte zza(int i4) {
        return this.zza[i4];
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public byte zzb(int i4) {
        return this.zza[i4];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zza, 0, bArr, 0, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final int zzf(int i4, int i5, int i6) {
        return zznl.zzb(i4, this.zza, 0, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final zzle zzg(int i4, int i5) {
        int iZzi = zzle.zzi(0, i5, zzd());
        return iZzi == 0 ? zzle.zzb : new zzkz(this.zza, 0, iZzi);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final void zzh(zzkw zzkwVar) {
        ((zzlk) zzkwVar).zzc(this.zza, 0, zzd());
    }
}
