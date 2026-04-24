package v1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: v1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1883a extends A1.a {
    public static final Parcelable.Creator<C1883a> CREATOR = new C1886d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f15290c;

    public C1883a(int i4, int i5, Bundle bundle) {
        this.f15288a = i4;
        this.f15289b = i5;
        this.f15290c = bundle;
    }

    public int i() {
        return this.f15289b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f15288a);
        A1.c.t(parcel, 2, i());
        A1.c.j(parcel, 3, this.f15290c, false);
        A1.c.b(parcel, iA);
    }
}
