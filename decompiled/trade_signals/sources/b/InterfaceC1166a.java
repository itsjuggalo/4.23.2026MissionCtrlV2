package b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: b.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1166a extends IInterface {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12535k = "android$support$v4$app$INotificationSideChannel".replace('$', com.amazon.a.a.o.c.a.b.f14112a);

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0204a extends Binder implements InterfaceC1166a {

        /* JADX INFO: renamed from: b.a$a$a, reason: collision with other inner class name */
        public static class C0205a implements InterfaceC1166a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f12536a;

            public C0205a(IBinder iBinder) {
                this.f12536a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12536a;
            }

            @Override // b.InterfaceC1166a
            public void y(String str, int i8, String str2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(InterfaceC1166a.f12535k);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i8);
                    parcelObtain.writeString(str2);
                    b.b(parcelObtain, notification, 0);
                    this.f12536a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static InterfaceC1166a D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC1166a.f12535k);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1166a)) ? new C0205a(iBinder) : (InterfaceC1166a) iInterfaceQueryLocalInterface;
        }
    }

    /* JADX INFO: renamed from: b.a$b */
    public static class b {
        public static void b(Parcel parcel, Parcelable parcelable, int i8) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i8);
            }
        }
    }

    void y(String str, int i8, String str2, Notification notification);
}
