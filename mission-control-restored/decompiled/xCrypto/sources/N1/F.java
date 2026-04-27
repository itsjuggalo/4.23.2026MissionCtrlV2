package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: loaded from: classes.dex */
public class F extends A1.a {
    public static final Parcelable.Creator<F> CREATOR = new C0467f0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2745a;

    public F(boolean z4) {
        this.f2745a = z4;
    }

    public boolean equals(Object obj) {
        return (obj instanceof F) && this.f2745a == ((F) obj).f2745a;
    }

    public int hashCode() {
        return AbstractC0939q.c(Boolean.valueOf(this.f2745a));
    }

    public boolean i() {
        return this.f2745a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.g(parcel, 1, i());
        A1.c.b(parcel, iA);
    }
}
