package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r extends T1.a {
    public static final Parcelable.Creator<r> CREATOR = new C1301v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f15054b;

    public r(int i8, List list) {
        this.f15053a = i8;
        this.f15054b = list;
    }

    public final int a() {
        return this.f15053a;
    }

    public final List d() {
        return this.f15054b;
    }

    public final void e(C1292l c1292l) {
        if (this.f15054b == null) {
            this.f15054b = new ArrayList();
        }
        this.f15054b.add(c1292l);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, this.f15053a);
        T1.c.s(parcel, 2, this.f15054b, false);
        T1.c.b(parcel, iA);
    }
}
