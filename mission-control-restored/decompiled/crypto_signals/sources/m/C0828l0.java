package m;

import android.os.Build;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: m.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0828l0 extends AbstractC0816f0 implements InterfaceC0818g0 {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final Method f8398D;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public Z.B f8399C;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f8398D = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // m.InterfaceC0818g0
    public final void c(l.i iVar, l.j jVar) {
        Z.B b3 = this.f8399C;
        if (b3 != null) {
            b3.c(iVar, jVar);
        }
    }

    @Override // m.InterfaceC0818g0
    public final void e(l.i iVar, l.j jVar) {
        Z.B b3 = this.f8399C;
        if (b3 != null) {
            b3.e(iVar, jVar);
        }
    }
}
