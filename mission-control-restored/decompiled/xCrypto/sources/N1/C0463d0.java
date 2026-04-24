package N1;

import N1.E;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: N1.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0463d0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return E.a.a(parcel.readString());
        } catch (E.b e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new E.a[i4];
    }
}
