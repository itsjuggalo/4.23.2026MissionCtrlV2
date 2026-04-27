package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: c.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0869a extends IInterface {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8292l = "android$support$v4$os$IResultReceiver".replace('$', com.amazon.a.a.o.c.a.b.f8816a);

    /* JADX INFO: renamed from: c.a$b */
    public static class b {
        public static Object b(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void Z(int i4, Bundle bundle);

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0125a extends Binder implements InterfaceC0869a {

        /* JADX INFO: renamed from: c.a$a$a, reason: collision with other inner class name */
        public static class C0126a implements InterfaceC0869a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f8293a;

            public C0126a(IBinder iBinder) {
                this.f8293a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8293a;
            }
        }

        public AbstractBinderC0125a() {
            attachInterface(this, InterfaceC0869a.f8292l);
        }

        public static InterfaceC0869a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC0869a.f8292l);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0869a)) ? new C0126a(iBinder) : (InterfaceC0869a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            String str = InterfaceC0869a.f8292l;
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i4 != 1) {
                return super.onTransact(i4, parcel, parcel2, i5);
            }
            Z(parcel.readInt(), (Bundle) b.b(parcel, Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
