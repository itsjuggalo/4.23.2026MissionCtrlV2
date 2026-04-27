package w6;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class Q implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f25040b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25041c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2795h f25042a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public static /* synthetic */ Q d(a aVar, File file, boolean z7, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                z7 = false;
            }
            return aVar.a(file, z7);
        }

        public static /* synthetic */ Q e(a aVar, String str, boolean z7, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                z7 = false;
            }
            return aVar.b(str, z7);
        }

        public static /* synthetic */ Q f(a aVar, Path path, boolean z7, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                z7 = false;
            }
            return aVar.c(path, z7);
        }

        public final Q a(File file, boolean z7) {
            kotlin.jvm.internal.r.f(file, "<this>");
            String string = file.toString();
            kotlin.jvm.internal.r.e(string, "toString()");
            return b(string, z7);
        }

        public final Q b(String str, boolean z7) {
            kotlin.jvm.internal.r.f(str, "<this>");
            return x6.d.k(str, z7);
        }

        public final Q c(Path path, boolean z7) {
            kotlin.jvm.internal.r.f(path, "<this>");
            return b(path.toString(), z7);
        }

        public a() {
        }
    }

    static {
        String separator = File.separator;
        kotlin.jvm.internal.r.e(separator, "separator");
        f25041c = separator;
    }

    public Q(C2795h bytes) {
        kotlin.jvm.internal.r.f(bytes, "bytes");
        this.f25042a = bytes;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Q other) {
        kotlin.jvm.internal.r.f(other, "other");
        return b().compareTo(other.b());
    }

    public final C2795h b() {
        return this.f25042a;
    }

    public final Q c() {
        int iO = x6.d.o(this);
        if (iO == -1) {
            return null;
        }
        return new Q(b().J(0, iO));
    }

    public boolean equals(Object obj) {
        return (obj instanceof Q) && kotlin.jvm.internal.r.b(((Q) obj).b(), b());
    }

    public final List h() {
        ArrayList arrayList = new ArrayList();
        int iO = x6.d.o(this);
        if (iO == -1) {
            iO = 0;
        } else if (iO < b().H() && b().l(iO) == 92) {
            iO++;
        }
        int iH = b().H();
        int i7 = iO;
        while (iO < iH) {
            if (b().l(iO) == 47 || b().l(iO) == 92) {
                arrayList.add(b().J(i7, iO));
                i7 = iO + 1;
            }
            iO++;
        }
        if (i7 < b().H()) {
            arrayList.add(b().J(i7, b().H()));
        }
        return arrayList;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public final boolean i() {
        return x6.d.o(this) != -1;
    }

    public final String j() {
        return k().N();
    }

    public final C2795h k() {
        int iL = x6.d.l(this);
        return iL != -1 ? C2795h.K(b(), iL + 1, 0, 2, null) : (s() == null || b().H() != 2) ? b() : C2795h.f25107e;
    }

    public final Q l() {
        return f25040b.b(toString(), true);
    }

    public final Q m() {
        Q q7;
        if (kotlin.jvm.internal.r.b(b(), x6.d.f25330d) || kotlin.jvm.internal.r.b(b(), x6.d.f25327a) || kotlin.jvm.internal.r.b(b(), x6.d.f25328b) || x6.d.n(this)) {
            return null;
        }
        int iL = x6.d.l(this);
        if (iL != 2 || s() == null) {
            if (iL == 1 && b().I(x6.d.f25328b)) {
                return null;
            }
            if (iL != -1 || s() == null) {
                if (iL == -1) {
                    return new Q(x6.d.f25330d);
                }
                if (iL != 0) {
                    return new Q(C2795h.K(b(), 0, iL, 1, null));
                }
                q7 = new Q(C2795h.K(b(), 0, 1, 1, null));
            } else {
                if (b().H() == 2) {
                    return null;
                }
                q7 = new Q(C2795h.K(b(), 0, 2, 1, null));
            }
        } else {
            if (b().H() == 3) {
                return null;
            }
            q7 = new Q(C2795h.K(b(), 0, 3, 1, null));
        }
        return q7;
    }

    public final Q n(Q other) {
        kotlin.jvm.internal.r.f(other, "other");
        if (!kotlin.jvm.internal.r.b(c(), other.c())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List listH = h();
        List listH2 = other.h();
        int iMin = Math.min(listH.size(), listH2.size());
        int i7 = 0;
        while (i7 < iMin && kotlin.jvm.internal.r.b(listH.get(i7), listH2.get(i7))) {
            i7++;
        }
        if (i7 == iMin && b().H() == other.b().H()) {
            return a.e(f25040b, ".", false, 1, null);
        }
        if (listH2.subList(i7, listH2.size()).indexOf(x6.d.f25331e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        C2792e c2792e = new C2792e();
        C2795h c2795hM = x6.d.m(other);
        if (c2795hM == null && (c2795hM = x6.d.m(this)) == null) {
            c2795hM = x6.d.s(f25041c);
        }
        int size = listH2.size();
        for (int i8 = i7; i8 < size; i8++) {
            c2792e.m(x6.d.f25331e);
            c2792e.m(c2795hM);
        }
        int size2 = listH.size();
        while (i7 < size2) {
            c2792e.m((C2795h) listH.get(i7));
            c2792e.m(c2795hM);
            i7++;
        }
        return x6.d.q(c2792e, false);
    }

    public final Q o(String child) {
        kotlin.jvm.internal.r.f(child, "child");
        return x6.d.j(this, x6.d.q(new C2792e().I(child), false), false);
    }

    public final Q p(Q child, boolean z7) {
        kotlin.jvm.internal.r.f(child, "child");
        return x6.d.j(this, child, z7);
    }

    public final File q() {
        return new File(toString());
    }

    public final Path r() {
        Path path = Paths.get(toString(), new String[0]);
        kotlin.jvm.internal.r.e(path, "get(toString())");
        return path;
    }

    public final Character s() {
        if (C2795h.t(b(), x6.d.f25327a, 0, 2, null) != -1 || b().H() < 2 || b().l(1) != 58) {
            return null;
        }
        char cL = (char) b().l(0);
        if (('a' > cL || cL >= '{') && ('A' > cL || cL >= '[')) {
            return null;
        }
        return Character.valueOf(cL);
    }

    public String toString() {
        return b().N();
    }
}
