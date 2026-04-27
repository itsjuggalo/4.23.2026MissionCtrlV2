package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: c.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1240a extends IInterface {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13319l = "android$support$v4$os$IResultReceiver".replace('$', com.amazon.a.a.o.c.a.b.f14112a);

    /* JADX INFO: renamed from: c.a$b */
    public static class b {
        public static Object b(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void C(int i8, Bundle bundle);

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0226a extends Binder implements InterfaceC1240a {

        /* JADX INFO: renamed from: c.a$a$a, reason: collision with other inner class name */
        public static class C0227a implements InterfaceC1240a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f13320a;

            public C0227a(IBinder iBinder) {
                this.f13320a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13320a;
            }
        }

        public AbstractBinderC0226a() {
            attachInterface(this, InterfaceC1240a.f13319l);
        }

        public static InterfaceC1240a D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC1240a.f13319l);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1240a)) ? new C0227a(iBinder) : (InterfaceC1240a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i8, Parcel parcel, Parcel parcel2, int i9) {
            String str = InterfaceC1240a.f13319l;
            if (i8 >= 1 && i8 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i8 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i8 != 1) {
                return super.onTransact(i8, parcel, parcel2, i9);
            }
            C(parcel.readInt(), (Bundle) b.b(parcel, Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
