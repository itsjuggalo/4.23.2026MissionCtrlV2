package A0;

import android.app.Activity;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f46a = a.f47a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f47a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static i3.k f48b = C0004a.f49a;

        /* JADX INFO: renamed from: A0.l$a$a, reason: collision with other inner class name */
        public static final class C0004a extends s implements i3.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0004a f49a = new C0004a();

            public C0004a() {
                super(1);
            }

            @Override // i3.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final l invoke(l it) {
                r.f(it, "it");
                return it;
            }
        }

        public final l a() {
            return (l) f48b.invoke(o.f50b);
        }
    }

    static l b() {
        return f46a.a();
    }

    k a(Activity activity);
}
