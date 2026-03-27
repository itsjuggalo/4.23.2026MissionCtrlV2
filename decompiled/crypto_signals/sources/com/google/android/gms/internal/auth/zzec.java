package com.google.android.gms.internal.auth;

import a3.d;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class zzec extends zzeb {
    protected final byte[] zza;

    public zzec(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzef) || zzd() != ((zzef) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzec)) {
            return obj.equals(this);
        }
        zzec zzecVar = (zzec) obj;
        int iZzj = zzj();
        int iZzj2 = zzecVar.zzj();
        if (iZzj != 0 && iZzj2 != 0 && iZzj != iZzj2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzecVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzecVar.zzd()) {
            throw new IllegalArgumentException(d.h("Ran off end of other: 0, ", iZzd, zzecVar.zzd(), ", "));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzecVar.zza;
        zzecVar.zzc();
        int i = 0;
        int i6 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i6]) {
                return false;
            }
            i++;
            i6++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final int zze(int i, int i6, int i7) {
        return zzfa.zzb(i, this.zza, 0, i7);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final zzef zzf(int i, int i6) {
        int iZzi = zzef.zzi(0, i6, zzd());
        return iZzi == 0 ? zzef.zzb : new zzdz(this.zza, 0, iZzi);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean zzh() {
        return zzhn.zzc(this.zza, 0, zzd());
    }
}
