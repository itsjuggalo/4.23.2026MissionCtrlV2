package n6;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends w0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ IBinder f16643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ e f16644h;

    public b(e eVar, IBinder iBinder) {
        this.f16643g = iBinder;
        this.f16644h = eVar;
    }

    @Override // n6.w0
    public final void b() {
        this.f16644h.f16646a.f16661n = (IInterface) this.f16644h.f16646a.f16656i.a(this.f16643g);
        f.r(this.f16644h.f16646a);
        this.f16644h.f16646a.f16654g = false;
        Iterator it = this.f16644h.f16646a.f16651d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f16644h.f16646a.f16651d.clear();
    }
}
