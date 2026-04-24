package n2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: n2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2394a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f21576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21577b = "com.google.android.play.core.appupdate.protocol.IAppUpdateService";

    public AbstractC2394a(IBinder iBinder, String str) {
        this.f21576a = iBinder;
    }

    public final Parcel D() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f21577b);
        return parcelObtain;
    }

    public final void E(int i8, Parcel parcel) {
        try {
            this.f21576a.transact(i8, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f21576a;
    }
}
