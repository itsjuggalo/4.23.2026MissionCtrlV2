package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzlb extends zzlf {
    private final int zzc;

    public zzlb(byte[] bArr, int i4, int i5) {
        super(bArr);
        zzlg.zzj(0, i5, bArr.length);
        this.zzc = i5;
    }

    @Override // com.google.android.gms.internal.measurement.zzlf, com.google.android.gms.internal.measurement.zzlg
    public final byte zza(int i4) {
        int i5 = this.zzc;
        if (((i5 - (i4 + 1)) | i4) >= 0) {
            return ((zzlf) this).zza[i4];
        }
        if (i4 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i4);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 18 + String.valueOf(i5).length());
        sb2.append("Index > length: ");
        sb2.append(i4);
        sb2.append(", ");
        sb2.append(i5);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzlf, com.google.android.gms.internal.measurement.zzlg
    public final byte zzb(int i4) {
        return ((zzlf) this).zza[i4];
    }

    @Override // com.google.android.gms.internal.measurement.zzlf, com.google.android.gms.internal.measurement.zzlg
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzlf
    public final int zzd() {
        return 0;
    }
}
