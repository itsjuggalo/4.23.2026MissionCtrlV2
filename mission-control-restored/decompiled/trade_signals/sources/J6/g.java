package J6;

import I6.S;
import I6.v0;
import R5.H;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0856m;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends I6.r {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4645a = new a();

        @Override // J6.g
        public InterfaceC0848e b(q6.b classId) {
            AbstractC2304t.f(classId, "classId");
            return null;
        }

        @Override // J6.g
        public B6.k c(InterfaceC0848e classDescriptor, Function0 compute) {
            AbstractC2304t.f(classDescriptor, "classDescriptor");
            AbstractC2304t.f(compute, "compute");
            return (B6.k) compute.invoke();
        }

        @Override // J6.g
        public boolean d(H moduleDescriptor) {
            AbstractC2304t.f(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // J6.g
        public boolean e(v0 typeConstructor) {
            AbstractC2304t.f(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // J6.g
        public Collection g(InterfaceC0848e classDescriptor) {
            AbstractC2304t.f(classDescriptor, "classDescriptor");
            Collection collectionR = classDescriptor.l().r();
            AbstractC2304t.e(collectionR, "getSupertypes(...)");
            return collectionR;
        }

        @Override // I6.r
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public S a(M6.i type) {
            AbstractC2304t.f(type, "type");
            return (S) type;
        }

        @Override // J6.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public InterfaceC0848e f(InterfaceC0856m descriptor) {
            AbstractC2304t.f(descriptor, "descriptor");
            return null;
        }
    }

    public abstract InterfaceC0848e b(q6.b bVar);

    public abstract B6.k c(InterfaceC0848e interfaceC0848e, Function0 function0);

    public abstract boolean d(H h8);

    public abstract boolean e(v0 v0Var);

    public abstract InterfaceC0851h f(InterfaceC0856m interfaceC0856m);

    public abstract Collection g(InterfaceC0848e interfaceC0848e);

    /* JADX INFO: renamed from: h */
    public abstract S a(M6.i iVar);
}
