package n7;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 implements m7.y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f16780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FirebaseAuth f16782g;

    public h1(String str, String str2, int i10, int i11, long j10, String str3, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.s.f(str3, "sessionInfo cannot be empty.");
        com.google.android.gms.common.internal.s.l(firebaseAuth, "firebaseAuth cannot be null.");
        this.f16776a = com.google.android.gms.common.internal.s.f(str, "sharedSecretKey cannot be empty. This is required to generate QR code URL.");
        this.f16777b = com.google.android.gms.common.internal.s.f(str2, "hashAlgorithm cannot be empty.");
        this.f16778c = i10;
        this.f16779d = i11;
        this.f16780e = j10;
        this.f16781f = str3;
        this.f16782g = firebaseAuth;
    }

    @Override // m7.y0
    public final String a() {
        return this.f16777b;
    }

    @Override // m7.y0
    public final int b() {
        return this.f16778c;
    }

    @Override // m7.y0
    public final String c() {
        return this.f16781f;
    }

    @Override // m7.y0
    public final String d(String str, String str2) {
        com.google.android.gms.common.internal.s.f(str, "accountName cannot be empty.");
        com.google.android.gms.common.internal.s.f(str2, "issuer cannot be empty.");
        return String.format(null, "otpauth://totp/%s:%s?secret=%s&issuer=%s&algorithm=%s&digits=%d", str2, str, this.f16776a, str2, this.f16777b, Integer.valueOf(this.f16778c));
    }

    @Override // m7.y0
    public final String e() {
        return d(com.google.android.gms.common.internal.s.f(((m7.a0) com.google.android.gms.common.internal.s.l(this.f16782g.m(), "Current user cannot be null, since user is required to be logged in to enroll for TOTP MFA.")).K(), "Email cannot be empty, since verified email is required to use MFA."), this.f16782g.l().q());
    }

    @Override // m7.y0
    public final long f() {
        return this.f16780e;
    }

    @Override // m7.y0
    public final int g() {
        return this.f16779d;
    }

    @Override // m7.y0
    public final void h(String str) {
        com.google.android.gms.common.internal.s.f(str, "qrCodeUrl cannot be empty.");
        try {
            j(str);
        } catch (ActivityNotFoundException unused) {
            j("https://play.google.com/store/search?q=otpauth&c=apps");
        }
    }

    @Override // m7.y0
    public final String i() {
        return this.f16776a;
    }

    public final void j(String str) {
        this.f16782g.l().m().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
    }
}
