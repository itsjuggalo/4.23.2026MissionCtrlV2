package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzae;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: loaded from: classes.dex */
public class y0 extends M {
    public static final Parcelable.Creator<y0> CREATOR = new z0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzait f5817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5820g;

    public y0(String str, String str2, String str3, zzait zzaitVar, String str4, String str5, String str6) {
        this.f5814a = zzae.zzb(str);
        this.f5815b = str2;
        this.f5816c = str3;
        this.f5817d = zzaitVar;
        this.f5818e = str4;
        this.f5819f = str5;
        this.f5820g = str6;
    }

    public static y0 G(zzait zzaitVar) {
        AbstractC1207s.l(zzaitVar, "Must specify a non-null webSignInCredential");
        return new y0(null, null, null, zzaitVar, null, null, null);
    }

    public static y0 H(String str, String str2, String str3, String str4) {
        AbstractC1207s.f(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new y0(str, str2, str3, null, null, null, str4);
    }

    public static y0 I(String str, String str2, String str3, String str4, String str5) {
        AbstractC1207s.f(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new y0(str, str2, str3, null, str4, str5, null);
    }

    public static zzait J(y0 y0Var, String str) {
        AbstractC1207s.k(y0Var);
        zzait zzaitVar = y0Var.f5817d;
        return zzaitVar != null ? zzaitVar : new zzait(y0Var.E(), y0Var.D(), y0Var.A(), null, y0Var.F(), null, str, y0Var.f5818e, y0Var.f5820g);
    }

    @Override // Z2.AbstractC0759h
    public String A() {
        return this.f5814a;
    }

    @Override // Z2.AbstractC0759h
    public String B() {
        return this.f5814a;
    }

    @Override // Z2.AbstractC0759h
    public final AbstractC0759h C() {
        return new y0(this.f5814a, this.f5815b, this.f5816c, this.f5817d, this.f5818e, this.f5819f, this.f5820g);
    }

    @Override // Z2.M
    public String D() {
        return this.f5816c;
    }

    @Override // Z2.M
    public String E() {
        return this.f5815b;
    }

    @Override // Z2.M
    public String F() {
        return this.f5819f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, A(), false);
        Q1.c.E(parcel, 2, E(), false);
        Q1.c.E(parcel, 3, D(), false);
        Q1.c.C(parcel, 4, this.f5817d, i7, false);
        Q1.c.E(parcel, 5, this.f5818e, false);
        Q1.c.E(parcel, 6, F(), false);
        Q1.c.E(parcel, 7, this.f5820g, false);
        Q1.c.b(parcel, iA);
    }
}
