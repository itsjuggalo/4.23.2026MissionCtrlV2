package X1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: X1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0740a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f5548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5549b;

    public AbstractC0740a(IBinder iBinder, String str) {
        this.f5548a = iBinder;
        this.f5549b = str;
    }

    public final Parcel a0() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f5549b);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5548a;
    }

    public final void b0(int i4, Parcel parcel) {
        try {
            this.f5548a.transact(i4, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
