package b6;

import H5.g;
import java.io.Closeable;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: b6.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1082m0 extends I implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9078c = new a(null);

    /* JADX INFO: renamed from: b6.m0$a */
    public static final class a extends H5.b {

        /* JADX INFO: renamed from: b6.m0$a$a, reason: collision with other inner class name */
        public static final class C0148a extends kotlin.jvm.internal.s implements Q5.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0148a f9079a = new C0148a();

            public C0148a() {
                super(1);
            }

            @Override // Q5.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC1082m0 invoke(g.b bVar) {
                if (bVar instanceof AbstractC1082m0) {
                    return (AbstractC1082m0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
            super(I.f9005b, C0148a.f9079a);
        }
    }
}
