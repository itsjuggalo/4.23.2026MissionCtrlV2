package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzbu extends zzca {
    private final String zzc;
    private final int zzd;
    private final int zze;

    public /* synthetic */ zzbu(String str, boolean z4, int i4, zzbr zzbrVar, zzbs zzbsVar, int i5, byte[] bArr) {
        this.zzc = str;
        this.zzd = i4;
        this.zze = i5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzca) {
            zzca zzcaVar = (zzca) obj;
            if (this.zzc.equals(zzcaVar.zza())) {
                zzcaVar.zzb();
                int i4 = this.zzd;
                int iZze = zzcaVar.zze();
                if (i4 == 0) {
                    throw null;
                }
                if (i4 == iZze) {
                    zzcaVar.zzc();
                    zzcaVar.zzd();
                    int i5 = this.zze;
                    int iZzf = zzcaVar.zzf();
                    if (i5 == 0) {
                        throw null;
                    }
                    if (iZzf == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzc.hashCode() ^ 1000003;
        int i4 = this.zzd;
        if (i4 == 0) {
            throw null;
        }
        int i5 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i4;
        if (this.zze != 0) {
            return (i5 * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i4 = this.zzd;
        String str = i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        String str2 = this.zze == 1 ? "READ_AND_WRITE" : "null";
        String str3 = this.zzc;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 73 + str.length() + 91 + str2.length() + 1);
        sb.append("FileComplianceOptions{fileOwner=");
        sb.append(str3);
        sb.append(", hasDifferentDmaOwner=false, fileChecks=");
        sb.append(str);
        sb.append(", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final String zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final zzbr zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final zzbs zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final int zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final int zzf() {
        return this.zze;
    }
}
