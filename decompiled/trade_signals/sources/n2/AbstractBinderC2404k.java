package n2;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: n2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC2404k extends AbstractBinderC2401h implements InterfaceC2405l {
    public static InterfaceC2405l E(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC2405l ? (InterfaceC2405l) iInterfaceQueryLocalInterface : new C2403j(iBinder);
    }
}
