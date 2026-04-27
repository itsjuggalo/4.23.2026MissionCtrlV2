package G4;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2649a = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (this.f2649a.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract void b();

    public abstract void c();

    public final boolean d() {
        return !this.f2649a.isEmpty();
    }

    public final void e(Object obj, boolean z7) {
        int size = this.f2649a.size();
        if (z7) {
            this.f2649a.add(obj);
            if (size == 0) {
                b();
                return;
            }
            return;
        }
        if (this.f2649a.remove(obj) && size == 1) {
            c();
        }
    }
}
