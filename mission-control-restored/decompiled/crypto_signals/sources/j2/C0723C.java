package j2;

import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: renamed from: j2.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0723C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7633d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FirebaseAuth f7635g;

    public C0723C(String str, String str2, int i, int i6, long j4, String str3, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.I.e(str3, "sessionInfo cannot be empty.");
        com.google.android.gms.common.internal.I.h(firebaseAuth, "firebaseAuth cannot be null.");
        com.google.android.gms.common.internal.I.e(str, "sharedSecretKey cannot be empty. This is required to generate QR code URL.");
        this.f7630a = str;
        com.google.android.gms.common.internal.I.e(str2, "hashAlgorithm cannot be empty.");
        this.f7631b = str2;
        this.f7632c = i;
        this.f7633d = i6;
        this.e = j4;
        this.f7634f = str3;
        this.f7635g = firebaseAuth;
    }

    public final String a(String str, String str2) {
        com.google.android.gms.common.internal.I.e(str, "accountName cannot be empty.");
        com.google.android.gms.common.internal.I.e(str2, "issuer cannot be empty.");
        return "otpauth://totp/" + str2 + ":" + str + "?secret=" + this.f7630a + "&issuer=" + str2 + "&algorithm=" + this.f7631b + "&digits=" + this.f7632c;
    }
}
