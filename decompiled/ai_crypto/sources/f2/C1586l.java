package f2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: f2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1586l extends Q1.a {
    public static final Parcelable.Creator<C1586l> CREATOR = new C1560K();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1558I f14100d;

    public C1586l(List list, boolean z7, boolean z8, C1558I c1558i) {
        this.f14097a = list;
        this.f14098b = z7;
        this.f14099c = z8;
        this.f14100d = c1558i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.I(parcel, 1, Collections.unmodifiableList(this.f14097a), false);
        Q1.c.g(parcel, 2, this.f14098b);
        Q1.c.g(parcel, 3, this.f14099c);
        Q1.c.C(parcel, 5, this.f14100d, i7, false);
        Q1.c.b(parcel, iA);
    }
}
