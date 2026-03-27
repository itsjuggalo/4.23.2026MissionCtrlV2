package w6;

import I6.AbstractC0613d0;
import I6.D0;
import I6.F0;
import I6.N0;
import I6.S;
import I6.V;
import I6.r0;
import I6.v0;
import R5.H;
import R5.InterfaceC0851h;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2487o;
import o5.InterfaceC2483k;
import p5.AbstractC2594p;
import p5.AbstractC2595q;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements v0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f24086f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H f24088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f24089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0613d0 f24090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2483k f24091e;

    public static final class a {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: renamed from: w6.q$a$a, reason: collision with other inner class name */
        public static final class EnumC0426a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0426a f24092a = new EnumC0426a("COMMON_SUPER_TYPE", 0);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0426a f24093b = new EnumC0426a("INTERSECTION_TYPE", 1);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final /* synthetic */ EnumC0426a[] f24094c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final /* synthetic */ InterfaceC2874a f24095d;

            static {
                EnumC0426a[] enumC0426aArrA = a();
                f24094c = enumC0426aArrA;
                f24095d = AbstractC2875b.a(enumC0426aArrA);
            }

            public EnumC0426a(String str, int i8) {
            }

            public static final /* synthetic */ EnumC0426a[] a() {
                return new EnumC0426a[]{f24092a, f24093b};
            }

            public static EnumC0426a valueOf(String str) {
                return (EnumC0426a) Enum.valueOf(EnumC0426a.class, str);
            }

            public static EnumC0426a[] values() {
                return (EnumC0426a[]) f24094c.clone();
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f24096a;

            static {
                int[] iArr = new int[EnumC0426a.values().length];
                try {
                    iArr[EnumC0426a.f24092a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC0426a.f24093b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f24096a = iArr;
            }
        }

        public a() {
        }

        public final AbstractC0613d0 a(Collection collection, EnumC0426a enumC0426a) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                AbstractC0613d0 abstractC0613d0 = (AbstractC0613d0) it.next();
                next = q.f24086f.c((AbstractC0613d0) next, abstractC0613d0, enumC0426a);
            }
            return (AbstractC0613d0) next;
        }

        public final AbstractC0613d0 b(Collection types) {
            AbstractC2304t.f(types, "types");
            return a(types, EnumC0426a.f24093b);
        }

        public final AbstractC0613d0 c(AbstractC0613d0 abstractC0613d0, AbstractC0613d0 abstractC0613d02, EnumC0426a enumC0426a) {
            if (abstractC0613d0 == null || abstractC0613d02 == null) {
                return null;
            }
            v0 v0VarO0 = abstractC0613d0.O0();
            v0 v0VarO02 = abstractC0613d02.O0();
            boolean z7 = v0VarO0 instanceof q;
            if (z7 && (v0VarO02 instanceof q)) {
                return e((q) v0VarO0, (q) v0VarO02, enumC0426a);
            }
            if (z7) {
                return d((q) v0VarO0, abstractC0613d02);
            }
            if (v0VarO02 instanceof q) {
                return d((q) v0VarO02, abstractC0613d0);
            }
            return null;
        }

        public final AbstractC0613d0 d(q qVar, AbstractC0613d0 abstractC0613d0) {
            if (qVar.g().contains(abstractC0613d0)) {
                return abstractC0613d0;
            }
            return null;
        }

        public final AbstractC0613d0 e(q qVar, q qVar2, EnumC0426a enumC0426a) {
            Set setD0;
            int i8 = b.f24096a[enumC0426a.ordinal()];
            if (i8 == 1) {
                setD0 = p5.z.d0(qVar.g(), qVar2.g());
            } else {
                if (i8 != 2) {
                    throw new C2487o();
                }
                setD0 = p5.z.L0(qVar.g(), qVar2.g());
            }
            return V.f(r0.f4460b.k(), new q(qVar.f24087a, qVar.f24088b, setD0, null), false);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public q(long j8, H h8, Set set) {
        this.f24090d = V.f(r0.f4460b.k(), this, false);
        this.f24091e = AbstractC2484l.a(new o(this));
        this.f24087a = j8;
        this.f24088b = h8;
        this.f24089c = set;
    }

    private final List h() {
        return (List) this.f24091e.getValue();
    }

    public static final List j(q qVar) {
        AbstractC0613d0 abstractC0613d0T = qVar.q().y().t();
        AbstractC2304t.e(abstractC0613d0T, "getDefaultType(...)");
        List listO = AbstractC2595q.o(F0.f(abstractC0613d0T, AbstractC2594p.e(new D0(N0.f4371f, qVar.f24090d)), null, 2, null));
        if (!qVar.i()) {
            listO.add(qVar.q().M());
        }
        return listO;
    }

    public static final CharSequence l(S it) {
        AbstractC2304t.f(it, "it");
        return it.toString();
    }

    @Override // I6.v0
    public v0 a(J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public final Set g() {
        return this.f24089c;
    }

    @Override // I6.v0
    public List getParameters() {
        return AbstractC2595q.i();
    }

    public final boolean i() {
        Collection collectionA = v.a(this.f24088b);
        if ((collectionA instanceof Collection) && collectionA.isEmpty()) {
            return true;
        }
        Iterator it = collectionA.iterator();
        while (it.hasNext()) {
            if (!(!this.f24089c.contains((S) it.next()))) {
                return false;
            }
        }
        return true;
    }

    public final String k() {
        return '[' + p5.z.h0(this.f24089c, com.amazon.a.a.o.b.f.f14100a, null, null, 0, null, p.f24085a, 30, null) + ']';
    }

    @Override // I6.v0
    public O5.i q() {
        return this.f24088b.q();
    }

    @Override // I6.v0
    public Collection r() {
        return h();
    }

    @Override // I6.v0
    public InterfaceC0851h s() {
        return null;
    }

    @Override // I6.v0
    public boolean t() {
        return false;
    }

    public String toString() {
        return "IntegerLiteralType" + k();
    }

    public /* synthetic */ q(long j8, H h8, Set set, AbstractC2296k abstractC2296k) {
        this(j8, h8, set);
    }
}
