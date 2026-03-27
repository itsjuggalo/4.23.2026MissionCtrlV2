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
    public SidecarDeviceState f8444b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final U0.a f8446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SidecarInterface.SidecarCallback f8447e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8443a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f8445c = new WeakHashMap();

    public DistinctElementSidecarCallback(U0.a aVar, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f8446d = aVar;
        this.f8447e = sidecarCallback;
    }

    public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.f8443a) {
            try {
                if (this.f8446d.a(this.f8444b, sidecarDeviceState)) {
                    return;
                }
                this.f8444b = sidecarDeviceState;
                this.f8447e.onDeviceStateChanged(sidecarDeviceState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.f8443a) {
            try {
                if (this.f8446d.d((SidecarWindowLayoutInfo) this.f8445c.get(iBinder), sidecarWindowLayoutInfo)) {
                    return;
                }
                this.f8445c.put(iBinder, sidecarWindowLayoutInfo);
                this.f8447e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
