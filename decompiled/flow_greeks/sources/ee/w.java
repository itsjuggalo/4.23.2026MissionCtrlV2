package ee;

import fe.h0;
import fe.m0;
import java.io.InputStream;
import ne.c;
import tf.b0;
import tf.x;
import tf.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends tf.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f8762f = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(wf.n storageManager, xe.v finder, h0 moduleDescriptor, m0 notFoundClasses, he.a additionalClassPartsProvider, he.c platformDependentDeclarationFilter, tf.o deserializationConfiguration, yf.p kotlinTypeChecker, pf.a samConversionResolver) {
        super(storageManager, finder, moduleDescriptor);
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(finder, "finder");
        kotlin.jvm.internal.t.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.t.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.t.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.t.f(deserializationConfiguration, "deserializationConfiguration");
        kotlin.jvm.internal.t.f(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.t.f(samConversionResolver, "samConversionResolver");
        tf.q qVar = new tf.q(this);
        uf.a aVar = uf.a.f22983r;
        tf.f fVar = new tf.f(moduleDescriptor, notFoundClasses, aVar);
        b0.a aVar2 = b0.a.f21931a;
        tf.w DO_NOTHING = tf.w.f22065a;
        kotlin.jvm.internal.t.e(DO_NOTHING, "DO_NOTHING");
        k(new tf.n(storageManager, moduleDescriptor, deserializationConfiguration, qVar, fVar, this, aVar2, DO_NOTHING, c.a.f17033a, x.a.f22074a, dd.r.n(new de.a(storageManager, moduleDescriptor), new g(storageManager, moduleDescriptor, null, 4, null)), notFoundClasses, tf.m.f21986a.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, aVar.e(), kotlinTypeChecker, samConversionResolver, null, z.f22082a, 262144, null));
    }

    @Override // tf.c
    public tf.r e(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        InputStream inputStreamC = h().c(fqName);
        if (inputStreamC != null) {
            return uf.c.f22985o.a(fqName, j(), i(), inputStreamC, false);
        }
        return null;
    }
}
