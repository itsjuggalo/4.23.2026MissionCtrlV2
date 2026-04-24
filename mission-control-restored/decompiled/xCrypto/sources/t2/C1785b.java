package t2;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import q2.w;
import q2.x;
import s2.AbstractC1772b;
import s2.InterfaceC1769B;
import s2.u;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: t2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1785b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f14751a;

    /* JADX INFO: renamed from: t2.b$a */
    public static final class a extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f14752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC1769B f14753b;

        public a(q2.e eVar, Type type, w wVar, InterfaceC1769B interfaceC1769B) {
            this.f14752a = new o(eVar, wVar, type);
            this.f14753b = interfaceC1769B;
        }

        @Override // q2.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection c(C1946a c1946a) throws IOException {
            if (c1946a.r0() == y2.b.NULL) {
                c1946a.n0();
                return null;
            }
            Collection collection = (Collection) this.f14753b.a();
            c1946a.f();
            while (c1946a.d0()) {
                collection.add(this.f14752a.c(c1946a));
            }
            c1946a.E();
            return collection;
        }

        @Override // q2.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(y2.c cVar, Collection collection) throws IOException {
            if (collection == null) {
                cVar.e0();
                return;
            }
            cVar.p();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                this.f14752a.e(cVar, it.next());
            }
            cVar.E();
        }
    }

    public C1785b(u uVar) {
        this.f14751a = uVar;
    }

    @Override // q2.x
    public w create(q2.e eVar, C1925a c1925a) {
        Type typeD = c1925a.d();
        Class clsC = c1925a.c();
        if (!Collection.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type typeH = AbstractC1772b.h(typeD, clsC);
        return new a(eVar, typeH, eVar.l(C1925a.b(typeH)), this.f14751a.t(c1925a));
    }
}
