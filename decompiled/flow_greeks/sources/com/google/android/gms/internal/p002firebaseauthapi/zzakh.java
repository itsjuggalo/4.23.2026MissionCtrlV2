package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzakh {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzakl zzc;
    private int zze;
    private int zzf;

    public static int zza(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public abstract double zza();

    public abstract float zzb();

    public abstract int zzb(int i10);

    public abstract int zzc();

    public abstract void zzc(int i10);

    public abstract int zzd();

    public abstract void zzd(int i10);

    public abstract int zze();

    public abstract boolean zze(int i10);

    public abstract int zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract int zzi();

    public abstract int zzj();

    public abstract long zzk();

    public abstract long zzl();

    public abstract long zzm();

    public abstract long zzn();

    public abstract long zzo();

    public abstract long zzp();

    public abstract zzajv zzq();

    public abstract String zzr();

    public abstract String zzs();

    public final void zzt() throws zzall {
        if (this.zza + this.zze >= this.zzf) {
            throw zzall.zzh();
        }
    }

    public final void zzu() {
        if (this.zze == 0) {
            zzc(0);
        }
    }

    public final void zzv() throws zzall {
        int iZzi;
        do {
            iZzi = zzi();
            if (iZzi == 0) {
                return;
            }
            zzt();
            this.zze++;
            this.zze--;
        } while (zze(iZzi));
    }

    public abstract boolean zzw();

    public abstract boolean zzx();

    private zzakh() {
        this.zzf = zzd;
        this.zzb = a.e.API_PRIORITY_OTHER;
    }

    public static long zza(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static zzakh zza(byte[] bArr, int i10, int i11, boolean z10) {
        zzakk zzakkVar = new zzakk(bArr, i10, i11, z10);
        try {
            zzakkVar.zzb(i11);
            return zzakkVar;
        } catch (zzall e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
