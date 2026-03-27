package a2;

import Z1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import e2.AbstractC1663a;

/* JADX INFO: renamed from: a2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1063j extends AbstractC1663a implements IInterface {
    public C1063j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final Z1.a F(Z1.a aVar, String str, int i8, Z1.a aVar2) {
        Parcel parcelE = E();
        e2.e.d(parcelE, aVar);
        parcelE.writeString(str);
        parcelE.writeInt(i8);
        e2.e.d(parcelE, aVar2);
        Parcel parcelD = D(2, parcelE);
        Z1.a aVarE = a.AbstractBinderC0162a.E(parcelD.readStrongBinder());
        parcelD.recycle();
        return aVarE;
    }

    public final Z1.a G(Z1.a aVar, String str, int i8, Z1.a aVar2) {
        Parcel parcelE = E();
        e2.e.d(parcelE, aVar);
        parcelE.writeString(str);
        parcelE.writeInt(i8);
        e2.e.d(parcelE, aVar2);
        Parcel parcelD = D(3, parcelE);
        Z1.a aVarE = a.AbstractBinderC0162a.E(parcelD.readStrongBinder());
        parcelD.recycle();
        return aVarE;
    }
}
