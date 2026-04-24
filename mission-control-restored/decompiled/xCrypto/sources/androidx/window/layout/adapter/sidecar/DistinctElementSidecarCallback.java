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
    public SidecarDeviceState f8209b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D0.a f8211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SidecarInterface.SidecarCallback f8212e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8208a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f8210c = new WeakHashMap();

    public DistinctElementSidecarCallback(D0.a aVar, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f8211d = aVar;
        this.f8212e = sidecarCallback;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.f8208a) {
            try {
                if (this.f8211d.a(this.f8209b, sidecarDeviceState)) {
                    return;
                }
                this.f8209b = sidecarDeviceState;
                this.f8212e.onDeviceStateChanged(sidecarDeviceState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.f8208a) {
            try {
                if (this.f8211d.d((SidecarWindowLayoutInfo) this.f8210c.get(iBinder), sidecarWindowLayoutInfo)) {
                    return;
                }
                this.f8210c.put(iBinder, sidecarWindowLayoutInfo);
                this.f8212e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
