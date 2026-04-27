package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Arrays;

/* JADX INFO: renamed from: N1.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0483t extends A1.a {
    public static final Parcelable.Creator<C0483t> CREATOR = new V();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0470h f2839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0468g f2840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0472i f2841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0464e f2842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2843h;

    public C0483t(String str, String str2, byte[] bArr, C0470h c0470h, C0468g c0468g, C0472i c0472i, C0464e c0464e, String str3) {
        boolean z4 = true;
        if ((c0470h == null || c0468g != null || c0472i != null) && ((c0470h != null || c0468g == null || c0472i != null) && (c0470h != null || c0468g != null || c0472i == null))) {
            z4 = false;
        }
        AbstractC0940s.a(z4);
        this.f2836a = str;
        this.f2837b = str2;
        this.f2838c = bArr;
        this.f2839d = c0470h;
        this.f2840e = c0468g;
        this.f2841f = c0472i;
        this.f2842g = c0464e;
        this.f2843h = str3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0483t)) {
            return false;
        }
        C0483t c0483t = (C0483t) obj;
        return AbstractC0939q.b(this.f2836a, c0483t.f2836a) && AbstractC0939q.b(this.f2837b, c0483t.f2837b) && Arrays.equals(this.f2838c, c0483t.f2838c) && AbstractC0939q.b(this.f2839d, c0483t.f2839d) && AbstractC0939q.b(this.f2840e, c0483t.f2840e) && AbstractC0939q.b(this.f2841f, c0483t.f2841f) && AbstractC0939q.b(this.f2842g, c0483t.f2842g) && AbstractC0939q.b(this.f2843h, c0483t.f2843h);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2836a, this.f2837b, this.f2838c, this.f2840e, this.f2839d, this.f2841f, this.f2842g, this.f2843h);
    }

    public String i() {
        return this.f2843h;
    }

    public C0464e k() {
        return this.f2842g;
    }

    public String l() {
        return this.f2836a;
    }

    public byte[] m() {
        return this.f2838c;
    }

    public String n() {
        return this.f2837b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, l(), false);
        A1.c.E(parcel, 2, n(), false);
        A1.c.k(parcel, 3, m(), false);
        A1.c.C(parcel, 4, this.f2839d, i4, false);
        A1.c.C(parcel, 5, this.f2840e, i4, false);
        A1.c.C(parcel, 6, this.f2841f, i4, false);
        A1.c.C(parcel, 7, k(), i4, false);
        A1.c.E(parcel, 8, i(), false);
        A1.c.b(parcel, iA);
    }
}
