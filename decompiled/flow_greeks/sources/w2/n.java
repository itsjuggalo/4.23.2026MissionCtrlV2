package w2;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n0;
import w2.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23644a = a.f23645a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f23646b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f23645a = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f23647c = n0.b(n.class).c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final cd.k f23648d = cd.l.b(new Function0() { // from class: w2.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return n.a.b();
            }
        });

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static o f23649e = b.f23617a;

        public static final x2.a b() {
            WindowLayoutComponent windowLayoutComponentL;
            try {
                ClassLoader classLoader = n.class.getClassLoader();
                l lVar = classLoader != null ? new l(classLoader, new t2.d(classLoader)) : null;
                if (lVar == null || (windowLayoutComponentL = lVar.l()) == null) {
                    return null;
                }
                return y2.a.f25167a.a(windowLayoutComponentL, new t2.d(classLoader));
            } catch (Throwable unused) {
                if (f23646b) {
                    Log.d(f23647c, "Failed to load WindowExtensions");
                }
                return null;
            }
        }

        public final x2.a c() {
            return (x2.a) f23648d.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final n d(Context context) {
            kotlin.jvm.internal.t.f(context, "context");
            x2.a aVarC = c();
            if (aVarC == null) {
                aVarC = androidx.window.layout.adapter.sidecar.b.f2887c.a(context);
            }
            return f23649e.a(new r(new w(null, 1, 0 == true ? 1 : 0), aVarC, s2.e.f19962b.a()));
        }
    }

    qg.d a(Activity activity);
}
