package p3;

import k3.AbstractC2279m;
import p3.AbstractC2557k;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: p3.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2566t extends AbstractC2557k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22317c;

    /* JADX INFO: renamed from: p3.t$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22318a;

        static {
            int[] iArr = new int[InterfaceC2560n.b.values().length];
            f22318a = iArr;
            try {
                iArr[InterfaceC2560n.b.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22318a[InterfaceC2560n.b.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C2566t(String str, InterfaceC2560n interfaceC2560n) {
        super(interfaceC2560n);
        this.f22317c = str;
    }

    @Override // p3.AbstractC2557k
    public AbstractC2557k.b I() {
        return AbstractC2557k.b.String;
    }

    @Override // p3.AbstractC2557k
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public int a(C2566t c2566t) {
        return this.f22317c.compareTo(c2566t.f22317c);
    }

    @Override // p3.InterfaceC2560n
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public C2566t c(InterfaceC2560n interfaceC2560n) {
        return new C2566t(this.f22317c, interfaceC2560n);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2566t)) {
            return false;
        }
        C2566t c2566t = (C2566t) obj;
        return this.f22317c.equals(c2566t.f22317c) && this.f22295a.equals(c2566t.f22295a);
    }

    @Override // p3.InterfaceC2560n
    public Object getValue() {
        return this.f22317c;
    }

    public int hashCode() {
        return this.f22317c.hashCode() + this.f22295a.hashCode();
    }

    @Override // p3.InterfaceC2560n
    public String v(InterfaceC2560n.b bVar) {
        StringBuilder sb;
        String strJ;
        int i8 = a.f22318a[bVar.ordinal()];
        if (i8 == 1) {
            sb = new StringBuilder();
            sb.append(J(bVar));
            sb.append("string:");
            strJ = this.f22317c;
        } else {
            if (i8 != 2) {
                throw new IllegalArgumentException("Invalid hash version for string node: " + bVar);
            }
            sb = new StringBuilder();
            sb.append(J(bVar));
            sb.append("string:");
            strJ = AbstractC2279m.j(this.f22317c);
        }
        sb.append(strJ);
        return sb.toString();
    }
}
