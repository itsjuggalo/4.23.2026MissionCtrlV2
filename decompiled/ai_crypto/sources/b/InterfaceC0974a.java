package b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: b.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0974a extends IInterface {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8470k = "android$support$v4$app$INotificationSideChannel".replace('$', com.amazon.a.a.o.c.a.b.f10001a);

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0143a extends Binder implements InterfaceC0974a {

        /* JADX INFO: renamed from: b.a$a$a, reason: collision with other inner class name */
        public static class C0144a implements InterfaceC0974a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f8471a;

            public C0144a(IBinder iBinder) {
                this.f8471a = iBinder;
            }

            @Override // b.InterfaceC0974a
            public void X(String str, int i7, String str2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(InterfaceC0974a.f8470k);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i7);
                    parcelObtain.writeString(str2);
                    b.b(parcelObtain, notification, 0);
                    this.f8471a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8471a;
            }
        }

        public static InterfaceC0974a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC0974a.f8470k);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0974a)) ? new C0144a(iBinder) : (InterfaceC0974a) iInterfaceQueryLocalInterface;
        }
    }

    /* JADX INFO: renamed from: b.a$b */
    public static class b {
        public static void b(Parcel parcel, Parcelable parcelable, int i7) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i7);
            }
        }
    }

    void X(String str, int i7, String str2, Notification notification);
}
