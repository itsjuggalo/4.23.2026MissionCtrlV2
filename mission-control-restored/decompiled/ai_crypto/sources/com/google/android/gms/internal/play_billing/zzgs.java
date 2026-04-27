package com.google.android.gms.internal.play_billing;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzgs implements zzjw {
    private final zzgr zza;

    private zzgs(zzgr zzgrVar) {
        byte[] bArr = zzhp.zzb;
        this.zza = zzgrVar;
        zzgrVar.zza = this;
    }

    public static zzgs zza(zzgr zzgrVar) {
        zzgs zzgsVar = zzgrVar.zza;
        return zzgsVar != null ? zzgsVar : new zzgs(zzgrVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzA(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzib)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzh(i7, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).longValue();
                i9 += 8;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzi(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z7) {
            while (i8 < zzibVar.size()) {
                this.zza.zzh(i7, zzibVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzibVar.size(); i12++) {
            zzibVar.zze(i12);
            i11 += 8;
        }
        this.zza.zzt(i11);
        while (i8 < zzibVar.size()) {
            this.zza.zzi(zzibVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzB(int i7, int i8) {
        this.zza.zzs(i7, (i8 >> 31) ^ (i8 + i8));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzC(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzhl)) {
            if (!z7) {
                while (i8 < list.size()) {
                    zzgr zzgrVar = this.zza;
                    int iIntValue = ((Integer) list.get(i8)).intValue();
                    zzgrVar.zzs(i7, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int iZzz = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                int iIntValue2 = ((Integer) list.get(i9)).intValue();
                iZzz += zzgr.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzt(iZzz);
            while (i8 < list.size()) {
                zzgr zzgrVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i8)).intValue();
                zzgrVar2.zzt((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i8++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z7) {
            while (i8 < zzhlVar.size()) {
                zzgr zzgrVar3 = this.zza;
                int iZze = zzhlVar.zze(i8);
                zzgrVar3.zzs(i7, (iZze >> 31) ^ (iZze + iZze));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int iZzz2 = 0;
        for (int i10 = 0; i10 < zzhlVar.size(); i10++) {
            int iZze2 = zzhlVar.zze(i10);
            iZzz2 += zzgr.zzz((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzt(iZzz2);
        while (i8 < zzhlVar.size()) {
            zzgr zzgrVar4 = this.zza;
            int iZze3 = zzhlVar.zze(i8);
            zzgrVar4.zzt((iZze3 >> 31) ^ (iZze3 + iZze3));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzD(int i7, long j7) {
        this.zza.zzu(i7, (j7 >> 63) ^ (j7 + j7));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzE(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzib)) {
            if (!z7) {
                while (i8 < list.size()) {
                    zzgr zzgrVar = this.zza;
                    long jLongValue = ((Long) list.get(i8)).longValue();
                    zzgrVar.zzu(i7, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                long jLongValue2 = ((Long) list.get(i9)).longValue();
                iZzA += zzgr.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzt(iZzA);
            while (i8 < list.size()) {
                zzgr zzgrVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i8)).longValue();
                zzgrVar2.zzv((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i8++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z7) {
            while (i8 < zzibVar.size()) {
                zzgr zzgrVar3 = this.zza;
                long jZze = zzibVar.zze(i8);
                zzgrVar3.zzu(i7, (jZze >> 63) ^ (jZze + jZze));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzibVar.size(); i10++) {
            long jZze2 = zzibVar.zze(i10);
            iZzA2 += zzgr.zzA((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzt(iZzA2);
        while (i8 < zzibVar.size()) {
            zzgr zzgrVar4 = this.zza;
            long jZze3 = zzibVar.zze(i8);
            zzgrVar4.zzv((jZze3 >> 63) ^ (jZze3 + jZze3));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    @Deprecated
    public final void zzF(int i7) {
        this.zza.zzr(i7, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzG(int i7, String str) {
        this.zza.zzp(i7, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzH(int i7, List list) {
        int i8 = 0;
        if (!(list instanceof zzhy)) {
            while (i8 < list.size()) {
                this.zza.zzp(i7, (String) list.get(i8));
                i8++;
            }
            return;
        }
        zzhy zzhyVar = (zzhy) list;
        while (i8 < list.size()) {
            Object objZzc = zzhyVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzp(i7, (String) objZzc);
            } else {
                this.zza.zze(i7, (zzgk) objZzc);
            }
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzI(int i7, int i8) {
        this.zza.zzs(i7, i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzJ(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzhl)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzs(i7, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int iZzz = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzz += zzgr.zzz(((Integer) list.get(i9)).intValue());
            }
            this.zza.zzt(iZzz);
            while (i8 < list.size()) {
                this.zza.zzt(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z7) {
            while (i8 < zzhlVar.size()) {
                this.zza.zzs(i7, zzhlVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int iZzz2 = 0;
        for (int i10 = 0; i10 < zzhlVar.size(); i10++) {
            iZzz2 += zzgr.zzz(zzhlVar.zze(i10));
        }
        this.zza.zzt(iZzz2);
        while (i8 < zzhlVar.size()) {
            this.zza.zzt(zzhlVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzK(int i7, long j7) {
        this.zza.zzu(i7, j7);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzL(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzib)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzu(i7, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzgr.zzA(((Long) list.get(i9)).longValue());
            }
            this.zza.zzt(iZzA);
            while (i8 < list.size()) {
                this.zza.zzv(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z7) {
            while (i8 < zzibVar.size()) {
                this.zza.zzu(i7, zzibVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzibVar.size(); i10++) {
            iZzA2 += zzgr.zzA(zzibVar.zze(i10));
        }
        this.zza.zzt(iZzA2);
        while (i8 < zzibVar.size()) {
            this.zza.zzv(zzibVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzb(int i7, boolean z7) {
        this.zza.zzd(i7, z7);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzc(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzgb)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzd(i7, ((Boolean) list.get(i8)).booleanValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Boolean) list.get(i10)).booleanValue();
                i9++;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i8)).booleanValue() ? (byte) 1 : (byte) 0);
                i8++;
            }
            return;
        }
        zzgb zzgbVar = (zzgb) list;
        if (!z7) {
            while (i8 < zzgbVar.size()) {
                this.zza.zzd(i7, zzgbVar.zzf(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzgbVar.size(); i12++) {
            zzgbVar.zzf(i12);
            i11++;
        }
        this.zza.zzt(i11);
        while (i8 < zzgbVar.size()) {
            this.zza.zzb(zzgbVar.zzf(i8) ? (byte) 1 : (byte) 0);
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzd(int i7, zzgk zzgkVar) {
        this.zza.zze(i7, zzgkVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zze(int i7, List list) {
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.zza.zze(i7, (zzgk) list.get(i8));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzf(int i7, double d7) {
        this.zza.zzh(i7, Double.doubleToRawLongBits(d7));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzg(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzgt)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzh(i7, Double.doubleToRawLongBits(((Double) list.get(i8)).doubleValue()));
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Double) list.get(i10)).doubleValue();
                i9 += 8;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i8)).doubleValue()));
                i8++;
            }
            return;
        }
        zzgt zzgtVar = (zzgt) list;
        if (!z7) {
            while (i8 < zzgtVar.size()) {
                this.zza.zzh(i7, Double.doubleToRawLongBits(zzgtVar.zze(i8)));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzgtVar.size(); i12++) {
            zzgtVar.zze(i12);
            i11 += 8;
        }
        this.zza.zzt(i11);
        while (i8 < zzgtVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzgtVar.zze(i8)));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    @Deprecated
    public final void zzh(int i7) {
        this.zza.zzr(i7, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzi(int i7, int i8) {
        this.zza.zzj(i7, i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzj(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzhl)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzj(i7, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzgr.zzA(((Integer) list.get(i9)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i8 < list.size()) {
                this.zza.zzk(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z7) {
            while (i8 < zzhlVar.size()) {
                this.zza.zzj(i7, zzhlVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzhlVar.size(); i10++) {
            iZzA2 += zzgr.zzA(zzhlVar.zze(i10));
        }
        this.zza.zzt(iZzA2);
        while (i8 < zzhlVar.size()) {
            this.zza.zzk(zzhlVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzk(int i7, int i8) {
        this.zza.zzf(i7, i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzl(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzhl)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzf(i7, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).intValue();
                i9 += 4;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzg(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z7) {
            while (i8 < zzhlVar.size()) {
                this.zza.zzf(i7, zzhlVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhlVar.size(); i12++) {
            zzhlVar.zze(i12);
            i11 += 4;
        }
        this.zza.zzt(i11);
        while (i8 < zzhlVar.size()) {
            this.zza.zzg(zzhlVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzm(int i7, long j7) {
        this.zza.zzh(i7, j7);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzn(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzib)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzh(i7, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).longValue();
                i9 += 8;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzi(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z7) {
            while (i8 < zzibVar.size()) {
                this.zza.zzh(i7, zzibVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzibVar.size(); i12++) {
            zzibVar.zze(i12);
            i11 += 8;
        }
        this.zza.zzt(i11);
        while (i8 < zzibVar.size()) {
            this.zza.zzi(zzibVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzo(int i7, float f7) {
        this.zza.zzf(i7, Float.floatToRawIntBits(f7));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzp(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzhd)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzf(i7, Float.floatToRawIntBits(((Float) list.get(i8)).floatValue()));
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Float) list.get(i10)).floatValue();
                i9 += 4;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i8)).floatValue()));
                i8++;
            }
            return;
        }
        zzhd zzhdVar = (zzhd) list;
        if (!z7) {
            while (i8 < zzhdVar.size()) {
                this.zza.zzf(i7, Float.floatToRawIntBits(zzhdVar.zze(i8)));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhdVar.size(); i12++) {
            zzhdVar.zze(i12);
            i11 += 4;
        }
        this.zza.zzt(i11);
        while (i8 < zzhdVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzhdVar.zze(i8)));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzq(int i7, Object obj, zzix zzixVar) {
        zzgr zzgrVar = this.zza;
        zzgrVar.zzr(i7, 3);
        zzixVar.zzi((zzim) obj, zzgrVar.zza);
        zzgrVar.zzr(i7, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzr(int i7, int i8) {
        this.zza.zzj(i7, i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzs(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzhl)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzj(i7, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzgr.zzA(((Integer) list.get(i9)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i8 < list.size()) {
                this.zza.zzk(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z7) {
            while (i8 < zzhlVar.size()) {
                this.zza.zzj(i7, zzhlVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzhlVar.size(); i10++) {
            iZzA2 += zzgr.zzA(zzhlVar.zze(i10));
        }
        this.zza.zzt(iZzA2);
        while (i8 < zzhlVar.size()) {
            this.zza.zzk(zzhlVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzt(int i7, long j7) {
        this.zza.zzu(i7, j7);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzu(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzib)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzu(i7, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzgr.zzA(((Long) list.get(i9)).longValue());
            }
            this.zza.zzt(iZzA);
            while (i8 < list.size()) {
                this.zza.zzv(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z7) {
            while (i8 < zzibVar.size()) {
                this.zza.zzu(i7, zzibVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzibVar.size(); i10++) {
            iZzA2 += zzgr.zzA(zzibVar.zze(i10));
        }
        this.zza.zzt(iZzA2);
        while (i8 < zzibVar.size()) {
            this.zza.zzv(zzibVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzv(int i7, Object obj, zzix zzixVar) {
        this.zza.zzm(i7, (zzim) obj, zzixVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzw(int i7, Object obj) {
        if (obj instanceof zzgk) {
            this.zza.zzo(i7, (zzgk) obj);
        } else {
            this.zza.zzn(i7, (zzim) obj);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzx(int i7, int i8) {
        this.zza.zzf(i7, i8);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzy(int i7, List list, boolean z7) {
        int i8 = 0;
        if (!(list instanceof zzhl)) {
            if (!z7) {
                while (i8 < list.size()) {
                    this.zza.zzf(i7, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i7, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).intValue();
                i9 += 4;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzg(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z7) {
            while (i8 < zzhlVar.size()) {
                this.zza.zzf(i7, zzhlVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i7, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhlVar.size(); i12++) {
            zzhlVar.zze(i12);
            i11 += 4;
        }
        this.zza.zzt(i11);
        while (i8 < zzhlVar.size()) {
            this.zza.zzg(zzhlVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzz(int i7, long j7) {
        this.zza.zzh(i7, j7);
    }
}
