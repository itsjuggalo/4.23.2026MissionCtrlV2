package i2;

import android.os.Parcel;
import android.os.Parcelable;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: i2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0656b extends AbstractC1255a {
    public static final Parcelable.Creator<C0656b> CREATOR = new com.google.android.gms.common.internal.Q(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6777d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f6778f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f6779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f6780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f6782n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f6783o;

    public C0656b(C0655a c0655a) {
        this.f6774a = (String) c0655a.f6769c;
        this.f6775b = (String) c0655a.f6770d;
        this.f6776c = null;
        this.f6777d = (String) c0655a.e;
        this.e = c0655a.f6767a;
        this.f6778f = (String) c0655a.f6771f;
        this.f6779k = c0655a.f6768b;
        this.f6782n = (String) c0655a.f6772g;
        this.f6783o = (String) c0655a.f6773h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 1, this.f6774a, false);
        u0.T(parcel, 2, this.f6775b, false);
        u0.T(parcel, 3, this.f6776c, false);
        u0.T(parcel, 4, this.f6777d, false);
        u0.b0(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        u0.T(parcel, 6, this.f6778f, false);
        u0.b0(parcel, 7, 4);
        parcel.writeInt(this.f6779k ? 1 : 0);
        u0.T(parcel, 8, this.f6780l, false);
        int i6 = this.f6781m;
        u0.b0(parcel, 9, 4);
        parcel.writeInt(i6);
        u0.T(parcel, 10, this.f6782n, false);
        u0.T(parcel, 11, this.f6783o, false);
        u0.a0(iX, parcel);
    }

    public C0656b(String str, String str2, String str3, String str4, boolean z6, String str5, boolean z7, String str6, int i, String str7, String str8) {
        this.f6774a = str;
        this.f6775b = str2;
        this.f6776c = str3;
        this.f6777d = str4;
        this.e = z6;
        this.f6778f = str5;
        this.f6779k = z7;
        this.f6780l = str6;
        this.f6781m = i;
        this.f6782n = str7;
        this.f6783o = str8;
    }
}
