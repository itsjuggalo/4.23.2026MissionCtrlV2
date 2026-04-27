package com.google.firebase.auth;

import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzao();
    private String zza;
    private String zzb;
    private String zzc;
    private boolean zzd;
    private String zze;

    public PhoneAuthCredential(String str, String str2, String str3, boolean z4, String str4) {
        AbstractC0940s.b(((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) ? false : true, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z4;
        this.zze = str4;
    }

    public static PhoneAuthCredential zzb(String str, String str2) {
        return new PhoneAuthCredential(null, null, str, true, str2);
    }

    public /* synthetic */ Object clone() {
        return new PhoneAuthCredential(this.zza, getSmsCode(), this.zzc, this.zzd, this.zze);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "phone";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "phone";
    }

    public String getSmsCode() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 1, this.zza, false);
        c.E(parcel, 2, getSmsCode(), false);
        c.E(parcel, 4, this.zzc, false);
        c.g(parcel, 5, this.zzd);
        c.E(parcel, 6, this.zze, false);
        c.b(parcel, iA);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return (PhoneAuthCredential) clone();
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzd;
    }

    public static PhoneAuthCredential zza(String str, String str2) {
        return new PhoneAuthCredential(str, str2, null, true, null);
    }

    public final String zzb() {
        return this.zzc;
    }

    public final PhoneAuthCredential zza(boolean z4) {
        this.zzd = false;
        return this;
    }
}
