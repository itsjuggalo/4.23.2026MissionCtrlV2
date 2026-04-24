package e2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends Binder implements IInterface {
    public d(String str) {
        attachInterface(this, str);
    }

    public boolean D(int i8, Parcel parcel, Parcel parcel2, int i9) {
        return false;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i8, parcel, parcel2, i9)) {
            return true;
        }
        return D(i8, parcel, parcel2, i9);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
