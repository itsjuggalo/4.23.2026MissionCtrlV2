package N1;

import android.os.Parcel;
import android.os.Parcelable;
import s3.AbstractC1024h;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: N1.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0134u extends AbstractC1255a {
    public static final Parcelable.Creator<C0134u> CREATOR = new J1.Y(25);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0131t f1796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1798d;

    public C0134u(C0134u c0134u, long j4) {
        com.google.android.gms.common.internal.I.g(c0134u);
        this.f1795a = c0134u.f1795a;
        this.f1796b = c0134u.f1796b;
        this.f1797c = c0134u.f1797c;
        this.f1798d = j4;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f1796b);
        String str = this.f1797c;
        int length = String.valueOf(str).length();
        String str2 = this.f1795a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + strValueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        return AbstractC1024h.d(sb, ",params=", strValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        J1.Y.a(this, parcel, i);
    }

    public C0134u(String str, C0131t c0131t, String str2, long j4) {
        this.f1795a = str;
        this.f1796b = c0131t;
        this.f1797c = str2;
        this.f1798d = j4;
    }
}
