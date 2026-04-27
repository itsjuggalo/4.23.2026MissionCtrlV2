package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: d2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1446s extends Q1.a {
    public static final Parcelable.Creator<C1446s> CREATOR = new C1408O();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13291a;

    public C1446s(boolean z7) {
        this.f13291a = z7;
    }

    public boolean A() {
        return this.f13291a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1446s) && this.f13291a == ((C1446s) obj).A();
    }

    public int hashCode() {
        return AbstractC1206q.c(Boolean.valueOf(this.f13291a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.g(parcel, 1, A());
        Q1.c.b(parcel, iA);
    }
}
