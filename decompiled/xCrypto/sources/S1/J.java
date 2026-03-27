package S1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class J extends A1.a {
    public static final Parcelable.Creator<J> CREATOR = new K();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H f4006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4008d;

    public J(J j4, long j5) {
        AbstractC0940s.k(j4);
        this.f4005a = j4.f4005a;
        this.f4006b = j4.f4006b;
        this.f4007c = j4.f4007c;
        this.f4008d = j5;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f4006b);
        String str = this.f4007c;
        int length = String.valueOf(str).length();
        String str2 = this.f4005a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + strValueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(strValueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        K.a(this, parcel, i4);
    }

    public J(String str, H h4, String str2, long j4) {
        this.f4005a = str;
        this.f4006b = h4;
        this.f4007c = str2;
        this.f4008d = j4;
    }
}
