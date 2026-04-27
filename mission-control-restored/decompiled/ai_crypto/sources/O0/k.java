package O0;

import Z5.u;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Comparable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f4037f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f4038g = new k(0, 0, 0, "");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f4039h = new k(0, 1, 0, "");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f4040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f4041j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E5.j f4046e;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final k a() {
            return k.f4039h;
        }

        public final k b(String str) {
            String strGroup;
            if (str != null && !u.P(str)) {
                Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                if (matcher.matches() && (strGroup = matcher.group(1)) != null) {
                    int i7 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    if (strGroup2 != null) {
                        int i8 = Integer.parseInt(strGroup2);
                        String strGroup3 = matcher.group(3);
                        if (strGroup3 != null) {
                            int i9 = Integer.parseInt(strGroup3);
                            String description = matcher.group(4) != null ? matcher.group(4) : "";
                            r.e(description, "description");
                            return new k(i7, i8, i9, description, null);
                        }
                    }
                }
            }
            return null;
        }

        public a() {
        }
    }

    public static final class b extends s implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BigInteger invoke() {
            return BigInteger.valueOf(k.this.h()).shiftLeft(32).or(BigInteger.valueOf(k.this.i())).shiftLeft(32).or(BigInteger.valueOf(k.this.j()));
        }
    }

    static {
        k kVar = new k(1, 0, 0, "");
        f4040i = kVar;
        f4041j = kVar;
    }

    public /* synthetic */ k(int i7, int i8, int i9, String str, AbstractC2148j abstractC2148j) {
        this(i7, i8, i9, str);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(k other) {
        r.f(other, "other");
        return c().compareTo(other.c());
    }

    public final BigInteger c() {
        Object value = this.f4046e.getValue();
        r.e(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f4042a == kVar.f4042a && this.f4043b == kVar.f4043b && this.f4044c == kVar.f4044c;
    }

    public final int h() {
        return this.f4042a;
    }

    public int hashCode() {
        return ((((527 + this.f4042a) * 31) + this.f4043b) * 31) + this.f4044c;
    }

    public final int i() {
        return this.f4043b;
    }

    public final int j() {
        return this.f4044c;
    }

    public String toString() {
        String str;
        if (u.P(this.f4045d)) {
            str = "";
        } else {
            str = '-' + this.f4045d;
        }
        return this.f4042a + com.amazon.a.a.o.c.a.b.f10001a + this.f4043b + com.amazon.a.a.o.c.a.b.f10001a + this.f4044c + str;
    }

    public k(int i7, int i8, int i9, String str) {
        this.f4042a = i7;
        this.f4043b = i8;
        this.f4044c = i9;
        this.f4045d = str;
        this.f4046e = E5.k.b(new b());
    }
}
