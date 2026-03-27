package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SidecarDeviceState f12509b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final O0.a f12511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SidecarInterface.SidecarCallback f12512e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12508a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f12510c = new WeakHashMap();

    public DistinctElementSidecarCallback(O0.a aVar, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f12511d = aVar;
        this.f12512e = sidecarCallback;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.f12508a) {
            try {
                if (this.f12511d.a(this.f12509b, sidecarDeviceState)) {
                    return;
                }
                this.f12509b = sidecarDeviceState;
                this.f12512e.onDeviceStateChanged(sidecarDeviceState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.f12508a) {
            try {
                if (this.f12511d.d((SidecarWindowLayoutInfo) this.f12510c.get(iBinder), sidecarWindowLayoutInfo)) {
                    return;
                }
                this.f12510c.put(iBinder, sidecarWindowLayoutInfo);
                this.f12512e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
