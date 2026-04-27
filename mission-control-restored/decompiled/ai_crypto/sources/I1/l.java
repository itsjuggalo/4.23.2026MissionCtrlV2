package I1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import d2.C1447t;

/* JADX INFO: loaded from: classes.dex */
public final class l extends Q1.a {
    public static final Parcelable.Creator<l> CREATOR = new E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f2936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C1447t f2940i;

    public l(String str, String str2, String str3, String str4, Uri uri, String str5, String str6, String str7, C1447t c1447t) {
        this.f2932a = (String) AbstractC1207s.k(str);
        this.f2933b = str2;
        this.f2934c = str3;
        this.f2935d = str4;
        this.f2936e = uri;
        this.f2937f = str5;
        this.f2938g = str6;
        this.f2939h = str7;
        this.f2940i = c1447t;
    }

    public String A() {
        return this.f2935d;
    }

    public String B() {
        return this.f2934c;
    }

    public String C() {
        return this.f2938g;
    }

    public String D() {
        return this.f2932a;
    }

    public String E() {
        return this.f2937f;
    }

    public Uri F() {
        return this.f2936e;
    }

    public C1447t G() {
        return this.f2940i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return AbstractC1206q.b(this.f2932a, lVar.f2932a) && AbstractC1206q.b(this.f2933b, lVar.f2933b) && AbstractC1206q.b(this.f2934c, lVar.f2934c) && AbstractC1206q.b(this.f2935d, lVar.f2935d) && AbstractC1206q.b(this.f2936e, lVar.f2936e) && AbstractC1206q.b(this.f2937f, lVar.f2937f) && AbstractC1206q.b(this.f2938g, lVar.f2938g) && AbstractC1206q.b(this.f2939h, lVar.f2939h) && AbstractC1206q.b(this.f2940i, lVar.f2940i);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f2932a, this.f2933b, this.f2934c, this.f2935d, this.f2936e, this.f2937f, this.f2938g, this.f2939h, this.f2940i);
    }

    public String k() {
        return this.f2939h;
    }

    public String p() {
        return this.f2933b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, D(), false);
        Q1.c.E(parcel, 2, p(), false);
        Q1.c.E(parcel, 3, B(), false);
        Q1.c.E(parcel, 4, A(), false);
        Q1.c.C(parcel, 5, F(), i7, false);
        Q1.c.E(parcel, 6, E(), false);
        Q1.c.E(parcel, 7, C(), false);
        Q1.c.E(parcel, 8, k(), false);
        Q1.c.C(parcel, 9, G(), i7, false);
        Q1.c.b(parcel, iA);
    }
}
