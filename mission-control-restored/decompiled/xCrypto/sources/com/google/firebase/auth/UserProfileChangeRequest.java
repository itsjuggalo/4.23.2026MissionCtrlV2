package com.google.firebase.auth;

import A1.a;
import A1.c;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class UserProfileChangeRequest extends a {
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzau();
    private String zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private Uri zze;

    public static class Builder {
        private String zza;
        private Uri zzb;
        private boolean zzc;
        private boolean zzd;

        public UserProfileChangeRequest build() {
            String str = this.zza;
            Uri uri = this.zzb;
            return new UserProfileChangeRequest(str, uri == null ? null : uri.toString(), this.zzc, this.zzd);
        }

        public String getDisplayName() {
            return this.zza;
        }

        public Uri getPhotoUri() {
            return this.zzb;
        }

        public Builder setDisplayName(String str) {
            if (str == null) {
                this.zzc = true;
                return this;
            }
            this.zza = str;
            return this;
        }

        public Builder setPhotoUri(Uri uri) {
            if (uri == null) {
                this.zzd = true;
                return this;
            }
            this.zzb = uri;
            return this;
        }
    }

    public UserProfileChangeRequest(String str, String str2, boolean z4, boolean z5) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z4;
        this.zzd = z5;
        this.zze = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public String getDisplayName() {
        return this.zza;
    }

    public Uri getPhotoUri() {
        return this.zze;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 2, getDisplayName(), false);
        c.E(parcel, 3, this.zzb, false);
        c.g(parcel, 4, this.zzc);
        c.g(parcel, 5, this.zzd);
        c.b(parcel, iA);
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
