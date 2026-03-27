package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzlc extends zzlg {
    private final int zzc;

    public zzlc(byte[] bArr, int i8, int i9) {
        super(bArr);
        zzlh.zzj(0, i9, bArr.length);
        this.zzc = i9;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final byte zza(int i8) {
        int i9 = this.zzc;
        if (((i9 - (i8 + 1)) | i8) >= 0) {
            return ((zzlg) this).zza[i8];
        }
        if (i8 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i8).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i8);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i8).length() + 18 + String.valueOf(i9).length());
        sb2.append("Index > length: ");
        sb2.append(i8);
        sb2.append(", ");
        sb2.append(i9);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final byte zzb(int i8) {
        return ((zzlg) this).zza[i8];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final int zzd() {
        return 0;
    }
}
