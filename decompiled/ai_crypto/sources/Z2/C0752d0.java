package Z2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: renamed from: Z2.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0752d0 extends Q1.a {
    public static final Parcelable.Creator<C0752d0> CREATOR = new w0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f5758e;

    /* JADX INFO: renamed from: Z2.d0$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Uri f5760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5761c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5762d;

        public C0752d0 a() {
            String str = this.f5759a;
            Uri uri = this.f5760b;
            return new C0752d0(str, uri == null ? null : uri.toString(), this.f5761c, this.f5762d);
        }

        public a b(String str) {
            if (str == null) {
                this.f5761c = true;
            } else {
                this.f5759a = str;
            }
            return this;
        }

        public a c(Uri uri) {
            if (uri == null) {
                this.f5762d = true;
            } else {
                this.f5760b = uri;
            }
            return this;
        }
    }

    public C0752d0(String str, String str2, boolean z7, boolean z8) {
        this.f5754a = str;
        this.f5755b = str2;
        this.f5756c = z7;
        this.f5757d = z8;
        this.f5758e = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public Uri A() {
        return this.f5758e;
    }

    public final boolean B() {
        return this.f5756c;
    }

    public String p() {
        return this.f5754a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, p(), false);
        Q1.c.E(parcel, 3, this.f5755b, false);
        Q1.c.g(parcel, 4, this.f5756c);
        Q1.c.g(parcel, 5, this.f5757d);
        Q1.c.b(parcel, iA);
    }

    public final String zza() {
        return this.f5755b;
    }

    public final boolean zzc() {
        return this.f5757d;
    }
}
