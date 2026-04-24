package D;

import android.view.View;
import com.cryptosignals.ap.android.R;
import java.util.Objects;

/* JADX INFO: renamed from: D.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0023x {
    public static void a(View view, A a6) {
        q.k kVar = (q.k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (kVar == null) {
            kVar = new q.k();
            view.setTag(R.id.tag_unhandled_key_listeners, kVar);
        }
        Objects.requireNonNull(a6);
        View.OnUnhandledKeyEventListener viewOnUnhandledKeyEventListenerC0022w = new ViewOnUnhandledKeyEventListenerC0022w();
        kVar.put(a6, viewOnUnhandledKeyEventListenerC0022w);
        view.addOnUnhandledKeyEventListener(viewOnUnhandledKeyEventListenerC0022w);
    }

    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void e(View view, A a6) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        q.k kVar = (q.k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (kVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) kVar.getOrDefault(a6, null)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    public static <T> T f(View view, int i) {
        return (T) view.requireViewById(i);
    }

    public static void g(View view, boolean z6) {
        view.setAccessibilityHeading(z6);
    }

    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void i(View view, F.a aVar) {
        view.setAutofillId(null);
    }

    public static void j(View view, boolean z6) {
        view.setScreenReaderFocusable(z6);
    }
}
