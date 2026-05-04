package n6;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f16639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16640b;

    public a(IBinder iBinder, String str) {
        this.f16639a = iBinder;
        this.f16640b = str;
    }

    public final Parcel H() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f16640b);
        return parcelObtain;
    }

    public final void I(int i10, Parcel parcel) {
        try {
            this.f16639a.transact(i10, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f16639a;
    }
}
