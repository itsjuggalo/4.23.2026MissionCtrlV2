package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0944w extends A1.a {
    public static final Parcelable.Creator<C0944w> CREATOR = new B();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f9987b;

    public C0944w(int i4, List list) {
        this.f9986a = i4;
        this.f9987b = list;
    }

    public final int i() {
        return this.f9986a;
    }

    public final List k() {
        return this.f9987b;
    }

    public final void l(C0938p c0938p) {
        if (this.f9987b == null) {
            this.f9987b = new ArrayList();
        }
        this.f9987b.add(c0938p);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f9986a);
        A1.c.I(parcel, 2, this.f9987b, false);
        A1.c.b(parcel, iA);
    }
}
