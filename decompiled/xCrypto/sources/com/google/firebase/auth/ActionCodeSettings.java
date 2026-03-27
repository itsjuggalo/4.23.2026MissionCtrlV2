package com.google.firebase.auth;

import A1.a;
import A1.c;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ActionCodeSettings extends a {
    public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zzb();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;
    private final String zzf;
    private final boolean zzg;
    private String zzh;
    private int zzi;
    private String zzj;
    private final String zzk;

    public static class Builder {
        private String zza;
        private String zzb;
        private String zzc;
        private boolean zzd;
        private String zze;
        private boolean zzf;

        @Deprecated
        private String zzg;
        private String zzh;

        public ActionCodeSettings build() {
            if (this.zza != null) {
                return new ActionCodeSettings(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }

        @Deprecated
        public String getDynamicLinkDomain() {
            return this.zzg;
        }

        public boolean getHandleCodeInApp() {
            return this.zzf;
        }

        public String getIOSBundleId() {
            return this.zzb;
        }

        public String getLinkDomain() {
            return this.zzh;
        }

        public String getUrl() {
            return this.zza;
        }

        public Builder setAndroidPackageName(String str, boolean z4, String str2) {
            this.zzc = str;
            this.zzd = z4;
            this.zze = str2;
            return this;
        }

        @Deprecated
        public Builder setDynamicLinkDomain(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setHandleCodeInApp(boolean z4) {
            this.zzf = z4;
            return this;
        }

        public Builder setIOSBundleId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setLinkDomain(String str) {
            this.zzh = str;
            return this;
        }

        public Builder setUrl(String str) {
            this.zza = str;
            return this;
        }

        private Builder() {
            this.zzf = false;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static ActionCodeSettings zzb() {
        return new ActionCodeSettings(new Builder());
    }

    public boolean canHandleCodeInApp() {
        return this.zzg;
    }

    public boolean getAndroidInstallApp() {
        return this.zze;
    }

    public String getAndroidMinimumVersion() {
        return this.zzf;
    }

    public String getAndroidPackageName() {
        return this.zzd;
    }

    public String getIOSBundle() {
        return this.zzb;
    }

    public String getLinkDomain() {
        return this.zzk;
    }

    public String getUrl() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 1, getUrl(), false);
        c.E(parcel, 2, getIOSBundle(), false);
        c.E(parcel, 3, this.zzc, false);
        c.E(parcel, 4, getAndroidPackageName(), false);
        c.g(parcel, 5, getAndroidInstallApp());
        c.E(parcel, 6, getAndroidMinimumVersion(), false);
        c.g(parcel, 7, canHandleCodeInApp());
        c.E(parcel, 8, this.zzh, false);
        c.t(parcel, 9, this.zzi);
        c.E(parcel, 10, this.zzj, false);
        c.E(parcel, 11, getLinkDomain(), false);
        c.b(parcel, iA);
    }

    public final int zza() {
        return this.zzi;
    }

    @Deprecated
    public final String zzc() {
        return this.zzj;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzh;
    }

    private ActionCodeSettings(Builder builder) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = null;
        this.zzd = builder.zzc;
        this.zze = builder.zzd;
        this.zzf = builder.zze;
        this.zzg = builder.zzf;
        this.zzj = builder.zzg;
        this.zzk = builder.zzh;
    }

    public final void zza(String str) {
        this.zzh = str;
    }

    public final void zza(int i4) {
        this.zzi = i4;
    }

    public ActionCodeSettings(String str, String str2, String str3, String str4, boolean z4, String str5, boolean z5, String str6, int i4, String str7, String str8) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = z4;
        this.zzf = str5;
        this.zzg = z5;
        this.zzh = str6;
        this.zzi = i4;
        this.zzj = str7;
        this.zzk = str8;
    }
}
