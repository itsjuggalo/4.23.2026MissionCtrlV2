package com.google.firebase.auth;

import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: loaded from: classes.dex */
public class zzc extends OAuthCredential {
    public static final Parcelable.Creator<zzc> CREATOR = new zze();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzait zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    public zzc(String str, String str2, String str3, zzait zzaitVar, String str4, String str5, String str6) {
        this.zza = com.google.android.gms.internal.p002firebaseauthapi.zzae.zzb(str);
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzaitVar;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public String getAccessToken() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public String getIdToken() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public String getSecret() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 1, getProvider(), false);
        c.E(parcel, 2, getIdToken(), false);
        c.E(parcel, 3, getAccessToken(), false);
        c.C(parcel, 4, this.zzd, i4, false);
        c.E(parcel, 5, this.zze, false);
        c.E(parcel, 6, getSecret(), false);
        c.E(parcel, 7, this.zzg, false);
        c.b(parcel, iA);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new zzc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }

    public static zzc zza(zzait zzaitVar) {
        AbstractC0940s.l(zzaitVar, "Must specify a non-null webSignInCredential");
        return new zzc(null, null, null, zzaitVar, null, null, null);
    }

    public static zzc zza(String str, String str2, String str3) {
        return zza(str, str2, str3, null, null);
    }

    public static zzc zza(String str, String str2, String str3, String str4, String str5) {
        AbstractC0940s.f(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zzc(str, str2, str3, null, str4, str5, null);
    }

    public static zzc zza(String str, String str2, String str3, String str4) {
        AbstractC0940s.f(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zzc(str, str2, str3, null, null, null, str4);
    }

    public static zzait zza(zzc zzcVar, String str) {
        AbstractC0940s.k(zzcVar);
        zzait zzaitVar = zzcVar.zzd;
        return zzaitVar != null ? zzaitVar : new zzait(zzcVar.getIdToken(), zzcVar.getAccessToken(), zzcVar.getProvider(), null, zzcVar.getSecret(), null, str, zzcVar.zze, zzcVar.zzg);
    }
}
