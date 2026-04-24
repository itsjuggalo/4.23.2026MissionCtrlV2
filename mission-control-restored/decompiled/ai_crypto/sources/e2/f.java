package e2;

import android.os.Parcel;
import android.os.Parcelable;
import e2.C1471a;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return C1471a.D(parcel.readInt());
        } catch (C1471a.b e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1471a.EnumC0233a[i7];
    }
}
