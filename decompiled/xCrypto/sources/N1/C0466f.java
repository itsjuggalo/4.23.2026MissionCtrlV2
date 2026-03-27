package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: renamed from: N1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0466f extends A1.a {
    public static final Parcelable.Creator<C0466f> CREATOR = new o0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2778a;

    public C0466f(boolean z4) {
        this.f2778a = z4;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0466f) && this.f2778a == ((C0466f) obj).f2778a;
    }

    public int hashCode() {
        return AbstractC0939q.c(Boolean.valueOf(this.f2778a));
    }

    public boolean i() {
        return this.f2778a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.g(parcel, 1, i());
        A1.c.b(parcel, iA);
    }
}
