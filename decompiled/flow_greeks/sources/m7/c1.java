package m7;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c1 extends n5.a {
    public static final Parcelable.Creator<c1> CREATOR = new w1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f15973e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Uri f15975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f15976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15977d;

        public c1 a() {
            String str = this.f15974a;
            Uri uri = this.f15975b;
            return new c1(str, uri == null ? null : uri.toString(), this.f15976c, this.f15977d);
        }

        public a b(String str) {
            if (str == null) {
                this.f15976c = true;
                return this;
            }
            this.f15974a = str;
            return this;
        }

        public a c(Uri uri) {
            if (uri == null) {
                this.f15977d = true;
                return this;
            }
            this.f15975b = uri;
            return this;
        }
    }

    public c1(String str, String str2, boolean z10, boolean z11) {
        this.f15969a = str;
        this.f15970b = str2;
        this.f15971c = z10;
        this.f15972d = z11;
        this.f15973e = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public Uri R() {
        return this.f15973e;
    }

    public final boolean S() {
        return this.f15971c;
    }

    public String v() {
        return this.f15969a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, v(), false);
        n5.c.E(parcel, 3, this.f15970b, false);
        n5.c.g(parcel, 4, this.f15971c);
        n5.c.g(parcel, 5, this.f15972d);
        n5.c.b(parcel, iA);
    }

    public final String zza() {
        return this.f15970b;
    }

    public final boolean zzc() {
        return this.f15972d;
    }
}
