package m7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z1 extends m0 {
    public static final Parcelable.Creator<z1> CREATOR = new y1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzajb f16078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f16080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f16081g;

    public z1(String str, String str2, String str3, zzajb zzajbVar, String str4, String str5, String str6) {
        this.f16075a = zzac.zzb(str);
        this.f16076b = str2;
        this.f16077c = str3;
        this.f16078d = zzajbVar;
        this.f16079e = str4;
        this.f16080f = str5;
        this.f16081g = str6;
    }

    public static zzajb X(z1 z1Var, String str) {
        com.google.android.gms.common.internal.s.k(z1Var);
        zzajb zzajbVar = z1Var.f16078d;
        return zzajbVar != null ? zzajbVar : new zzajb(z1Var.V(), z1Var.U(), z1Var.R(), null, z1Var.W(), null, str, z1Var.f16079e, z1Var.f16081g);
    }

    public static z1 Y(zzajb zzajbVar) {
        com.google.android.gms.common.internal.s.l(zzajbVar, "Must specify a non-null webSignInCredential");
        return new z1(null, null, null, zzajbVar, null, null, null);
    }

    public static z1 Z(String str, String str2, String str3, String str4) {
        com.google.android.gms.common.internal.s.f(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new z1(str, str2, str3, null, null, null, str4);
    }

    public static z1 a0(String str, String str2, String str3, String str4, String str5) {
        com.google.android.gms.common.internal.s.f(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new z1(str, str2, str3, null, str4, str5, null);
    }

    @Override // m7.h
    public final String R() {
        return this.f16075a;
    }

    @Override // m7.h
    public final String S() {
        return this.f16075a;
    }

    @Override // m7.h
    public final h T() {
        return new z1(this.f16075a, this.f16076b, this.f16077c, this.f16078d, this.f16079e, this.f16080f, this.f16081g);
    }

    @Override // m7.m0
    public final String U() {
        return this.f16077c;
    }

    @Override // m7.m0
    public final String V() {
        return this.f16076b;
    }

    @Override // m7.m0
    public final String W() {
        return this.f16080f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, R(), false);
        n5.c.E(parcel, 2, V(), false);
        n5.c.E(parcel, 3, U(), false);
        n5.c.C(parcel, 4, this.f16078d, i10, false);
        n5.c.E(parcel, 5, this.f16079e, false);
        n5.c.E(parcel, 6, W(), false);
        n5.c.E(parcel, 7, this.f16081g, false);
        n5.c.b(parcel, iA);
    }
}
