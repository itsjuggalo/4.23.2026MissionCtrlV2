package o1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import java.util.Arrays;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class l extends AbstractC1255a {
    public static final Parcelable.Creator<l> CREATOR = new r(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f8658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8660c;

    public l(p pVar, String str, int i) {
        I.g(pVar);
        this.f8658a = pVar;
        this.f8659b = str;
        this.f8660c = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return I.j(this.f8658a, lVar.f8658a) && I.j(this.f8659b, lVar.f8659b) && this.f8660c == lVar.f8660c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8658a, this.f8659b});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.S(parcel, 1, this.f8658a, i, false);
        u0.T(parcel, 2, this.f8659b, false);
        u0.b0(parcel, 3, 4);
        parcel.writeInt(this.f8660c);
        u0.a0(iX, parcel);
    }
}
