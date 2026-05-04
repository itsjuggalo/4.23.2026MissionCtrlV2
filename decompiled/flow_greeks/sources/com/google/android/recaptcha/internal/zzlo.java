package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzlo implements zzpy {
    private final zzln zza;

    private zzlo(zzln zzlnVar) {
        byte[] bArr = zznl.zzb;
        this.zza = zzlnVar;
        zzlnVar.zza = this;
    }

    public static zzlo zza(zzln zzlnVar) {
        zzlo zzloVar = zzlnVar.zza;
        return zzloVar != null ? zzloVar : new zzlo(zzlnVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzA(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zznx)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzh(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).getClass();
                i12 += 8;
            }
            this.zza.zzt(i12);
            while (i11 < list.size()) {
                this.zza.zzi(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z10) {
            while (i11 < zznxVar.size()) {
                this.zza.zzh(i10, zznxVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zznxVar.size(); i15++) {
            zznxVar.zze(i15);
            i14 += 8;
        }
        this.zza.zzt(i14);
        while (i11 < zznxVar.size()) {
            this.zza.zzi(zznxVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzB(int i10, int i11) {
        this.zza.zzs(i10, (i11 >> 31) ^ (i11 + i11));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzC(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzne)) {
            if (!z10) {
                while (i11 < list.size()) {
                    zzln zzlnVar = this.zza;
                    int iIntValue = ((Integer) list.get(i11)).intValue();
                    zzlnVar.zzs(i10, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int iZzA = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                int iIntValue2 = ((Integer) list.get(i12)).intValue();
                iZzA += zzln.zzA((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzt(iZzA);
            while (i11 < list.size()) {
                zzln zzlnVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i11)).intValue();
                zzlnVar2.zzt((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i11++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z10) {
            while (i11 < zzneVar.size()) {
                zzln zzlnVar3 = this.zza;
                int iZze = zzneVar.zze(i11);
                zzlnVar3.zzs(i10, (iZze >> 31) ^ (iZze + iZze));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int iZzA2 = 0;
        for (int i13 = 0; i13 < zzneVar.size(); i13++) {
            int iZze2 = zzneVar.zze(i13);
            iZzA2 += zzln.zzA((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzt(iZzA2);
        while (i11 < zzneVar.size()) {
            zzln zzlnVar4 = this.zza;
            int iZze3 = zzneVar.zze(i11);
            zzlnVar4.zzt((iZze3 >> 31) ^ (iZze3 + iZze3));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzD(int i10, long j10) {
        this.zza.zzu(i10, (j10 >> 63) ^ (j10 + j10));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzE(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zznx)) {
            if (!z10) {
                while (i11 < list.size()) {
                    zzln zzlnVar = this.zza;
                    long jLongValue = ((Long) list.get(i11)).longValue();
                    zzlnVar.zzu(i10, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int iZzB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                long jLongValue2 = ((Long) list.get(i12)).longValue();
                iZzB += zzln.zzB((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzt(iZzB);
            while (i11 < list.size()) {
                zzln zzlnVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i11)).longValue();
                zzlnVar2.zzv((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i11++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z10) {
            while (i11 < zznxVar.size()) {
                zzln zzlnVar3 = this.zza;
                long jZze = zznxVar.zze(i11);
                zzlnVar3.zzu(i10, (jZze >> 63) ^ (jZze + jZze));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int iZzB2 = 0;
        for (int i13 = 0; i13 < zznxVar.size(); i13++) {
            long jZze2 = zznxVar.zze(i13);
            iZzB2 += zzln.zzB((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzt(iZzB2);
        while (i11 < zznxVar.size()) {
            zzln zzlnVar4 = this.zza;
            long jZze3 = zznxVar.zze(i11);
            zzlnVar4.zzv((jZze3 >> 63) ^ (jZze3 + jZze3));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    @Deprecated
    public final void zzF(int i10) {
        this.zza.zzr(i10, 3);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzG(int i10, String str) {
        this.zza.zzp(i10, str);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzH(int i10, List list) {
        int i11 = 0;
        if (!(list instanceof zznu)) {
            while (i11 < list.size()) {
                this.zza.zzp(i10, (String) list.get(i11));
                i11++;
            }
            return;
        }
        zznu zznuVar = (zznu) list;
        while (i11 < list.size()) {
            Object objZzc = zznuVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzp(i10, (String) objZzc);
            } else {
                this.zza.zze(i10, (zzle) objZzc);
            }
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzI(int i10, int i11) {
        this.zza.zzs(i10, i11);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzJ(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzne)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzs(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int iZzA = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzA += zzln.zzA(((Integer) list.get(i12)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i11 < list.size()) {
                this.zza.zzt(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z10) {
            while (i11 < zzneVar.size()) {
                this.zza.zzs(i10, zzneVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int iZzA2 = 0;
        for (int i13 = 0; i13 < zzneVar.size(); i13++) {
            iZzA2 += zzln.zzA(zzneVar.zze(i13));
        }
        this.zza.zzt(iZzA2);
        while (i11 < zzneVar.size()) {
            this.zza.zzt(zzneVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzK(int i10, long j10) {
        this.zza.zzu(i10, j10);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzL(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zznx)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzu(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int iZzB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzB += zzln.zzB(((Long) list.get(i12)).longValue());
            }
            this.zza.zzt(iZzB);
            while (i11 < list.size()) {
                this.zza.zzv(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z10) {
            while (i11 < zznxVar.size()) {
                this.zza.zzu(i10, zznxVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int iZzB2 = 0;
        for (int i13 = 0; i13 < zznxVar.size(); i13++) {
            iZzB2 += zzln.zzB(zznxVar.zze(i13));
        }
        this.zza.zzt(iZzB2);
        while (i11 < zznxVar.size()) {
            this.zza.zzv(zznxVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzb(int i10, boolean z10) {
        this.zza.zzd(i10, z10);
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
    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzc(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzkv)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzd(i10, ((Boolean) list.get(i11)).booleanValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Boolean) list.get(i13)).getClass();
                i12++;
            }
            this.zza.zzt(i12);
            while (i11 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : (byte) 0);
                i11++;
            }
            return;
        }
        zzkv zzkvVar = (zzkv) list;
        if (!z10) {
            while (i11 < zzkvVar.size()) {
                this.zza.zzd(i10, zzkvVar.zzf(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzkvVar.size(); i15++) {
            zzkvVar.zzf(i15);
            i14++;
        }
        this.zza.zzt(i14);
        while (i11 < zzkvVar.size()) {
            this.zza.zzb(zzkvVar.zzf(i11) ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzd(int i10, zzle zzleVar) {
        this.zza.zze(i10, zzleVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zze(int i10, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zza.zze(i10, (zzle) list.get(i11));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzf(int i10, double d10) {
        this.zza.zzh(i10, Double.doubleToRawLongBits(d10));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzg(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzmi)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzh(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Double) list.get(i13)).getClass();
                i12 += 8;
            }
            this.zza.zzt(i12);
            while (i11 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        zzmi zzmiVar = (zzmi) list;
        if (!z10) {
            while (i11 < zzmiVar.size()) {
                this.zza.zzh(i10, Double.doubleToRawLongBits(zzmiVar.zze(i11)));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzmiVar.size(); i15++) {
            zzmiVar.zze(i15);
            i14 += 8;
        }
        this.zza.zzt(i14);
        while (i11 < zzmiVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzmiVar.zze(i11)));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    @Deprecated
    public final void zzh(int i10) {
        this.zza.zzr(i10, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzi(int i10, int i11) {
        this.zza.zzj(i10, i11);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzj(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzne)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzj(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int iZzB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzB += zzln.zzB(((Integer) list.get(i12)).intValue());
            }
            this.zza.zzt(iZzB);
            while (i11 < list.size()) {
                this.zza.zzk(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z10) {
            while (i11 < zzneVar.size()) {
                this.zza.zzj(i10, zzneVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int iZzB2 = 0;
        for (int i13 = 0; i13 < zzneVar.size(); i13++) {
            iZzB2 += zzln.zzB(zzneVar.zze(i13));
        }
        this.zza.zzt(iZzB2);
        while (i11 < zzneVar.size()) {
            this.zza.zzk(zzneVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzk(int i10, int i11) {
        this.zza.zzf(i10, i11);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzl(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzne)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzf(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).getClass();
                i12 += 4;
            }
            this.zza.zzt(i12);
            while (i11 < list.size()) {
                this.zza.zzg(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z10) {
            while (i11 < zzneVar.size()) {
                this.zza.zzf(i10, zzneVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzneVar.size(); i15++) {
            zzneVar.zze(i15);
            i14 += 4;
        }
        this.zza.zzt(i14);
        while (i11 < zzneVar.size()) {
            this.zza.zzg(zzneVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzm(int i10, long j10) {
        this.zza.zzh(i10, j10);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzn(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zznx)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzh(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).getClass();
                i12 += 8;
            }
            this.zza.zzt(i12);
            while (i11 < list.size()) {
                this.zza.zzi(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z10) {
            while (i11 < zznxVar.size()) {
                this.zza.zzh(i10, zznxVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zznxVar.size(); i15++) {
            zznxVar.zze(i15);
            i14 += 8;
        }
        this.zza.zzt(i14);
        while (i11 < zznxVar.size()) {
            this.zza.zzi(zznxVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzo(int i10, float f10) {
        this.zza.zzf(i10, Float.floatToRawIntBits(f10));
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzp(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzmv)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzf(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Float) list.get(i13)).getClass();
                i12 += 4;
            }
            this.zza.zzt(i12);
            while (i11 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        zzmv zzmvVar = (zzmv) list;
        if (!z10) {
            while (i11 < zzmvVar.size()) {
                this.zza.zzf(i10, Float.floatToRawIntBits(zzmvVar.zze(i11)));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzmvVar.size(); i15++) {
            zzmvVar.zze(i15);
            i14 += 4;
        }
        this.zza.zzt(i14);
        while (i11 < zzmvVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzmvVar.zze(i11)));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzq(int i10, Object obj, zzow zzowVar) {
        zzln zzlnVar = this.zza;
        zzlnVar.zzr(i10, 3);
        zzowVar.zzj((zzoi) obj, zzlnVar.zza);
        zzlnVar.zzr(i10, 4);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzr(int i10, int i11) {
        this.zza.zzj(i10, i11);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzs(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzne)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzj(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int iZzB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzB += zzln.zzB(((Integer) list.get(i12)).intValue());
            }
            this.zza.zzt(iZzB);
            while (i11 < list.size()) {
                this.zza.zzk(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z10) {
            while (i11 < zzneVar.size()) {
                this.zza.zzj(i10, zzneVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int iZzB2 = 0;
        for (int i13 = 0; i13 < zzneVar.size(); i13++) {
            iZzB2 += zzln.zzB(zzneVar.zze(i13));
        }
        this.zza.zzt(iZzB2);
        while (i11 < zzneVar.size()) {
            this.zza.zzk(zzneVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzt(int i10, long j10) {
        this.zza.zzu(i10, j10);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzu(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zznx)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzu(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int iZzB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzB += zzln.zzB(((Long) list.get(i12)).longValue());
            }
            this.zza.zzt(iZzB);
            while (i11 < list.size()) {
                this.zza.zzv(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        zznx zznxVar = (zznx) list;
        if (!z10) {
            while (i11 < zznxVar.size()) {
                this.zza.zzu(i10, zznxVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int iZzB2 = 0;
        for (int i13 = 0; i13 < zznxVar.size(); i13++) {
            iZzB2 += zzln.zzB(zznxVar.zze(i13));
        }
        this.zza.zzt(iZzB2);
        while (i11 < zznxVar.size()) {
            this.zza.zzv(zznxVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzv(int i10, Object obj, zzow zzowVar) {
        this.zza.zzm(i10, (zzoi) obj, zzowVar);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzw(int i10, Object obj) {
        if (obj instanceof zzle) {
            this.zza.zzo(i10, (zzle) obj);
        } else {
            this.zza.zzn(i10, (zzoi) obj);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzx(int i10, int i11) {
        this.zza.zzf(i10, i11);
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzy(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof zzne)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.zza.zzf(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.zza.zzr(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).getClass();
                i12 += 4;
            }
            this.zza.zzt(i12);
            while (i11 < list.size()) {
                this.zza.zzg(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        zzne zzneVar = (zzne) list;
        if (!z10) {
            while (i11 < zzneVar.size()) {
                this.zza.zzf(i10, zzneVar.zze(i11));
                i11++;
            }
            return;
        }
        this.zza.zzr(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < zzneVar.size(); i15++) {
            zzneVar.zze(i15);
            i14 += 4;
        }
        this.zza.zzt(i14);
        while (i11 < zzneVar.size()) {
            this.zza.zzg(zzneVar.zze(i11));
            i11++;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpy
    public final void zzz(int i10, long j10) {
        this.zza.zzh(i10, j10);
    }
}
