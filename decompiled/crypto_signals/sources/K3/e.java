package K3;

import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.view.GestureCropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureCropImageView f1001a;

    public e(GestureCropImageView gestureCropImageView) {
        this.f1001a = gestureCropImageView;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        GestureCropImageView gestureCropImageView = this.f1001a;
        gestureCropImageView.f(scaleFactor, gestureCropImageView.f5830E, gestureCropImageView.f5831F);
        return true;
    }
}
