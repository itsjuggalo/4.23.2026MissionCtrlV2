package E1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends Q1.a {
    public static final Parcelable.Creator<c> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f1587b;

    public c(int i7, List list) {
        this.f1586a = i7;
        this.f1587b = (List) AbstractC1207s.k(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f1586a);
        Q1.c.I(parcel, 2, this.f1587b, false);
        Q1.c.b(parcel, iA);
    }
}
