package r1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: r1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1745b extends A1.a {
    public static final Parcelable.Creator<C1745b> CREATOR = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0234b f14487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f14491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f14492g;

    /* JADX INFO: renamed from: r1.b$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f14493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C0234b f14494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f14495c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f14496d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f14497e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f14498f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14499g;

        public a() {
            e.a aVarI = e.i();
            aVarI.b(false);
            this.f14493a = aVarI.a();
            C0234b.a aVarI2 = C0234b.i();
            aVarI2.b(false);
            this.f14494b = aVarI2.a();
            d.a aVarI3 = d.i();
            aVarI3.b(false);
            this.f14495c = aVarI3.a();
            c.a aVarI4 = c.i();
            aVarI4.b(false);
            this.f14496d = aVarI4.a();
        }

        public C1745b a() {
            return new C1745b(this.f14493a, this.f14494b, this.f14497e, this.f14498f, this.f14499g, this.f14495c, this.f14496d);
        }

        public a b(boolean z4) {
            this.f14498f = z4;
            return this;
        }

        public a c(C0234b c0234b) {
            this.f14494b = (C0234b) AbstractC0940s.k(c0234b);
            return this;
        }

        public a d(c cVar) {
            this.f14496d = (c) AbstractC0940s.k(cVar);
            return this;
        }

        public a e(d dVar) {
            this.f14495c = (d) AbstractC0940s.k(dVar);
            return this;
        }

        public a f(e eVar) {
            this.f14493a = (e) AbstractC0940s.k(eVar);
            return this;
        }

        public final a g(String str) {
            this.f14497e = str;
            return this;
        }

        public final a h(int i4) {
            this.f14499g = i4;
            return this;
        }
    }

    /* JADX INFO: renamed from: r1.b$b, reason: collision with other inner class name */
    public static final class C0234b extends A1.a {
        public static final Parcelable.Creator<C0234b> CREATOR = new w();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f14500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f14501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f14502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f14503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f14504e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f14505f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f14506g;

        /* JADX INFO: renamed from: r1.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f14507a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f14508b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f14509c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f14510d = true;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f14511e = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public List f14512f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public boolean f14513g = false;

            public C0234b a() {
                return new C0234b(this.f14507a, this.f14508b, this.f14509c, this.f14510d, this.f14511e, this.f14512f, this.f14513g);
            }

            public a b(boolean z4) {
                this.f14507a = z4;
                return this;
            }
        }

        public C0234b(boolean z4, String str, String str2, boolean z5, String str3, List list, boolean z6) {
            boolean z7 = true;
            if (z5 && z6) {
                z7 = false;
            }
            AbstractC0940s.b(z7, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.f14500a = z4;
            if (z4) {
                AbstractC0940s.l(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f14501b = str;
            this.f14502c = str2;
            this.f14503d = z5;
            Parcelable.Creator<C1745b> creator = C1745b.CREATOR;
            ArrayList arrayList = null;
            if (list != null && !list.isEmpty()) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList);
            }
            this.f14505f = arrayList;
            this.f14504e = str3;
            this.f14506g = z6;
        }

        public static a i() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0234b)) {
                return false;
            }
            C0234b c0234b = (C0234b) obj;
            return this.f14500a == c0234b.f14500a && AbstractC0939q.b(this.f14501b, c0234b.f14501b) && AbstractC0939q.b(this.f14502c, c0234b.f14502c) && this.f14503d == c0234b.f14503d && AbstractC0939q.b(this.f14504e, c0234b.f14504e) && AbstractC0939q.b(this.f14505f, c0234b.f14505f) && this.f14506g == c0234b.f14506g;
        }

        public int hashCode() {
            return AbstractC0939q.c(Boolean.valueOf(this.f14500a), this.f14501b, this.f14502c, Boolean.valueOf(this.f14503d), this.f14504e, this.f14505f, Boolean.valueOf(this.f14506g));
        }

        public boolean k() {
            return this.f14503d;
        }

        public List l() {
            return this.f14505f;
        }

        public String m() {
            return this.f14504e;
        }

        public String n() {
            return this.f14502c;
        }

        public String o() {
            return this.f14501b;
        }

        public boolean p() {
            return this.f14500a;
        }

        public boolean q() {
            return this.f14506g;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            int iA = A1.c.a(parcel);
            A1.c.g(parcel, 1, p());
            A1.c.E(parcel, 2, o(), false);
            A1.c.E(parcel, 3, n(), false);
            A1.c.g(parcel, 4, k());
            A1.c.E(parcel, 5, m(), false);
            A1.c.G(parcel, 6, l(), false);
            A1.c.g(parcel, 7, q());
            A1.c.b(parcel, iA);
        }
    }

    /* JADX INFO: renamed from: r1.b$c */
    public static final class c extends A1.a {
        public static final Parcelable.Creator<c> CREATOR = new x();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f14514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f14515b;

        /* JADX INFO: renamed from: r1.b$c$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f14516a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f14517b;

            public c a() {
                return new c(this.f14516a, this.f14517b);
            }

            public a b(boolean z4) {
                this.f14516a = z4;
                return this;
            }
        }

        public c(boolean z4, String str) {
            if (z4) {
                AbstractC0940s.k(str);
            }
            this.f14514a = z4;
            this.f14515b = str;
        }

        public static a i() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f14514a == cVar.f14514a && AbstractC0939q.b(this.f14515b, cVar.f14515b);
        }

        public int hashCode() {
            return AbstractC0939q.c(Boolean.valueOf(this.f14514a), this.f14515b);
        }

        public String k() {
            return this.f14515b;
        }

        public boolean l() {
            return this.f14514a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            int iA = A1.c.a(parcel);
            A1.c.g(parcel, 1, l());
            A1.c.E(parcel, 2, k(), false);
            A1.c.b(parcel, iA);
        }
    }

    /* JADX INFO: renamed from: r1.b$d */
    public static final class d extends A1.a {
        public static final Parcelable.Creator<d> CREATOR = new y();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f14518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f14519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f14520c;

        /* JADX INFO: renamed from: r1.b$d$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f14521a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public byte[] f14522b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f14523c;

            public d a() {
                return new d(this.f14521a, this.f14522b, this.f14523c);
            }

            public a b(boolean z4) {
                this.f14521a = z4;
                return this;
            }
        }

        public d(boolean z4, byte[] bArr, String str) {
            if (z4) {
                AbstractC0940s.k(bArr);
                AbstractC0940s.k(str);
            }
            this.f14518a = z4;
            this.f14519b = bArr;
            this.f14520c = str;
        }

        public static a i() {
            return new a();
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
            return this.f14518a == dVar.f14518a && Arrays.equals(this.f14519b, dVar.f14519b) && ((str = this.f14520c) == (str2 = dVar.f14520c) || (str != null && str.equals(str2)));
        }

        public int hashCode() {
            return (Arrays.hashCode(new Object[]{Boolean.valueOf(this.f14518a), this.f14520c}) * 31) + Arrays.hashCode(this.f14519b);
        }

        public byte[] k() {
            return this.f14519b;
        }

        public String l() {
            return this.f14520c;
        }

        public boolean m() {
            return this.f14518a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            int iA = A1.c.a(parcel);
            A1.c.g(parcel, 1, m());
            A1.c.k(parcel, 2, k(), false);
            A1.c.E(parcel, 3, l(), false);
            A1.c.b(parcel, iA);
        }
    }

    /* JADX INFO: renamed from: r1.b$e */
    public static final class e extends A1.a {
        public static final Parcelable.Creator<e> CREATOR = new z();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f14524a;

        /* JADX INFO: renamed from: r1.b$e$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f14525a = false;

            public e a() {
                return new e(this.f14525a);
            }

            public a b(boolean z4) {
                this.f14525a = z4;
                return this;
            }
        }

        public e(boolean z4) {
            this.f14524a = z4;
        }

        public static a i() {
            return new a();
        }

        public boolean equals(Object obj) {
            return (obj instanceof e) && this.f14524a == ((e) obj).f14524a;
        }

        public int hashCode() {
            return AbstractC0939q.c(Boolean.valueOf(this.f14524a));
        }

        public boolean k() {
            return this.f14524a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            int iA = A1.c.a(parcel);
            A1.c.g(parcel, 1, k());
            A1.c.b(parcel, iA);
        }
    }

    public C1745b(e eVar, C0234b c0234b, String str, boolean z4, int i4, d dVar, c cVar) {
        this.f14486a = (e) AbstractC0940s.k(eVar);
        this.f14487b = (C0234b) AbstractC0940s.k(c0234b);
        this.f14488c = str;
        this.f14489d = z4;
        this.f14490e = i4;
        if (dVar == null) {
            d.a aVarI = d.i();
            aVarI.b(false);
            dVar = aVarI.a();
        }
        this.f14491f = dVar;
        if (cVar == null) {
            c.a aVarI2 = c.i();
            aVarI2.b(false);
            cVar = aVarI2.a();
        }
        this.f14492g = cVar;
    }

    public static a i() {
        return new a();
    }

    public static a p(C1745b c1745b) {
        AbstractC0940s.k(c1745b);
        a aVarI = i();
        aVarI.c(c1745b.k());
        aVarI.f(c1745b.n());
        aVarI.e(c1745b.m());
        aVarI.d(c1745b.l());
        aVarI.b(c1745b.f14489d);
        aVarI.h(c1745b.f14490e);
        String str = c1745b.f14488c;
        if (str != null) {
            aVarI.g(str);
        }
        return aVarI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1745b)) {
            return false;
        }
        C1745b c1745b = (C1745b) obj;
        return AbstractC0939q.b(this.f14486a, c1745b.f14486a) && AbstractC0939q.b(this.f14487b, c1745b.f14487b) && AbstractC0939q.b(this.f14491f, c1745b.f14491f) && AbstractC0939q.b(this.f14492g, c1745b.f14492g) && AbstractC0939q.b(this.f14488c, c1745b.f14488c) && this.f14489d == c1745b.f14489d && this.f14490e == c1745b.f14490e;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f14486a, this.f14487b, this.f14491f, this.f14492g, this.f14488c, Boolean.valueOf(this.f14489d));
    }

    public C0234b k() {
        return this.f14487b;
    }

    public c l() {
        return this.f14492g;
    }

    public d m() {
        return this.f14491f;
    }

    public e n() {
        return this.f14486a;
    }

    public boolean o() {
        return this.f14489d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 1, n(), i4, false);
        A1.c.C(parcel, 2, k(), i4, false);
        A1.c.E(parcel, 3, this.f14488c, false);
        A1.c.g(parcel, 4, o());
        A1.c.t(parcel, 5, this.f14490e);
        A1.c.C(parcel, 6, m(), i4, false);
        A1.c.C(parcel, 7, l(), i4, false);
        A1.c.b(parcel, iA);
    }
}
