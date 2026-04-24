package d;

import Z.AbstractActivityC0282y;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: renamed from: d.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0503g {
    public static OnBackInvokedDispatcher a(AbstractActivityC0282y abstractActivityC0282y) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = abstractActivityC0282y.getOnBackInvokedDispatcher();
        kotlin.jvm.internal.j.d(onBackInvokedDispatcher, "activity.getOnBackInvokedDispatcher()");
        return onBackInvokedDispatcher;
    }

    public static void b(Object dispatcher, Object callback) {
        kotlin.jvm.internal.j.e(dispatcher, "dispatcher");
        kotlin.jvm.internal.j.e(callback, "callback");
        ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(0, (OnBackInvokedCallback) callback);
    }

    public static void c(Object dispatcher, Object callback) {
        kotlin.jvm.internal.j.e(dispatcher, "dispatcher");
        kotlin.jvm.internal.j.e(callback, "callback");
        ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
    }
}
