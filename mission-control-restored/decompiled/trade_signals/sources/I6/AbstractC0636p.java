package I6;

import R5.InterfaceC0851h;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2470H;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: I6.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0636p extends AbstractC0641v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H6.i f4453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4454c;

    /* JADX INFO: renamed from: I6.p$a */
    public final class a implements v0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final J6.g f4455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC2483k f4456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC0636p f4457c;

        public a(AbstractC0636p abstractC0636p, J6.g kotlinTypeRefiner) {
            AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f4457c = abstractC0636p;
            this.f4455a = kotlinTypeRefiner;
            this.f4456b = AbstractC2484l.b(EnumC2486n.f21975b, new C0634o(this, abstractC0636p));
        }

        public static final List f(a aVar, AbstractC0636p abstractC0636p) {
            return J6.h.b(aVar.f4455a, abstractC0636p.r());
        }

        @Override // I6.v0
        public v0 a(J6.g kotlinTypeRefiner) {
            AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.f4457c.a(kotlinTypeRefiner);
        }

        public final List d() {
            return (List) this.f4456b.getValue();
        }

        @Override // I6.v0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List r() {
            return d();
        }

        public boolean equals(Object obj) {
            return this.f4457c.equals(obj);
        }

        @Override // I6.v0
        public List getParameters() {
            List parameters = this.f4457c.getParameters();
            AbstractC2304t.e(parameters, "getParameters(...)");
            return parameters;
        }

        public int hashCode() {
            return this.f4457c.hashCode();
        }

        @Override // I6.v0
        public O5.i q() {
            O5.i iVarQ = this.f4457c.q();
            AbstractC2304t.e(iVarQ, "getBuiltIns(...)");
            return iVarQ;
        }

        @Override // I6.v0
        public InterfaceC0851h s() {
            return this.f4457c.s();
        }

        @Override // I6.v0
        public boolean t() {
            return this.f4457c.t();
        }

        public String toString() {
            return this.f4457c.toString();
        }
    }

    /* JADX INFO: renamed from: I6.p$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection f4458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f4459b;

        public b(Collection allSupertypes) {
            AbstractC2304t.f(allSupertypes, "allSupertypes");
            this.f4458a = allSupertypes;
            this.f4459b = AbstractC2594p.e(K6.l.f4913a.l());
        }

        public final Collection a() {
            return this.f4458a;
        }

        public final List b() {
            return this.f4459b;
        }

        public final void c(List list) {
            AbstractC2304t.f(list, "<set-?>");
            this.f4459b = list;
        }
    }

    public AbstractC0636p(H6.n storageManager) {
        AbstractC2304t.f(storageManager, "storageManager");
        this.f4453b = storageManager.i(new C0620h(this), C0622i.f4430a, new C0624j(this));
    }

    public static final b A(AbstractC0636p abstractC0636p) {
        return new b(abstractC0636p.n());
    }

    public static final b B(boolean z7) {
        return new b(AbstractC2594p.e(K6.l.f4913a.l()));
    }

    public static final C2470H C(AbstractC0636p abstractC0636p, b supertypes) {
        AbstractC2304t.f(supertypes, "supertypes");
        Collection collectionA = abstractC0636p.v().a(abstractC0636p, supertypes.a(), new C0626k(abstractC0636p), new C0628l(abstractC0636p));
        if (collectionA.isEmpty()) {
            S sO = abstractC0636p.o();
            collectionA = sO != null ? AbstractC2594p.e(sO) : null;
            if (collectionA == null) {
                collectionA = AbstractC2595q.i();
            }
        }
        if (abstractC0636p.u()) {
            abstractC0636p.v().a(abstractC0636p, collectionA, new C0630m(abstractC0636p), new C0632n(abstractC0636p));
        }
        List listG0 = collectionA instanceof List ? (List) collectionA : null;
        if (listG0 == null) {
            listG0 = p5.z.G0(collectionA);
        }
        supertypes.c(abstractC0636p.x(listG0));
        return C2470H.f21956a;
    }

    public static final Iterable D(AbstractC0636p abstractC0636p, v0 it) {
        AbstractC2304t.f(it, "it");
        return abstractC0636p.m(it, false);
    }

    public static final C2470H E(AbstractC0636p abstractC0636p, S it) {
        AbstractC2304t.f(it, "it");
        abstractC0636p.z(it);
        return C2470H.f21956a;
    }

    public static final Iterable F(AbstractC0636p abstractC0636p, v0 it) {
        AbstractC2304t.f(it, "it");
        return abstractC0636p.m(it, true);
    }

    public static final C2470H G(AbstractC0636p abstractC0636p, S it) {
        AbstractC2304t.f(it, "it");
        abstractC0636p.y(it);
        return C2470H.f21956a;
    }

    @Override // I6.v0
    public v0 a(J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this, kotlinTypeRefiner);
    }

    public final Collection m(v0 v0Var, boolean z7) {
        List listR0;
        AbstractC0636p abstractC0636p = v0Var instanceof AbstractC0636p ? (AbstractC0636p) v0Var : null;
        if (abstractC0636p != null && (listR0 = p5.z.r0(((b) abstractC0636p.f4453b.invoke()).a(), abstractC0636p.p(z7))) != null) {
            return listR0;
        }
        Collection collectionR = v0Var.r();
        AbstractC2304t.e(collectionR, "getSupertypes(...)");
        return collectionR;
    }

    public abstract Collection n();

    public abstract S o();

    public Collection p(boolean z7) {
        return AbstractC2595q.i();
    }

    public boolean u() {
        return this.f4454c;
    }

    public abstract R5.k0 v();

    @Override // I6.v0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public List r() {
        return ((b) this.f4453b.invoke()).b();
    }

    public List x(List supertypes) {
        AbstractC2304t.f(supertypes, "supertypes");
        return supertypes;
    }

    public void y(S type) {
        AbstractC2304t.f(type, "type");
    }

    public void z(S type) {
        AbstractC2304t.f(type, "type");
    }
}
