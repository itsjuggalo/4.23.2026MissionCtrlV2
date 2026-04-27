package j2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.G;

/* JADX INFO: loaded from: classes.dex */
public final class j extends T1.a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G f19995b;

    public j(int i8, G g8) {
        this.f19994a = i8;
        this.f19995b = g8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, this.f19994a);
        T1.c.o(parcel, 2, this.f19995b, i8, false);
        T1.c.b(parcel, iA);
    }
}
