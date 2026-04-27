package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: renamed from: Z2.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0746a0 extends AbstractC0759h {
    public static final Parcelable.Creator<C0746a0> CREATOR = new v0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5752b;

    public C0746a0(String str, String str2) {
        this.f5751a = AbstractC1207s.e(str);
        this.f5752b = AbstractC1207s.e(str2);
    }

    public static zzait D(C0746a0 c0746a0, String str) {
        AbstractC1207s.k(c0746a0);
        return new zzait(null, c0746a0.f5751a, c0746a0.A(), null, c0746a0.f5752b, null, str, null, null);
    }

    @Override // Z2.AbstractC0759h
    public String A() {
        return "twitter.com";
    }

    @Override // Z2.AbstractC0759h
    public String B() {
        return "twitter.com";
    }

    @Override // Z2.AbstractC0759h
    public final AbstractC0759h C() {
        return new C0746a0(this.f5751a, this.f5752b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f5751a, false);
        Q1.c.E(parcel, 2, this.f5752b, false);
        Q1.c.b(parcel, iA);
    }
}
