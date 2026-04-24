package n4;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19635a;

        public class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Method f19636b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method) {
                super();
                this.f19636b = method;
            }

            @Override // n4.E.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f19636b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e7) {
                    throw new RuntimeException("Failed invoking canAccess", e7);
                }
            }
        }

        /* JADX INFO: renamed from: n4.E$b$b, reason: collision with other inner class name */
        public class C0313b extends b {
            public C0313b() {
                super();
            }

            @Override // n4.E.b
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
                aVar = new C0313b();
            }
            f19635a = aVar;
        }

        public b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f19635a.a(accessibleObject, obj);
    }

    public static l4.s b(List list, Class cls) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return l4.s.ALLOW;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }
}
