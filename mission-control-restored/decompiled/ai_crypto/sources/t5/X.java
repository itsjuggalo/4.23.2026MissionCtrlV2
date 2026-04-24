package t5;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f23612a = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (this.f23612a.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract void b();

    public abstract void c();

    public final boolean d() {
        return !this.f23612a.isEmpty();
    }

    public final void e(Object obj, boolean z7) {
        int size = this.f23612a.size();
        if (z7) {
            this.f23612a.add(obj);
            if (size == 0) {
                b();
                return;
            }
            return;
        }
        if (this.f23612a.remove(obj) && size == 1) {
            c();
        }
    }
}
