package yf;

import fe.h0;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import xf.r0;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends xf.r {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25404a = new a();

        @Override // yf.g
        public fe.e b(ef.b classId) {
            kotlin.jvm.internal.t.f(classId, "classId");
            return null;
        }

        @Override // yf.g
        public qf.k c(fe.e classDescriptor, Function0 compute) {
            kotlin.jvm.internal.t.f(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.t.f(compute, "compute");
            return (qf.k) compute.invoke();
        }

        @Override // yf.g
        public boolean d(h0 moduleDescriptor) {
            kotlin.jvm.internal.t.f(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // yf.g
        public boolean e(u1 typeConstructor) {
            kotlin.jvm.internal.t.f(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // yf.g
        public Collection g(fe.e classDescriptor) {
            kotlin.jvm.internal.t.f(classDescriptor, "classDescriptor");
            Collection collectionC = classDescriptor.k().c();
            kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
            return collectionC;
        }

        @Override // xf.r
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public r0 a(bg.i type) {
            kotlin.jvm.internal.t.f(type, "type");
            return (r0) type;
        }

        @Override // yf.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public fe.e f(fe.m descriptor) {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            return null;
        }
    }

    public abstract fe.e b(ef.b bVar);

    public abstract qf.k c(fe.e eVar, Function0 function0);

    public abstract boolean d(h0 h0Var);

    public abstract boolean e(u1 u1Var);

    public abstract fe.h f(fe.m mVar);

    public abstract Collection g(fe.e eVar);

    /* JADX INFO: renamed from: h */
    public abstract r0 a(bg.i iVar);
}
