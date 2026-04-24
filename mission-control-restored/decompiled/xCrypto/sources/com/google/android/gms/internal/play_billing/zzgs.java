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
    public final void zzA(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzib)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzh(i4, ((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).getClass();
                i6 += 8;
            }
            this.zza.zzt(i6);
            while (i5 < list.size()) {
                this.zza.zzi(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z4) {
            while (i5 < zzibVar.size()) {
                this.zza.zzh(i4, zzibVar.zze(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzibVar.size(); i9++) {
            zzibVar.zze(i9);
            i8 += 8;
        }
        this.zza.zzt(i8);
        while (i5 < zzibVar.size()) {
            this.zza.zzi(zzibVar.zze(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzB(int i4, int i5) {
        this.zza.zzs(i4, (i5 >> 31) ^ (i5 + i5));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzC(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzhl)) {
            if (!z4) {
                while (i5 < list.size()) {
                    zzgr zzgrVar = this.zza;
                    int iIntValue = ((Integer) list.get(i5)).intValue();
                    zzgrVar.zzs(i4, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int iZzz = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                int iIntValue2 = ((Integer) list.get(i6)).intValue();
                iZzz += zzgr.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzt(iZzz);
            while (i5 < list.size()) {
                zzgr zzgrVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i5)).intValue();
                zzgrVar2.zzt((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i5++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z4) {
            while (i5 < zzhlVar.size()) {
                zzgr zzgrVar3 = this.zza;
                int iZze = zzhlVar.zze(i5);
                zzgrVar3.zzs(i4, (iZze >> 31) ^ (iZze + iZze));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int iZzz2 = 0;
        for (int i7 = 0; i7 < zzhlVar.size(); i7++) {
            int iZze2 = zzhlVar.zze(i7);
            iZzz2 += zzgr.zzz((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzt(iZzz2);
        while (i5 < zzhlVar.size()) {
            zzgr zzgrVar4 = this.zza;
            int iZze3 = zzhlVar.zze(i5);
            zzgrVar4.zzt((iZze3 >> 31) ^ (iZze3 + iZze3));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzD(int i4, long j4) {
        this.zza.zzu(i4, (j4 >> 63) ^ (j4 + j4));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzE(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzib)) {
            if (!z4) {
                while (i5 < list.size()) {
                    zzgr zzgrVar = this.zza;
                    long jLongValue = ((Long) list.get(i5)).longValue();
                    zzgrVar.zzu(i4, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                long jLongValue2 = ((Long) list.get(i6)).longValue();
                iZzA += zzgr.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzt(iZzA);
            while (i5 < list.size()) {
                zzgr zzgrVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i5)).longValue();
                zzgrVar2.zzv((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i5++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z4) {
            while (i5 < zzibVar.size()) {
                zzgr zzgrVar3 = this.zza;
                long jZze = zzibVar.zze(i5);
                zzgrVar3.zzu(i4, (jZze >> 63) ^ (jZze + jZze));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzibVar.size(); i7++) {
            long jZze2 = zzibVar.zze(i7);
            iZzA2 += zzgr.zzA((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzt(iZzA2);
        while (i5 < zzibVar.size()) {
            zzgr zzgrVar4 = this.zza;
            long jZze3 = zzibVar.zze(i5);
            zzgrVar4.zzv((jZze3 >> 63) ^ (jZze3 + jZze3));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    @Deprecated
    public final void zzF(int i4) {
        this.zza.zzr(i4, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzG(int i4, String str) {
        this.zza.zzp(i4, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzH(int i4, List list) {
        int i5 = 0;
        if (!(list instanceof zzhy)) {
            while (i5 < list.size()) {
                this.zza.zzp(i4, (String) list.get(i5));
                i5++;
            }
            return;
        }
        zzhy zzhyVar = (zzhy) list;
        while (i5 < list.size()) {
            Object objZzc = zzhyVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzp(i4, (String) objZzc);
            } else {
                this.zza.zze(i4, (zzgk) objZzc);
            }
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzI(int i4, int i5) {
        this.zza.zzs(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzJ(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzhl)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzs(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int iZzz = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzz += zzgr.zzz(((Integer) list.get(i6)).intValue());
            }
            this.zza.zzt(iZzz);
            while (i5 < list.size()) {
                this.zza.zzt(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z4) {
            while (i5 < zzhlVar.size()) {
                this.zza.zzs(i4, zzhlVar.zze(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int iZzz2 = 0;
        for (int i7 = 0; i7 < zzhlVar.size(); i7++) {
            iZzz2 += zzgr.zzz(zzhlVar.zze(i7));
        }
        this.zza.zzt(iZzz2);
        while (i5 < zzhlVar.size()) {
            this.zza.zzt(zzhlVar.zze(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzK(int i4, long j4) {
        this.zza.zzu(i4, j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzL(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzib)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzu(i4, ((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzA += zzgr.zzA(((Long) list.get(i6)).longValue());
            }
            this.zza.zzt(iZzA);
            while (i5 < list.size()) {
                this.zza.zzv(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z4) {
            while (i5 < zzibVar.size()) {
                this.zza.zzu(i4, zzibVar.zze(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzibVar.size(); i7++) {
            iZzA2 += zzgr.zzA(zzibVar.zze(i7));
        }
        this.zza.zzt(iZzA2);
        while (i5 < zzibVar.size()) {
            this.zza.zzv(zzibVar.zze(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzb(int i4, boolean z4) {
        this.zza.zzd(i4, z4);
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
    public final void zzc(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzgb)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzd(i4, ((Boolean) list.get(i5)).booleanValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Boolean) list.get(i7)).getClass();
                i6++;
            }
            this.zza.zzt(i6);
            while (i5 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i5)).booleanValue() ? (byte) 1 : (byte) 0);
                i5++;
            }
            return;
        }
        zzgb zzgbVar = (zzgb) list;
        if (!z4) {
            while (i5 < zzgbVar.size()) {
                this.zza.zzd(i4, zzgbVar.zzf(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzgbVar.size(); i9++) {
            zzgbVar.zzf(i9);
            i8++;
        }
        this.zza.zzt(i8);
        while (i5 < zzgbVar.size()) {
            this.zza.zzb(zzgbVar.zzf(i5) ? (byte) 1 : (byte) 0);
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzd(int i4, zzgk zzgkVar) {
        this.zza.zze(i4, zzgkVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zze(int i4, List list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.zza.zze(i4, (zzgk) list.get(i5));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzf(int i4, double d4) {
        this.zza.zzh(i4, Double.doubleToRawLongBits(d4));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzg(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzgt)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzh(i4, Double.doubleToRawLongBits(((Double) list.get(i5)).doubleValue()));
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Double) list.get(i7)).getClass();
                i6 += 8;
            }
            this.zza.zzt(i6);
            while (i5 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i5)).doubleValue()));
                i5++;
            }
            return;
        }
        zzgt zzgtVar = (zzgt) list;
        if (!z4) {
            while (i5 < zzgtVar.size()) {
                this.zza.zzh(i4, Double.doubleToRawLongBits(zzgtVar.zze(i5)));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzgtVar.size(); i9++) {
            zzgtVar.zze(i9);
            i8 += 8;
        }
        this.zza.zzt(i8);
        while (i5 < zzgtVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzgtVar.zze(i5)));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    @Deprecated
    public final void zzh(int i4) {
        this.zza.zzr(i4, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzi(int i4, int i5) {
        this.zza.zzj(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzj(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzhl)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzj(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzA += zzgr.zzA(((Integer) list.get(i6)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i5 < list.size()) {
                this.zza.zzk(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z4) {
            while (i5 < zzhlVar.size()) {
                this.zza.zzj(i4, zzhlVar.zze(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzhlVar.size(); i7++) {
            iZzA2 += zzgr.zzA(zzhlVar.zze(i7));
        }
        this.zza.zzt(iZzA2);
        while (i5 < zzhlVar.size()) {
            this.zza.zzk(zzhlVar.zze(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzk(int i4, int i5) {
        this.zza.zzf(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzl(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzhl)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzf(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).getClass();
                i6 += 4;
            }
            this.zza.zzt(i6);
            while (i5 < list.size()) {
                this.zza.zzg(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z4) {
            while (i5 < zzhlVar.size()) {
                this.zza.zzf(i4, zzhlVar.zze(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzhlVar.size(); i9++) {
            zzhlVar.zze(i9);
            i8 += 4;
        }
        this.zza.zzt(i8);
        while (i5 < zzhlVar.size()) {
            this.zza.zzg(zzhlVar.zze(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzm(int i4, long j4) {
        this.zza.zzh(i4, j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzn(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzib)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzh(i4, ((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).getClass();
                i6 += 8;
            }
            this.zza.zzt(i6);
            while (i5 < list.size()) {
                this.zza.zzi(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z4) {
            while (i5 < zzibVar.size()) {
                this.zza.zzh(i4, zzibVar.zze(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzibVar.size(); i9++) {
            zzibVar.zze(i9);
            i8 += 8;
        }
        this.zza.zzt(i8);
        while (i5 < zzibVar.size()) {
            this.zza.zzi(zzibVar.zze(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzo(int i4, float f4) {
        this.zza.zzf(i4, Float.floatToRawIntBits(f4));
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzp(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzhd)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzf(i4, Float.floatToRawIntBits(((Float) list.get(i5)).floatValue()));
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Float) list.get(i7)).getClass();
                i6 += 4;
            }
            this.zza.zzt(i6);
            while (i5 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i5)).floatValue()));
                i5++;
            }
            return;
        }
        zzhd zzhdVar = (zzhd) list;
        if (!z4) {
            while (i5 < zzhdVar.size()) {
                this.zza.zzf(i4, Float.floatToRawIntBits(zzhdVar.zze(i5)));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzhdVar.size(); i9++) {
            zzhdVar.zze(i9);
            i8 += 4;
        }
        this.zza.zzt(i8);
        while (i5 < zzhdVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzhdVar.zze(i5)));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzq(int i4, Object obj, zzix zzixVar) {
        zzgr zzgrVar = this.zza;
        zzgrVar.zzr(i4, 3);
        zzixVar.zzi((zzim) obj, zzgrVar.zza);
        zzgrVar.zzr(i4, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzr(int i4, int i5) {
        this.zza.zzj(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzs(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzhl)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzj(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzA += zzgr.zzA(((Integer) list.get(i6)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i5 < list.size()) {
                this.zza.zzk(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z4) {
            while (i5 < zzhlVar.size()) {
                this.zza.zzj(i4, zzhlVar.zze(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzhlVar.size(); i7++) {
            iZzA2 += zzgr.zzA(zzhlVar.zze(i7));
        }
        this.zza.zzt(iZzA2);
        while (i5 < zzhlVar.size()) {
            this.zza.zzk(zzhlVar.zze(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzt(int i4, long j4) {
        this.zza.zzu(i4, j4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzu(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzib)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzu(i4, ((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzA += zzgr.zzA(((Long) list.get(i6)).longValue());
            }
            this.zza.zzt(iZzA);
            while (i5 < list.size()) {
                this.zza.zzv(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        zzib zzibVar = (zzib) list;
        if (!z4) {
            while (i5 < zzibVar.size()) {
                this.zza.zzu(i4, zzibVar.zze(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzibVar.size(); i7++) {
            iZzA2 += zzgr.zzA(zzibVar.zze(i7));
        }
        this.zza.zzt(iZzA2);
        while (i5 < zzibVar.size()) {
            this.zza.zzv(zzibVar.zze(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzv(int i4, Object obj, zzix zzixVar) {
        this.zza.zzm(i4, (zzim) obj, zzixVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzw(int i4, Object obj) {
        if (obj instanceof zzgk) {
            this.zza.zzo(i4, (zzgk) obj);
        } else {
            this.zza.zzn(i4, (zzim) obj);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzx(int i4, int i5) {
        this.zza.zzf(i4, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzy(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzhl)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzf(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzr(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).getClass();
                i6 += 4;
            }
            this.zza.zzt(i6);
            while (i5 < list.size()) {
                this.zza.zzg(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzhl zzhlVar = (zzhl) list;
        if (!z4) {
            while (i5 < zzhlVar.size()) {
                this.zza.zzf(i4, zzhlVar.zze(i5));
                i5++;
            }
            return;
        }
        this.zza.zzr(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzhlVar.size(); i9++) {
            zzhlVar.zze(i9);
            i8 += 4;
        }
        this.zza.zzt(i8);
        while (i5 < zzhlVar.size()) {
            this.zza.zzg(zzhlVar.zze(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzjw
    public final void zzz(int i4, long j4) {
        this.zza.zzh(i4, j4);
    }
}
