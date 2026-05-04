package re;

import ce.o;
import dd.a0;
import ge.h;
import java.util.Iterator;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements ge.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f19851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ve.d f19852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.h f19854d;

    public g(k c10, ve.d annotationOwner, boolean z10) {
        t.f(c10, "c");
        t.f(annotationOwner, "annotationOwner");
        this.f19851a = c10;
        this.f19852b = annotationOwner;
        this.f19853c = z10;
        this.f19854d = c10.a().u().h(new f(this));
    }

    public static final ge.c c(g gVar, ve.a annotation) {
        t.f(annotation, "annotation");
        return pe.d.f18592a.e(annotation, gVar.f19851a, gVar.f19853c);
    }

    @Override // ge.h
    public boolean E(ef.c cVar) {
        return h.b.b(this, cVar);
    }

    @Override // ge.h
    public ge.c b(ef.c fqName) {
        ge.c cVar;
        t.f(fqName, "fqName");
        ve.a aVarB = this.f19852b.b(fqName);
        return (aVarB == null || (cVar = (ge.c) this.f19854d.invoke(aVarB)) == null) ? pe.d.f18592a.a(fqName, this.f19852b, this.f19851a) : cVar;
    }

    @Override // ge.h
    public boolean isEmpty() {
        return this.f19852b.getAnnotations().isEmpty() && !this.f19852b.n();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return jg.t.z(jg.t.H(jg.t.E(a0.Q(this.f19852b.getAnnotations()), this.f19854d), pe.d.f18592a.a(o.a.f4021y, this.f19852b, this.f19851a))).iterator();
    }

    public /* synthetic */ g(k kVar, ve.d dVar, boolean z10, int i10, kotlin.jvm.internal.k kVar2) {
        this(kVar, dVar, (i10 & 4) != 0 ? false : z10);
    }
}
