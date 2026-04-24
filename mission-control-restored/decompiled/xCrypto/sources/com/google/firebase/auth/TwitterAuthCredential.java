package com.google.firebase.auth;

import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: loaded from: classes.dex */
public class TwitterAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzat();
    private String zza;
    private String zzb;

    public TwitterAuthCredential(String str, String str2) {
        this.zza = AbstractC0940s.e(str);
        this.zzb = AbstractC0940s.e(str2);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "twitter.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "twitter.com";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 1, this.zza, false);
        c.E(parcel, 2, this.zzb, false);
        c.b(parcel, iA);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new TwitterAuthCredential(this.zza, this.zzb);
    }

    public static zzait zza(TwitterAuthCredential twitterAuthCredential, String str) {
        AbstractC0940s.k(twitterAuthCredential);
        return new zzait(null, twitterAuthCredential.zza, twitterAuthCredential.getProvider(), null, twitterAuthCredential.zzb, null, str, null, null);
    }
}
