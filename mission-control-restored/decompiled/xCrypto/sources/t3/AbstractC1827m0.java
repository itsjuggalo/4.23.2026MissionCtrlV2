package t3;

import Z2.i;
import java.io.Closeable;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: t3.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1827m0 extends I implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f15020c = new a(null);

    /* JADX INFO: renamed from: t3.m0$a */
    public static final class a extends Z2.b {

        /* JADX INFO: renamed from: t3.m0$a$a, reason: collision with other inner class name */
        public static final class C0243a extends kotlin.jvm.internal.s implements i3.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0243a f15021a = new C0243a();

            public C0243a() {
                super(1);
            }

            @Override // i3.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC1827m0 invoke(i.b bVar) {
                if (bVar instanceof AbstractC1827m0) {
                    return (AbstractC1827m0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
            super(I.f14947b, C0243a.f15021a);
        }
    }
}
