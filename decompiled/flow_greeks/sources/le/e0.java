package le;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e0 implements ve.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15612a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final e0 a(Type type) {
            kotlin.jvm.internal.t.f(type, "type");
            boolean z10 = type instanceof Class;
            if (z10) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new c0(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z10 && ((Class) type).isArray())) ? new m(type) : type instanceof WildcardType ? new h0((WildcardType) type) : new s(type);
        }

        public a() {
        }
    }

    public abstract Type Q();

    @Override // ve.d
    public ve.a b(ef.c fqName) {
        Object obj;
        kotlin.jvm.internal.t.f(fqName, "fqName");
        Iterator it = getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ef.b bVarG = ((ve.a) next).g();
            if (kotlin.jvm.internal.t.b(bVarG != null ? bVarG.a() : null, fqName)) {
                obj = next;
                break;
            }
        }
        return (ve.a) obj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e0) && kotlin.jvm.internal.t.b(Q(), ((e0) obj).Q());
    }

    public int hashCode() {
        return Q().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + Q();
    }
}
