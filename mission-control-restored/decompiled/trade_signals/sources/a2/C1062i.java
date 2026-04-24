package a2;

import Z1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import e2.AbstractC1663a;

/* JADX INFO: renamed from: a2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1062i extends AbstractC1663a implements IInterface {
    public C1062i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int F() {
        Parcel parcelD = D(6, E());
        int i8 = parcelD.readInt();
        parcelD.recycle();
        return i8;
    }

    public final int G(Z1.a aVar, String str, boolean z7) {
        Parcel parcelE = E();
        e2.e.d(parcelE, aVar);
        parcelE.writeString(str);
        parcelE.writeInt(z7 ? 1 : 0);
        Parcel parcelD = D(3, parcelE);
        int i8 = parcelD.readInt();
        parcelD.recycle();
        return i8;
    }

    public final int H(Z1.a aVar, String str, boolean z7) {
        Parcel parcelE = E();
        e2.e.d(parcelE, aVar);
        parcelE.writeString(str);
        parcelE.writeInt(z7 ? 1 : 0);
        Parcel parcelD = D(5, parcelE);
        int i8 = parcelD.readInt();
        parcelD.recycle();
        return i8;
    }

    public final Z1.a I(Z1.a aVar, String str, int i8) {
        Parcel parcelE = E();
        e2.e.d(parcelE, aVar);
        parcelE.writeString(str);
        parcelE.writeInt(i8);
        Parcel parcelD = D(2, parcelE);
        Z1.a aVarE = a.AbstractBinderC0162a.E(parcelD.readStrongBinder());
        parcelD.recycle();
        return aVarE;
    }

    public final Z1.a J(Z1.a aVar, String str, int i8, Z1.a aVar2) {
        Parcel parcelE = E();
        e2.e.d(parcelE, aVar);
        parcelE.writeString(str);
        parcelE.writeInt(i8);
        e2.e.d(parcelE, aVar2);
        Parcel parcelD = D(8, parcelE);
        Z1.a aVarE = a.AbstractBinderC0162a.E(parcelD.readStrongBinder());
        parcelD.recycle();
        return aVarE;
    }

    public final Z1.a K(Z1.a aVar, String str, int i8) {
        Parcel parcelE = E();
        e2.e.d(parcelE, aVar);
        parcelE.writeString(str);
        parcelE.writeInt(i8);
        Parcel parcelD = D(4, parcelE);
        Z1.a aVarE = a.AbstractBinderC0162a.E(parcelD.readStrongBinder());
        parcelD.recycle();
        return aVarE;
    }

    public final Z1.a L(Z1.a aVar, String str, boolean z7, long j8) {
        Parcel parcelE = E();
        e2.e.d(parcelE, aVar);
        parcelE.writeString(str);
        parcelE.writeInt(z7 ? 1 : 0);
        parcelE.writeLong(j8);
        Parcel parcelD = D(7, parcelE);
        Z1.a aVarE = a.AbstractBinderC0162a.E(parcelD.readStrongBinder());
        parcelD.recycle();
        return aVarE;
    }
}
