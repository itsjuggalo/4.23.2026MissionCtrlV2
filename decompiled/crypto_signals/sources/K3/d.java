package K3;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.yalantis.ucrop.view.GestureCropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class d extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureCropImageView f1000a;

    public d(GestureCropImageView gestureCropImageView) {
        this.f1000a = gestureCropImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        GestureCropImageView gestureCropImageView = this.f1000a;
        float doubleTapTargetScale = gestureCropImageView.getDoubleTapTargetScale();
        float x6 = motionEvent.getX();
        float y = motionEvent.getY();
        if (doubleTapTargetScale > gestureCropImageView.getMaxScale()) {
            doubleTapTargetScale = gestureCropImageView.getMaxScale();
        }
        float currentScale = gestureCropImageView.getCurrentScale();
        b bVar = new b(gestureCropImageView, currentScale, doubleTapTargetScale - currentScale, x6, y);
        gestureCropImageView.f998x = bVar;
        gestureCropImageView.post(bVar);
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        this.f1000a.b(-f6, -f7);
        return true;
    }
}
