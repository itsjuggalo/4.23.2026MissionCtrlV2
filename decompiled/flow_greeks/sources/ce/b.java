package ce;

import dd.a0;
import fe.h0;
import fe.o0;
import java.util.ServiceLoader;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3892a = a.f3893a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f3893a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final cd.k f3894b = cd.l.a(cd.n.f3864b, ce.a.f3891a);

        public static final b a() {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(b.class, b.class.getClassLoader());
            t.c(serviceLoaderLoad);
            b bVar = (b) a0.a0(serviceLoaderLoad);
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
        }

        public final b c() {
            return (b) f3894b.getValue();
        }
    }

    o0 a(wf.n nVar, h0 h0Var, Iterable iterable, he.c cVar, he.a aVar, boolean z10);
}
