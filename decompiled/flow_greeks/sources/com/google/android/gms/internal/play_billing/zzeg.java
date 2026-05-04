package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
class zzeg extends zzef {
    protected final byte[] zza;

    public zzeg(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzei) || zzd() != ((zzei) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzeg)) {
            return obj.equals(this);
        }
        zzeg zzegVar = (zzeg) obj;
        int iZzi = zzi();
        int iZzi2 = zzegVar.zzi();
        if (iZzi != 0 && iZzi2 != 0 && iZzi != iZzi2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzegVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzegVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzegVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzegVar.zza;
        zzegVar.zzc();
        int i10 = 0;
        int i11 = 0;
        while (i10 < iZzd) {
            if (bArr[i10] != bArr2[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public byte zza(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public byte zzb(int i10) {
        return this.zza[i10];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final int zze(int i10, int i11, int i12) {
        return zzfo.zzb(i10, this.zza, 0, i12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final zzei zzf(int i10, int i11) {
        int iZzh = zzei.zzh(0, i11, zzd());
        return iZzh == 0 ? zzei.zzb : new zzec(this.zza, 0, iZzh);
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final void zzg(zzdz zzdzVar) {
        ((zzem) zzdzVar).zzc(this.zza, 0, zzd());
    }
}
