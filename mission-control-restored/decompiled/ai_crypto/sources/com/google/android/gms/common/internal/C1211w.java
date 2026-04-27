package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1211w extends Q1.a {
    public static final Parcelable.Creator<C1211w> CREATOR = new B();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f11170b;

    public C1211w(int i7, List list) {
        this.f11169a = i7;
        this.f11170b = list;
    }

    public final int A() {
        return this.f11169a;
    }

    public final List B() {
        return this.f11170b;
    }

    public final void C(C1205p c1205p) {
        if (this.f11170b == null) {
            this.f11170b = new ArrayList();
        }
        this.f11170b.add(c1205p);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f11169a);
        Q1.c.I(parcel, 2, this.f11170b, false);
        Q1.c.b(parcel, iA);
    }
}
