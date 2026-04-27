package s2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14606a;

        public class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Method f14607b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method) {
                super();
                this.f14607b = method;
            }

            @Override // s2.E.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f14607b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e4) {
                    throw new RuntimeException("Failed invoking canAccess", e4);
                }
            }
        }

        /* JADX INFO: renamed from: s2.E$b$b, reason: collision with other inner class name */
        public class C0235b extends b {
            public C0235b() {
                super();
            }

            @Override // s2.E.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            b aVar;
            if (w.c()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                    aVar = null;
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new C0235b();
            }
            f14606a = aVar;
        }

        public b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f14606a.a(accessibleObject, obj);
    }

    public static q2.s b(List list, Class cls) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return q2.s.ALLOW;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }
}
