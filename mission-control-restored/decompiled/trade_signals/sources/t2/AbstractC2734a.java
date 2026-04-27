package t2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: t2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2734a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f23291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23292b = "com.google.android.play.core.inappreview.protocol.IInAppReviewService";

    public AbstractC2734a(IBinder iBinder, String str) {
        this.f23291a = iBinder;
    }

    public final Parcel D() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f23292b);
        return parcelObtain;
    }

    public final void E(int i8, Parcel parcel) {
        try {
            this.f23291a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f23291a;
    }
}
