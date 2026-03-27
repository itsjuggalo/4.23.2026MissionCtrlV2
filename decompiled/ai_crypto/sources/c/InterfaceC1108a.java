package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: c.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1108a extends IInterface {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9101l = "android$support$v4$os$IResultReceiver".replace('$', com.amazon.a.a.o.c.a.b.f10001a);

    /* JADX INFO: renamed from: c.a$b */
    public static class b {
        public static Object b(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void Y(int i7, Bundle bundle);

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0149a extends Binder implements InterfaceC1108a {

        /* JADX INFO: renamed from: c.a$a$a, reason: collision with other inner class name */
        public static class C0150a implements InterfaceC1108a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f9102a;

            public C0150a(IBinder iBinder) {
                this.f9102a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9102a;
            }
        }

        public AbstractBinderC0149a() {
            attachInterface(this, InterfaceC1108a.f9101l);
        }

        public static InterfaceC1108a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC1108a.f9101l);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1108a)) ? new C0150a(iBinder) : (InterfaceC1108a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) {
            String str = InterfaceC1108a.f9101l;
            if (i7 >= 1 && i7 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i7 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i7 != 1) {
                return super.onTransact(i7, parcel, parcel2, i8);
            }
            Y(parcel.readInt(), (Bundle) b.b(parcel, Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
