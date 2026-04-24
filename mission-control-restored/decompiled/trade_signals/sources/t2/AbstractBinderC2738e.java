package t2;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: t2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC2738e extends AbstractBinderC2735b implements InterfaceC2739f {
    public static InterfaceC2739f E(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC2739f ? (InterfaceC2739f) iInterfaceQueryLocalInterface : new C2737d(iBinder);
    }
}
