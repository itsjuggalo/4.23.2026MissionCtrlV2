package N0;

import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements M0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0079a f5444a = new C0079a(null);

    /* JADX INFO: renamed from: N0.a$a, reason: collision with other inner class name */
    public static final class C0079a {
        public C0079a() {
        }

        public final M0.a a(WindowLayoutComponent component, I0.d adapter) {
            AbstractC2304t.f(component, "component");
            AbstractC2304t.f(adapter, "adapter");
            int iA = I0.e.f4033a.a();
            return iA >= 6 ? new f(component, adapter) : iA >= 2 ? new e(component, adapter) : iA == 1 ? new d(component, adapter) : new c();
        }

        public /* synthetic */ C0079a(AbstractC2296k abstractC2296k) {
            this();
        }
    }
}
