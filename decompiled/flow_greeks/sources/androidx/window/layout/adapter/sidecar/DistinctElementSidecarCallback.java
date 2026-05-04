package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.Map;
import java.util.WeakHashMap;
import z2.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SidecarDeviceState f2871b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f2873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SidecarInterface.SidecarCallback f2874e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2870a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2872c = new WeakHashMap();

    public DistinctElementSidecarCallback(e eVar, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f2873d = eVar;
        this.f2874e = sidecarCallback;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.f2870a) {
            try {
                if (this.f2873d.e(this.f2871b, sidecarDeviceState)) {
                    return;
                }
                this.f2871b = sidecarDeviceState;
                this.f2874e.onDeviceStateChanged(sidecarDeviceState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.f2870a) {
            try {
                if (this.f2873d.h((SidecarWindowLayoutInfo) this.f2872c.get(iBinder), sidecarWindowLayoutInfo)) {
                    return;
                }
                this.f2872c.put(iBinder, sidecarWindowLayoutInfo);
                this.f2874e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
