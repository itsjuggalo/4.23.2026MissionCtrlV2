package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
class zzlg extends zzlf {
    protected final byte[] zza;

    public zzlg(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlh) || zzc() != ((zzlh) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzlg)) {
            return obj.equals(this);
        }
        zzlg zzlgVar = (zzlg) obj;
        int iZzi = zzi();
        int iZzi2 = zzlgVar.zzi();
        if (iZzi != 0 && iZzi2 != 0 && iZzi != iZzi2) {
            return false;
        }
        int iZzc = zzc();
        if (iZzc > zzlgVar.zzc()) {
            int iZzc2 = zzc();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + 18 + String.valueOf(iZzc2).length());
            sb.append("Length too large: ");
            sb.append(iZzc);
            sb.append(iZzc2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (iZzc > zzlgVar.zzc()) {
            int iZzc3 = zzlgVar.zzc();
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzc).length() + 27 + String.valueOf(iZzc3).length());
            sb2.append("Ran off end of other: 0, ");
            sb2.append(iZzc);
            sb2.append(", ");
            sb2.append(iZzc3);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzlgVar.zza;
        zzlgVar.zzd();
        int i8 = 0;
        int i9 = 0;
        while (i8 < iZzc) {
            if (bArr[i8] != bArr2[i9]) {
                return false;
            }
            i8++;
            i9++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public byte zza(int i8) {
        return this.zza[i8];
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public byte zzb(int i8) {
        return this.zza[i8];
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final zzlh zze(int i8, int i9) {
        int iZzj = zzlh.zzj(0, i9, zzc());
        return iZzj == 0 ? zzlh.zzb : new zzlc(this.zza, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final void zzf(zzkz zzkzVar) {
        ((zzlk) zzkzVar).zzv(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzlh
    public final int zzg(int i8, int i9, int i10) {
        return zzmp.zzc(i8, this.zza, 0, i10);
    }
}
