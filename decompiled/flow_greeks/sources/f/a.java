package f;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0169a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f9033a;

        public C0169a(Object obj) {
            this.f9033a = obj;
        }

        public final Object a() {
            return this.f9033a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0169a b(Context context, Object obj) {
        t.f(context, "context");
        return null;
    }

    public abstract Object c(int i10, Intent intent);
}
