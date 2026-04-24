package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: loaded from: classes.dex */
public class D extends AbstractC0759h {
    public static final Parcelable.Creator<D> CREATOR = new l0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5709a;

    public D(String str) {
        this.f5709a = AbstractC1207s.e(str);
    }

    public static zzait D(D d7, String str) {
        AbstractC1207s.k(d7);
        return new zzait(null, d7.f5709a, d7.A(), null, null, null, str, null, null);
    }

    @Override // Z2.AbstractC0759h
    public String A() {
        return "github.com";
    }

    @Override // Z2.AbstractC0759h
    public String B() {
        return "github.com";
    }

    @Override // Z2.AbstractC0759h
    public final AbstractC0759h C() {
        return new D(this.f5709a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f5709a, false);
        Q1.c.b(parcel, iA);
    }
}
