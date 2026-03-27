package O5;

import R5.H;
import R5.O;
import java.util.ServiceLoader;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6032a = a.f6033a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6033a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final InterfaceC2483k f6034b = AbstractC2484l.b(EnumC2486n.f21975b, O5.a.f6031a);

        public static final b a() {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(b.class, b.class.getClassLoader());
            AbstractC2304t.c(serviceLoaderLoad);
            b bVar = (b) z.Z(serviceLoaderLoad);
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
        }

        public final b c() {
            return (b) f6034b.getValue();
        }
    }

    O a(H6.n nVar, H h8, Iterable iterable, T5.c cVar, T5.a aVar, boolean z7);
}
