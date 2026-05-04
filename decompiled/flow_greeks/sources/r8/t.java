package r8;

import r8.k;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class t extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19440c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19441a;

        static {
            int[] iArr = new int[n.b.values().length];
            f19441a = iArr;
            try {
                iArr[n.b.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19441a[n.b.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public t(String str, n nVar) {
        super(nVar);
        this.f19440c = str;
    }

    @Override // r8.n
    public String C(n.b bVar) {
        int i10 = a.f19441a[bVar.ordinal()];
        if (i10 == 1) {
            return u(bVar) + "string:" + this.f19440c;
        }
        if (i10 != 2) {
            throw new IllegalArgumentException("Invalid hash version for string node: " + bVar);
        }
        return u(bVar) + "string:" + m8.m.j(this.f19440c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f19440c.equals(tVar.f19440c) && this.f19419a.equals(tVar.f19419a);
    }

    @Override // r8.n
    public Object getValue() {
        return this.f19440c;
    }

    public int hashCode() {
        return this.f19440c.hashCode() + this.f19419a.hashCode();
    }

    @Override // r8.k
    public k.b s() {
        return k.b.String;
    }

    @Override // r8.k
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public int a(t tVar) {
        return this.f19440c.compareTo(tVar.f19440c);
    }

    @Override // r8.n
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public t D(n nVar) {
        return new t(this.f19440c, nVar);
    }
}
