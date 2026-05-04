package io.flutter.plugin.view;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import io.flutter.embedding.engine.systemchannels.SensitiveContentChannel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class SensitiveContentPlugin implements SensitiveContentChannel.SensitiveContentMethodHandler {
    private Activity mFlutterActivity;
    private final int mFlutterViewId;
    private final SensitiveContentChannel mSensitiveContentChannel;

    public SensitiveContentPlugin(int i10, Activity activity, SensitiveContentChannel sensitiveContentChannel) {
        this.mFlutterActivity = activity;
        this.mFlutterViewId = i10;
        this.mSensitiveContentChannel = sensitiveContentChannel;
        sensitiveContentChannel.setSensitiveContentMethodHandler(this);
    }

    private String getFlutterViewNotFoundErrorReason() {
        return "FlutterView with ID " + this.mFlutterViewId + "not found";
    }

    private String getNotSupportedErrorReason() {
        return "isSupported() should be called before attempting to set content sensitivity as it is not supported on this device.";
    }

    public void destroy() {
        this.mSensitiveContentChannel.setSensitiveContentMethodHandler(null);
        this.mFlutterActivity = null;
    }

    @Override // io.flutter.embedding.engine.systemchannels.SensitiveContentChannel.SensitiveContentMethodHandler
    public int getContentSensitivity() {
        if (!isSupported()) {
            return 2;
        }
        View viewFindViewById = this.mFlutterActivity.findViewById(this.mFlutterViewId);
        if (viewFindViewById != null) {
            return viewFindViewById.getContentSensitivity();
        }
        throw new IllegalArgumentException(getFlutterViewNotFoundErrorReason());
    }

    @Override // io.flutter.embedding.engine.systemchannels.SensitiveContentChannel.SensitiveContentMethodHandler
    public boolean isSupported() {
        return Build.VERSION.SDK_INT >= 35;
    }

    @Override // io.flutter.embedding.engine.systemchannels.SensitiveContentChannel.SensitiveContentMethodHandler
    public void setContentSensitivity(int i10) {
        if (!isSupported()) {
            throw new IllegalStateException(getNotSupportedErrorReason());
        }
        View viewFindViewById = this.mFlutterActivity.findViewById(this.mFlutterViewId);
        if (viewFindViewById == null) {
            throw new IllegalArgumentException(getFlutterViewNotFoundErrorReason());
        }
        if (viewFindViewById.getContentSensitivity() == i10) {
            return;
        }
        viewFindViewById.setContentSensitivity(i10);
        viewFindViewById.invalidate();
    }
}
