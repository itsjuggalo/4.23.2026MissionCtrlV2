package u7;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class M implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f23583b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f23584c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2814g f23585a;

    public static final class a {
        public a() {
        }

        public static /* synthetic */ M d(a aVar, File file, boolean z7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            return aVar.a(file, z7);
        }

        public static /* synthetic */ M e(a aVar, String str, boolean z7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            return aVar.b(str, z7);
        }

        public static /* synthetic */ M f(a aVar, Path path, boolean z7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            return aVar.c(path, z7);
        }

        public final M a(File file, boolean z7) {
            AbstractC2304t.f(file, "<this>");
            String string = file.toString();
            AbstractC2304t.e(string, "toString()");
            return b(string, z7);
        }

        public final M b(String str, boolean z7) {
            AbstractC2304t.f(str, "<this>");
            return v7.d.k(str, z7);
        }

        public final M c(Path path, boolean z7) {
            AbstractC2304t.f(path, "<this>");
            return b(path.toString(), z7);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        String separator = File.separator;
        AbstractC2304t.e(separator, "separator");
        f23584c = separator;
    }

    public M(C2814g bytes) {
        AbstractC2304t.f(bytes, "bytes");
        this.f23585a = bytes;
    }

    public final File B() {
        return new File(toString());
    }

    public final Path H() {
        Path path = Paths.get(toString(), new String[0]);
        AbstractC2304t.e(path, "get(toString())");
        return path;
    }

    public final Character I() {
        if (C2814g.B(b(), v7.d.f23909a, 0, 2, null) != -1 || b().R() < 2 || b().k(1) != 58) {
            return null;
        }
        char cK = (char) b().k(0);
        if (('a' > cK || cK >= '{') && ('A' > cK || cK >= '[')) {
            return null;
        }
        return Character.valueOf(cK);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(M other) {
        AbstractC2304t.f(other, "other");
        return b().compareTo(other.b());
    }

    public final C2814g b() {
        return this.f23585a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof M) && AbstractC2304t.b(((M) obj).b(), b());
    }

    public final M g() {
        int iO = v7.d.o(this);
        if (iO == -1) {
            return null;
        }
        return new M(b().T(0, iO));
    }

    public int hashCode() {
        return b().hashCode();
    }

    public final List i() {
        ArrayList arrayList = new ArrayList();
        int iO = v7.d.o(this);
        if (iO == -1) {
            iO = 0;
        } else if (iO < b().R() && b().k(iO) == 92) {
            iO++;
        }
        int iR = b().R();
        int i8 = iO;
        while (iO < iR) {
            if (b().k(iO) == 47 || b().k(iO) == 92) {
                arrayList.add(b().T(i8, iO));
                i8 = iO + 1;
            }
            iO++;
        }
        if (i8 < b().R()) {
            arrayList.add(b().T(i8, b().R()));
        }
        return arrayList;
    }

    public final boolean k() {
        return v7.d.o(this) != -1;
    }

    public final String l() {
        return m().X();
    }

    public final C2814g m() {
        int iL = v7.d.l(this);
        return iL != -1 ? C2814g.U(b(), iL + 1, 0, 2, null) : (I() == null || b().R() != 2) ? b() : C2814g.f23649e;
    }

    public final M n() {
        return f23583b.b(toString(), true);
    }

    public final M q() {
        M m8;
        if (AbstractC2304t.b(b(), v7.d.f23912d) || AbstractC2304t.b(b(), v7.d.f23909a) || AbstractC2304t.b(b(), v7.d.f23910b) || v7.d.n(this)) {
            return null;
        }
        int iL = v7.d.l(this);
        if (iL != 2 || I() == null) {
            if (iL == 1 && b().S(v7.d.f23910b)) {
                return null;
            }
            if (iL != -1 || I() == null) {
                if (iL == -1) {
                    return new M(v7.d.f23912d);
                }
                if (iL != 0) {
                    return new M(C2814g.U(b(), 0, iL, 1, null));
                }
                m8 = new M(C2814g.U(b(), 0, 1, 1, null));
            } else {
                if (b().R() == 2) {
                    return null;
                }
                m8 = new M(C2814g.U(b(), 0, 2, 1, null));
            }
        } else {
            if (b().R() == 3) {
                return null;
            }
            m8 = new M(C2814g.U(b(), 0, 3, 1, null));
        }
        return m8;
    }

    public final M r(M other) {
        AbstractC2304t.f(other, "other");
        if (!AbstractC2304t.b(g(), other.g())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List listI = i();
        List listI2 = other.i();
        int iMin = Math.min(listI.size(), listI2.size());
        int i8 = 0;
        while (i8 < iMin && AbstractC2304t.b(listI.get(i8), listI2.get(i8))) {
            i8++;
        }
        if (i8 == iMin && b().R() == other.b().R()) {
            return a.e(f23583b, ".", false, 1, null);
        }
        if (listI2.subList(i8, listI2.size()).indexOf(v7.d.f23913e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        C2811d c2811d = new C2811d();
        C2814g c2814gM = v7.d.m(other);
        if (c2814gM == null && (c2814gM = v7.d.m(this)) == null) {
            c2814gM = v7.d.s(f23584c);
        }
        int size = listI2.size();
        for (int i9 = i8; i9 < size; i9++) {
            c2811d.y0(v7.d.f23913e);
            c2811d.y0(c2814gM);
        }
        int size2 = listI.size();
        while (i8 < size2) {
            c2811d.y0((C2814g) listI.get(i8));
            c2811d.y0(c2814gM);
            i8++;
        }
        return v7.d.q(c2811d, false);
    }

    public final M t(String child) {
        AbstractC2304t.f(child, "child");
        return v7.d.j(this, v7.d.q(new C2811d().G(child), false), false);
    }

    public String toString() {
        return b().X();
    }

    public final M w(M child, boolean z7) {
        AbstractC2304t.f(child, "child");
        return v7.d.j(this, child, z7);
    }
}
