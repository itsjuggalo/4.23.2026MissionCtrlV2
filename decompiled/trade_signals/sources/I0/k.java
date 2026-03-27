package I0;

import V6.C;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Comparable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f4052f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f4053g = new k(0, 0, 0, "");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f4054h = new k(0, 1, 0, "");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f4055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f4056j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2483k f4061e;

    public static final class a {
        public a() {
        }

        public final k a() {
            return k.f4054h;
        }

        public final k b(String str) {
            String strGroup;
            if (str != null && !C.a0(str)) {
                Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                if (matcher.matches() && (strGroup = matcher.group(1)) != null) {
                    int i8 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    if (strGroup2 != null) {
                        int i9 = Integer.parseInt(strGroup2);
                        String strGroup3 = matcher.group(3);
                        if (strGroup3 != null) {
                            int i10 = Integer.parseInt(strGroup3);
                            String strGroup4 = matcher.group(4) != null ? matcher.group(4) : "";
                            AbstractC2304t.c(strGroup4);
                            return new k(i8, i9, i10, strGroup4, null);
                        }
                    }
                }
            }
            return null;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class b extends AbstractC2306v implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BigInteger invoke() {
            return BigInteger.valueOf(k.this.i()).shiftLeft(32).or(BigInteger.valueOf(k.this.k())).shiftLeft(32).or(BigInteger.valueOf(k.this.l()));
        }
    }

    static {
        k kVar = new k(1, 0, 0, "");
        f4055i = kVar;
        f4056j = kVar;
    }

    public k(int i8, int i9, int i10, String str) {
        this.f4057a = i8;
        this.f4058b = i9;
        this.f4059c = i10;
        this.f4060d = str;
        this.f4061e = AbstractC2484l.a(new b());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(k other) {
        AbstractC2304t.f(other, "other");
        return g().compareTo(other.g());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f4057a == kVar.f4057a && this.f4058b == kVar.f4058b && this.f4059c == kVar.f4059c;
    }

    public final BigInteger g() {
        Object value = this.f4061e.getValue();
        AbstractC2304t.e(value, "getValue(...)");
        return (BigInteger) value;
    }

    public int hashCode() {
        return ((((527 + this.f4057a) * 31) + this.f4058b) * 31) + this.f4059c;
    }

    public final int i() {
        return this.f4057a;
    }

    public final int k() {
        return this.f4058b;
    }

    public final int l() {
        return this.f4059c;
    }

    public String toString() {
        String str;
        if (!C.a0(this.f4060d)) {
            str = '-' + this.f4060d;
        } else {
            str = "";
        }
        return this.f4057a + com.amazon.a.a.o.c.a.b.f14112a + this.f4058b + com.amazon.a.a.o.c.a.b.f14112a + this.f4059c + str;
    }

    public /* synthetic */ k(int i8, int i9, int i10, String str, AbstractC2296k abstractC2296k) {
        this(i8, i9, i10, str);
    }
}
