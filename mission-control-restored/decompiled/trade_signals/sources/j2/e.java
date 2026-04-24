package j2;

import android.os.Parcel;
import c2.AbstractBinderC1251b;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends AbstractBinderC1251b implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // c2.AbstractBinderC1251b
    public final boolean D(int i8, Parcel parcel, Parcel parcel2, int i9) {
        switch (i8) {
            case 3:
                c2.c.b(parcel);
                parcel2.writeNoException();
                return true;
            case 4:
            case 6:
                c2.c.b(parcel);
                parcel2.writeNoException();
                return true;
            case 5:
            default:
                return false;
            case 7:
                c2.c.b(parcel);
                parcel2.writeNoException();
                return true;
            case 8:
                l lVar = (l) c2.c.a(parcel, l.CREATOR);
                c2.c.b(parcel);
                w(lVar);
                parcel2.writeNoException();
                return true;
            case 9:
                c2.c.b(parcel);
                parcel2.writeNoException();
                return true;
        }
    }
}
