package m;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: m.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC0814e0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0816f0 f8342a;

    public ViewOnTouchListenerC0814e0(AbstractC0816f0 abstractC0816f0) {
        this.f8342a = abstractC0816f0;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        r rVar;
        int action = motionEvent.getAction();
        int x6 = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        AbstractC0816f0 abstractC0816f0 = this.f8342a;
        if (action == 0 && (rVar = abstractC0816f0.f8366z) != null && rVar.isShowing() && x6 >= 0 && x6 < abstractC0816f0.f8366z.getWidth() && y >= 0 && y < abstractC0816f0.f8366z.getHeight()) {
            abstractC0816f0.f8363v.postDelayed(abstractC0816f0.f8359r, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        abstractC0816f0.f8363v.removeCallbacks(abstractC0816f0.f8359r);
        return false;
    }
}
