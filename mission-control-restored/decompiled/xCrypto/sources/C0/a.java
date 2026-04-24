package C0;

import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import x0.C1915d;
import x0.C1916e;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements B0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0007a f129a = new C0007a(null);

    /* JADX INFO: renamed from: C0.a$a, reason: collision with other inner class name */
    public static final class C0007a {
        public /* synthetic */ C0007a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final B0.a a(WindowLayoutComponent component, C1915d adapter) {
            r.f(component, "component");
            r.f(adapter, "adapter");
            int iA = C1916e.f15704a.a();
            return iA >= 2 ? new e(component) : iA == 1 ? new d(component, adapter) : new c();
        }

        public C0007a() {
        }
    }
}
