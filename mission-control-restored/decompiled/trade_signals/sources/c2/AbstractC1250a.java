package c2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: c2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1250a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f13339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13340b;

    public AbstractC1250a(IBinder iBinder, String str) {
        this.f13339a = iBinder;
        this.f13340b = str;
    }

    public final Parcel D() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f13340b);
        return parcelObtain;
    }

    public final void E(int i8, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f13339a.transact(i8, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public final void F(int i8, Parcel parcel) {
        try {
            this.f13339a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f13339a;
    }
}
