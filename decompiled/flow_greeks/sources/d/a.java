package d;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f7395a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Context f7396b;

    public final void a(b listener) {
        t.f(listener, "listener");
        Context context = this.f7396b;
        if (context != null) {
            listener.a(context);
        }
        this.f7395a.add(listener);
    }

    public final void b() {
        this.f7396b = null;
    }

    public final void c(Context context) {
        t.f(context, "context");
        this.f7396b = context;
        Iterator it = this.f7395a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(context);
        }
    }

    public final Context d() {
        return this.f7396b;
    }

    public final void e(b listener) {
        t.f(listener, "listener");
        this.f7395a.remove(listener);
    }
}
