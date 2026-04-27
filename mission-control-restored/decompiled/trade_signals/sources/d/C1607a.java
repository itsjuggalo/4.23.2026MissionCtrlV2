package d;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: d.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1607a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f16694a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Context f16695b;

    public final void a(InterfaceC1608b listener) {
        AbstractC2304t.f(listener, "listener");
        Context context = this.f16695b;
        if (context != null) {
            listener.a(context);
        }
        this.f16694a.add(listener);
    }

    public final void b() {
        this.f16695b = null;
    }

    public final void c(Context context) {
        AbstractC2304t.f(context, "context");
        this.f16695b = context;
        Iterator it = this.f16694a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1608b) it.next()).a(context);
        }
    }

    public final Context d() {
        return this.f16695b;
    }

    public final void e(InterfaceC1608b listener) {
        AbstractC2304t.f(listener, "listener");
        this.f16694a.remove(listener);
    }
}
