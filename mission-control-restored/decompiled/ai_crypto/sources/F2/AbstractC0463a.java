package F2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: F2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0463a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f1905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1906b;

    public AbstractC0463a(IBinder iBinder, String str) {
        this.f1905a = iBinder;
        this.f1906b = str;
    }

    public final Parcel a0() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1906b);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1905a;
    }

    public final void b0(int i7, Parcel parcel) {
        try {
            this.f1905a.transact(i7, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
