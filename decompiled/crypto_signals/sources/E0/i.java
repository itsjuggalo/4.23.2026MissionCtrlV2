package E0;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import io.flutter.plugin.platform.x;
import io.flutter.plugin.platform.y;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class i implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f374a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f376c;

    public i(View view, io.flutter.plugin.platform.k kVar) {
        this.f375b = view;
        this.f376c = kVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        Window window;
        WindowManager.LayoutParams attributes;
        switch (this.f374a) {
            case 0:
                kotlin.jvm.internal.j.e(view, "view");
                view.removeOnAttachStateChangeListener(this);
                Activity activity = (Activity) ((WeakReference) this.f376c).get();
                IBinder iBinder = (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
                if (activity != null && iBinder != null) {
                    ((j) this.f375b).c(iBinder, activity);
                }
                break;
            default:
                x xVar = new x(this, 0);
                View view2 = (View) this.f375b;
                view2.getViewTreeObserver().addOnDrawListener(new y(view2, xVar));
                view2.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f374a) {
            case 0:
                kotlin.jvm.internal.j.e(view, "view");
                break;
        }
    }

    public i(j sidecarCompat, Activity activity) {
        kotlin.jvm.internal.j.e(sidecarCompat, "sidecarCompat");
        this.f375b = sidecarCompat;
        this.f376c = new WeakReference(activity);
    }

    private final void a(View view) {
    }
}
