package n1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.List;

/* JADX INFO: renamed from: n1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1617c extends A1.a {
    public static final Parcelable.Creator<C1617c> CREATOR = new C1623i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f13600b;

    public C1617c(int i4, List list) {
        this.f13599a = i4;
        this.f13600b = (List) AbstractC0940s.k(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f13599a);
        A1.c.I(parcel, 2, this.f13600b, false);
        A1.c.b(parcel, iA);
    }
}
