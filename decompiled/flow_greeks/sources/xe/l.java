package xe;

import fe.j1;
import fe.m0;
import java.util.List;
import ne.c;
import oe.d0;
import oe.v;
import pe.i;
import re.e;
import tf.o;
import we.l1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements oe.a0 {
        @Override // oe.a0
        public List a(ef.b classId) {
            kotlin.jvm.internal.t.f(classId, "classId");
            return null;
        }
    }

    public static final k a(fe.h0 module, wf.n storageManager, m0 notFoundClasses, re.j lazyJavaPackageFragmentProvider, v reflectKotlinClassFinder, n deserializedDescriptorResolver, tf.w errorReporter, df.e jvmMetadataVersion) {
        kotlin.jvm.internal.t.f(module, "module");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.t.f(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        kotlin.jvm.internal.t.f(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.t.f(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.t.f(errorReporter, "errorReporter");
        kotlin.jvm.internal.t.f(jvmMetadataVersion, "jvmMetadataVersion");
        return new k(storageManager, module, o.a.f22024a, new o(reflectKotlinClassFinder, deserializedDescriptorResolver), i.a(module, notFoundClasses, storageManager, reflectKotlinClassFinder, jvmMetadataVersion), lazyJavaPackageFragmentProvider, notFoundClasses, errorReporter, c.a.f17033a, tf.m.f21986a.a(), yf.p.f25422b.a(), new ag.a(dd.q.e(xf.x.f25092a)));
    }

    public static final re.j b(oe.u javaClassFinder, fe.h0 module, wf.n storageManager, m0 notFoundClasses, v reflectKotlinClassFinder, n deserializedDescriptorResolver, tf.w errorReporter, ue.b javaSourceElementFactory, re.n singleModuleClassResolver, d0 packagePartProvider) {
        kotlin.jvm.internal.t.f(javaClassFinder, "javaClassFinder");
        kotlin.jvm.internal.t.f(module, "module");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.t.f(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.t.f(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.t.f(errorReporter, "errorReporter");
        kotlin.jvm.internal.t.f(javaSourceElementFactory, "javaSourceElementFactory");
        kotlin.jvm.internal.t.f(singleModuleClassResolver, "singleModuleClassResolver");
        kotlin.jvm.internal.t.f(packagePartProvider, "packagePartProvider");
        pe.o DO_NOTHING = pe.o.f18612a;
        kotlin.jvm.internal.t.e(DO_NOTHING, "DO_NOTHING");
        pe.j EMPTY = pe.j.f18605a;
        kotlin.jvm.internal.t.e(EMPTY, "EMPTY");
        i.a aVar = i.a.f18604a;
        pf.b bVar = new pf.b(storageManager, dd.r.k());
        j1.a aVar2 = j1.a.f9488a;
        c.a aVar3 = c.a.f17033a;
        ce.n nVar = new ce.n(module, notFoundClasses);
        d0.b bVar2 = oe.d0.f17958d;
        oe.d dVar = new oe.d(bVar2.a());
        e.a aVar4 = e.a.f19849a;
        return new re.j(new re.d(storageManager, javaClassFinder, reflectKotlinClassFinder, deserializedDescriptorResolver, DO_NOTHING, errorReporter, EMPTY, aVar, bVar, javaSourceElementFactory, singleModuleClassResolver, packagePartProvider, aVar2, aVar3, module, nVar, dVar, new l1(new we.g(aVar4)), v.a.f18096a, aVar4, yf.p.f25422b.a(), bVar2.a(), new a(), null, 8388608, null));
    }
}
