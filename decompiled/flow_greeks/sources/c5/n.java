package c5;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends n5.a {
    public static final Parcelable.Creator<n> CREATOR = new i0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f3681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a6.t f3685i;

    public n(String str, String str2, String str3, String str4, Uri uri, String str5, String str6, String str7, a6.t tVar) {
        this.f3677a = (String) com.google.android.gms.common.internal.s.k(str);
        this.f3678b = str2;
        this.f3679c = str3;
        this.f3680d = str4;
        this.f3681e = uri;
        this.f3682f = str5;
        this.f3683g = str6;
        this.f3684h = str7;
        this.f3685i = tVar;
    }

    public String R() {
        return this.f3680d;
    }

    public String S() {
        return this.f3679c;
    }

    public String T() {
        return this.f3683g;
    }

    public String U() {
        return this.f3677a;
    }

    public String V() {
        return this.f3682f;
    }

    public Uri W() {
        return this.f3681e;
    }

    public a6.t X() {
        return this.f3685i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return com.google.android.gms.common.internal.q.b(this.f3677a, nVar.f3677a) && com.google.android.gms.common.internal.q.b(this.f3678b, nVar.f3678b) && com.google.android.gms.common.internal.q.b(this.f3679c, nVar.f3679c) && com.google.android.gms.common.internal.q.b(this.f3680d, nVar.f3680d) && com.google.android.gms.common.internal.q.b(this.f3681e, nVar.f3681e) && com.google.android.gms.common.internal.q.b(this.f3682f, nVar.f3682f) && com.google.android.gms.common.internal.q.b(this.f3683g, nVar.f3683g) && com.google.android.gms.common.internal.q.b(this.f3684h, nVar.f3684h) && com.google.android.gms.common.internal.q.b(this.f3685i, nVar.f3685i);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f3677a, this.f3678b, this.f3679c, this.f3680d, this.f3681e, this.f3682f, this.f3683g, this.f3684h, this.f3685i);
    }

    public String p() {
        return this.f3684h;
    }

    public String v() {
        return this.f3678b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, U(), false);
        n5.c.E(parcel, 2, v(), false);
        n5.c.E(parcel, 3, S(), false);
        n5.c.E(parcel, 4, R(), false);
        n5.c.C(parcel, 5, W(), i10, false);
        n5.c.E(parcel, 6, V(), false);
        n5.c.E(parcel, 7, T(), false);
        n5.c.E(parcel, 8, p(), false);
        n5.c.C(parcel, 9, X(), i10, false);
        n5.c.b(parcel, iA);
    }
}
