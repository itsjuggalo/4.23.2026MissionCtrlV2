package S1;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class D2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f3903d;

    public D2(String str, String str2, Bundle bundle, long j4) {
        this.f3900a = str;
        this.f3901b = str2;
        this.f3903d = bundle;
        this.f3902c = j4;
    }

    public static D2 a(J j4) {
        return new D2(j4.f4005a, j4.f4007c, j4.f4006b.o(), j4.f4008d);
    }

    public final J b() {
        return new J(this.f3900a, new H(new Bundle(this.f3903d)), this.f3901b, this.f3902c);
    }

    public final String toString() {
        String str = this.f3901b;
        String string = this.f3903d.toString();
        int length = String.valueOf(str).length();
        String str2 = this.f3900a;
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
