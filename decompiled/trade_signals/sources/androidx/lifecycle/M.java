package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11956a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.f11956a.values().iterator();
        while (it.hasNext()) {
            ((J) it.next()).a();
        }
        this.f11956a.clear();
    }

    public final J b(String key) {
        AbstractC2304t.f(key, "key");
        return (J) this.f11956a.get(key);
    }

    public final Set c() {
        return new HashSet(this.f11956a.keySet());
    }

    public final void d(String key, J viewModel) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(viewModel, "viewModel");
        J j8 = (J) this.f11956a.put(key, viewModel);
        if (j8 != null) {
            j8.d();
        }
    }
}
