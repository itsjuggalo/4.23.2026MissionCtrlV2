package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaq implements zzbp {
    public static final /* synthetic */ int zza = 0;
    private static volatile zzaj zzb = new zzaj(zzap.zza);
    private final String zzd;
    private final Object zze;
    private volatile zzao zzf;
    private volatile Object zzh;
    private final zzak zzi;
    private volatile int zzg = -1;
    private final String zzc = "com.google.android.gms.fido";

    public zzaq(String str, String str2, Object obj, zzak zzakVar, boolean z10) {
        this.zzd = str2;
        this.zze = obj;
        this.zzi = zzakVar;
    }

    @Override // com.google.android.gms.internal.fido.zzbp
    public final Object zza() {
        zzae.zza();
        synchronized (this) {
            zzae.zzb();
            int i10 = zzan.zza;
            throw null;
        }
    }
}
