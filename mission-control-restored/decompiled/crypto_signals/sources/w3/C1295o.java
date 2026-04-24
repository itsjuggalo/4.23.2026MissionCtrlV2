package w3;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: w3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1295o extends B3.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final C1294n f10793x = new C1294n();
    public static final Object y = new Object();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Object[] f10794t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10795u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String[] f10796v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f10797w;

    @Override // B3.a
    public final int B() {
        if (this.f10795u == 0) {
            return 10;
        }
        Object objO = O();
        if (objO instanceof Iterator) {
            boolean z6 = this.f10794t[this.f10795u - 2] instanceof t3.k;
            Iterator it = (Iterator) objO;
            if (!it.hasNext()) {
                return z6 ? 4 : 2;
            }
            if (z6) {
                return 5;
            }
            Q(it.next());
            return B();
        }
        if (objO instanceof t3.k) {
            return 3;
        }
        if (objO instanceof t3.f) {
            return 1;
        }
        if (objO instanceof t3.l) {
            Serializable serializable = ((t3.l) objO).f10249a;
            if (serializable instanceof String) {
                return 6;
            }
            if (serializable instanceof Boolean) {
                return 8;
            }
            if (serializable instanceof Number) {
                return 7;
            }
            throw new AssertionError();
        }
        if (objO instanceof t3.j) {
            return 9;
        }
        if (objO == y) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new B3.c("Custom JsonElement subclass " + objO.getClass().getName() + " is not supported");
    }

    @Override // B3.a
    public final void H() {
        int iC = S.i.c(B());
        if (iC == 1) {
            i();
            return;
        }
        if (iC != 9) {
            if (iC == 3) {
                j();
                return;
            }
            if (iC == 4) {
                N(true);
                return;
            }
            P();
            int i = this.f10795u;
            if (i > 0) {
                int[] iArr = this.f10797w;
                int i6 = i - 1;
                iArr[i6] = iArr[i6] + 1;
            }
        }
    }

    public final void K(int i) {
        if (B() == i) {
            return;
        }
        throw new IllegalStateException("Expected " + k0.a.j(i) + " but was " + k0.a.j(B()) + M());
    }

    public final String L(boolean z6) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i6 = this.f10795u;
            if (i >= i6) {
                return sb.toString();
            }
            Object[] objArr = this.f10794t;
            Object obj = objArr[i];
            if (obj instanceof t3.f) {
                i++;
                if (i < i6 && (objArr[i] instanceof Iterator)) {
                    int i7 = this.f10797w[i];
                    if (z6 && i7 > 0 && (i == i6 - 1 || i == i6 - 2)) {
                        i7--;
                    }
                    sb.append('[');
                    sb.append(i7);
                    sb.append(']');
                }
            } else if ((obj instanceof t3.k) && (i = i + 1) < i6 && (objArr[i] instanceof Iterator)) {
                sb.append('.');
                String str = this.f10796v[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    public final String M() {
        return " at path " + L(false);
    }

    public final String N(boolean z6) {
        K(5);
        Map.Entry entry = (Map.Entry) ((Iterator) O()).next();
        String str = (String) entry.getKey();
        this.f10796v[this.f10795u - 1] = z6 ? "<skipped>" : str;
        Q(entry.getValue());
        return str;
    }

    public final Object O() {
        return this.f10794t[this.f10795u - 1];
    }

    public final Object P() {
        Object[] objArr = this.f10794t;
        int i = this.f10795u - 1;
        this.f10795u = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public final void Q(Object obj) {
        int i = this.f10795u;
        Object[] objArr = this.f10794t;
        if (i == objArr.length) {
            int i6 = i * 2;
            this.f10794t = Arrays.copyOf(objArr, i6);
            this.f10797w = Arrays.copyOf(this.f10797w, i6);
            this.f10796v = (String[]) Arrays.copyOf(this.f10796v, i6);
        }
        Object[] objArr2 = this.f10794t;
        int i7 = this.f10795u;
        this.f10795u = i7 + 1;
        objArr2[i7] = obj;
    }

    @Override // B3.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f10794t = new Object[]{y};
        this.f10795u = 1;
    }

    @Override // B3.a
    public final void d() {
        K(1);
        Q(((t3.f) O()).f10246a.iterator());
        this.f10797w[this.f10795u - 1] = 0;
    }

    @Override // B3.a
    public final void f() {
        K(3);
        Q(((v3.k) ((t3.k) O()).f10248a.entrySet()).iterator());
    }

    @Override // B3.a
    public final void i() {
        K(2);
        P();
        P();
        int i = this.f10795u;
        if (i > 0) {
            int[] iArr = this.f10797w;
            int i6 = i - 1;
            iArr[i6] = iArr[i6] + 1;
        }
    }

    @Override // B3.a
    public final void j() {
        K(4);
        this.f10796v[this.f10795u - 1] = null;
        P();
        P();
        int i = this.f10795u;
        if (i > 0) {
            int[] iArr = this.f10797w;
            int i6 = i - 1;
            iArr[i6] = iArr[i6] + 1;
        }
    }

    @Override // B3.a
    public final String l() {
        return L(false);
    }

    @Override // B3.a
    public final String n() {
        return L(true);
    }

    @Override // B3.a
    public final boolean o() {
        int iB = B();
        return (iB == 4 || iB == 2 || iB == 10) ? false : true;
    }

    @Override // B3.a
    public final boolean r() {
        K(8);
        boolean zA = ((t3.l) P()).a();
        int i = this.f10795u;
        if (i > 0) {
            int[] iArr = this.f10797w;
            int i6 = i - 1;
            iArr[i6] = iArr[i6] + 1;
        }
        return zA;
    }

    @Override // B3.a
    public final double s() throws B3.c {
        int iB = B();
        if (iB != 7 && iB != 6) {
            throw new IllegalStateException("Expected " + k0.a.j(7) + " but was " + k0.a.j(iB) + M());
        }
        double dH = ((t3.l) O()).h();
        if (this.f160s != 1 && (Double.isNaN(dH) || Double.isInfinite(dH))) {
            throw new B3.c("JSON forbids NaN and infinities: " + dH);
        }
        P();
        int i = this.f10795u;
        if (i > 0) {
            int[] iArr = this.f10797w;
            int i6 = i - 1;
            iArr[i6] = iArr[i6] + 1;
        }
        return dH;
    }

    @Override // B3.a
    public final int t() {
        int iB = B();
        if (iB != 7 && iB != 6) {
            throw new IllegalStateException("Expected " + k0.a.j(7) + " but was " + k0.a.j(iB) + M());
        }
        t3.l lVar = (t3.l) O();
        int iIntValue = lVar.f10249a instanceof Number ? lVar.k().intValue() : Integer.parseInt(lVar.c());
        P();
        int i = this.f10795u;
        if (i > 0) {
            int[] iArr = this.f10797w;
            int i6 = i - 1;
            iArr[i6] = iArr[i6] + 1;
        }
        return iIntValue;
    }

    @Override // B3.a
    public final String toString() {
        return C1295o.class.getSimpleName() + M();
    }

    @Override // B3.a
    public final long u() {
        int iB = B();
        if (iB != 7 && iB != 6) {
            throw new IllegalStateException("Expected " + k0.a.j(7) + " but was " + k0.a.j(iB) + M());
        }
        t3.l lVar = (t3.l) O();
        long jLongValue = lVar.f10249a instanceof Number ? lVar.k().longValue() : Long.parseLong(lVar.c());
        P();
        int i = this.f10795u;
        if (i > 0) {
            int[] iArr = this.f10797w;
            int i6 = i - 1;
            iArr[i6] = iArr[i6] + 1;
        }
        return jLongValue;
    }

    @Override // B3.a
    public final String v() {
        return N(false);
    }

    @Override // B3.a
    public final void x() {
        K(9);
        P();
        int i = this.f10795u;
        if (i > 0) {
            int[] iArr = this.f10797w;
            int i6 = i - 1;
            iArr[i6] = iArr[i6] + 1;
        }
    }

    @Override // B3.a
    public final String z() {
        int iB = B();
        if (iB != 6 && iB != 7) {
            throw new IllegalStateException("Expected " + k0.a.j(6) + " but was " + k0.a.j(iB) + M());
        }
        String strC = ((t3.l) P()).c();
        int i = this.f10795u;
        if (i > 0) {
            int[] iArr = this.f10797w;
            int i6 = i - 1;
            iArr[i6] = iArr[i6] + 1;
        }
        return strC;
    }
}
