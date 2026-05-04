package tb;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f21793a = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (this.f21793a.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract void b();

    public abstract void c();

    public final boolean d() {
        return !this.f21793a.isEmpty();
    }

    public final void e(Object obj, boolean z10) {
        int size = this.f21793a.size();
        if (z10) {
            this.f21793a.add(obj);
            if (size == 0) {
                b();
                return;
            }
            return;
        }
        if (this.f21793a.remove(obj) && size == 1) {
            c();
        }
    }
}
