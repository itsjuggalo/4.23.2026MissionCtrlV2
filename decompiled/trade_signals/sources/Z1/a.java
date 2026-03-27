package Z1;

import android.os.IBinder;
import android.os.IInterface;
import e2.d;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: Z1.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0162a extends d implements a {
        public AbstractBinderC0162a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a E(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new c(iBinder);
        }
    }
}
