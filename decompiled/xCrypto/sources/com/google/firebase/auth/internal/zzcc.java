package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.TotpSecret;

/* JADX INFO: loaded from: classes.dex */
public final class zzcc implements TotpSecret {
    private final String zza;
    private final String zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;
    private String zzf;
    private FirebaseAuth zzg;

    public zzcc(String str, String str2, int i4, int i5, long j4, String str3, FirebaseAuth firebaseAuth) {
        AbstractC0940s.f(str3, "sessionInfo cannot be empty.");
        AbstractC0940s.l(firebaseAuth, "firebaseAuth cannot be null.");
        this.zza = AbstractC0940s.f(str, "sharedSecretKey cannot be empty. This is required to generate QR code URL.");
        this.zzb = AbstractC0940s.f(str2, "hashAlgorithm cannot be empty.");
        this.zzc = i4;
        this.zzd = i5;
        this.zze = j4;
        this.zzf = str3;
        this.zzg = firebaseAuth;
    }

    private final void zza(String str) {
        this.zzg.getApp().getApplicationContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String generateQrCodeUrl() {
        return generateQrCodeUrl(AbstractC0940s.f(((FirebaseUser) AbstractC0940s.l(this.zzg.getCurrentUser(), "Current user cannot be null, since user is required to be logged in to enroll for TOTP MFA.")).getEmail(), "Email cannot be empty, since verified email is required to use MFA."), this.zzg.getApp().getName());
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final int getCodeIntervalSeconds() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final int getCodeLength() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final long getEnrollmentCompletionDeadline() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String getHashAlgorithm() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String getSessionInfo() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String getSharedSecretKey() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final void openInOtpApp(String str) {
        AbstractC0940s.f(str, "qrCodeUrl cannot be empty.");
        try {
            zza(str);
        } catch (ActivityNotFoundException unused) {
            zza("https://play.google.com/store/search?q=otpauth&c=apps");
        }
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final void openInOtpApp(String str, String str2, Activity activity) {
        AbstractC0940s.f(str, "QrCodeUrl cannot be empty.");
        AbstractC0940s.f(str2, "FallbackUrl cannot be empty.");
        AbstractC0940s.l(activity, "Activity cannot be null.");
        try {
            zza(str, activity);
        } catch (ActivityNotFoundException unused) {
            zza(str2, activity);
        }
    }

    private static void zza(String str, Activity activity) {
        AbstractC0940s.l(activity, "Activity cannot be null.");
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String generateQrCodeUrl(String str, String str2) {
        AbstractC0940s.f(str, "accountName cannot be empty.");
        AbstractC0940s.f(str2, "issuer cannot be empty.");
        return String.format(null, "otpauth://totp/%s:%s?secret=%s&issuer=%s&algorithm=%s&digits=%d", str2, str, this.zza, str2, this.zzb, Integer.valueOf(this.zzc));
    }
}
