package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
class zzlf extends zzle {
    protected final byte[] zza;

    public zzlf(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlg) || zzc() != ((zzlg) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzlf)) {
            return obj.equals(this);
        }
        zzlf zzlfVar = (zzlf) obj;
        int iZzi = zzi();
        int iZzi2 = zzlfVar.zzi();
        if (iZzi != 0 && iZzi2 != 0 && iZzi != iZzi2) {
            return false;
        }
        int iZzc = zzc();
        if (iZzc > zzlfVar.zzc()) {
            int iZzc2 = zzc();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + 18 + String.valueOf(iZzc2).length());
            sb.append("Length too large: ");
            sb.append(iZzc);
            sb.append(iZzc2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (iZzc > zzlfVar.zzc()) {
            int iZzc3 = zzlfVar.zzc();
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzc).length() + 27 + String.valueOf(iZzc3).length());
            sb2.append("Ran off end of other: 0, ");
            sb2.append(iZzc);
            sb2.append(", ");
            sb2.append(iZzc3);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzlfVar.zza;
        zzlfVar.zzd();
        int i7 = 0;
        int i8 = 0;
        while (i7 < iZzc) {
            if (bArr[i7] != bArr2[i8]) {
                return false;
            }
            i7++;
            i8++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public byte zza(int i7) {
        return this.zza[i7];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public byte zzb(int i7) {
        return this.zza[i7];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final zzlg zze(int i7, int i8) {
        int iZzj = zzlg.zzj(0, i8, zzc());
        return iZzj == 0 ? zzlg.zzb : new zzlb(this.zza, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final void zzf(zzky zzkyVar) {
        ((zzlj) zzkyVar).zzv(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final int zzg(int i7, int i8, int i9) {
        return zzmo.zzc(i7, this.zza, 0, i9);
    }
}
