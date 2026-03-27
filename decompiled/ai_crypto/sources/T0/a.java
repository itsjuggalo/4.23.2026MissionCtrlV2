package T0;

import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements S0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0081a f4699a = new C0081a(null);

    /* JADX INFO: renamed from: T0.a$a, reason: collision with other inner class name */
    public static final class C0081a {
        public /* synthetic */ C0081a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final S0.a a(WindowLayoutComponent component, O0.d adapter) {
            r.f(component, "component");
            r.f(adapter, "adapter");
            int iA = O0.e.f4019a.a();
            return iA >= 2 ? new e(component) : iA == 1 ? new d(component, adapter) : new c();
        }

        public C0081a() {
        }
    }
}
