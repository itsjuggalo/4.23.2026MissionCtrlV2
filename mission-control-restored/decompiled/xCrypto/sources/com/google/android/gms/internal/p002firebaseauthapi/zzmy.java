package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* JADX INFO: loaded from: classes.dex */
public final class zzmy {
    private static final Object zza = new Object();
    private static final String zzb = "zzmy";
    private zzbv zzc;

    public static final class zza {
        private Context zza = null;
        private String zzb = null;
        private String zzc = null;
        private String zzd = null;
        private zzbe zze = null;
        private boolean zzf = true;
        private zzbn zzg = null;
        private zzww zzh = null;
        private zzbv zzi;

        private static zzbv zza(byte[] bArr) {
            return zzbv.zza(zzcc.zza(zzbd.zza(bArr), zzbj.zza()));
        }

        private final zzbe zzb() throws KeyStoreException {
            zzmy.zzd();
            zznd zzndVar = new zznd();
            try {
                boolean zZzc = zznd.zzc(this.zzd);
                try {
                    return zzndVar.zza(this.zzd);
                } catch (GeneralSecurityException | ProviderException e4) {
                    if (!zZzc) {
                        throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.zzd), e4);
                    }
                    Log.w(zzmy.zzb, "cannot use Android Keystore, it'll be disabled", e4);
                    return null;
                }
            } catch (GeneralSecurityException | ProviderException e5) {
                Log.w(zzmy.zzb, "cannot use Android Keystore, it'll be disabled", e5);
                return null;
            }
        }

        public final zza zza(zzww zzwwVar) {
            this.zzh = zzwwVar;
            return this;
        }

        public final zza zza(String str) {
            if (str.startsWith("android-keystore://")) {
                if (this.zzf) {
                    this.zzd = str;
                    return this;
                }
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }

        private final zzbv zzb(byte[] bArr) {
            try {
                this.zze = new zznd().zza(this.zzd);
                try {
                    return zzbv.zza(zzbq.zza(zzbd.zza(bArr), this.zze, new byte[0]));
                } catch (IOException | GeneralSecurityException e4) {
                    try {
                        return zza(bArr);
                    } catch (IOException unused) {
                        throw e4;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e5) {
                try {
                    zzbv zzbvVarZza = zza(bArr);
                    Log.w(zzmy.zzb, "cannot use Android Keystore, it'll be disabled", e5);
                    return zzbvVarZza;
                } catch (IOException unused2) {
                    throw e5;
                }
            }
        }

        public final zza zza(Context context, String str, String str2) {
            if (context != null) {
                this.zza = context;
                this.zzb = str;
                this.zzc = str2;
                return this;
            }
            throw new IllegalArgumentException("need an Android context");
        }

        public final synchronized zzmy zza() {
            zzmy zzmyVar;
            try {
                if (this.zzb != null) {
                    zzww zzwwVar = this.zzh;
                    if (zzwwVar != null && this.zzg == null) {
                        this.zzg = zzbn.zza(zzcm.zza(zzwwVar.zzk()));
                    }
                    synchronized (zzmy.zza) {
                        try {
                            byte[] bArrZzb = zzb(this.zza, this.zzb, this.zzc);
                            if (bArrZzb == null) {
                                if (this.zzd != null) {
                                    this.zze = zzb();
                                }
                                zzbn zzbnVar = this.zzg;
                                if (zzbnVar != null) {
                                    zzbq zzbqVarZza = zzbq.zza(zzbnVar);
                                    zzmy.zza(zzbqVarZza, new zznf(this.zza, this.zzb, this.zzc), this.zze);
                                    this.zzi = zzbv.zza(zzbqVarZza);
                                } else {
                                    throw new GeneralSecurityException("cannot read or generate keyset");
                                }
                            } else if (this.zzd != null) {
                                zzmy.zzd();
                                this.zzi = zzb(bArrZzb);
                            } else {
                                this.zzi = zza(bArrZzb);
                            }
                            zzmyVar = new zzmy(this);
                        } finally {
                        }
                    }
                } else {
                    throw new IllegalArgumentException("keysetName cannot be null");
                }
            } catch (Throwable th) {
                throw th;
            }
            return zzmyVar;
        }

        private static byte[] zzb(Context context, String str, String str2) throws CharConversionException {
            SharedPreferences sharedPreferences;
            if (str != null) {
                Context applicationContext = context.getApplicationContext();
                if (str2 == null) {
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                } else {
                    sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
                }
                try {
                    String string = sharedPreferences.getString(str, null);
                    if (string == null) {
                        return null;
                    }
                    return zzzr.zza(string);
                } catch (ClassCastException | IllegalArgumentException unused) {
                    throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
                }
            }
            throw new IllegalArgumentException("keysetName cannot be null");
        }
    }

    public static /* synthetic */ boolean zzd() {
        return true;
    }

    public final synchronized zzbq zza() {
        return this.zzc.zza();
    }

    private zzmy(zza zzaVar) {
        new zznf(zzaVar.zza, zzaVar.zzb, zzaVar.zzc);
        this.zzc = zzaVar.zzi;
    }

    public static /* synthetic */ void zza(zzbq zzbqVar, zzbx zzbxVar, zzbe zzbeVar) throws GeneralSecurityException {
        try {
            if (zzbeVar != null) {
                zzbqVar.zza(zzbxVar, zzbeVar, new byte[0]);
            } else {
                zzcc.zza(zzbqVar, zzbxVar, zzbj.zza());
            }
        } catch (IOException e4) {
            throw new GeneralSecurityException(e4);
        }
    }
}
