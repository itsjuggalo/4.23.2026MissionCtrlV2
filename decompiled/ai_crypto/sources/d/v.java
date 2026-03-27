package d;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f13121b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0 f13122c;

    public v(boolean z7) {
        this.f13120a = z7;
    }

    public final void a(InterfaceC1387c cancellable) {
        kotlin.jvm.internal.r.f(cancellable, "cancellable");
        this.f13121b.add(cancellable);
    }

    public final Function0 b() {
        return this.f13122c;
    }

    public abstract void c();

    public abstract void d();

    public abstract void e(C1386b c1386b);

    public abstract void f(C1386b c1386b);

    public final boolean g() {
        return this.f13120a;
    }

    public final void h() {
        Iterator it = this.f13121b.iterator();
        while (it.hasNext()) {
            ((InterfaceC1387c) it.next()).cancel();
        }
    }

    public final void i(InterfaceC1387c cancellable) {
        kotlin.jvm.internal.r.f(cancellable, "cancellable");
        this.f13121b.remove(cancellable);
    }

    public final void j(boolean z7) {
        this.f13120a = z7;
        Function0 function0 = this.f13122c;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void k(Function0 function0) {
        this.f13122c = function0;
    }
}
