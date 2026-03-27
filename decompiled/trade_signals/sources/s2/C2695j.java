package s2;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.Map;
import l2.C2329m;
import t2.InterfaceC2739f;

/* JADX INFO: renamed from: s2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2695j extends t2.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2329m f23073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C2698m f23074c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2695j(C2698m c2698m, C2329m c2329m, C2329m c2329m2) {
        super(c2329m);
        this.f23073b = c2329m2;
        this.f23074c = c2698m;
    }

    @Override // t2.j
    public final void a() {
        try {
            InterfaceC2739f interfaceC2739f = (InterfaceC2739f) this.f23074c.f23079a.e();
            String str = this.f23074c.f23080b;
            Bundle bundle = new Bundle();
            Map mapA = AbstractC2699n.a();
            bundle.putInt("playcore_version_code", ((Integer) mapA.get("java")).intValue());
            if (mapA.containsKey("native")) {
                bundle.putInt("playcore_native_version", ((Integer) mapA.get("native")).intValue());
            }
            if (mapA.containsKey("unity")) {
                bundle.putInt("playcore_unity_version", ((Integer) mapA.get("unity")).intValue());
            }
            C2698m c2698m = this.f23074c;
            interfaceC2739f.e(str, bundle, new BinderC2697l(c2698m, this.f23073b, c2698m.f23080b));
        } catch (RemoteException e8) {
            C2698m.f23078c.b(e8, "error requesting in-app review for %s", this.f23074c.f23080b);
            this.f23073b.d(new RuntimeException(e8));
        }
    }
}
