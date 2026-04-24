package I1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: I1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0581f extends Q1.a {
    public static final Parcelable.Creator<C0581f> CREATOR = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2917f;

    /* JADX INFO: renamed from: I1.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f2920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f2921d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2922e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2923f;

        public C0581f a() {
            return new C0581f(this.f2918a, this.f2919b, this.f2920c, this.f2921d, this.f2922e, this.f2923f);
        }

        public a b(String str) {
            this.f2919b = str;
            return this;
        }

        public a c(String str) {
            this.f2921d = str;
            return this;
        }

        public a d(boolean z7) {
            this.f2922e = z7;
            return this;
        }

        public a e(String str) {
            AbstractC1207s.k(str);
            this.f2918a = str;
            return this;
        }

        public final a f(String str) {
            this.f2920c = str;
            return this;
        }

        public final a g(int i7) {
            this.f2923f = i7;
            return this;
        }
    }

    public C0581f(String str, String str2, String str3, String str4, boolean z7, int i7) {
        AbstractC1207s.k(str);
        this.f2912a = str;
        this.f2913b = str2;
        this.f2914c = str3;
        this.f2915d = str4;
        this.f2916e = z7;
        this.f2917f = i7;
    }

    public static a A() {
        return new a();
    }

    public static a F(C0581f c0581f) {
        AbstractC1207s.k(c0581f);
        a aVarA = A();
        aVarA.e(c0581f.D());
        aVarA.c(c0581f.C());
        aVarA.b(c0581f.B());
        aVarA.d(c0581f.f2916e);
        aVarA.g(c0581f.f2917f);
        String str = c0581f.f2914c;
        if (str != null) {
            aVarA.f(str);
        }
        return aVarA;
    }

    public String B() {
        return this.f2913b;
    }

    public String C() {
        return this.f2915d;
    }

    public String D() {
        return this.f2912a;
    }

    public boolean E() {
        return this.f2916e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0581f)) {
            return false;
        }
        C0581f c0581f = (C0581f) obj;
        return AbstractC1206q.b(this.f2912a, c0581f.f2912a) && AbstractC1206q.b(this.f2915d, c0581f.f2915d) && AbstractC1206q.b(this.f2913b, c0581f.f2913b) && AbstractC1206q.b(Boolean.valueOf(this.f2916e), Boolean.valueOf(c0581f.f2916e)) && this.f2917f == c0581f.f2917f;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f2912a, this.f2913b, this.f2915d, Boolean.valueOf(this.f2916e), Integer.valueOf(this.f2917f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, D(), false);
        Q1.c.E(parcel, 2, B(), false);
        Q1.c.E(parcel, 3, this.f2914c, false);
        Q1.c.E(parcel, 4, C(), false);
        Q1.c.g(parcel, 5, E());
        Q1.c.t(parcel, 6, this.f2917f);
        Q1.c.b(parcel, iA);
    }
}
