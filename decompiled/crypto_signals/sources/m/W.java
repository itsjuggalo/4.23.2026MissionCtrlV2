package m;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import l.ViewOnTouchListenerC0785a;

/* JADX INFO: loaded from: classes.dex */
public final class W implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewOnTouchListenerC0785a f8317b;

    public /* synthetic */ W(ViewOnTouchListenerC0785a viewOnTouchListenerC0785a, int i) {
        this.f8316a = i;
        this.f8317b = viewOnTouchListenerC0785a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8316a) {
            case 0:
                ViewParent parent = this.f8317b.f7939d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                ViewOnTouchListenerC0785a viewOnTouchListenerC0785a = this.f8317b;
                viewOnTouchListenerC0785a.a();
                View view = viewOnTouchListenerC0785a.f7939d;
                if (view.isEnabled() && !view.isLongClickable() && viewOnTouchListenerC0785a.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    viewOnTouchListenerC0785a.f7941k = true;
                    break;
                }
                break;
        }
    }
}
