package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.f;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzakh {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzakl zzc;
    private int zze;
    private int zzf;

    public static int zza(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double zza();

    public abstract float zzb();

    public abstract int zzb(int i);

    public abstract int zzc();

    public abstract void zzc(int i);

    public abstract int zzd();

    public abstract void zzd(int i);

    public abstract int zze();

    public abstract boolean zze(int i);

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
        this.zzb = f.API_PRIORITY_OTHER;
    }

    public static long zza(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    public static zzakh zza(byte[] bArr, int i, int i6, boolean z6) {
        zzakk zzakkVar = new zzakk(bArr, i, i6, z6);
        try {
            zzakkVar.zzb(i6);
            return zzakkVar;
        } catch (zzall e) {
            throw new IllegalArgumentException(e);
        }
    }
}
