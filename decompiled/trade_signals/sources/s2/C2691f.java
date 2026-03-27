package s2;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: s2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2691f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new C2690e((PendingIntent) parcel.readParcelable(AbstractC2687b.class.getClassLoader()), parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new AbstractC2687b[i8];
    }
}
