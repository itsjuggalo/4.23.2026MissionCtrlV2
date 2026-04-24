package l2;

import P1.C0648b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.T;

/* JADX INFO: loaded from: classes.dex */
public final class l extends Q1.a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0648b f18305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f18306c;

    public l(int i7, C0648b c0648b, T t7) {
        this.f18304a = i7;
        this.f18305b = c0648b;
        this.f18306c = t7;
    }

    public final C0648b A() {
        return this.f18305b;
    }

    public final T B() {
        return this.f18306c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f18304a);
        Q1.c.C(parcel, 2, this.f18305b, i7, false);
        Q1.c.C(parcel, 3, this.f18306c, i7, false);
        Q1.c.b(parcel, iA);
    }
}
