package M1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: M1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0638a extends Q1.a {
    public static final Parcelable.Creator<C0638a> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f3806c;

    public C0638a(int i7, int i8, Bundle bundle) {
        this.f3804a = i7;
        this.f3805b = i8;
        this.f3806c = bundle;
    }

    public int A() {
        return this.f3805b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f3804a);
        Q1.c.t(parcel, 2, A());
        Q1.c.j(parcel, 3, this.f3806c, false);
        Q1.c.b(parcel, iA);
    }
}
