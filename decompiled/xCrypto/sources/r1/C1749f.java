package r1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: r1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1749f extends A1.a {
    public static final Parcelable.Creator<C1749f> CREATOR = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14533f;

    /* JADX INFO: renamed from: r1.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f14535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f14536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f14537d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f14538e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14539f;

        public C1749f a() {
            return new C1749f(this.f14534a, this.f14535b, this.f14536c, this.f14537d, this.f14538e, this.f14539f);
        }

        public a b(String str) {
            this.f14535b = str;
            return this;
        }

        public a c(String str) {
            this.f14537d = str;
            return this;
        }

        public a d(boolean z4) {
            this.f14538e = z4;
            return this;
        }

        public a e(String str) {
            AbstractC0940s.k(str);
            this.f14534a = str;
            return this;
        }

        public final a f(String str) {
            this.f14536c = str;
            return this;
        }

        public final a g(int i4) {
            this.f14539f = i4;
            return this;
        }
    }

    public C1749f(String str, String str2, String str3, String str4, boolean z4, int i4) {
        AbstractC0940s.k(str);
        this.f14528a = str;
        this.f14529b = str2;
        this.f14530c = str3;
        this.f14531d = str4;
        this.f14532e = z4;
        this.f14533f = i4;
    }

    public static a i() {
        return new a();
    }

    public static a o(C1749f c1749f) {
        AbstractC0940s.k(c1749f);
        a aVarI = i();
        aVarI.e(c1749f.m());
        aVarI.c(c1749f.l());
        aVarI.b(c1749f.k());
        aVarI.d(c1749f.f14532e);
        aVarI.g(c1749f.f14533f);
        String str = c1749f.f14530c;
        if (str != null) {
            aVarI.f(str);
        }
        return aVarI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1749f)) {
            return false;
        }
        C1749f c1749f = (C1749f) obj;
        return AbstractC0939q.b(this.f14528a, c1749f.f14528a) && AbstractC0939q.b(this.f14531d, c1749f.f14531d) && AbstractC0939q.b(this.f14529b, c1749f.f14529b) && AbstractC0939q.b(Boolean.valueOf(this.f14532e), Boolean.valueOf(c1749f.f14532e)) && this.f14533f == c1749f.f14533f;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f14528a, this.f14529b, this.f14531d, Boolean.valueOf(this.f14532e), Integer.valueOf(this.f14533f));
    }

    public String k() {
        return this.f14529b;
    }

    public String l() {
        return this.f14531d;
    }

    public String m() {
        return this.f14528a;
    }

    public boolean n() {
        return this.f14532e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, m(), false);
        A1.c.E(parcel, 2, k(), false);
        A1.c.E(parcel, 3, this.f14530c, false);
        A1.c.E(parcel, 4, l(), false);
        A1.c.g(parcel, 5, n());
        A1.c.t(parcel, 6, this.f14533f);
        A1.c.b(parcel, iA);
    }
}
