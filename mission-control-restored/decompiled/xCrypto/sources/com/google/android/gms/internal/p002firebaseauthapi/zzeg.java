package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzeg extends zzcx {
    private final int zza;
    private final zza zzb;

    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("NO_PREFIX");
        private final String zzd;

        private zza(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    public static final class zzb {
        private Integer zza;
        private zza zzb;

        public final zzb zza(int i4) throws InvalidAlgorithmParameterException {
            if (i4 != 16 && i4 != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i4)));
            }
            this.zza = Integer.valueOf(i4);
            return this;
        }

        private zzb() {
            this.zza = null;
            this.zzb = zza.zzc;
        }

        public final zzb zza(zza zzaVar) {
            this.zzb = zzaVar;
            return this;
        }

        public final zzeg zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num != null) {
                if (this.zzb != null) {
                    return new zzeg(num.intValue(), this.zzb);
                }
                throw new GeneralSecurityException("Variant is not set");
            }
            throw new GeneralSecurityException("Key size is not set");
        }
    }

    public static zzb zzc() {
        return new zzb();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzeg)) {
            return false;
        }
        zzeg zzegVar = (zzeg) obj;
        return zzegVar.zza == this.zza && zzegVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzeg.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        return "AesGcmSiv Parameters (variant: " + String.valueOf(this.zzb) + ", " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzce
    public final boolean zza() {
        return this.zzb != zza.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zza zzd() {
        return this.zzb;
    }

    private zzeg(int i4, zza zzaVar) {
        this.zza = i4;
        this.zzb = zzaVar;
    }
}
