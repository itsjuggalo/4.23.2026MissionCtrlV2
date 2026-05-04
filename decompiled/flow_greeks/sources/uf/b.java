package uf;

import ce.o;
import dd.r;
import dd.s;
import fe.h0;
import fe.m0;
import fe.o0;
import fe.r0;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import ne.c;
import pd.k;
import tf.b0;
import tf.f;
import tf.m;
import tf.o;
import tf.w;
import tf.x;
import wf.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ce.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f22984b = new d();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends q implements k {
        public a(Object obj) {
            super(1, obj, d.class, "loadResource", "loadResource(Ljava/lang/String;)Ljava/io/InputStream;", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final InputStream invoke(String p02) {
            t.f(p02, "p0");
            return ((d) this.receiver).a(p02);
        }
    }

    @Override // ce.b
    public o0 a(n storageManager, h0 builtInsModule, Iterable classDescriptorFactories, he.c platformDependentDeclarationFilter, he.a additionalClassPartsProvider, boolean z10) {
        t.f(storageManager, "storageManager");
        t.f(builtInsModule, "builtInsModule");
        t.f(classDescriptorFactories, "classDescriptorFactories");
        t.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        t.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        return b(storageManager, builtInsModule, o.H, classDescriptorFactories, platformDependentDeclarationFilter, additionalClassPartsProvider, z10, new a(this.f22984b));
    }

    public final o0 b(n nVar, h0 h0Var, Set packageFqNames, Iterable classDescriptorFactories, he.c platformDependentDeclarationFilter, he.a additionalClassPartsProvider, boolean z10, k loadResource) {
        n storageManager = nVar;
        h0 module = h0Var;
        t.f(storageManager, "storageManager");
        t.f(module, "module");
        t.f(packageFqNames, "packageFqNames");
        t.f(classDescriptorFactories, "classDescriptorFactories");
        t.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        t.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        t.f(loadResource, "loadResource");
        ArrayList arrayList = new ArrayList(s.u(packageFqNames, 10));
        Iterator it = packageFqNames.iterator();
        while (it.hasNext()) {
            ef.c cVar = (ef.c) it.next();
            String strR = uf.a.f22983r.r(cVar);
            InputStream inputStream = (InputStream) loadResource.invoke(strR);
            if (inputStream == null) {
                throw new IllegalStateException("Resource not found in classpath: " + strR);
            }
            h0 h0Var2 = module;
            storageManager = nVar;
            module = h0Var2;
            arrayList.add(c.f22985o.a(cVar, nVar, h0Var2, inputStream, z10));
        }
        r0 r0Var = new r0(arrayList);
        m0 m0Var = new m0(storageManager, module);
        o.a aVar = o.a.f22024a;
        tf.q qVar = new tf.q(r0Var);
        uf.a aVar2 = uf.a.f22983r;
        f fVar = new f(module, m0Var, aVar2);
        b0.a aVar3 = b0.a.f21931a;
        w DO_NOTHING = w.f22065a;
        t.e(DO_NOTHING, "DO_NOTHING");
        tf.n nVar2 = new tf.n(storageManager, h0Var, aVar, qVar, fVar, r0Var, aVar3, DO_NOTHING, c.a.f17033a, x.a.f22074a, classDescriptorFactories, m0Var, m.f21986a.a(), additionalClassPartsProvider, platformDependentDeclarationFilter, aVar2.e(), null, new pf.b(storageManager, r.k()), null, null, 851968, null);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).L0(nVar2);
        }
        return r0Var;
    }
}
