package E6;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: E6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0464c implements R5.U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H6.n f973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A f974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final R5.H f975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0475n f976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H6.h f977e;

    public AbstractC0464c(H6.n storageManager, A finder, R5.H moduleDescriptor) {
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(finder, "finder");
        AbstractC2304t.f(moduleDescriptor, "moduleDescriptor");
        this.f973a = storageManager;
        this.f974b = finder;
        this.f975c = moduleDescriptor;
        this.f977e = storageManager.d(new C0463b(this));
    }

    public static final R5.N f(AbstractC0464c abstractC0464c, q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        r rVarE = abstractC0464c.e(fqName);
        if (rVarE == null) {
            return null;
        }
        rVarE.M0(abstractC0464c.g());
        return rVarE;
    }

    @Override // R5.U
    public boolean a(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return (this.f977e.f(fqName) ? (R5.N) this.f977e.invoke(fqName) : e(fqName)) == null;
    }

    @Override // R5.U
    public void b(q6.c fqName, Collection packageFragments) {
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(packageFragments, "packageFragments");
        S6.a.a(packageFragments, this.f977e.invoke(fqName));
    }

    @Override // R5.O
    public List c(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return AbstractC2595q.m(this.f977e.invoke(fqName));
    }

    public abstract r e(q6.c cVar);

    public final C0475n g() {
        C0475n c0475n = this.f976d;
        if (c0475n != null) {
            return c0475n;
        }
        AbstractC2304t.s("components");
        return null;
    }

    public final A h() {
        return this.f974b;
    }

    public final R5.H i() {
        return this.f975c;
    }

    public final H6.n j() {
        return this.f973a;
    }

    public final void k(C0475n c0475n) {
        AbstractC2304t.f(c0475n, "<set-?>");
        this.f976d = c0475n;
    }

    @Override // R5.O
    public Collection v(q6.c fqName, B5.k nameFilter) {
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(nameFilter, "nameFilter");
        return p5.S.d();
    }
}
