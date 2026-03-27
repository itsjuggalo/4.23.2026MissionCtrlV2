package Y6;

import Y6.AbstractC1016l0;
import java.io.Closeable;
import kotlin.jvm.internal.AbstractC2296k;
import s5.AbstractC2704b;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: Y6.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1016l0 extends I implements Closeable, AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9676c = new a(null);

    /* JADX INFO: renamed from: Y6.l0$a */
    public static final class a extends AbstractC2704b {
        public a() {
            super(I.f9626b, new B5.k() { // from class: Y6.k0
                @Override // B5.k
                public final Object invoke(Object obj) {
                    return AbstractC1016l0.a.d((InterfaceC2711i.b) obj);
                }
            });
        }

        public static final AbstractC1016l0 d(InterfaceC2711i.b bVar) {
            if (bVar instanceof AbstractC1016l0) {
                return (AbstractC1016l0) bVar;
            }
            return null;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }
}
