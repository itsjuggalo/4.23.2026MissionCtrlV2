package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzlb extends zzlf {
    private final int zzc;

    public zzlb(byte[] bArr, int i7, int i8) {
        super(bArr);
        zzlg.zzj(0, i8, bArr.length);
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzlf, com.google.android.gms.internal.measurement.zzlg
    public final byte zza(int i7) {
        int i8 = this.zzc;
        if (((i8 - (i7 + 1)) | i7) >= 0) {
            return ((zzlf) this).zza[i7];
        }
        if (i7 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i7);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i7).length() + 18 + String.valueOf(i8).length());
        sb2.append("Index > length: ");
        sb2.append(i7);
        sb2.append(", ");
        sb2.append(i8);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzlf, com.google.android.gms.internal.measurement.zzlg
    public final byte zzb(int i7) {
        return ((zzlf) this).zza[i7];
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
