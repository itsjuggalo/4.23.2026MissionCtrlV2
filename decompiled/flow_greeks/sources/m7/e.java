package m7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends n5.a {
    public static final Parcelable.Creator<e> CREATOR = new d1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f15989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f15990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f15991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f15993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f15994k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f15999e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f16000f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f16001g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f16002h;

        public e a() {
            if (this.f15995a != null) {
                return new e(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }

        public a b(String str, boolean z10, String str2) {
            this.f15997c = str;
            this.f15998d = z10;
            this.f15999e = str2;
            return this;
        }

        public a c(String str) {
            this.f16001g = str;
            return this;
        }

        public a d(boolean z10) {
            this.f16000f = z10;
            return this;
        }

        public a e(String str) {
            this.f15996b = str;
            return this;
        }

        public a f(String str) {
            this.f16002h = str;
            return this;
        }

        public a g(String str) {
            this.f15995a = str;
            return this;
        }

        public a() {
            this.f16000f = false;
        }
    }

    public static a Y() {
        return new a();
    }

    public static e c0() {
        return new e(new a());
    }

    public boolean R() {
        return this.f15990g;
    }

    public boolean S() {
        return this.f15988e;
    }

    public String T() {
        return this.f15989f;
    }

    public String U() {
        return this.f15987d;
    }

    public String V() {
        return this.f15985b;
    }

    public String W() {
        return this.f15994k;
    }

    public String X() {
        return this.f15984a;
    }

    public final int Z() {
        return this.f15992i;
    }

    public final void a0(int i10) {
        this.f15992i = i10;
    }

    public final void b0(String str) {
        this.f15991h = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, X(), false);
        n5.c.E(parcel, 2, V(), false);
        n5.c.E(parcel, 3, this.f15986c, false);
        n5.c.E(parcel, 4, U(), false);
        n5.c.g(parcel, 5, S());
        n5.c.E(parcel, 6, T(), false);
        n5.c.g(parcel, 7, R());
        n5.c.E(parcel, 8, this.f15991h, false);
        n5.c.t(parcel, 9, this.f15992i);
        n5.c.E(parcel, 10, this.f15993j, false);
        n5.c.E(parcel, 11, W(), false);
        n5.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f15993j;
    }

    public final String zzd() {
        return this.f15986c;
    }

    public final String zze() {
        return this.f15991h;
    }

    public e(a aVar) {
        this.f15984a = aVar.f15995a;
        this.f15985b = aVar.f15996b;
        this.f15986c = null;
        this.f15987d = aVar.f15997c;
        this.f15988e = aVar.f15998d;
        this.f15989f = aVar.f15999e;
        this.f15990g = aVar.f16000f;
        this.f15993j = aVar.f16001g;
        this.f15994k = aVar.f16002h;
    }

    public e(String str, String str2, String str3, String str4, boolean z10, String str5, boolean z11, String str6, int i10, String str7, String str8) {
        this.f15984a = str;
        this.f15985b = str2;
        this.f15986c = str3;
        this.f15987d = str4;
        this.f15988e = z10;
        this.f15989f = str5;
        this.f15990g = z11;
        this.f15991h = str6;
        this.f15992i = i10;
        this.f15993j = str7;
        this.f15994k = str8;
    }
}
