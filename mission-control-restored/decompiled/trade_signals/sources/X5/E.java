package X5;

import h6.InterfaceC1892a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E implements h6.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9397a = new a(null);

    public static final class a {
        public a() {
        }

        public final E a(Type type) {
            AbstractC2304t.f(type, "type");
            boolean z7 = type instanceof Class;
            if (z7) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new C(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z7 && ((Class) type).isArray())) ? new m(type) : type instanceof WildcardType ? new H((WildcardType) type) : new s(type);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public abstract Type R();

    @Override // h6.InterfaceC1895d
    public InterfaceC1892a b(q6.c fqName) {
        Object obj;
        AbstractC2304t.f(fqName, "fqName");
        Iterator it = getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            q6.b bVarD = ((InterfaceC1892a) next).d();
            if (AbstractC2304t.b(bVarD != null ? bVarD.a() : null, fqName)) {
                obj = next;
                break;
            }
        }
        return (InterfaceC1892a) obj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof E) && AbstractC2304t.b(R(), ((E) obj).R());
    }

    public int hashCode() {
        return R().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + R();
    }
}
