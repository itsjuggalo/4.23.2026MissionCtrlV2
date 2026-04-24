package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Binder implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f4898b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4899a;

    public c(d dVar) {
        this.f4899a = dVar;
        attachInterface(this, b.f4897h);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) {
        String str = b.f4897h;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i6);
        }
        this.f4899a.a(parcel.readInt(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
