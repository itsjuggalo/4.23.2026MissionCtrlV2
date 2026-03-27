package b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: b.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0855a extends IInterface {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8235k = "android$support$v4$app$INotificationSideChannel".replace('$', com.amazon.a.a.o.c.a.b.f8816a);

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0121a extends Binder implements InterfaceC0855a {

        /* JADX INFO: renamed from: b.a$a$a, reason: collision with other inner class name */
        public static class C0122a implements InterfaceC0855a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f8236a;

            public C0122a(IBinder iBinder) {
                this.f8236a = iBinder;
            }

            @Override // b.InterfaceC0855a
            public void V(String str, int i4, String str2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(InterfaceC0855a.f8235k);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeString(str2);
                    b.b(parcelObtain, notification, 0);
                    this.f8236a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8236a;
            }
        }

        public static InterfaceC0855a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC0855a.f8235k);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0855a)) ? new C0122a(iBinder) : (InterfaceC0855a) iInterfaceQueryLocalInterface;
        }
    }

    /* JADX INFO: renamed from: b.a$b */
    public static class b {
        public static void b(Parcel parcel, Parcelable parcelable, int i4) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i4);
            }
        }
    }

    void V(String str, int i4, String str2, Notification notification);
}
