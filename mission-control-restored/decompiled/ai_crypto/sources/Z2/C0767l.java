package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: renamed from: Z2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0767l extends AbstractC0759h {
    public static final Parcelable.Creator<C0767l> CREATOR = new B0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5805a;

    public C0767l(String str) {
        this.f5805a = AbstractC1207s.e(str);
    }

    public static zzait D(C0767l c0767l, String str) {
        AbstractC1207s.k(c0767l);
        return new zzait(null, c0767l.f5805a, c0767l.A(), null, null, null, str, null, null);
    }

    @Override // Z2.AbstractC0759h
    public String A() {
        return "facebook.com";
    }

    @Override // Z2.AbstractC0759h
    public String B() {
        return "facebook.com";
    }

    @Override // Z2.AbstractC0759h
    public final AbstractC0759h C() {
        return new C0767l(this.f5805a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f5805a, false);
        Q1.c.b(parcel, iA);
    }
}
