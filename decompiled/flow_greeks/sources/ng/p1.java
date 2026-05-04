package ng;

import gd.i;
import java.io.Closeable;
import java.util.concurrent.Executor;
import ng.p1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p1 extends k0 implements Closeable, AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f17174c = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends gd.b {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static final p1 d(i.b bVar) {
            if (bVar instanceof p1) {
                return (p1) bVar;
            }
            return null;
        }

        public a() {
            super(k0.f17152b, new pd.k() { // from class: ng.o1
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return p1.a.d((i.b) obj);
                }
            });
        }
    }

    public abstract Executor e0();
}
