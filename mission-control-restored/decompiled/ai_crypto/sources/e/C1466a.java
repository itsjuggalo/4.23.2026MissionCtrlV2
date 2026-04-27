package e;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: e.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1466a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f13510a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Context f13511b;

    public final void a(InterfaceC1467b listener) {
        r.f(listener, "listener");
        Context context = this.f13511b;
        if (context != null) {
            listener.a(context);
        }
        this.f13510a.add(listener);
    }

    public final void b() {
        this.f13511b = null;
    }

    public final void c(Context context) {
        r.f(context, "context");
        this.f13511b = context;
        Iterator it = this.f13510a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1467b) it.next()).a(context);
        }
    }
}
