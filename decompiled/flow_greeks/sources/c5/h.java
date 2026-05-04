package c5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h extends n5.a {
    public static final Parcelable.Creator<h> CREATOR = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f3661g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f3665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3666e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3667f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3668g;

        public h a() {
            return new h(this.f3662a, this.f3663b, this.f3664c, this.f3666e, this.f3667f, this.f3668g, this.f3665d);
        }

        public a b(String str) {
            this.f3663b = str;
            return this;
        }

        public a c(List list) {
            this.f3665d = list;
            return this;
        }

        public a d(String str) {
            this.f3666e = str;
            return this;
        }

        public a e(boolean z10) {
            this.f3667f = z10;
            return this;
        }

        public a f(String str) {
            com.google.android.gms.common.internal.s.k(str);
            this.f3662a = str;
            return this;
        }

        public final a g(String str) {
            this.f3664c = str;
            return this;
        }

        public final a h(int i10) {
            this.f3668g = i10;
            return this;
        }
    }

    public h(String str, String str2, String str3, String str4, boolean z10, int i10, List list) {
        com.google.android.gms.common.internal.s.k(str);
        this.f3655a = str;
        this.f3656b = str2;
        this.f3657c = str3;
        this.f3658d = str4;
        this.f3659e = z10;
        this.f3660f = i10;
        this.f3661g = list;
    }

    public static a R() {
        return new a();
    }

    public static a X(h hVar) {
        com.google.android.gms.common.internal.s.k(hVar);
        a aVarR = R();
        aVarR.f(hVar.V());
        aVarR.d(hVar.U());
        aVarR.b(hVar.T());
        aVarR.e(hVar.f3659e);
        aVarR.h(hVar.f3660f);
        aVarR.c(hVar.S());
        String str = hVar.f3657c;
        if (str != null) {
            aVarR.g(str);
        }
        return aVarR;
    }

    public List S() {
        return this.f3661g;
    }

    public String T() {
        return this.f3656b;
    }

    public String U() {
        return this.f3658d;
    }

    public String V() {
        return this.f3655a;
    }

    public boolean W() {
        return this.f3659e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return com.google.android.gms.common.internal.q.b(this.f3655a, hVar.f3655a) && com.google.android.gms.common.internal.q.b(this.f3658d, hVar.f3658d) && com.google.android.gms.common.internal.q.b(this.f3656b, hVar.f3656b) && com.google.android.gms.common.internal.q.b(Boolean.valueOf(this.f3659e), Boolean.valueOf(hVar.f3659e)) && this.f3660f == hVar.f3660f && com.google.android.gms.common.internal.q.b(this.f3661g, hVar.f3661g);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f3655a, this.f3656b, this.f3658d, Boolean.valueOf(this.f3659e), Integer.valueOf(this.f3660f), this.f3661g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, V(), false);
        n5.c.E(parcel, 2, T(), false);
        n5.c.E(parcel, 3, this.f3657c, false);
        n5.c.E(parcel, 4, U(), false);
        n5.c.g(parcel, 5, W());
        n5.c.t(parcel, 6, this.f3660f);
        n5.c.I(parcel, 7, S(), false);
        n5.c.b(parcel, iA);
    }
}
