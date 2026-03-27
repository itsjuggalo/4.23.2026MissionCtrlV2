package I1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: I1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0577b extends Q1.a {
    public static final Parcelable.Creator<C0577b> CREATOR = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0029b f2871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f2875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f2876g;

    /* JADX INFO: renamed from: I1.b$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f2877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C0029b f2878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f2879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f2880d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f2881e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2882f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2883g;

        public a() {
            e.a aVarA = e.A();
            aVarA.b(false);
            this.f2877a = aVarA.a();
            C0029b.a aVarA2 = C0029b.A();
            aVarA2.b(false);
            this.f2878b = aVarA2.a();
            d.a aVarA3 = d.A();
            aVarA3.b(false);
            this.f2879c = aVarA3.a();
            c.a aVarA4 = c.A();
            aVarA4.b(false);
            this.f2880d = aVarA4.a();
        }

        public C0577b a() {
            return new C0577b(this.f2877a, this.f2878b, this.f2881e, this.f2882f, this.f2883g, this.f2879c, this.f2880d);
        }

        public a b(boolean z7) {
            this.f2882f = z7;
            return this;
        }

        public a c(C0029b c0029b) {
            this.f2878b = (C0029b) AbstractC1207s.k(c0029b);
            return this;
        }

        public a d(c cVar) {
            this.f2880d = (c) AbstractC1207s.k(cVar);
            return this;
        }

        public a e(d dVar) {
            this.f2879c = (d) AbstractC1207s.k(dVar);
            return this;
        }

        public a f(e eVar) {
            this.f2877a = (e) AbstractC1207s.k(eVar);
            return this;
        }

        public final a g(String str) {
            this.f2881e = str;
            return this;
        }

        public final a h(int i7) {
            this.f2883g = i7;
            return this;
        }
    }

    /* JADX INFO: renamed from: I1.b$b, reason: collision with other inner class name */
    public static final class C0029b extends Q1.a {
        public static final Parcelable.Creator<C0029b> CREATOR = new w();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f2887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f2888e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f2889f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f2890g;

        /* JADX INFO: renamed from: I1.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f2891a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f2892b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f2893c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f2894d = true;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f2895e = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public List f2896f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public boolean f2897g = false;

            public C0029b a() {
                return new C0029b(this.f2891a, this.f2892b, this.f2893c, this.f2894d, this.f2895e, this.f2896f, this.f2897g);
            }

            public a b(boolean z7) {
                this.f2891a = z7;
                return this;
            }
        }

        public C0029b(boolean z7, String str, String str2, boolean z8, String str3, List list, boolean z9) {
            boolean z10 = true;
            if (z8 && z9) {
                z10 = false;
            }
            AbstractC1207s.b(z10, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.f2884a = z7;
            if (z7) {
                AbstractC1207s.l(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f2885b = str;
            this.f2886c = str2;
            this.f2887d = z8;
            Parcelable.Creator<C0577b> creator = C0577b.CREATOR;
            ArrayList arrayList = null;
            if (list != null && !list.isEmpty()) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList);
            }
            this.f2889f = arrayList;
            this.f2888e = str3;
            this.f2890g = z9;
        }

        public static a A() {
            return new a();
        }

        public boolean B() {
            return this.f2887d;
        }

        public List C() {
            return this.f2889f;
        }

        public String D() {
            return this.f2888e;
        }

        public String E() {
            return this.f2886c;
        }

        public String F() {
            return this.f2885b;
        }

        public boolean G() {
            return this.f2884a;
        }

        public boolean H() {
            return this.f2890g;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0029b)) {
                return false;
            }
            C0029b c0029b = (C0029b) obj;
            return this.f2884a == c0029b.f2884a && AbstractC1206q.b(this.f2885b, c0029b.f2885b) && AbstractC1206q.b(this.f2886c, c0029b.f2886c) && this.f2887d == c0029b.f2887d && AbstractC1206q.b(this.f2888e, c0029b.f2888e) && AbstractC1206q.b(this.f2889f, c0029b.f2889f) && this.f2890g == c0029b.f2890g;
        }

        public int hashCode() {
            return AbstractC1206q.c(Boolean.valueOf(this.f2884a), this.f2885b, this.f2886c, Boolean.valueOf(this.f2887d), this.f2888e, this.f2889f, Boolean.valueOf(this.f2890g));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            int iA = Q1.c.a(parcel);
            Q1.c.g(parcel, 1, G());
            Q1.c.E(parcel, 2, F(), false);
            Q1.c.E(parcel, 3, E(), false);
            Q1.c.g(parcel, 4, B());
            Q1.c.E(parcel, 5, D(), false);
            Q1.c.G(parcel, 6, C(), false);
            Q1.c.g(parcel, 7, H());
            Q1.c.b(parcel, iA);
        }
    }

    /* JADX INFO: renamed from: I1.b$c */
    public static final class c extends Q1.a {
        public static final Parcelable.Creator<c> CREATOR = new x();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2899b;

        /* JADX INFO: renamed from: I1.b$c$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f2900a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f2901b;

            public c a() {
                return new c(this.f2900a, this.f2901b);
            }

            public a b(boolean z7) {
                this.f2900a = z7;
                return this;
            }
        }

        public c(boolean z7, String str) {
            if (z7) {
                AbstractC1207s.k(str);
            }
            this.f2898a = z7;
            this.f2899b = str;
        }

        public static a A() {
            return new a();
        }

        public String B() {
            return this.f2899b;
        }

        public boolean C() {
            return this.f2898a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f2898a == cVar.f2898a && AbstractC1206q.b(this.f2899b, cVar.f2899b);
        }

        public int hashCode() {
            return AbstractC1206q.c(Boolean.valueOf(this.f2898a), this.f2899b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            int iA = Q1.c.a(parcel);
            Q1.c.g(parcel, 1, C());
            Q1.c.E(parcel, 2, B(), false);
            Q1.c.b(parcel, iA);
        }
    }

    /* JADX INFO: renamed from: I1.b$d */
    public static final class d extends Q1.a {
        public static final Parcelable.Creator<d> CREATOR = new y();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f2903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2904c;

        /* JADX INFO: renamed from: I1.b$d$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f2905a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public byte[] f2906b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f2907c;

            public d a() {
                return new d(this.f2905a, this.f2906b, this.f2907c);
            }

            public a b(boolean z7) {
                this.f2905a = z7;
                return this;
            }
        }

        public d(boolean z7, byte[] bArr, String str) {
            if (z7) {
                AbstractC1207s.k(bArr);
                AbstractC1207s.k(str);
            }
            this.f2902a = z7;
            this.f2903b = bArr;
            this.f2904c = str;
        }

        public static a A() {
            return new a();
        }

        public byte[] B() {
            return this.f2903b;
        }

        public String C() {
            return this.f2904c;
        }

        public boolean D() {
            return this.f2902a;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f2902a == dVar.f2902a && Arrays.equals(this.f2903b, dVar.f2903b) && ((str = this.f2904c) == (str2 = dVar.f2904c) || (str != null && str.equals(str2)));
        }

        public int hashCode() {
            return (Arrays.hashCode(new Object[]{Boolean.valueOf(this.f2902a), this.f2904c}) * 31) + Arrays.hashCode(this.f2903b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            int iA = Q1.c.a(parcel);
            Q1.c.g(parcel, 1, D());
            Q1.c.k(parcel, 2, B(), false);
            Q1.c.E(parcel, 3, C(), false);
            Q1.c.b(parcel, iA);
        }
    }

    /* JADX INFO: renamed from: I1.b$e */
    public static final class e extends Q1.a {
        public static final Parcelable.Creator<e> CREATOR = new z();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2908a;

        /* JADX INFO: renamed from: I1.b$e$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f2909a = false;

            public e a() {
                return new e(this.f2909a);
            }

            public a b(boolean z7) {
                this.f2909a = z7;
                return this;
            }
        }

        public e(boolean z7) {
            this.f2908a = z7;
        }

        public static a A() {
            return new a();
        }

        public boolean B() {
            return this.f2908a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof e) && this.f2908a == ((e) obj).f2908a;
        }

        public int hashCode() {
            return AbstractC1206q.c(Boolean.valueOf(this.f2908a));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            int iA = Q1.c.a(parcel);
            Q1.c.g(parcel, 1, B());
            Q1.c.b(parcel, iA);
        }
    }

    public C0577b(e eVar, C0029b c0029b, String str, boolean z7, int i7, d dVar, c cVar) {
        this.f2870a = (e) AbstractC1207s.k(eVar);
        this.f2871b = (C0029b) AbstractC1207s.k(c0029b);
        this.f2872c = str;
        this.f2873d = z7;
        this.f2874e = i7;
        if (dVar == null) {
            d.a aVarA = d.A();
            aVarA.b(false);
            dVar = aVarA.a();
        }
        this.f2875f = dVar;
        if (cVar == null) {
            c.a aVarA2 = c.A();
            aVarA2.b(false);
            cVar = aVarA2.a();
        }
        this.f2876g = cVar;
    }

    public static a A() {
        return new a();
    }

    public static a G(C0577b c0577b) {
        AbstractC1207s.k(c0577b);
        a aVarA = A();
        aVarA.c(c0577b.B());
        aVarA.f(c0577b.E());
        aVarA.e(c0577b.D());
        aVarA.d(c0577b.C());
        aVarA.b(c0577b.f2873d);
        aVarA.h(c0577b.f2874e);
        String str = c0577b.f2872c;
        if (str != null) {
            aVarA.g(str);
        }
        return aVarA;
    }

    public C0029b B() {
        return this.f2871b;
    }

    public c C() {
        return this.f2876g;
    }

    public d D() {
        return this.f2875f;
    }

    public e E() {
        return this.f2870a;
    }

    public boolean F() {
        return this.f2873d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0577b)) {
            return false;
        }
        C0577b c0577b = (C0577b) obj;
        return AbstractC1206q.b(this.f2870a, c0577b.f2870a) && AbstractC1206q.b(this.f2871b, c0577b.f2871b) && AbstractC1206q.b(this.f2875f, c0577b.f2875f) && AbstractC1206q.b(this.f2876g, c0577b.f2876g) && AbstractC1206q.b(this.f2872c, c0577b.f2872c) && this.f2873d == c0577b.f2873d && this.f2874e == c0577b.f2874e;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f2870a, this.f2871b, this.f2875f, this.f2876g, this.f2872c, Boolean.valueOf(this.f2873d));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, E(), i7, false);
        Q1.c.C(parcel, 2, B(), i7, false);
        Q1.c.E(parcel, 3, this.f2872c, false);
        Q1.c.g(parcel, 4, F());
        Q1.c.t(parcel, 5, this.f2874e);
        Q1.c.C(parcel, 6, D(), i7, false);
        Q1.c.C(parcel, 7, C(), i7, false);
        Q1.c.b(parcel, iA);
    }
}
