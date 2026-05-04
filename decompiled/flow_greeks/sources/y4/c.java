package y4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends n5.a {
    public static final Parcelable.Creator<c> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f25273b;

    public c(int i10, List list) {
        this.f25272a = i10;
        this.f25273b = (List) s.k(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f25272a);
        n5.c.I(parcel, 2, this.f25273b, false);
        n5.c.b(parcel, iA);
    }
}
