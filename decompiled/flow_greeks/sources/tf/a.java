package tf;

import gf.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tf.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sf.a f21928a;

    /* JADX INFO: renamed from: tf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class C0377a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21929a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.PROPERTY_GETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.PROPERTY_SETTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f21929a = iArr;
        }
    }

    public a(sf.a protocol) {
        kotlin.jvm.internal.t.f(protocol, "protocol");
        this.f21928a = protocol;
    }

    @Override // tf.h
    public List a(n0 container, gf.p callableProto, d kind, int i10, ze.u proto) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(callableProto, "callableProto");
        kotlin.jvm.internal.t.f(kind, "kind");
        kotlin.jvm.internal.t.f(proto, "proto");
        List listK = (List) proto.t(this.f21928a.h());
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listK, 10));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ze.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // tf.h
    public List b(ze.s proto, bf.c nameResolver) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        List listK = (List) proto.t(this.f21928a.p());
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listK, 10));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ze.b) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // tf.h
    public List c(n0 container, ze.g proto) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        List listK = (List) proto.t(this.f21928a.d());
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listK, 10));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ze.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // tf.h
    public List d(n0 container, gf.p proto, d kind) {
        List listK;
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(kind, "kind");
        if (proto instanceof ze.d) {
            listK = (List) ((ze.d) proto).t(this.f21928a.c());
        } else if (proto instanceof ze.i) {
            listK = (List) ((ze.i) proto).t(this.f21928a.f());
        } else {
            if (!(proto instanceof ze.n)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i10 = C0377a.f21929a[kind.ordinal()];
            if (i10 == 1) {
                listK = (List) ((ze.n) proto).t(this.f21928a.i());
            } else if (i10 == 2) {
                listK = (List) ((ze.n) proto).t(this.f21928a.m());
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto");
                }
                listK = (List) ((ze.n) proto).t(this.f21928a.n());
            }
        }
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listK, 10));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ze.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // tf.h
    public List e(n0.a container) {
        kotlin.jvm.internal.t.f(container, "container");
        List listK = (List) container.f().t(this.f21928a.a());
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listK, 10));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ze.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // tf.h
    public List g(ze.q proto, bf.c nameResolver) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        List listK = (List) proto.t(this.f21928a.o());
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listK, 10));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ze.b) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // tf.h
    public List i(n0 container, ze.n proto) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        i.f fVarK = this.f21928a.k();
        List listK = fVarK != null ? (List) proto.t(fVarK) : null;
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listK, 10));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ze.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // tf.h
    public List k(n0 container, ze.n proto) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        i.f fVarJ = this.f21928a.j();
        List listK = fVarJ != null ? (List) proto.t(fVarJ) : null;
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listK, 10));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ze.b) it.next(), container.b()));
        }
        return arrayList;
    }

    @Override // tf.h
    public List l(n0 container, gf.p proto, d kind) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(kind, "kind");
        List listK = null;
        if (proto instanceof ze.i) {
            i.f fVarG = this.f21928a.g();
            if (fVarG != null) {
                listK = (List) ((ze.i) proto).t(fVarG);
            }
        } else {
            if (!(proto instanceof ze.n)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i10 = C0377a.f21929a[kind.ordinal()];
            if (i10 != 1 && i10 != 2 && i10 != 3) {
                throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + kind).toString());
            }
            i.f fVarL = this.f21928a.l();
            if (fVarL != null) {
                listK = (List) ((ze.n) proto).t(fVarL);
            }
        }
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listK, 10));
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(f((ze.b) it.next(), container.b()));
        }
        return arrayList;
    }

    public final sf.a m() {
        return this.f21928a;
    }
}
