package i2;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class D2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f15062d;

    public D2(String str, String str2, Bundle bundle, long j7) {
        this.f15059a = str;
        this.f15060b = str2;
        this.f15062d = bundle;
        this.f15061c = j7;
    }

    public static D2 a(C1750J c1750j) {
        return new D2(c1750j.f15164a, c1750j.f15166c, c1750j.f15165b.F(), c1750j.f15167d);
    }

    public final C1750J b() {
        return new C1750J(this.f15059a, new C1748H(new Bundle(this.f15062d)), this.f15060b, this.f15061c);
    }

    public final String toString() {
        String str = this.f15060b;
        String string = this.f15062d.toString();
        int length = String.valueOf(str).length();
        String str2 = this.f15059a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + string.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(string);
        return sb.toString();
    }
}
