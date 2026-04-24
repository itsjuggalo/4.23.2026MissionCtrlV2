package m;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class P0 extends M.c {
    public static final Parcelable.Creator<P0> CREATOR = new M.b(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8270d;

    public P0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f8269c = parcel.readInt();
        this.f8270d = parcel.readInt() != 0;
    }

    @Override // M.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f8269c);
        parcel.writeInt(this.f8270d ? 1 : 0);
    }
}
