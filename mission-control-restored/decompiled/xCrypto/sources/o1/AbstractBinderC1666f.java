package o1;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.auth.zzb;

/* JADX INFO: renamed from: o1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1666f extends zzb implements InterfaceC1667g {
    public static InterfaceC1667g b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.account.IWorkAccountService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC1667g ? (InterfaceC1667g) iInterfaceQueryLocalInterface : new C1665e(iBinder);
    }
}
