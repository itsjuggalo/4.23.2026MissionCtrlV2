package R0;

import android.app.Activity;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4667a = a.f4668a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f4668a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Q5.k f4669b = C0079a.f4670a;

        /* JADX INFO: renamed from: R0.l$a$a, reason: collision with other inner class name */
        public static final class C0079a extends s implements Q5.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0079a f4670a = new C0079a();

            public C0079a() {
                super(1);
            }

            @Override // Q5.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final l invoke(l it) {
                r.f(it, "it");
                return it;
            }
        }

        public final l a() {
            return (l) f4669b.invoke(o.f4671b);
        }
    }

    static l b() {
        return f4667a.a();
    }

    k a(Activity activity);
}
