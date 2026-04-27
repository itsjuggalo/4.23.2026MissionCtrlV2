package x0;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.AbstractC1753A;

/* JADX INFO: renamed from: x0.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1922k implements Comparable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f15722f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C1922k f15723g = new C1922k(0, 0, 0, "");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C1922k f15724h = new C1922k(0, 1, 0, "");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C1922k f15725i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C1922k f15726j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final W2.j f15731e;

    /* JADX INFO: renamed from: x0.k$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final C1922k a() {
            return C1922k.f15724h;
        }

        public final C1922k b(String str) {
            String strGroup;
            if (str != null && !AbstractC1753A.U(str)) {
                Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                if (matcher.matches() && (strGroup = matcher.group(1)) != null) {
                    int i4 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    if (strGroup2 != null) {
                        int i5 = Integer.parseInt(strGroup2);
                        String strGroup3 = matcher.group(3);
                        if (strGroup3 != null) {
                            int i6 = Integer.parseInt(strGroup3);
                            String description = matcher.group(4) != null ? matcher.group(4) : "";
                            r.e(description, "description");
                            return new C1922k(i4, i5, i6, description, null);
                        }
                    }
                }
            }
            return null;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: x0.k$b */
    public static final class b extends s implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BigInteger invoke() {
            return BigInteger.valueOf(C1922k.this.h()).shiftLeft(32).or(BigInteger.valueOf(C1922k.this.i())).shiftLeft(32).or(BigInteger.valueOf(C1922k.this.k()));
        }
    }

    static {
        C1922k c1922k = new C1922k(1, 0, 0, "");
        f15725i = c1922k;
        f15726j = c1922k;
    }

    public /* synthetic */ C1922k(int i4, int i5, int i6, String str, AbstractC1585j abstractC1585j) {
        this(i4, i5, i6, str);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1922k other) {
        r.f(other, "other");
        return g().compareTo(other.g());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1922k)) {
            return false;
        }
        C1922k c1922k = (C1922k) obj;
        return this.f15727a == c1922k.f15727a && this.f15728b == c1922k.f15728b && this.f15729c == c1922k.f15729c;
    }

    public final BigInteger g() {
        Object value = this.f15731e.getValue();
        r.e(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public final int h() {
        return this.f15727a;
    }

    public int hashCode() {
        return ((((527 + this.f15727a) * 31) + this.f15728b) * 31) + this.f15729c;
    }

    public final int i() {
        return this.f15728b;
    }

    public final int k() {
        return this.f15729c;
    }

    public String toString() {
        String str;
        if (AbstractC1753A.U(this.f15730d)) {
            str = "";
        } else {
            str = '-' + this.f15730d;
        }
        return this.f15727a + com.amazon.a.a.o.c.a.b.f8816a + this.f15728b + com.amazon.a.a.o.c.a.b.f8816a + this.f15729c + str;
    }

    public C1922k(int i4, int i5, int i6, String str) {
        this.f15727a = i4;
        this.f15728b = i5;
        this.f15729c = i6;
        this.f15730d = str;
        this.f15731e = W2.k.b(new b());
    }
}
