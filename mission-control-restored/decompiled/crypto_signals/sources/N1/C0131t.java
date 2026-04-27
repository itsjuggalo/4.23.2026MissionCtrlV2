package N1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: N1.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0131t extends AbstractC1255a implements Iterable {
    public static final Parcelable.Creator<C0131t> CREATOR = new J1.Y(24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f1790a;

    public C0131t(Bundle bundle) {
        this.f1790a = bundle;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new A2.d(this);
    }

    public final Object m(String str) {
        return this.f1790a.get(str);
    }

    public final Double n() {
        return Double.valueOf(this.f1790a.getDouble("value"));
    }

    public final String o() {
        return this.f1790a.getString("currency");
    }

    public final Bundle p() {
        return new Bundle(this.f1790a);
    }

    public final String toString() {
        return this.f1790a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = t2.u0.X(20293, parcel);
        t2.u0.L(parcel, 2, p(), false);
        t2.u0.a0(iX, parcel);
    }
}
