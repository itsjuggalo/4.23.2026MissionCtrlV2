package d;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: d.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1206a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f11370a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Context f11371b;

    public final void a(InterfaceC1207b listener) {
        r.f(listener, "listener");
        Context context = this.f11371b;
        if (context != null) {
            listener.a(context);
        }
        this.f11370a.add(listener);
    }

    public final void b() {
        this.f11371b = null;
    }

    public final void c(Context context) {
        r.f(context, "context");
        this.f11371b = context;
        Iterator it = this.f11370a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1207b) it.next()).a(context);
        }
    }

    public final Context d() {
        return this.f11371b;
    }

    public final void e(InterfaceC1207b listener) {
        r.f(listener, "listener");
        this.f11370a.remove(listener);
    }
}
