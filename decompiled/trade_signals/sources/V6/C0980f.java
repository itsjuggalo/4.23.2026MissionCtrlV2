package V6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: V6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0980f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f8976d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0980f f8977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0980f f8978f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f8980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f8981c;

    /* JADX INFO: renamed from: V6.f$a */
    public static final class a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final C0144a f8982j = new C0144a(null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f8983k = new a(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f8987d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f8988e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f8989f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f8990g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f8991h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f8992i;

        /* JADX INFO: renamed from: V6.f$a$a, reason: collision with other inner class name */
        public static final class C0144a {
            public C0144a() {
            }

            public final a a() {
                return a.f8983k;
            }

            public /* synthetic */ C0144a(AbstractC2296k abstractC2296k) {
                this();
            }
        }

        public a(int i8, int i9, String groupSeparator, String byteSeparator, String bytePrefix, String byteSuffix) {
            AbstractC2304t.f(groupSeparator, "groupSeparator");
            AbstractC2304t.f(byteSeparator, "byteSeparator");
            AbstractC2304t.f(bytePrefix, "bytePrefix");
            AbstractC2304t.f(byteSuffix, "byteSuffix");
            this.f8984a = i8;
            this.f8985b = i9;
            this.f8986c = groupSeparator;
            this.f8987d = byteSeparator;
            this.f8988e = bytePrefix;
            this.f8989f = byteSuffix;
            this.f8990g = i8 == Integer.MAX_VALUE && i9 == Integer.MAX_VALUE;
            this.f8991h = bytePrefix.length() == 0 && byteSuffix.length() == 0 && byteSeparator.length() <= 1;
            this.f8992i = AbstractC0981g.b(groupSeparator) || AbstractC0981g.b(byteSeparator) || AbstractC0981g.b(bytePrefix) || AbstractC0981g.b(byteSuffix);
        }

        public final StringBuilder b(StringBuilder sb, String indent) {
            AbstractC2304t.f(sb, "sb");
            AbstractC2304t.f(indent, "indent");
            sb.append(indent);
            sb.append("bytesPerLine = ");
            sb.append(this.f8984a);
            sb.append(com.amazon.a.a.o.b.f.f14100a);
            sb.append('\n');
            sb.append(indent);
            sb.append("bytesPerGroup = ");
            sb.append(this.f8985b);
            sb.append(com.amazon.a.a.o.b.f.f14100a);
            sb.append('\n');
            sb.append(indent);
            sb.append("groupSeparator = \"");
            sb.append(this.f8986c);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSeparator = \"");
            sb.append(this.f8987d);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytePrefix = \"");
            sb.append(this.f8988e);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSuffix = \"");
            sb.append(this.f8989f);
            sb.append("\"");
            return sb;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: V6.f$b */
    public static final class b {
        public b() {
        }

        public final C0980f a() {
            return C0980f.f8977e;
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: V6.f$c */
    public static final class c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f8993h = new a(null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f8994i = new c("", "", false, 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f8997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f8998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f8999e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f9000f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f9001g;

        /* JADX INFO: renamed from: V6.f$c$a */
        public static final class a {
            public a() {
            }

            public final c a() {
                return c.f8994i;
            }

            public /* synthetic */ a(AbstractC2296k abstractC2296k) {
                this();
            }
        }

        public c(String prefix, String suffix, boolean z7, int i8) {
            AbstractC2304t.f(prefix, "prefix");
            AbstractC2304t.f(suffix, "suffix");
            this.f8995a = prefix;
            this.f8996b = suffix;
            this.f8997c = z7;
            this.f8998d = i8;
            boolean z8 = prefix.length() == 0 && suffix.length() == 0;
            this.f8999e = z8;
            this.f9000f = z8 && i8 == 1;
            this.f9001g = AbstractC0981g.b(prefix) || AbstractC0981g.b(suffix);
        }

        public final StringBuilder b(StringBuilder sb, String indent) {
            AbstractC2304t.f(sb, "sb");
            AbstractC2304t.f(indent, "indent");
            sb.append(indent);
            sb.append("prefix = \"");
            sb.append(this.f8995a);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("suffix = \"");
            sb.append(this.f8996b);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("removeLeadingZeros = ");
            sb.append(this.f8997c);
            sb.append(',');
            sb.append('\n');
            sb.append(indent);
            sb.append("minLength = ");
            sb.append(this.f8998d);
            return sb;
        }

        public final boolean c() {
            return this.f9001g;
        }

        public final String d() {
            return this.f8995a;
        }

        public final String e() {
            return this.f8996b;
        }

        public final boolean f() {
            return this.f8999e;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    static {
        a.C0144a c0144a = a.f8982j;
        a aVarA = c0144a.a();
        c.a aVar = c.f8993h;
        f8977e = new C0980f(false, aVarA, aVar.a());
        f8978f = new C0980f(true, c0144a.a(), aVar.a());
    }

    public C0980f(boolean z7, a bytes, c number) {
        AbstractC2304t.f(bytes, "bytes");
        AbstractC2304t.f(number, "number");
        this.f8979a = z7;
        this.f8980b = bytes;
        this.f8981c = number;
    }

    public final c b() {
        return this.f8981c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(");
        sb.append('\n');
        sb.append("    upperCase = ");
        sb.append(this.f8979a);
        sb.append(com.amazon.a.a.o.b.f.f14100a);
        sb.append('\n');
        sb.append("    bytes = BytesHexFormat(");
        sb.append('\n');
        this.f8980b.b(sb, "        ").append('\n');
        sb.append("    ),");
        sb.append('\n');
        sb.append("    number = NumberHexFormat(");
        sb.append('\n');
        this.f8981c.b(sb, "        ").append('\n');
        sb.append("    )");
        sb.append('\n');
        sb.append(")");
        return sb.toString();
    }
}
