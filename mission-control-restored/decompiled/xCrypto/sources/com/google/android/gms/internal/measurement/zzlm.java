package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzlm implements zzou {
    private final zzll zza;

    private zzlm(zzll zzllVar) {
        byte[] bArr = zzmo.zzb;
        this.zza = zzllVar;
        zzllVar.zza = this;
    }

    public static zzlm zza(zzll zzllVar) {
        zzlm zzlmVar = zzllVar.zza;
        return zzlmVar != null ? zzlmVar : new zzlm(zzllVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzA(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzf(i4, ((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).getClass();
                i6 += 8;
            }
            zzllVar.zzr(i6);
            while (i5 < list.size()) {
                zzllVar.zzu(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z4) {
            while (i5 < zzmzVar.size()) {
                this.zza.zzf(i4, zzmzVar.zzc(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzmzVar.size(); i9++) {
            zzmzVar.zzc(i9);
            i8 += 8;
        }
        zzllVar2.zzr(i8);
        while (i5 < zzmzVar.size()) {
            zzllVar2.zzu(zzmzVar.zzc(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzB(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzlx)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzd(i4, Float.floatToRawIntBits(((Float) list.get(i5)).floatValue()));
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Float) list.get(i7)).getClass();
                i6 += 4;
            }
            zzllVar.zzr(i6);
            while (i5 < list.size()) {
                zzllVar.zzs(Float.floatToRawIntBits(((Float) list.get(i5)).floatValue()));
                i5++;
            }
            return;
        }
        zzlx zzlxVar = (zzlx) list;
        if (!z4) {
            while (i5 < zzlxVar.size()) {
                this.zza.zzd(i4, Float.floatToRawIntBits(zzlxVar.zze(i5)));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzlxVar.size(); i9++) {
            zzlxVar.zze(i9);
            i8 += 4;
        }
        zzllVar2.zzr(i8);
        while (i5 < zzlxVar.size()) {
            zzllVar2.zzs(Float.floatToRawIntBits(zzlxVar.zze(i5)));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzC(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzln)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzf(i4, Double.doubleToRawLongBits(((Double) list.get(i5)).doubleValue()));
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Double) list.get(i7)).getClass();
                i6 += 8;
            }
            zzllVar.zzr(i6);
            while (i5 < list.size()) {
                zzllVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i5)).doubleValue()));
                i5++;
            }
            return;
        }
        zzln zzlnVar = (zzln) list;
        if (!z4) {
            while (i5 < zzlnVar.size()) {
                this.zza.zzf(i4, Double.doubleToRawLongBits(zzlnVar.zze(i5)));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzlnVar.size(); i9++) {
            zzlnVar.zze(i9);
            i8 += 8;
        }
        zzllVar2.zzr(i8);
        while (i5 < zzlnVar.size()) {
            zzllVar2.zzu(Double.doubleToRawLongBits(zzlnVar.zze(i5)));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzD(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmf)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzb(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzA += zzll.zzA(((Integer) list.get(i6)).intValue());
            }
            zzllVar.zzr(iZzA);
            while (i5 < list.size()) {
                zzllVar.zzq(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z4) {
            while (i5 < zzmfVar.size()) {
                this.zza.zzb(i4, zzmfVar.zzf(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzmfVar.size(); i7++) {
            iZzA2 += zzll.zzA(zzmfVar.zzf(i7));
        }
        zzllVar2.zzr(iZzA2);
        while (i5 < zzmfVar.size()) {
            zzllVar2.zzq(zzmfVar.zzf(i5));
            i5++;
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
    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzE(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzkx)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzg(i4, ((Boolean) list.get(i5)).booleanValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Boolean) list.get(i7)).getClass();
                i6++;
            }
            zzllVar.zzr(i6);
            while (i5 < list.size()) {
                zzllVar.zzp(((Boolean) list.get(i5)).booleanValue() ? (byte) 1 : (byte) 0);
                i5++;
            }
            return;
        }
        zzkx zzkxVar = (zzkx) list;
        if (!z4) {
            while (i5 < zzkxVar.size()) {
                this.zza.zzg(i4, zzkxVar.zze(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzkxVar.size(); i9++) {
            zzkxVar.zze(i9);
            i8++;
        }
        zzllVar2.zzr(i8);
        while (i5 < zzkxVar.size()) {
            zzllVar2.zzp(zzkxVar.zze(i5) ? (byte) 1 : (byte) 0);
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzF(int i4, List list) {
        int i5 = 0;
        if (!(list instanceof zzmw)) {
            while (i5 < list.size()) {
                this.zza.zzh(i4, (String) list.get(i5));
                i5++;
            }
            return;
        }
        zzmw zzmwVar = (zzmw) list;
        while (i5 < list.size()) {
            Object objZzc = zzmwVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzh(i4, (String) objZzc);
            } else {
                this.zza.zzi(i4, (zzlg) objZzc);
            }
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzG(int i4, List list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.zza.zzi(i4, (zzlg) list.get(i5));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzH(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmf)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzc(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int iZzz = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzz += zzll.zzz(((Integer) list.get(i6)).intValue());
            }
            zzllVar.zzr(iZzz);
            while (i5 < list.size()) {
                zzllVar.zzr(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z4) {
            while (i5 < zzmfVar.size()) {
                this.zza.zzc(i4, zzmfVar.zzf(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int iZzz2 = 0;
        for (int i7 = 0; i7 < zzmfVar.size(); i7++) {
            iZzz2 += zzll.zzz(zzmfVar.zzf(i7));
        }
        zzllVar2.zzr(iZzz2);
        while (i5 < zzmfVar.size()) {
            zzllVar2.zzr(zzmfVar.zzf(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzI(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmf)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzd(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).getClass();
                i6 += 4;
            }
            zzllVar.zzr(i6);
            while (i5 < list.size()) {
                zzllVar.zzs(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z4) {
            while (i5 < zzmfVar.size()) {
                this.zza.zzd(i4, zzmfVar.zzf(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzmfVar.size(); i9++) {
            zzmfVar.zzf(i9);
            i8 += 4;
        }
        zzllVar2.zzr(i8);
        while (i5 < zzmfVar.size()) {
            zzllVar2.zzs(zzmfVar.zzf(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzJ(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzf(i4, ((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Long) list.get(i7)).getClass();
                i6 += 8;
            }
            zzllVar.zzr(i6);
            while (i5 < list.size()) {
                zzllVar.zzu(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z4) {
            while (i5 < zzmzVar.size()) {
                this.zza.zzf(i4, zzmzVar.zzc(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzmzVar.size(); i9++) {
            zzmzVar.zzc(i9);
            i8 += 8;
        }
        zzllVar2.zzr(i8);
        while (i5 < zzmzVar.size()) {
            zzllVar2.zzu(zzmzVar.zzc(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzK(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmf)) {
            if (!z4) {
                while (i5 < list.size()) {
                    zzll zzllVar = this.zza;
                    int iIntValue = ((Integer) list.get(i5)).intValue();
                    zzllVar.zzc(i4, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i5++;
                }
                return;
            }
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i4, 2);
            int iZzz = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                int iIntValue2 = ((Integer) list.get(i6)).intValue();
                iZzz += zzll.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzllVar2.zzr(iZzz);
            while (i5 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i5)).intValue();
                zzllVar2.zzr((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i5++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z4) {
            while (i5 < zzmfVar.size()) {
                zzll zzllVar3 = this.zza;
                int iZzf = zzmfVar.zzf(i5);
                zzllVar3.zzc(i4, (iZzf >> 31) ^ (iZzf + iZzf));
                i5++;
            }
            return;
        }
        zzll zzllVar4 = this.zza;
        zzllVar4.zza(i4, 2);
        int iZzz2 = 0;
        for (int i7 = 0; i7 < zzmfVar.size(); i7++) {
            int iZzf2 = zzmfVar.zzf(i7);
            iZzz2 += zzll.zzz((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzllVar4.zzr(iZzz2);
        while (i5 < zzmfVar.size()) {
            int iZzf3 = zzmfVar.zzf(i5);
            zzllVar4.zzr((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzL(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    zzll zzllVar = this.zza;
                    long jLongValue = ((Long) list.get(i5)).longValue();
                    zzllVar.zze(i4, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i5++;
                }
                return;
            }
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                long jLongValue2 = ((Long) list.get(i6)).longValue();
                iZzA += zzll.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzllVar2.zzr(iZzA);
            while (i5 < list.size()) {
                long jLongValue3 = ((Long) list.get(i5)).longValue();
                zzllVar2.zzt((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i5++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z4) {
            while (i5 < zzmzVar.size()) {
                zzll zzllVar3 = this.zza;
                long jZzc = zzmzVar.zzc(i5);
                zzllVar3.zze(i4, (jZzc >> 63) ^ (jZzc + jZzc));
                i5++;
            }
            return;
        }
        zzll zzllVar4 = this.zza;
        zzllVar4.zza(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzmzVar.size(); i7++) {
            long jZzc2 = zzmzVar.zzc(i7);
            iZzA2 += zzll.zzA((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        zzllVar4.zzr(iZzA2);
        while (i5 < zzmzVar.size()) {
            long jZzc3 = zzmzVar.zzc(i5);
            zzllVar4.zzt((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzM(int i4, zznd zzndVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            zzllVar.zzr(zzne.zzc(zzndVar, entry.getKey(), entry.getValue()));
            zzne.zzb(zzllVar, zzndVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzb(int i4, int i5) {
        this.zza.zzd(i4, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzc(int i4, long j4) {
        this.zza.zze(i4, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzd(int i4, long j4) {
        this.zza.zzf(i4, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zze(int i4, float f4) {
        this.zza.zzd(i4, Float.floatToRawIntBits(f4));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzf(int i4, double d4) {
        this.zza.zzf(i4, Double.doubleToRawLongBits(d4));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzg(int i4, int i5) {
        this.zza.zzb(i4, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzh(int i4, long j4) {
        this.zza.zze(i4, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzi(int i4, int i5) {
        this.zza.zzb(i4, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzj(int i4, long j4) {
        this.zza.zzf(i4, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzk(int i4, int i5) {
        this.zza.zzd(i4, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzl(int i4, boolean z4) {
        this.zza.zzg(i4, z4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzm(int i4, String str) {
        this.zza.zzh(i4, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzn(int i4, zzlg zzlgVar) {
        this.zza.zzi(i4, zzlgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzo(int i4, int i5) {
        this.zza.zzc(i4, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzp(int i4, int i5) {
        this.zza.zzc(i4, (i5 >> 31) ^ (i5 + i5));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzq(int i4, long j4) {
        this.zza.zze(i4, (j4 >> 63) ^ (j4 + j4));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzr(int i4, Object obj, zznw zznwVar) {
        this.zza.zzl(i4, (zznl) obj, zznwVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzs(int i4, Object obj, zznw zznwVar) {
        zzll zzllVar = this.zza;
        zzllVar.zza(i4, 3);
        zznwVar.zzf((zznl) obj, zzllVar.zza);
        zzllVar.zza(i4, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    @Deprecated
    public final void zzt(int i4) {
        this.zza.zza(i4, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    @Deprecated
    public final void zzu(int i4) {
        this.zza.zza(i4, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzv(int i4, Object obj) {
        if (obj instanceof zzlg) {
            this.zza.zzn(i4, (zzlg) obj);
        } else {
            this.zza.zzm(i4, (zznl) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzw(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmf)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzb(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzA += zzll.zzA(((Integer) list.get(i6)).intValue());
            }
            zzllVar.zzr(iZzA);
            while (i5 < list.size()) {
                zzllVar.zzq(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z4) {
            while (i5 < zzmfVar.size()) {
                this.zza.zzb(i4, zzmfVar.zzf(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzmfVar.size(); i7++) {
            iZzA2 += zzll.zzA(zzmfVar.zzf(i7));
        }
        zzllVar2.zzr(iZzA2);
        while (i5 < zzmfVar.size()) {
            zzllVar2.zzq(zzmfVar.zzf(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzx(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmf)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzd(i4, ((Integer) list.get(i5)).intValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((Integer) list.get(i7)).getClass();
                i6 += 4;
            }
            zzllVar.zzr(i6);
            while (i5 < list.size()) {
                zzllVar.zzs(((Integer) list.get(i5)).intValue());
                i5++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z4) {
            while (i5 < zzmfVar.size()) {
                this.zza.zzd(i4, zzmfVar.zzf(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < zzmfVar.size(); i9++) {
            zzmfVar.zzf(i9);
            i8 += 4;
        }
        zzllVar2.zzr(i8);
        while (i5 < zzmfVar.size()) {
            zzllVar2.zzs(zzmfVar.zzf(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzy(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zze(i4, ((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzA += zzll.zzA(((Long) list.get(i6)).longValue());
            }
            zzllVar.zzr(iZzA);
            while (i5 < list.size()) {
                zzllVar.zzt(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z4) {
            while (i5 < zzmzVar.size()) {
                this.zza.zze(i4, zzmzVar.zzc(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzmzVar.size(); i7++) {
            iZzA2 += zzll.zzA(zzmzVar.zzc(i7));
        }
        zzllVar2.zzr(iZzA2);
        while (i5 < zzmzVar.size()) {
            zzllVar2.zzt(zzmzVar.zzc(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzz(int i4, List list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzmz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zze(i4, ((Long) list.get(i5)).longValue());
                    i5++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i4, 2);
            int iZzA = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzA += zzll.zzA(((Long) list.get(i6)).longValue());
            }
            zzllVar.zzr(iZzA);
            while (i5 < list.size()) {
                zzllVar.zzt(((Long) list.get(i5)).longValue());
                i5++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z4) {
            while (i5 < zzmzVar.size()) {
                this.zza.zze(i4, zzmzVar.zzc(i5));
                i5++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i4, 2);
        int iZzA2 = 0;
        for (int i7 = 0; i7 < zzmzVar.size(); i7++) {
            iZzA2 += zzll.zzA(zzmzVar.zzc(i7));
        }
        zzllVar2.zzr(iZzA2);
        while (i5 < zzmzVar.size()) {
            zzllVar2.zzt(zzmzVar.zzc(i5));
            i5++;
        }
    }
}
