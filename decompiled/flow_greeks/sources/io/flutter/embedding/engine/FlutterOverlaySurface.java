package io.flutter.embedding.engine;

import android.view.Surface;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FlutterOverlaySurface {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f12533id;
    private final Surface surface;

    public FlutterOverlaySurface(int i10, Surface surface) {
        this.f12533id = i10;
        this.surface = surface;
    }

    public int getId() {
        return this.f12533id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
