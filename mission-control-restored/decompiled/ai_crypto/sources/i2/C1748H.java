package i2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* JADX INFO: renamed from: i2.H, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1748H extends Q1.a implements Iterable {
    public static final Parcelable.Creator<C1748H> CREATOR = new C1749I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f15142a;

    public C1748H(Bundle bundle) {
        this.f15142a = bundle;
    }

    public final Object A(String str) {
        return this.f15142a.get(str);
    }

    public final Long B(String str) {
        return Long.valueOf(this.f15142a.getLong(str));
    }

    public final Double C(String str) {
        return Double.valueOf(this.f15142a.getDouble("value"));
    }

    public final String D(String str) {
        return this.f15142a.getString(str);
    }

    public final int E() {
        return this.f15142a.size();
    }

    public final Bundle F() {
        return new Bundle(this.f15142a);
    }

    public final /* synthetic */ Bundle G() {
        return this.f15142a;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C1747G(this);
    }

    public final String toString() {
        return this.f15142a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.j(parcel, 2, F(), false);
        Q1.c.b(parcel, iA);
    }
}
