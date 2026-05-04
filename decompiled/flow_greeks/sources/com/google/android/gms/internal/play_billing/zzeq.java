package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzeq implements zzhu {
    private final zzep zza;

    private zzeq(zzep zzepVar) {
        byte[] bArr = zzfo.zzb;
        this.zza = zzepVar;
        zzepVar.zza = this;
    }

    public static zzeq zza(zzep zzepVar) {
        zzeq zzeqVar = zzepVar.zza;
        return zzeqVar != null ? zzeqVar : new zzeq(zzepVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzA(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzga)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzi(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).getClass();
                i12 += 8;
            }
            zzepVar.zzv(i12);
            while (i11 < list.size()) {
                zzepVar.zzj(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzga zzgaVar = (zzga) list;
        if (!z10) {
            while (i11 < zzgaVar.size()) {
                this.zza.zzi(i10, zzgaVar.zze(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzgaVar.size(); i15++) {
            zzgaVar.zze(i15);
            i14 += 8;
        }
        zzepVar2.zzv(i14);
        while (i11 < zzgaVar.size()) {
            zzepVar2.zzj(zzgaVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzB(int i10, int i11) {
        this.zza.zzu(i10, (i11 >> 31) ^ (i11 + i11));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzC(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzfj)) {
            if (!z10) {
                while (i11 < list.size()) {
                    zzep zzepVar = this.zza;
                    int iIntValue = ((Integer) list.get(i11)).intValue();
                    zzepVar.zzu(i10, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i11++;
                }
                return;
            }
            zzep zzepVar2 = this.zza;
            zzepVar2.zzt(i10, 2);
            int iZzC = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                int iIntValue2 = ((Integer) list.get(i12)).intValue();
                iZzC += zzep.zzC((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzepVar2.zzv(iZzC);
            while (i11 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i11)).intValue();
                zzepVar2.zzv((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i11++;
            }
            return;
        }
        zzfj zzfjVar = (zzfj) list;
        if (!z10) {
            while (i11 < zzfjVar.size()) {
                zzep zzepVar3 = this.zza;
                int iZze = zzfjVar.zze(i11);
                zzepVar3.zzu(i10, (iZze >> 31) ^ (iZze + iZze));
                i11++;
            }
            return;
        }
        zzep zzepVar4 = this.zza;
        zzepVar4.zzt(i10, 2);
        int iZzC2 = 0;
        for (int i13 = 0; i13 < zzfjVar.size(); i13++) {
            int iZze2 = zzfjVar.zze(i13);
            iZzC2 += zzep.zzC((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        zzepVar4.zzv(iZzC2);
        while (i11 < zzfjVar.size()) {
            int iZze3 = zzfjVar.zze(i11);
            zzepVar4.zzv((iZze3 >> 31) ^ (iZze3 + iZze3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzD(int i10, long j10) {
        this.zza.zzw(i10, (j10 >> 63) ^ (j10 + j10));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzE(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzga)) {
            if (!z10) {
                while (i11 < list.size()) {
                    zzep zzepVar = this.zza;
                    long jLongValue = ((Long) list.get(i11)).longValue();
                    zzepVar.zzw(i10, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i11++;
                }
                return;
            }
            zzep zzepVar2 = this.zza;
            zzepVar2.zzt(i10, 2);
            int iZzD = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                long jLongValue2 = ((Long) list.get(i12)).longValue();
                iZzD += zzep.zzD((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzepVar2.zzv(iZzD);
            while (i11 < list.size()) {
                long jLongValue3 = ((Long) list.get(i11)).longValue();
                zzepVar2.zzx((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i11++;
            }
            return;
        }
        zzga zzgaVar = (zzga) list;
        if (!z10) {
            while (i11 < zzgaVar.size()) {
                zzep zzepVar3 = this.zza;
                long jZze = zzgaVar.zze(i11);
                zzepVar3.zzw(i10, (jZze >> 63) ^ (jZze + jZze));
                i11++;
            }
            return;
        }
        zzep zzepVar4 = this.zza;
        zzepVar4.zzt(i10, 2);
        int iZzD2 = 0;
        for (int i13 = 0; i13 < zzgaVar.size(); i13++) {
            long jZze2 = zzgaVar.zze(i13);
            iZzD2 += zzep.zzD((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        zzepVar4.zzv(iZzD2);
        while (i11 < zzgaVar.size()) {
            long jZze3 = zzgaVar.zze(i11);
            zzepVar4.zzx((jZze3 >> 63) ^ (jZze3 + jZze3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    @Deprecated
    public final void zzF(int i10) {
        this.zza.zzt(i10, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzG(int i10, String str) {
        this.zza.zzr(i10, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzH(int i10, List list) {
        int i11 = 0;
        if (!(list instanceof zzfx)) {
            while (i11 < list.size()) {
                this.zza.zzr(i10, (String) list.get(i11));
                i11++;
            }
            return;
        }
        zzfx zzfxVar = (zzfx) list;
        while (i11 < list.size()) {
            Object objZza = zzfxVar.zza();
            if (objZza instanceof String) {
                this.zza.zzr(i10, (String) objZza);
            } else {
                this.zza.zze(i10, (zzei) objZza);
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzI(int i10, int i11) {
        this.zza.zzu(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzJ(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzfj)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzu(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int iZzC = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzC += zzep.zzC(((Integer) list.get(i12)).intValue());
            }
            zzepVar.zzv(iZzC);
            while (i11 < list.size()) {
                zzepVar.zzv(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzfj zzfjVar = (zzfj) list;
        if (!z10) {
            while (i11 < zzfjVar.size()) {
                this.zza.zzu(i10, zzfjVar.zze(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int iZzC2 = 0;
        for (int i13 = 0; i13 < zzfjVar.size(); i13++) {
            iZzC2 += zzep.zzC(zzfjVar.zze(i13));
        }
        zzepVar2.zzv(iZzC2);
        while (i11 < zzfjVar.size()) {
            zzepVar2.zzv(zzfjVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzK(int i10, long j10) {
        this.zza.zzw(i10, j10);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzL(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzga)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzw(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int iZzD = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzD += zzep.zzD(((Long) list.get(i12)).longValue());
            }
            zzepVar.zzv(iZzD);
            while (i11 < list.size()) {
                zzepVar.zzx(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzga zzgaVar = (zzga) list;
        if (!z10) {
            while (i11 < zzgaVar.size()) {
                this.zza.zzw(i10, zzgaVar.zze(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int iZzD2 = 0;
        for (int i13 = 0; i13 < zzgaVar.size(); i13++) {
            iZzD2 += zzep.zzD(zzgaVar.zze(i13));
        }
        zzepVar2.zzv(iZzD2);
        while (i11 < zzgaVar.size()) {
            zzepVar2.zzx(zzgaVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzb(int i10, boolean z10) {
        this.zza.zzd(i10, z10);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzc(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzdy)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzd(i10, ((Boolean) list.get(i11)).booleanValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Boolean) list.get(i13)).getClass();
                i12++;
            }
            zzepVar.zzv(i12);
            while (i11 < list.size()) {
                zzepVar.zzb(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : (byte) 0);
                i11++;
            }
            return;
        }
        zzdy zzdyVar = (zzdy) list;
        if (!z10) {
            while (i11 < zzdyVar.size()) {
                this.zza.zzd(i10, zzdyVar.zzf(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzdyVar.size(); i15++) {
            zzdyVar.zzf(i15);
            i14++;
        }
        zzepVar2.zzv(i14);
        while (i11 < zzdyVar.size()) {
            zzepVar2.zzb(zzdyVar.zzf(i11) ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzd(int i10, zzei zzeiVar) {
        this.zza.zze(i10, zzeiVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zze(int i10, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zza.zze(i10, (zzei) list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzf(int i10, double d10) {
        this.zza.zzi(i10, Double.doubleToRawLongBits(d10));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzg(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzer)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzi(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Double) list.get(i13)).getClass();
                i12 += 8;
            }
            zzepVar.zzv(i12);
            while (i11 < list.size()) {
                zzepVar.zzj(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        zzer zzerVar = (zzer) list;
        if (!z10) {
            while (i11 < zzerVar.size()) {
                this.zza.zzi(i10, Double.doubleToRawLongBits(zzerVar.zze(i11)));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzerVar.size(); i15++) {
            zzerVar.zze(i15);
            i14 += 8;
        }
        zzepVar2.zzv(i14);
        while (i11 < zzerVar.size()) {
            zzepVar2.zzj(Double.doubleToRawLongBits(zzerVar.zze(i11)));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    @Deprecated
    public final void zzh(int i10) {
        this.zza.zzt(i10, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzi(int i10, int i11) {
        this.zza.zzk(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzj(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzfj)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzk(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int iZzD = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzD += zzep.zzD(((Integer) list.get(i12)).intValue());
            }
            zzepVar.zzv(iZzD);
            while (i11 < list.size()) {
                zzepVar.zzl(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzfj zzfjVar = (zzfj) list;
        if (!z10) {
            while (i11 < zzfjVar.size()) {
                this.zza.zzk(i10, zzfjVar.zze(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int iZzD2 = 0;
        for (int i13 = 0; i13 < zzfjVar.size(); i13++) {
            iZzD2 += zzep.zzD(zzfjVar.zze(i13));
        }
        zzepVar2.zzv(iZzD2);
        while (i11 < zzfjVar.size()) {
            zzepVar2.zzl(zzfjVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzk(int i10, int i11) {
        this.zza.zzg(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzl(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzfj)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzg(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).getClass();
                i12 += 4;
            }
            zzepVar.zzv(i12);
            while (i11 < list.size()) {
                zzepVar.zzh(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzfj zzfjVar = (zzfj) list;
        if (!z10) {
            while (i11 < zzfjVar.size()) {
                this.zza.zzg(i10, zzfjVar.zze(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzfjVar.size(); i15++) {
            zzfjVar.zze(i15);
            i14 += 4;
        }
        zzepVar2.zzv(i14);
        while (i11 < zzfjVar.size()) {
            zzepVar2.zzh(zzfjVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzm(int i10, long j10) {
        this.zza.zzi(i10, j10);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzn(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzga)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzi(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).getClass();
                i12 += 8;
            }
            zzepVar.zzv(i12);
            while (i11 < list.size()) {
                zzepVar.zzj(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzga zzgaVar = (zzga) list;
        if (!z10) {
            while (i11 < zzgaVar.size()) {
                this.zza.zzi(i10, zzgaVar.zze(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzgaVar.size(); i15++) {
            zzgaVar.zze(i15);
            i14 += 8;
        }
        zzepVar2.zzv(i14);
        while (i11 < zzgaVar.size()) {
            zzepVar2.zzj(zzgaVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzo(int i10, float f10) {
        this.zza.zzg(i10, Float.floatToRawIntBits(f10));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzp(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzfb)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzg(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Float) list.get(i13)).getClass();
                i12 += 4;
            }
            zzepVar.zzv(i12);
            while (i11 < list.size()) {
                zzepVar.zzh(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z10) {
            while (i11 < zzfbVar.size()) {
                this.zza.zzg(i10, Float.floatToRawIntBits(zzfbVar.zze(i11)));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzfbVar.size(); i15++) {
            zzfbVar.zze(i15);
            i14 += 4;
        }
        zzepVar2.zzv(i14);
        while (i11 < zzfbVar.size()) {
            zzepVar2.zzh(Float.floatToRawIntBits(zzfbVar.zze(i11)));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzq(int i10, Object obj, zzgv zzgvVar) {
        zzep zzepVar = this.zza;
        zzepVar.zzt(i10, 3);
        zzgvVar.zzi((zzgl) obj, zzepVar.zza);
        zzepVar.zzt(i10, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzr(int i10, int i11) {
        this.zza.zzk(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzs(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzfj)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzk(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int iZzD = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzD += zzep.zzD(((Integer) list.get(i12)).intValue());
            }
            zzepVar.zzv(iZzD);
            while (i11 < list.size()) {
                zzepVar.zzl(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzfj zzfjVar = (zzfj) list;
        if (!z10) {
            while (i11 < zzfjVar.size()) {
                this.zza.zzk(i10, zzfjVar.zze(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int iZzD2 = 0;
        for (int i13 = 0; i13 < zzfjVar.size(); i13++) {
            iZzD2 += zzep.zzD(zzfjVar.zze(i13));
        }
        zzepVar2.zzv(iZzD2);
        while (i11 < zzfjVar.size()) {
            zzepVar2.zzl(zzfjVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzt(int i10, long j10) {
        this.zza.zzw(i10, j10);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzu(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzga)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzw(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int iZzD = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzD += zzep.zzD(((Long) list.get(i12)).longValue());
            }
            zzepVar.zzv(iZzD);
            while (i11 < list.size()) {
                zzepVar.zzx(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zzga zzgaVar = (zzga) list;
        if (!z10) {
            while (i11 < zzgaVar.size()) {
                this.zza.zzw(i10, zzgaVar.zze(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int iZzD2 = 0;
        for (int i13 = 0; i13 < zzgaVar.size(); i13++) {
            iZzD2 += zzep.zzD(zzgaVar.zze(i13));
        }
        zzepVar2.zzv(iZzD2);
        while (i11 < zzgaVar.size()) {
            zzepVar2.zzx(zzgaVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzv(int i10, Object obj, zzgv zzgvVar) {
        this.zza.zzn(i10, (zzgl) obj, zzgvVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzw(int i10, Object obj) {
        if (obj instanceof zzei) {
            this.zza.zzq(i10, (zzei) obj);
        } else {
            this.zza.zzp(i10, (zzgl) obj);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzx(int i10, int i11) {
        this.zza.zzg(i10, i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzy(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzfj)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzg(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            zzep zzepVar = this.zza;
            zzepVar.zzt(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).getClass();
                i12 += 4;
            }
            zzepVar.zzv(i12);
            while (i11 < list.size()) {
                zzepVar.zzh(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzfj zzfjVar = (zzfj) list;
        if (!z10) {
            while (i11 < zzfjVar.size()) {
                this.zza.zzg(i10, zzfjVar.zze(i11));
                i11++;
            }
            return;
        }
        zzep zzepVar2 = this.zza;
        zzepVar2.zzt(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzfjVar.size(); i15++) {
            zzfjVar.zze(i15);
            i14 += 4;
        }
        zzepVar2.zzv(i14);
        while (i11 < zzfjVar.size()) {
            zzepVar2.zzh(zzfjVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzz(int i10, long j10) {
        this.zza.zzi(i10, j10);
    }
}
