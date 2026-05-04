package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2446a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.f2446a.values().iterator();
        while (it.hasNext()) {
            ((i0) it.next()).a();
        }
        this.f2446a.clear();
    }

    public final i0 b(String key) {
        kotlin.jvm.internal.t.f(key, "key");
        return (i0) this.f2446a.get(key);
    }

    public final Set c() {
        return new HashSet(this.f2446a.keySet());
    }

    public final void d(String key, i0 viewModel) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(viewModel, "viewModel");
        i0 i0Var = (i0) this.f2446a.put(key, viewModel);
        if (i0Var != null) {
            i0Var.d();
        }
    }
}
