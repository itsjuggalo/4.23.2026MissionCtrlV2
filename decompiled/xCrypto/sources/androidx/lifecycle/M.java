package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7660a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.f7660a.values().iterator();
        while (it.hasNext()) {
            ((J) it.next()).a();
        }
        this.f7660a.clear();
    }

    public final J b(String key) {
        kotlin.jvm.internal.r.f(key, "key");
        return (J) this.f7660a.get(key);
    }

    public final Set c() {
        return new HashSet(this.f7660a.keySet());
    }

    public final void d(String key, J viewModel) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(viewModel, "viewModel");
        J j4 = (J) this.f7660a.put(key, viewModel);
        if (j4 != null) {
            j4.d();
        }
    }
}
