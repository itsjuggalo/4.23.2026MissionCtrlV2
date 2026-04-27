package com.google.firebase.auth;

import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzf();
    private String zza;
    private String zzb;
    private final String zzc;
    private String zzd;
    private boolean zze;

    public EmailAuthCredential(String str, String str2) {
        this(str, str2, null, null, false);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "password";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return !TextUtils.isEmpty(this.zzb) ? "password" : "emailLink";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.E(parcel, 1, this.zza, false);
        c.E(parcel, 2, this.zzb, false);
        c.E(parcel, 3, this.zzc, false);
        c.E(parcel, 4, this.zzd, false);
        c.g(parcel, 5, this.zze);
        c.b(parcel, iA);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new EmailAuthCredential(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.zzc);
    }

    public final boolean zzg() {
        return this.zze;
    }

    public EmailAuthCredential(String str, String str2, String str3, String str4, boolean z4) {
        this.zza = AbstractC0940s.e(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = z4;
    }

    public final EmailAuthCredential zza(FirebaseUser firebaseUser) {
        this.zzd = firebaseUser.zze();
        this.zze = true;
        return this;
    }

    public static boolean zza(String str) {
        ActionCodeUrl link;
        return (TextUtils.isEmpty(str) || (link = ActionCodeUrl.parseLink(str)) == null || link.getOperation() != 4) ? false : true;
    }
}
