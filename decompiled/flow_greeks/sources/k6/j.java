package k6;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends l6.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f14737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f14738c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(m mVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f14737b = taskCompletionSource2;
        this.f14738c = mVar;
    }

    @Override // l6.j
    public final void a() {
        try {
            l6.f fVar = (l6.f) this.f14738c.f14743a.e();
            String str = this.f14738c.f14744b;
            Bundle bundle = new Bundle();
            Map mapA = n.a();
            bundle.putInt("playcore_version_code", ((Integer) mapA.get("java")).intValue());
            if (mapA.containsKey("native")) {
                bundle.putInt("playcore_native_version", ((Integer) mapA.get("native")).intValue());
            }
            if (mapA.containsKey("unity")) {
                bundle.putInt("playcore_unity_version", ((Integer) mapA.get("unity")).intValue());
            }
            m mVar = this.f14738c;
            fVar.i(str, bundle, new l(mVar, this.f14737b, mVar.f14744b));
        } catch (RemoteException e10) {
            m.f14742c.b(e10, "error requesting in-app review for %s", this.f14738c.f14744b);
            this.f14737b.trySetException(new RuntimeException(e10));
        }
    }
}
