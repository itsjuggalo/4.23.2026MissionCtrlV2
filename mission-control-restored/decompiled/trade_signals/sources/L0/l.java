package L0;

import android.app.Activity;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;

/* JADX INFO: loaded from: classes.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4995a = a.f4996a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f4996a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static B5.k f4997b = C0072a.f4999a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final m f4998c = new m(null, 1, 0 == true ? 1 : 0);

        /* JADX INFO: renamed from: L0.l$a$a, reason: collision with other inner class name */
        public static final class C0072a extends AbstractC2306v implements B5.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0072a f4999a = new C0072a();

            public C0072a() {
                super(1);
            }

            @Override // B5.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final l invoke(l it) {
                AbstractC2304t.f(it, "it");
                return it;
            }
        }

        public final l a() {
            return (l) f4997b.invoke(f4998c);
        }
    }

    static l b() {
        return f4995a.a();
    }

    k a(Activity activity);
}
