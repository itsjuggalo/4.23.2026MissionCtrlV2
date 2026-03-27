package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: loaded from: classes.dex */
public class T extends AbstractC0759h {
    public static final Parcelable.Creator<T> CREATOR = new t0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5743a;

    public T(String str) {
        this.f5743a = AbstractC1207s.e(str);
    }

    public static zzait D(T t7, String str) {
        AbstractC1207s.k(t7);
        return new zzait(null, null, t7.A(), null, null, t7.f5743a, str, null, null);
    }

    @Override // Z2.AbstractC0759h
    public String A() {
        return "playgames.google.com";
    }

    @Override // Z2.AbstractC0759h
    public String B() {
        return "playgames.google.com";
    }

    @Override // Z2.AbstractC0759h
    public final AbstractC0759h C() {
        return new T(this.f5743a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f5743a, false);
        Q1.c.b(parcel, iA);
    }
}
