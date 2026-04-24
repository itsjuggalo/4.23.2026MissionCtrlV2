package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzakb {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzakf zzc;
    private int zze;
    private int zzf;

    public static long zza(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    public static int zze(int i4) {
        return (-(i4 & 1)) ^ (i4 >>> 1);
    }

    public abstract double zza();

    public abstract int zza(int i4);

    public abstract float zzb();

    public abstract void zzb(int i4);

    public abstract int zzc();

    public abstract void zzc(int i4);

    public abstract int zzd();

    public abstract boolean zzd(int i4);

    public abstract int zze();

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

    public abstract zzajp zzq();

    public abstract String zzr();

    public abstract String zzs();

    public abstract boolean zzt();

    public abstract boolean zzu();

    public final void zzv() throws zzalf {
        if (this.zza + this.zze >= this.zzf) {
            throw zzalf.zzh();
        }
    }

    public final void zzw() {
        if (this.zze == 0) {
            zzb(0);
        }
    }

    public final void zzx() throws zzalf {
        int iZzi;
        do {
            iZzi = zzi();
            if (iZzi == 0) {
                return;
            }
            zzv();
            this.zze++;
            this.zze--;
        } while (zzd(iZzi));
    }

    private zzakb() {
        this.zzf = zzd;
        this.zzb = Integer.MAX_VALUE;
    }

    public static zzakb zza(byte[] bArr, int i4, int i5, boolean z4) {
        zzaka zzakaVar = new zzaka(bArr, i4, i5, z4);
        try {
            zzakaVar.zza(i5);
            return zzakaVar;
        } catch (zzalf e4) {
            throw new IllegalArgumentException(e4);
        }
    }
}
