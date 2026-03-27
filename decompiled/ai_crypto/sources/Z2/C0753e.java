package Z2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: Z2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0753e extends Q1.a {
    public static final Parcelable.Creator<C0753e> CREATOR = new x0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f5767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f5769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f5772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5773k;

    /* JADX INFO: renamed from: Z2.e$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5777d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f5778e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f5779f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f5780g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f5781h;

        public C0753e a() {
            if (this.f5774a != null) {
                return new C0753e(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }

        public a b(String str, boolean z7, String str2) {
            this.f5776c = str;
            this.f5777d = z7;
            this.f5778e = str2;
            return this;
        }

        public a c(String str) {
            this.f5780g = str;
            return this;
        }

        public a d(boolean z7) {
            this.f5779f = z7;
            return this;
        }

        public a e(String str) {
            this.f5775b = str;
            return this;
        }

        public a f(String str) {
            this.f5781h = str;
            return this;
        }

        public a g(String str) {
            this.f5774a = str;
            return this;
        }

        public a() {
            this.f5779f = false;
        }
    }

    public static a H() {
        return new a();
    }

    public static C0753e L() {
        return new C0753e(new a());
    }

    public boolean A() {
        return this.f5769g;
    }

    public boolean B() {
        return this.f5767e;
    }

    public String C() {
        return this.f5768f;
    }

    public String D() {
        return this.f5766d;
    }

    public String E() {
        return this.f5764b;
    }

    public String F() {
        return this.f5773k;
    }

    public String G() {
        return this.f5763a;
    }

    public final int I() {
        return this.f5771i;
    }

    public final void J(int i7) {
        this.f5771i = i7;
    }

    public final void K(String str) {
        this.f5770h = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, G(), false);
        Q1.c.E(parcel, 2, E(), false);
        Q1.c.E(parcel, 3, this.f5765c, false);
        Q1.c.E(parcel, 4, D(), false);
        Q1.c.g(parcel, 5, B());
        Q1.c.E(parcel, 6, C(), false);
        Q1.c.g(parcel, 7, A());
        Q1.c.E(parcel, 8, this.f5770h, false);
        Q1.c.t(parcel, 9, this.f5771i);
        Q1.c.E(parcel, 10, this.f5772j, false);
        Q1.c.E(parcel, 11, F(), false);
        Q1.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f5772j;
    }

    public final String zzd() {
        return this.f5765c;
    }

    public final String zze() {
        return this.f5770h;
    }

    public C0753e(a aVar) {
        this.f5763a = aVar.f5774a;
        this.f5764b = aVar.f5775b;
        this.f5765c = null;
        this.f5766d = aVar.f5776c;
        this.f5767e = aVar.f5777d;
        this.f5768f = aVar.f5778e;
        this.f5769g = aVar.f5779f;
        this.f5772j = aVar.f5780g;
        this.f5773k = aVar.f5781h;
    }

    public C0753e(String str, String str2, String str3, String str4, boolean z7, String str5, boolean z8, String str6, int i7, String str7, String str8) {
        this.f5763a = str;
        this.f5764b = str2;
        this.f5765c = str3;
        this.f5766d = str4;
        this.f5767e = z7;
        this.f5768f = str5;
        this.f5769g = z8;
        this.f5770h = str6;
        this.f5771i = i7;
        this.f5772j = str7;
        this.f5773k = str8;
    }
}
