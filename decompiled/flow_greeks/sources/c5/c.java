package c5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends n5.a {
    public static final Parcelable.Creator<c> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f3607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f3608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f3612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0067c f3613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3614h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f3615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f3616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f3617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0067c f3618d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3619e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3620f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3621g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f3622h;

        public a() {
            e.a aVarR = e.R();
            aVarR.b(false);
            this.f3615a = aVarR.a();
            b.a aVarR2 = b.R();
            aVarR2.g(false);
            this.f3616b = aVarR2.b();
            d.a aVarR3 = d.R();
            aVarR3.b(false);
            this.f3617c = aVarR3.a();
            C0067c.a aVarR4 = C0067c.R();
            aVarR4.b(false);
            this.f3618d = aVarR4.a();
        }

        public c a() {
            return new c(this.f3615a, this.f3616b, this.f3619e, this.f3620f, this.f3621g, this.f3617c, this.f3618d, this.f3622h);
        }

        public a b(boolean z10) {
            this.f3620f = z10;
            return this;
        }

        public a c(b bVar) {
            this.f3616b = (b) com.google.android.gms.common.internal.s.k(bVar);
            return this;
        }

        public a d(C0067c c0067c) {
            this.f3618d = (C0067c) com.google.android.gms.common.internal.s.k(c0067c);
            return this;
        }

        public a e(d dVar) {
            this.f3617c = (d) com.google.android.gms.common.internal.s.k(dVar);
            return this;
        }

        public a f(e eVar) {
            this.f3615a = (e) com.google.android.gms.common.internal.s.k(eVar);
            return this;
        }

        public a g(boolean z10) {
            this.f3622h = z10;
            return this;
        }

        public final a h(String str) {
            this.f3619e = str;
            return this;
        }

        public final a i(int i10) {
            this.f3621g = i10;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends n5.a {
        public static final Parcelable.Creator<b> CREATOR = new z();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f3623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f3626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f3627e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f3628f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f3629g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List f3630h;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f3631a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f3632b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f3633c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f3634d = true;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f3635e = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public List f3636f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public boolean f3637g = false;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public List f3638h = null;

            public a a(String str, List list) {
                this.f3635e = (String) com.google.android.gms.common.internal.s.l(str, "linkedServiceId must be provided if you want to associate linked accounts.");
                this.f3636f = list;
                return this;
            }

            public b b() {
                return new b(this.f3631a, this.f3632b, this.f3633c, this.f3634d, this.f3635e, this.f3636f, this.f3637g, this.f3638h);
            }

            public a c(boolean z10) {
                this.f3634d = z10;
                return this;
            }

            public a d(String str) {
                this.f3633c = str;
                return this;
            }

            public a e(boolean z10) {
                this.f3637g = z10;
                return this;
            }

            public a f(String str) {
                this.f3632b = com.google.android.gms.common.internal.s.e(str);
                return this;
            }

            public a g(boolean z10) {
                this.f3631a = z10;
                return this;
            }
        }

        public b(boolean z10, String str, String str2, boolean z11, String str3, List list, boolean z12, List list2) {
            boolean z13 = true;
            if (z11 && z12) {
                z13 = false;
            }
            com.google.android.gms.common.internal.s.b(z13, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.f3623a = z10;
            if (z10) {
                com.google.android.gms.common.internal.s.l(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f3624b = str;
            this.f3625c = str2;
            this.f3626d = z11;
            Parcelable.Creator<c> creator = c.CREATOR;
            ArrayList arrayList = null;
            if (list != null && !list.isEmpty()) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList);
            }
            this.f3628f = arrayList;
            this.f3627e = str3;
            this.f3629g = z12;
            this.f3630h = list2;
        }

        public static a R() {
            return new a();
        }

        public boolean S() {
            return this.f3626d;
        }

        public List T() {
            return this.f3630h;
        }

        public List U() {
            return this.f3628f;
        }

        public String V() {
            return this.f3627e;
        }

        public String W() {
            return this.f3625c;
        }

        public String X() {
            return this.f3624b;
        }

        public boolean Y() {
            return this.f3623a;
        }

        public boolean Z() {
            return this.f3629g;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3623a == bVar.f3623a && com.google.android.gms.common.internal.q.b(this.f3624b, bVar.f3624b) && com.google.android.gms.common.internal.q.b(this.f3625c, bVar.f3625c) && this.f3626d == bVar.f3626d && com.google.android.gms.common.internal.q.b(this.f3627e, bVar.f3627e) && com.google.android.gms.common.internal.q.b(this.f3628f, bVar.f3628f) && this.f3629g == bVar.f3629g && com.google.android.gms.common.internal.q.b(this.f3630h, bVar.f3630h);
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f3623a), this.f3624b, this.f3625c, Boolean.valueOf(this.f3626d), this.f3627e, this.f3628f, Boolean.valueOf(this.f3629g), this.f3630h);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int iA = n5.c.a(parcel);
            n5.c.g(parcel, 1, Y());
            n5.c.E(parcel, 2, X(), false);
            n5.c.E(parcel, 3, W(), false);
            n5.c.g(parcel, 4, S());
            n5.c.E(parcel, 5, V(), false);
            n5.c.G(parcel, 6, U(), false);
            n5.c.g(parcel, 7, Z());
            n5.c.I(parcel, 8, T(), false);
            n5.c.b(parcel, iA);
        }
    }

    /* JADX INFO: renamed from: c5.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0067c extends n5.a {
        public static final Parcelable.Creator<C0067c> CREATOR = new a0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f3639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3640b;

        /* JADX INFO: renamed from: c5.c$c$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f3641a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f3642b;

            public C0067c a() {
                return new C0067c(this.f3641a, this.f3642b);
            }

            public a b(boolean z10) {
                this.f3641a = z10;
                return this;
            }
        }

        public C0067c(boolean z10, String str) {
            if (z10) {
                com.google.android.gms.common.internal.s.k(str);
            }
            this.f3639a = z10;
            this.f3640b = str;
        }

        public static a R() {
            return new a();
        }

        public String S() {
            return this.f3640b;
        }

        public boolean T() {
            return this.f3639a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0067c)) {
                return false;
            }
            C0067c c0067c = (C0067c) obj;
            return this.f3639a == c0067c.f3639a && com.google.android.gms.common.internal.q.b(this.f3640b, c0067c.f3640b);
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f3639a), this.f3640b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int iA = n5.c.a(parcel);
            n5.c.g(parcel, 1, T());
            n5.c.E(parcel, 2, S(), false);
            n5.c.b(parcel, iA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends n5.a {
        public static final Parcelable.Creator<d> CREATOR = new b0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f3643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f3644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3645c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f3646a = false;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public byte[] f3647b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f3648c;

            public d a() {
                return new d(this.f3646a, this.f3647b, this.f3648c);
            }

            public a b(boolean z10) {
                this.f3646a = z10;
                return this;
            }
        }

        public d(boolean z10, byte[] bArr, String str) {
            if (z10) {
                com.google.android.gms.common.internal.s.k(bArr);
                com.google.android.gms.common.internal.s.k(str);
            }
            this.f3643a = z10;
            this.f3644b = bArr;
            this.f3645c = str;
        }

        public static a R() {
            return new a();
        }

        public byte[] S() {
            return this.f3644b;
        }

        public String T() {
            return this.f3645c;
        }

        public boolean U() {
            return this.f3643a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f3643a == dVar.f3643a && Arrays.equals(this.f3644b, dVar.f3644b) && Objects.equals(this.f3645c, dVar.f3645c);
        }

        public int hashCode() {
            return (Objects.hash(Boolean.valueOf(this.f3643a), this.f3645c) * 31) + Arrays.hashCode(this.f3644b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int iA = n5.c.a(parcel);
            n5.c.g(parcel, 1, U());
            n5.c.k(parcel, 2, S(), false);
            n5.c.E(parcel, 3, T(), false);
            n5.c.b(parcel, iA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends n5.a {
        public static final Parcelable.Creator<e> CREATOR = new c0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f3649a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f3650a = false;

            public e a() {
                return new e(this.f3650a);
            }

            public a b(boolean z10) {
                this.f3650a = z10;
                return this;
            }
        }

        public e(boolean z10) {
            this.f3649a = z10;
        }

        public static a R() {
            return new a();
        }

        public boolean S() {
            return this.f3649a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof e) && this.f3649a == ((e) obj).f3649a;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f3649a));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int iA = n5.c.a(parcel);
            n5.c.g(parcel, 1, S());
            n5.c.b(parcel, iA);
        }
    }

    public c(e eVar, b bVar, String str, boolean z10, int i10, d dVar, C0067c c0067c, boolean z11) {
        this.f3607a = (e) com.google.android.gms.common.internal.s.k(eVar);
        this.f3608b = (b) com.google.android.gms.common.internal.s.k(bVar);
        this.f3609c = str;
        this.f3610d = z10;
        this.f3611e = i10;
        if (dVar == null) {
            d.a aVarR = d.R();
            aVarR.b(false);
            dVar = aVarR.a();
        }
        this.f3612f = dVar;
        if (c0067c == null) {
            C0067c.a aVarR2 = C0067c.R();
            aVarR2.b(false);
            c0067c = aVarR2.a();
        }
        this.f3613g = c0067c;
        this.f3614h = z11;
    }

    public static a R() {
        return new a();
    }

    public static a Y(c cVar) {
        com.google.android.gms.common.internal.s.k(cVar);
        a aVarR = R();
        aVarR.c(cVar.S());
        aVarR.f(cVar.V());
        aVarR.e(cVar.U());
        aVarR.d(cVar.T());
        aVarR.b(cVar.f3610d);
        aVarR.i(cVar.f3611e);
        aVarR.g(cVar.f3614h);
        String str = cVar.f3609c;
        if (str != null) {
            aVarR.h(str);
        }
        return aVarR;
    }

    public b S() {
        return this.f3608b;
    }

    public C0067c T() {
        return this.f3613g;
    }

    public d U() {
        return this.f3612f;
    }

    public e V() {
        return this.f3607a;
    }

    public boolean W() {
        return this.f3614h;
    }

    public boolean X() {
        return this.f3610d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return com.google.android.gms.common.internal.q.b(this.f3607a, cVar.f3607a) && com.google.android.gms.common.internal.q.b(this.f3608b, cVar.f3608b) && com.google.android.gms.common.internal.q.b(this.f3612f, cVar.f3612f) && com.google.android.gms.common.internal.q.b(this.f3613g, cVar.f3613g) && com.google.android.gms.common.internal.q.b(this.f3609c, cVar.f3609c) && this.f3610d == cVar.f3610d && this.f3611e == cVar.f3611e && this.f3614h == cVar.f3614h;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f3607a, this.f3608b, this.f3612f, this.f3613g, this.f3609c, Boolean.valueOf(this.f3610d), Integer.valueOf(this.f3611e), Boolean.valueOf(this.f3614h));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, V(), i10, false);
        n5.c.C(parcel, 2, S(), i10, false);
        n5.c.E(parcel, 3, this.f3609c, false);
        n5.c.g(parcel, 4, X());
        n5.c.t(parcel, 5, this.f3611e);
        n5.c.C(parcel, 6, U(), i10, false);
        n5.c.C(parcel, 7, T(), i10, false);
        n5.c.g(parcel, 8, W());
        n5.c.b(parcel, iA);
    }
}
