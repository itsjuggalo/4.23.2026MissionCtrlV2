package S1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class H extends A1.a implements Iterable {
    public static final Parcelable.Creator<H> CREATOR = new I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f3983a;

    public H(Bundle bundle) {
        this.f3983a = bundle;
    }

    public final Object i(String str) {
        return this.f3983a.get(str);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new G(this);
    }

    public final Long k(String str) {
        return Long.valueOf(this.f3983a.getLong(str));
    }

    public final Double l(String str) {
        return Double.valueOf(this.f3983a.getDouble("value"));
    }

    public final String m(String str) {
        return this.f3983a.getString(str);
    }

    public final int n() {
        return this.f3983a.size();
    }

    public final Bundle o() {
        return new Bundle(this.f3983a);
    }

    public final /* synthetic */ Bundle p() {
        return this.f3983a;
    }

    public final String toString() {
        return this.f3983a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.j(parcel, 2, o(), false);
        A1.c.b(parcel, iA);
    }
}
