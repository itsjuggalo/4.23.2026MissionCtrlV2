package t1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9882a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f9882a) {
            case 0:
                int iK0 = D.k0(parcel);
                Intent intent = null;
                while (parcel.dataPosition() < iK0) {
                    int i = parcel.readInt();
                    if (((char) i) != 1) {
                        D.j0(i, parcel);
                    } else {
                        intent = (Intent) D.z(parcel, i, Intent.CREATOR);
                    }
                }
                D.G(iK0, parcel);
                return new a(intent);
            default:
                return new g(parcel.readStrongBinder());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f9882a) {
            case 0:
                return new a[i];
            default:
                return new g[i];
        }
    }
}
