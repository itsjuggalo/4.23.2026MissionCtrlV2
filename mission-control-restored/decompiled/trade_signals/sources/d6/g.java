package d6;

import O5.o;
import S5.h;
import U6.r;
import b6.C1228d;
import h6.InterfaceC1892a;
import h6.InterfaceC1895d;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements S5.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f17003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1895d f17004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H6.h f17006d;

    public g(k c8, InterfaceC1895d annotationOwner, boolean z7) {
        AbstractC2304t.f(c8, "c");
        AbstractC2304t.f(annotationOwner, "annotationOwner");
        this.f17003a = c8;
        this.f17004b = annotationOwner;
        this.f17005c = z7;
        this.f17006d = c8.a().u().d(new f(this));
    }

    public static final S5.c d(g gVar, InterfaceC1892a annotation) {
        AbstractC2304t.f(annotation, "annotation");
        return C1228d.f13193a.e(annotation, gVar.f17003a, gVar.f17005c);
    }

    @Override // S5.h
    public S5.c b(q6.c fqName) {
        S5.c cVar;
        AbstractC2304t.f(fqName, "fqName");
        InterfaceC1892a interfaceC1892aB = this.f17004b.b(fqName);
        return (interfaceC1892aB == null || (cVar = (S5.c) this.f17006d.invoke(interfaceC1892aB)) == null) ? C1228d.f13193a.a(fqName, this.f17004b, this.f17003a) : cVar;
    }

    @Override // S5.h
    public boolean isEmpty() {
        return this.f17004b.getAnnotations().isEmpty() && !this.f17004b.i();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return r.w(r.F(r.B(z.P(this.f17004b.getAnnotations()), this.f17006d), C1228d.f13193a.a(o.a.f6210y, this.f17004b, this.f17003a))).iterator();
    }

    @Override // S5.h
    public boolean r(q6.c cVar) {
        return h.b.b(this, cVar);
    }

    public /* synthetic */ g(k kVar, InterfaceC1895d interfaceC1895d, boolean z7, int i8, AbstractC2296k abstractC2296k) {
        this(kVar, interfaceC1895d, (i8 & 4) != 0 ? false : z7);
    }
}
