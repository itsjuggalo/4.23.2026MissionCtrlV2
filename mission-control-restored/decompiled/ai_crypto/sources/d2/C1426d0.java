package d2;

import android.os.Parcel;
import android.os.Parcelable;
import d2.C1398E;

/* JADX INFO: renamed from: d2.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1426d0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return C1398E.a.a(parcel.readString());
        } catch (C1398E.b e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1398E.a[i7];
    }
}
