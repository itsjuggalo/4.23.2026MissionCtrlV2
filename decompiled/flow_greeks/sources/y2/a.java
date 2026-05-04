package y2;

import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements x2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0468a f25167a = new C0468a(null);

    /* JADX INFO: renamed from: y2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0468a {
        public /* synthetic */ C0468a(k kVar) {
            this();
        }

        public final x2.a a(WindowLayoutComponent component, t2.d adapter) {
            t.f(component, "component");
            t.f(adapter, "adapter");
            int iA = t2.e.f20647a.a();
            return iA >= 9 ? new g(component, adapter) : iA >= 6 ? new f(component, adapter) : iA >= 2 ? new e(component, adapter) : iA == 1 ? new d(component, adapter) : new c();
        }

        public C0468a() {
        }
    }
}
