package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: loaded from: classes.dex */
public class F extends AbstractC0759h {
    public static final Parcelable.Creator<F> CREATOR = new m0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5717b;

    public F(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("idToken cannot be empty");
        }
        if (str2 != null && str2.length() == 0) {
            throw new IllegalArgumentException("accessToken cannot be empty");
        }
        this.f5716a = str;
        this.f5717b = str2;
    }

    public static zzait D(F f7, String str) {
        AbstractC1207s.k(f7);
        return new zzait(f7.f5716a, f7.f5717b, f7.A(), null, null, null, str, null, null);
    }

    @Override // Z2.AbstractC0759h
    public String A() {
        return "google.com";
    }

    @Override // Z2.AbstractC0759h
    public String B() {
        return "google.com";
    }

    @Override // Z2.AbstractC0759h
    public final AbstractC0759h C() {
        return new F(this.f5716a, this.f5717b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f5716a, false);
        Q1.c.E(parcel, 2, this.f5717b, false);
        Q1.c.b(parcel, iA);
    }
}
