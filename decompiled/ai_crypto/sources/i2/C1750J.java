package i2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: i2.J, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1750J extends Q1.a {
    public static final Parcelable.Creator<C1750J> CREATOR = new C1751K();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1748H f15165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f15167d;

    public C1750J(C1750J c1750j, long j7) {
        AbstractC1207s.k(c1750j);
        this.f15164a = c1750j.f15164a;
        this.f15165b = c1750j.f15165b;
        this.f15166c = c1750j.f15166c;
        this.f15167d = j7;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f15165b);
        String str = this.f15166c;
        int length = String.valueOf(str).length();
        String str2 = this.f15164a;
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
    public final void writeToParcel(Parcel parcel, int i7) {
        C1751K.a(this, parcel, i7);
    }

    public C1750J(String str, C1748H c1748h, String str2, long j7) {
        this.f15164a = str;
        this.f15165b = c1748h;
        this.f15166c = str2;
        this.f15167d = j7;
    }
}
