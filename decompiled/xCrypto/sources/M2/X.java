package M2;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2061a = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (this.f2061a.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract void b();

    public abstract void c();

    public final boolean d() {
        return !this.f2061a.isEmpty();
    }

    public final void e(Object obj, boolean z4) {
        int size = this.f2061a.size();
        if (z4) {
            this.f2061a.add(obj);
            if (size == 0) {
                b();
                return;
            }
            return;
        }
        if (this.f2061a.remove(obj) && size == 1) {
            c();
        }
    }
}
