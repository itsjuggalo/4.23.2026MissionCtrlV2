package uf;

import cd.q;
import fe.h0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import nf.e;
import tf.u;
import wf.n;
import ze.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends u implements ce.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f22985o = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f22986n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final c a(ef.c fqName, n storageManager, h0 module, InputStream inputStream, boolean z10) throws IllegalAccessException, IOException, InvocationTargetException {
            t.f(fqName, "fqName");
            t.f(storageManager, "storageManager");
            t.f(module, "module");
            t.f(inputStream, "inputStream");
            q qVarA = af.c.a(inputStream);
            m mVar = (m) qVarA.a();
            af.a aVar = (af.a) qVarA.b();
            if (mVar != null) {
                return new c(fqName, storageManager, module, mVar, aVar, z10, null);
            }
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + af.a.f810h + ", actual " + aVar + ". Please update Kotlin");
        }

        public a() {
        }
    }

    public /* synthetic */ c(ef.c cVar, n nVar, h0 h0Var, m mVar, af.a aVar, boolean z10, k kVar) {
        this(cVar, nVar, h0Var, mVar, aVar, z10);
    }

    @Override // ie.h0, ie.m
    public String toString() {
        return "builtins package fragment for " + e() + " from " + e.s(this);
    }

    public c(ef.c cVar, n nVar, h0 h0Var, m mVar, af.a aVar, boolean z10) {
        super(cVar, nVar, h0Var, mVar, aVar, null);
        this.f22986n = z10;
    }
}
