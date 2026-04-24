package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzli {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzlj zzc;

    private zzli() {
    }

    public static int zzF(int i4) {
        return (i4 >>> 1) ^ (-(i4 & 1));
    }

    public static long zzG(long j4) {
        return (j4 >>> 1) ^ (-(1 & j4));
    }

    public static zzli zzH(byte[] bArr, int i4, int i5, boolean z4) {
        zzlf zzlfVar = new zzlf(bArr, 0, 0, false, null);
        try {
            zzlfVar.zze(0);
            return zzlfVar;
        } catch (zznn e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public abstract void zzA(int i4);

    public abstract boolean zzC();

    public abstract boolean zzD();

    public abstract boolean zzE(int i4);

    public final void zzI() throws zznn {
        int iZzm;
        do {
            iZzm = zzm();
            if (iZzm == 0) {
                return;
            }
            int i4 = this.zza;
            if (i4 >= this.zzb) {
                throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.zza = i4 + 1;
            this.zza--;
        } while (zzE(iZzm));
    }

    public abstract double zzb();

    public abstract float zzc();

    public abstract int zzd();

    public abstract int zze(int i4);

    public abstract int zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract int zzk();

    public abstract int zzl();

    public abstract int zzm();

    public abstract int zzn();

    public abstract long zzo();

    public abstract long zzp();

    public abstract long zzt();

    public abstract long zzu();

    public abstract long zzv();

    public abstract zzle zzw();

    public abstract String zzx();

    public abstract String zzy();

    public abstract void zzz(int i4);

    public /* synthetic */ zzli(zzlh zzlhVar) {
    }
}
