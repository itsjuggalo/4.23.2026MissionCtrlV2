package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w extends n5.a {
    public static final Parcelable.Creator<w> CREATOR = new b0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f5804b;

    public w(int i10, List list) {
        this.f5803a = i10;
        this.f5804b = list;
    }

    public final int R() {
        return this.f5803a;
    }

    public final List S() {
        return this.f5804b;
    }

    public final void T(p pVar) {
        if (this.f5804b == null) {
            this.f5804b = new ArrayList();
        }
        this.f5804b.add(pVar);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f5803a);
        n5.c.I(parcel, 2, this.f5804b, false);
        n5.c.b(parcel, iA);
    }
}
