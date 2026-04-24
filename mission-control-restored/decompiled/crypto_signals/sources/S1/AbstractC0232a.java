package S1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: S1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0232a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f2852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2853b;

    public AbstractC0232a(IBinder iBinder, String str) {
        this.f2852a = iBinder;
        this.f2853b = str;
    }

    public final void a(int i, Parcel parcel) {
        try {
            this.f2852a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2852a;
    }
}
