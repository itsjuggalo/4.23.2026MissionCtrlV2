package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzln implements zzov {
    private final zzlm zza;

    private zzln(zzlm zzlmVar) {
        byte[] bArr = zzmp.zzb;
        this.zza = zzlmVar;
        zzlmVar.zza = this;
    }

    public static zzln zza(zzlm zzlmVar) {
        zzln zzlnVar = zzlmVar.zza;
        return zzlnVar != null ? zzlnVar : new zzln(zzlmVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzA(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzna)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzf(i8, ((Long) list.get(i9)).longValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Long) list.get(i11)).longValue();
                i10 += 8;
            }
            zzlmVar.zzr(i10);
            while (i9 < list.size()) {
                zzlmVar.zzu(((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z7) {
            while (i9 < zznaVar.size()) {
                this.zza.zzf(i8, zznaVar.zzc(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < zznaVar.size(); i13++) {
            zznaVar.zzc(i13);
            i12 += 8;
        }
        zzlmVar2.zzr(i12);
        while (i9 < zznaVar.size()) {
            zzlmVar2.zzu(zznaVar.zzc(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzB(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzly)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzd(i8, Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Float) list.get(i11)).floatValue();
                i10 += 4;
            }
            zzlmVar.zzr(i10);
            while (i9 < list.size()) {
                zzlmVar.zzs(Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
                i9++;
            }
            return;
        }
        zzly zzlyVar = (zzly) list;
        if (!z7) {
            while (i9 < zzlyVar.size()) {
                this.zza.zzd(i8, Float.floatToRawIntBits(zzlyVar.zze(i9)));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < zzlyVar.size(); i13++) {
            zzlyVar.zze(i13);
            i12 += 4;
        }
        zzlmVar2.zzr(i12);
        while (i9 < zzlyVar.size()) {
            zzlmVar2.zzs(Float.floatToRawIntBits(zzlyVar.zze(i9)));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzC(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzlo)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzf(i8, Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Double) list.get(i11)).doubleValue();
                i10 += 8;
            }
            zzlmVar.zzr(i10);
            while (i9 < list.size()) {
                zzlmVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
                i9++;
            }
            return;
        }
        zzlo zzloVar = (zzlo) list;
        if (!z7) {
            while (i9 < zzloVar.size()) {
                this.zza.zzf(i8, Double.doubleToRawLongBits(zzloVar.zze(i9)));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < zzloVar.size(); i13++) {
            zzloVar.zze(i13);
            i12 += 8;
        }
        zzlmVar2.zzr(i12);
        while (i9 < zzloVar.size()) {
            zzlmVar2.zzu(Double.doubleToRawLongBits(zzloVar.zze(i9)));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzD(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzmg)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzb(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int iZzA = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                iZzA += zzlm.zzA(((Integer) list.get(i10)).intValue());
            }
            zzlmVar.zzr(iZzA);
            while (i9 < list.size()) {
                zzlmVar.zzq(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z7) {
            while (i9 < zzmgVar.size()) {
                this.zza.zzb(i8, zzmgVar.zzf(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int iZzA2 = 0;
        for (int i11 = 0; i11 < zzmgVar.size(); i11++) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i11));
        }
        zzlmVar2.zzr(iZzA2);
        while (i9 < zzmgVar.size()) {
            zzlmVar2.zzq(zzmgVar.zzf(i9));
            i9++;
        }
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
    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzE(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzky)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzg(i8, ((Boolean) list.get(i9)).booleanValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Boolean) list.get(i11)).booleanValue();
                i10++;
            }
            zzlmVar.zzr(i10);
            while (i9 < list.size()) {
                zzlmVar.zzp(((Boolean) list.get(i9)).booleanValue() ? (byte) 1 : (byte) 0);
                i9++;
            }
            return;
        }
        zzky zzkyVar = (zzky) list;
        if (!z7) {
            while (i9 < zzkyVar.size()) {
                this.zza.zzg(i8, zzkyVar.zze(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < zzkyVar.size(); i13++) {
            zzkyVar.zze(i13);
            i12++;
        }
        zzlmVar2.zzr(i12);
        while (i9 < zzkyVar.size()) {
            zzlmVar2.zzp(zzkyVar.zze(i9) ? (byte) 1 : (byte) 0);
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzF(int i8, List list) {
        int i9 = 0;
        if (!(list instanceof zzmx)) {
            while (i9 < list.size()) {
                this.zza.zzh(i8, (String) list.get(i9));
                i9++;
            }
            return;
        }
        zzmx zzmxVar = (zzmx) list;
        while (i9 < list.size()) {
            Object objZzc = zzmxVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzh(i8, (String) objZzc);
            } else {
                this.zza.zzi(i8, (zzlh) objZzc);
            }
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzG(int i8, List list) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.zza.zzi(i8, (zzlh) list.get(i9));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzH(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzmg)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzc(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int iZzz = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                iZzz += zzlm.zzz(((Integer) list.get(i10)).intValue());
            }
            zzlmVar.zzr(iZzz);
            while (i9 < list.size()) {
                zzlmVar.zzr(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z7) {
            while (i9 < zzmgVar.size()) {
                this.zza.zzc(i8, zzmgVar.zzf(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int iZzz2 = 0;
        for (int i11 = 0; i11 < zzmgVar.size(); i11++) {
            iZzz2 += zzlm.zzz(zzmgVar.zzf(i11));
        }
        zzlmVar2.zzr(iZzz2);
        while (i9 < zzmgVar.size()) {
            zzlmVar2.zzr(zzmgVar.zzf(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzI(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzmg)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzd(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Integer) list.get(i11)).intValue();
                i10 += 4;
            }
            zzlmVar.zzr(i10);
            while (i9 < list.size()) {
                zzlmVar.zzs(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z7) {
            while (i9 < zzmgVar.size()) {
                this.zza.zzd(i8, zzmgVar.zzf(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < zzmgVar.size(); i13++) {
            zzmgVar.zzf(i13);
            i12 += 4;
        }
        zzlmVar2.zzr(i12);
        while (i9 < zzmgVar.size()) {
            zzlmVar2.zzs(zzmgVar.zzf(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzJ(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzna)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzf(i8, ((Long) list.get(i9)).longValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Long) list.get(i11)).longValue();
                i10 += 8;
            }
            zzlmVar.zzr(i10);
            while (i9 < list.size()) {
                zzlmVar.zzu(((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z7) {
            while (i9 < zznaVar.size()) {
                this.zza.zzf(i8, zznaVar.zzc(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < zznaVar.size(); i13++) {
            zznaVar.zzc(i13);
            i12 += 8;
        }
        zzlmVar2.zzr(i12);
        while (i9 < zznaVar.size()) {
            zzlmVar2.zzu(zznaVar.zzc(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzK(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzmg)) {
            if (!z7) {
                while (i9 < list.size()) {
                    zzlm zzlmVar = this.zza;
                    int iIntValue = ((Integer) list.get(i9)).intValue();
                    zzlmVar.zzc(i8, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i9++;
                }
                return;
            }
            zzlm zzlmVar2 = this.zza;
            zzlmVar2.zza(i8, 2);
            int iZzz = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                int iIntValue2 = ((Integer) list.get(i10)).intValue();
                iZzz += zzlm.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzlmVar2.zzr(iZzz);
            while (i9 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i9)).intValue();
                zzlmVar2.zzr((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i9++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z7) {
            while (i9 < zzmgVar.size()) {
                zzlm zzlmVar3 = this.zza;
                int iZzf = zzmgVar.zzf(i9);
                zzlmVar3.zzc(i8, (iZzf >> 31) ^ (iZzf + iZzf));
                i9++;
            }
            return;
        }
        zzlm zzlmVar4 = this.zza;
        zzlmVar4.zza(i8, 2);
        int iZzz2 = 0;
        for (int i11 = 0; i11 < zzmgVar.size(); i11++) {
            int iZzf2 = zzmgVar.zzf(i11);
            iZzz2 += zzlm.zzz((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzlmVar4.zzr(iZzz2);
        while (i9 < zzmgVar.size()) {
            int iZzf3 = zzmgVar.zzf(i9);
            zzlmVar4.zzr((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzL(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzna)) {
            if (!z7) {
                while (i9 < list.size()) {
                    zzlm zzlmVar = this.zza;
                    long jLongValue = ((Long) list.get(i9)).longValue();
                    zzlmVar.zze(i8, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i9++;
                }
                return;
            }
            zzlm zzlmVar2 = this.zza;
            zzlmVar2.zza(i8, 2);
            int iZzA = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                long jLongValue2 = ((Long) list.get(i10)).longValue();
                iZzA += zzlm.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzlmVar2.zzr(iZzA);
            while (i9 < list.size()) {
                long jLongValue3 = ((Long) list.get(i9)).longValue();
                zzlmVar2.zzt((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i9++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z7) {
            while (i9 < zznaVar.size()) {
                zzlm zzlmVar3 = this.zza;
                long jZzc = zznaVar.zzc(i9);
                zzlmVar3.zze(i8, (jZzc >> 63) ^ (jZzc + jZzc));
                i9++;
            }
            return;
        }
        zzlm zzlmVar4 = this.zza;
        zzlmVar4.zza(i8, 2);
        int iZzA2 = 0;
        for (int i11 = 0; i11 < zznaVar.size(); i11++) {
            long jZzc2 = zznaVar.zzc(i11);
            iZzA2 += zzlm.zzA((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        zzlmVar4.zzr(iZzA2);
        while (i9 < zznaVar.size()) {
            long jZzc3 = zznaVar.zzc(i9);
            zzlmVar4.zzt((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzM(int i8, zzne zzneVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            zzlmVar.zzr(zznf.zzc(zzneVar, entry.getKey(), entry.getValue()));
            zznf.zzb(zzlmVar, zzneVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzb(int i8, int i9) {
        this.zza.zzd(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzc(int i8, long j8) {
        this.zza.zze(i8, j8);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzd(int i8, long j8) {
        this.zza.zzf(i8, j8);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zze(int i8, float f8) {
        this.zza.zzd(i8, Float.floatToRawIntBits(f8));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzf(int i8, double d8) {
        this.zza.zzf(i8, Double.doubleToRawLongBits(d8));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzg(int i8, int i9) {
        this.zza.zzb(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzh(int i8, long j8) {
        this.zza.zze(i8, j8);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzi(int i8, int i9) {
        this.zza.zzb(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzj(int i8, long j8) {
        this.zza.zzf(i8, j8);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzk(int i8, int i9) {
        this.zza.zzd(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzl(int i8, boolean z7) {
        this.zza.zzg(i8, z7);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzm(int i8, String str) {
        this.zza.zzh(i8, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzn(int i8, zzlh zzlhVar) {
        this.zza.zzi(i8, zzlhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzo(int i8, int i9) {
        this.zza.zzc(i8, i9);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzp(int i8, int i9) {
        this.zza.zzc(i8, (i9 >> 31) ^ (i9 + i9));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzq(int i8, long j8) {
        this.zza.zze(i8, (j8 >> 63) ^ (j8 + j8));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzr(int i8, Object obj, zznx zznxVar) {
        this.zza.zzl(i8, (zznm) obj, zznxVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzs(int i8, Object obj, zznx zznxVar) {
        zzlm zzlmVar = this.zza;
        zzlmVar.zza(i8, 3);
        zznxVar.zzf((zznm) obj, zzlmVar.zza);
        zzlmVar.zza(i8, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    @Deprecated
    public final void zzt(int i8) {
        this.zza.zza(i8, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    @Deprecated
    public final void zzu(int i8) {
        this.zza.zza(i8, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzv(int i8, Object obj) {
        if (obj instanceof zzlh) {
            this.zza.zzn(i8, (zzlh) obj);
        } else {
            this.zza.zzm(i8, (zznm) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzw(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzmg)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzb(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int iZzA = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                iZzA += zzlm.zzA(((Integer) list.get(i10)).intValue());
            }
            zzlmVar.zzr(iZzA);
            while (i9 < list.size()) {
                zzlmVar.zzq(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z7) {
            while (i9 < zzmgVar.size()) {
                this.zza.zzb(i8, zzmgVar.zzf(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int iZzA2 = 0;
        for (int i11 = 0; i11 < zzmgVar.size(); i11++) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i11));
        }
        zzlmVar2.zzr(iZzA2);
        while (i9 < zzmgVar.size()) {
            zzlmVar2.zzq(zzmgVar.zzf(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzx(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzmg)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zzd(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Integer) list.get(i11)).intValue();
                i10 += 4;
            }
            zzlmVar.zzr(i10);
            while (i9 < list.size()) {
                zzlmVar.zzs(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z7) {
            while (i9 < zzmgVar.size()) {
                this.zza.zzd(i8, zzmgVar.zzf(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < zzmgVar.size(); i13++) {
            zzmgVar.zzf(i13);
            i12 += 4;
        }
        zzlmVar2.zzr(i12);
        while (i9 < zzmgVar.size()) {
            zzlmVar2.zzs(zzmgVar.zzf(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzy(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzna)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zze(i8, ((Long) list.get(i9)).longValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int iZzA = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                iZzA += zzlm.zzA(((Long) list.get(i10)).longValue());
            }
            zzlmVar.zzr(iZzA);
            while (i9 < list.size()) {
                zzlmVar.zzt(((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z7) {
            while (i9 < zznaVar.size()) {
                this.zza.zze(i8, zznaVar.zzc(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int iZzA2 = 0;
        for (int i11 = 0; i11 < zznaVar.size(); i11++) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i11));
        }
        zzlmVar2.zzr(iZzA2);
        while (i9 < zznaVar.size()) {
            zzlmVar2.zzt(zznaVar.zzc(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzz(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof zzna)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.zza.zze(i8, ((Long) list.get(i9)).longValue());
                    i9++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i8, 2);
            int iZzA = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                iZzA += zzlm.zzA(((Long) list.get(i10)).longValue());
            }
            zzlmVar.zzr(iZzA);
            while (i9 < list.size()) {
                zzlmVar.zzt(((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z7) {
            while (i9 < zznaVar.size()) {
                this.zza.zze(i8, zznaVar.zzc(i9));
                i9++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i8, 2);
        int iZzA2 = 0;
        for (int i11 = 0; i11 < zznaVar.size(); i11++) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i11));
        }
        zzlmVar2.zzr(iZzA2);
        while (i9 < zznaVar.size()) {
            zzlmVar2.zzt(zznaVar.zzc(i9));
            i9++;
        }
    }
}
