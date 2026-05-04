package t2;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kg.c0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Comparable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f20667f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f20668g = new l(0, 0, 0, "");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f20669h = new l(0, 1, 0, "");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l f20670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l f20671j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cd.k f20676e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final l a() {
            return l.f20669h;
        }

        public final l b(String str) {
            String strGroup;
            if (str != null && !c0.e0(str)) {
                Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                if (matcher.matches() && (strGroup = matcher.group(1)) != null) {
                    int i10 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    if (strGroup2 != null) {
                        int i11 = Integer.parseInt(strGroup2);
                        String strGroup3 = matcher.group(3);
                        if (strGroup3 != null) {
                            int i12 = Integer.parseInt(strGroup3);
                            String strGroup4 = matcher.group(4) != null ? matcher.group(4) : "";
                            t.c(strGroup4);
                            return new l(i10, i11, i12, strGroup4, null);
                        }
                    }
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        l lVar = new l(1, 0, 0, "");
        f20670i = lVar;
        f20671j = lVar;
    }

    public /* synthetic */ l(int i10, int i11, int i12, String str, kotlin.jvm.internal.k kVar) {
        this(i10, i11, i12, str);
    }

    public static final BigInteger c(l lVar) {
        return BigInteger.valueOf(lVar.f20672a).shiftLeft(32).or(BigInteger.valueOf(lVar.f20673b)).shiftLeft(32).or(BigInteger.valueOf(lVar.f20674c));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f20672a == lVar.f20672a && this.f20673b == lVar.f20673b && this.f20674c == lVar.f20674c;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(l other) {
        t.f(other, "other");
        return i().compareTo(other.i());
    }

    public int hashCode() {
        return ((((527 + this.f20672a) * 31) + this.f20673b) * 31) + this.f20674c;
    }

    public final BigInteger i() {
        Object value = this.f20676e.getValue();
        t.e(value, "getValue(...)");
        return (BigInteger) value;
    }

    public String toString() {
        String str;
        if (c0.e0(this.f20675d)) {
            str = "";
        } else {
            str = '-' + this.f20675d;
        }
        return this.f20672a + com.amazon.a.a.o.c.a.b.f4610a + this.f20673b + com.amazon.a.a.o.c.a.b.f4610a + this.f20674c + str;
    }

    public l(int i10, int i11, int i12, String str) {
        this.f20672a = i10;
        this.f20673b = i11;
        this.f20674c = i12;
        this.f20675d = str;
        this.f20676e = cd.l.b(new Function0() { // from class: t2.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return l.c(this.f20666a);
            }
        });
    }
}
