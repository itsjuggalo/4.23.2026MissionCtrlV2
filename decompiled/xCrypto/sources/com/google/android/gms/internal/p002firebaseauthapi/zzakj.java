package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzakj implements zzaof {
    private final zzakg zza;

    private zzakj(zzakg zzakgVar) {
        zzakg zzakgVar2 = (zzakg) zzalb.zza(zzakgVar, "output");
        this.zza = zzakgVar2;
        zzakgVar2.zze = this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i4, List<Double> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzaki)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzb(i4, list.get(i5).doubleValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZza = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZza += zzakg.zza(list.get(i6).doubleValue());
            }
            this.zza.zzn(iZza);
            while (i5 < list.size()) {
                this.zza.zzb(list.get(i5).doubleValue());
                i5++;
            }
            return;
        }
        zzaki zzakiVar = (zzaki) list;
        if (!z4) {
            while (i5 < zzakiVar.size()) {
                this.zza.zzb(i4, zzakiVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZza2 = 0;
        for (int i7 = 0; i7 < zzakiVar.size(); i7++) {
            iZza2 += zzakg.zza(zzakiVar.zzb(i7));
        }
        this.zza.zzn(iZza2);
        while (i5 < zzakiVar.size()) {
            this.zza.zzb(zzakiVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzc(int i4, List<Integer> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzakz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzi(i4, list.get(i5).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZzc = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzc += zzakg.zzc(list.get(i6).intValue());
            }
            this.zza.zzn(iZzc);
            while (i5 < list.size()) {
                this.zza.zzl(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        zzakz zzakzVar = (zzakz) list;
        if (!z4) {
            while (i5 < zzakzVar.size()) {
                this.zza.zzi(i4, zzakzVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZzc2 = 0;
        for (int i7 = 0; i7 < zzakzVar.size(); i7++) {
            iZzc2 += zzakg.zzc(zzakzVar.zzb(i7));
        }
        this.zza.zzn(iZzc2);
        while (i5 < zzakzVar.size()) {
            this.zza.zzl(zzakzVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzd(int i4, List<Integer> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzakz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzh(i4, list.get(i5).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZzd = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzd += zzakg.zzd(list.get(i6).intValue());
            }
            this.zza.zzn(iZzd);
            while (i5 < list.size()) {
                this.zza.zzk(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        zzakz zzakzVar = (zzakz) list;
        if (!z4) {
            while (i5 < zzakzVar.size()) {
                this.zza.zzh(i4, zzakzVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZzd2 = 0;
        for (int i7 = 0; i7 < zzakzVar.size(); i7++) {
            iZzd2 += zzakg.zzd(zzakzVar.zzb(i7));
        }
        this.zza.zzn(iZzd2);
        while (i5 < zzakzVar.size()) {
            this.zza.zzk(zzakzVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zze(int i4, List<Long> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzalr)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzf(i4, list.get(i5).longValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZzc = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzc += zzakg.zzc(list.get(i6).longValue());
            }
            this.zza.zzn(iZzc);
            while (i5 < list.size()) {
                this.zza.zzh(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        zzalr zzalrVar = (zzalr) list;
        if (!z4) {
            while (i5 < zzalrVar.size()) {
                this.zza.zzf(i4, zzalrVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZzc2 = 0;
        for (int i7 = 0; i7 < zzalrVar.size(); i7++) {
            iZzc2 += zzakg.zzc(zzalrVar.zzb(i7));
        }
        this.zza.zzn(iZzc2);
        while (i5 < zzalrVar.size()) {
            this.zza.zzh(zzalrVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzf(int i4, List<Float> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzakx)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzb(i4, list.get(i5).floatValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZza = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZza += zzakg.zza(list.get(i6).floatValue());
            }
            this.zza.zzn(iZza);
            while (i5 < list.size()) {
                this.zza.zzb(list.get(i5).floatValue());
                i5++;
            }
            return;
        }
        zzakx zzakxVar = (zzakx) list;
        if (!z4) {
            while (i5 < zzakxVar.size()) {
                this.zza.zzb(i4, zzakxVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZza2 = 0;
        for (int i7 = 0; i7 < zzakxVar.size(); i7++) {
            iZza2 += zzakg.zza(zzakxVar.zzb(i7));
        }
        this.zza.zzn(iZza2);
        while (i5 < zzakxVar.size()) {
            this.zza.zzb(zzakxVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzg(int i4, List<Integer> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzakz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzi(i4, list.get(i5).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZze = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZze += zzakg.zze(list.get(i6).intValue());
            }
            this.zza.zzn(iZze);
            while (i5 < list.size()) {
                this.zza.zzl(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        zzakz zzakzVar = (zzakz) list;
        if (!z4) {
            while (i5 < zzakzVar.size()) {
                this.zza.zzi(i4, zzakzVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZze2 = 0;
        for (int i7 = 0; i7 < zzakzVar.size(); i7++) {
            iZze2 += zzakg.zze(zzakzVar.zzb(i7));
        }
        this.zza.zzn(iZze2);
        while (i5 < zzakzVar.size()) {
            this.zza.zzl(zzakzVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzh(int i4, List<Long> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzalr)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzh(i4, list.get(i5).longValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZzd = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzd += zzakg.zzd(list.get(i6).longValue());
            }
            this.zza.zzn(iZzd);
            while (i5 < list.size()) {
                this.zza.zzj(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        zzalr zzalrVar = (zzalr) list;
        if (!z4) {
            while (i5 < zzalrVar.size()) {
                this.zza.zzh(i4, zzalrVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZzd2 = 0;
        for (int i7 = 0; i7 < zzalrVar.size(); i7++) {
            iZzd2 += zzakg.zzd(zzalrVar.zzb(i7));
        }
        this.zza.zzn(iZzd2);
        while (i5 < zzalrVar.size()) {
            this.zza.zzj(zzalrVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzi(int i4, List<Integer> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzakz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzh(i4, list.get(i5).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZzg = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzg += zzakg.zzg(list.get(i6).intValue());
            }
            this.zza.zzn(iZzg);
            while (i5 < list.size()) {
                this.zza.zzk(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        zzakz zzakzVar = (zzakz) list;
        if (!z4) {
            while (i5 < zzakzVar.size()) {
                this.zza.zzh(i4, zzakzVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZzg2 = 0;
        for (int i7 = 0; i7 < zzakzVar.size(); i7++) {
            iZzg2 += zzakg.zzg(zzakzVar.zzb(i7));
        }
        this.zza.zzn(iZzg2);
        while (i5 < zzakzVar.size()) {
            this.zza.zzk(zzakzVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzj(int i4, List<Long> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzalr)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzf(i4, list.get(i5).longValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZze = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZze += zzakg.zze(list.get(i6).longValue());
            }
            this.zza.zzn(iZze);
            while (i5 < list.size()) {
                this.zza.zzh(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        zzalr zzalrVar = (zzalr) list;
        if (!z4) {
            while (i5 < zzalrVar.size()) {
                this.zza.zzf(i4, zzalrVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZze2 = 0;
        for (int i7 = 0; i7 < zzalrVar.size(); i7++) {
            iZze2 += zzakg.zze(zzalrVar.zzb(i7));
        }
        this.zza.zzn(iZze2);
        while (i5 < zzalrVar.size()) {
            this.zza.zzh(zzalrVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzk(int i4, List<Integer> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzakz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzj(i4, list.get(i5).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZzh = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzh += zzakg.zzh(list.get(i6).intValue());
            }
            this.zza.zzn(iZzh);
            while (i5 < list.size()) {
                this.zza.zzm(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        zzakz zzakzVar = (zzakz) list;
        if (!z4) {
            while (i5 < zzakzVar.size()) {
                this.zza.zzj(i4, zzakzVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZzh2 = 0;
        for (int i7 = 0; i7 < zzakzVar.size(); i7++) {
            iZzh2 += zzakg.zzh(zzakzVar.zzb(i7));
        }
        this.zza.zzn(iZzh2);
        while (i5 < zzakzVar.size()) {
            this.zza.zzm(zzakzVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzl(int i4, List<Long> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzalr)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzg(i4, list.get(i5).longValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZzf = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzf += zzakg.zzf(list.get(i6).longValue());
            }
            this.zza.zzn(iZzf);
            while (i5 < list.size()) {
                this.zza.zzi(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        zzalr zzalrVar = (zzalr) list;
        if (!z4) {
            while (i5 < zzalrVar.size()) {
                this.zza.zzg(i4, zzalrVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZzf2 = 0;
        for (int i7 = 0; i7 < zzalrVar.size(); i7++) {
            iZzf2 += zzakg.zzf(zzalrVar.zzb(i7));
        }
        this.zza.zzn(iZzf2);
        while (i5 < zzalrVar.size()) {
            this.zza.zzi(zzalrVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzm(int i4, List<Integer> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzakz)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzl(i4, list.get(i5).intValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZzj = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzj += zzakg.zzj(list.get(i6).intValue());
            }
            this.zza.zzn(iZzj);
            while (i5 < list.size()) {
                this.zza.zzn(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        zzakz zzakzVar = (zzakz) list;
        if (!z4) {
            while (i5 < zzakzVar.size()) {
                this.zza.zzl(i4, zzakzVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZzj2 = 0;
        for (int i7 = 0; i7 < zzakzVar.size(); i7++) {
            iZzj2 += zzakg.zzj(zzakzVar.zzb(i7));
        }
        this.zza.zzn(iZzj2);
        while (i5 < zzakzVar.size()) {
            this.zza.zzn(zzakzVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzn(int i4, List<Long> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzalr)) {
            if (!z4) {
                while (i5 < list.size()) {
                    this.zza.zzh(i4, list.get(i5).longValue());
                    i5++;
                }
                return;
            }
            this.zza.zzk(i4, 2);
            int iZzg = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                iZzg += zzakg.zzg(list.get(i6).longValue());
            }
            this.zza.zzn(iZzg);
            while (i5 < list.size()) {
                this.zza.zzj(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        zzalr zzalrVar = (zzalr) list;
        if (!z4) {
            while (i5 < zzalrVar.size()) {
                this.zza.zzh(i4, zzalrVar.zzb(i5));
                i5++;
            }
            return;
        }
        this.zza.zzk(i4, 2);
        int iZzg2 = 0;
        for (int i7 = 0; i7 < zzalrVar.size(); i7++) {
            iZzg2 += zzakg.zzg(zzalrVar.zzb(i7));
        }
        this.zza.zzn(iZzg2);
        while (i5 < zzalrVar.size()) {
            this.zza.zzj(zzalrVar.zzb(i5));
            i5++;
        }
    }

    public static zzakj zza(zzakg zzakgVar) {
        zzakj zzakjVar = zzakgVar.zze;
        return zzakjVar != null ? zzakjVar : new zzakj(zzakgVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, boolean z4) {
        this.zza.zzb(i4, z4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, List<Boolean> list, boolean z4) {
        int i5 = 0;
        if (!(list instanceof zzajn)) {
            if (z4) {
                this.zza.zzk(i4, 2);
                int iZza = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    iZza += zzakg.zza(list.get(i6).booleanValue());
                }
                this.zza.zzn(iZza);
                while (i5 < list.size()) {
                    this.zza.zzb(list.get(i5).booleanValue());
                    i5++;
                }
                return;
            }
            while (i5 < list.size()) {
                this.zza.zzb(i4, list.get(i5).booleanValue());
                i5++;
            }
            return;
        }
        zzajn zzajnVar = (zzajn) list;
        if (z4) {
            this.zza.zzk(i4, 2);
            int iZza2 = 0;
            for (int i7 = 0; i7 < zzajnVar.size(); i7++) {
                iZza2 += zzakg.zza(zzajnVar.zzb(i7));
            }
            this.zza.zzn(iZza2);
            while (i5 < zzajnVar.size()) {
                this.zza.zzb(zzajnVar.zzb(i5));
                i5++;
            }
            return;
        }
        while (i5 < zzajnVar.size()) {
            this.zza.zzb(i4, zzajnVar.zzb(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i4, int i5) {
        this.zza.zzh(i4, i5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzd(int i4, int i5) {
        this.zza.zzh(i4, i5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zze(int i4, int i5) {
        this.zza.zzj(i4, i5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzf(int i4, int i5) {
        this.zza.zzl(i4, i5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i4, long j4) {
        this.zza.zzh(i4, j4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zze(int i4, long j4) {
        this.zza.zzh(i4, j4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzd(int i4, long j4) {
        this.zza.zzg(i4, j4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i4, Object obj, zzamv zzamvVar) {
        this.zza.zzc(i4, (zzamc) obj, zzamvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, zzajp zzajpVar) {
        this.zza.zzc(i4, zzajpVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i4, List<?> list, zzamv zzamvVar) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzb(i4, list.get(i5), zzamvVar);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzc(int i4, int i5) {
        this.zza.zzi(i4, i5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, List<zzajp> list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.zza.zzc(i4, list.get(i5));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzc(int i4, long j4) {
        this.zza.zzf(i4, j4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    @Deprecated
    public final void zzb(int i4) {
        this.zza.zzk(i4, 3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, double d4) {
        this.zza.zzb(i4, d4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i4, List<String> list) {
        int i5 = 0;
        if (list instanceof zzaln) {
            zzaln zzalnVar = (zzaln) list;
            while (i5 < list.size()) {
                Object objZza = zzalnVar.zza(i5);
                if (objZza instanceof String) {
                    this.zza.zzb(i4, (String) objZza);
                } else {
                    this.zza.zzc(i4, (zzajp) objZza);
                }
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.zza.zzb(i4, list.get(i5));
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    @Deprecated
    public final void zza(int i4) {
        this.zza.zzk(i4, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, int i5) {
        this.zza.zzi(i4, i5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, long j4) {
        this.zza.zzf(i4, j4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, float f4) {
        this.zza.zzb(i4, f4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, Object obj, zzamv zzamvVar) {
        zzakg zzakgVar = this.zza;
        zzakgVar.zzk(i4, 3);
        zzamvVar.zza((zzamc) obj, zzakgVar.zze);
        zzakgVar.zzk(i4, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, List<?> list, zzamv zzamvVar) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            zza(i4, list.get(i5), zzamvVar);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final <K, V> void zza(int i4, zzalx<K, V> zzalxVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzk(i4, 2);
            this.zza.zzn(zzalu.zza(zzalxVar, entry.getKey(), entry.getValue()));
            zzalu.zza(this.zza, zzalxVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, Object obj) {
        if (obj instanceof zzajp) {
            this.zza.zzd(i4, (zzajp) obj);
        } else {
            this.zza.zzb(i4, (zzamc) obj);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i4, String str) {
        this.zza.zzb(i4, str);
    }
}
