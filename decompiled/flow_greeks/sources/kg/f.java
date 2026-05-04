package kg;

import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f14878d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f14879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f14880f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f14882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f14883c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final C0258a f14884j = new C0258a(null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f14885k = new a(a.e.API_PRIORITY_OTHER, a.e.API_PRIORITY_OTHER, "  ", "", "", "");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f14888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f14889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f14890e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f14891f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f14892g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f14893h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f14894i;

        /* JADX INFO: renamed from: kg.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0258a {
            public /* synthetic */ C0258a(kotlin.jvm.internal.k kVar) {
                this();
            }

            public final a a() {
                return a.f14885k;
            }

            public C0258a() {
            }
        }

        public a(int i10, int i11, String groupSeparator, String byteSeparator, String bytePrefix, String byteSuffix) {
            kotlin.jvm.internal.t.f(groupSeparator, "groupSeparator");
            kotlin.jvm.internal.t.f(byteSeparator, "byteSeparator");
            kotlin.jvm.internal.t.f(bytePrefix, "bytePrefix");
            kotlin.jvm.internal.t.f(byteSuffix, "byteSuffix");
            this.f14886a = i10;
            this.f14887b = i11;
            this.f14888c = groupSeparator;
            this.f14889d = byteSeparator;
            this.f14890e = bytePrefix;
            this.f14891f = byteSuffix;
            this.f14892g = i10 == Integer.MAX_VALUE && i11 == Integer.MAX_VALUE;
            this.f14893h = bytePrefix.length() == 0 && byteSuffix.length() == 0 && byteSeparator.length() <= 1;
            this.f14894i = g.b(groupSeparator) || g.b(byteSeparator) || g.b(bytePrefix) || g.b(byteSuffix);
        }

        public final StringBuilder b(StringBuilder sb2, String indent) {
            kotlin.jvm.internal.t.f(sb2, "sb");
            kotlin.jvm.internal.t.f(indent, "indent");
            sb2.append(indent);
            sb2.append("bytesPerLine = ");
            sb2.append(this.f14886a);
            sb2.append(com.amazon.a.a.o.b.f.f4598a);
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("bytesPerGroup = ");
            sb2.append(this.f14887b);
            sb2.append(com.amazon.a.a.o.b.f.f4598a);
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("groupSeparator = \"");
            sb2.append(this.f14888c);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("byteSeparator = \"");
            sb2.append(this.f14889d);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("bytePrefix = \"");
            sb2.append(this.f14890e);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("byteSuffix = \"");
            sb2.append(this.f14891f);
            sb2.append("\"");
            return sb2;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BytesHexFormat(");
            sb2.append('\n');
            b(sb2, "    ").append('\n');
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final f a() {
            return f.f14879e;
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f14895h = new a(null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f14896i = new c("", "", false, 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f14898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f14899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f14901e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f14902f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f14903g;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                this();
            }

            public final c a() {
                return c.f14896i;
            }

            public a() {
            }
        }

        public c(String prefix, String suffix, boolean z10, int i10) {
            kotlin.jvm.internal.t.f(prefix, "prefix");
            kotlin.jvm.internal.t.f(suffix, "suffix");
            this.f14897a = prefix;
            this.f14898b = suffix;
            this.f14899c = z10;
            this.f14900d = i10;
            boolean z11 = prefix.length() == 0 && suffix.length() == 0;
            this.f14901e = z11;
            this.f14902f = z11 && i10 == 1;
            this.f14903g = g.b(prefix) || g.b(suffix);
        }

        public final StringBuilder b(StringBuilder sb2, String indent) {
            kotlin.jvm.internal.t.f(sb2, "sb");
            kotlin.jvm.internal.t.f(indent, "indent");
            sb2.append(indent);
            sb2.append("prefix = \"");
            sb2.append(this.f14897a);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("suffix = \"");
            sb2.append(this.f14898b);
            sb2.append("\",");
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("removeLeadingZeros = ");
            sb2.append(this.f14899c);
            sb2.append(',');
            sb2.append('\n');
            sb2.append(indent);
            sb2.append("minLength = ");
            sb2.append(this.f14900d);
            return sb2;
        }

        public final boolean c() {
            return this.f14903g;
        }

        public final String d() {
            return this.f14897a;
        }

        public final String e() {
            return this.f14898b;
        }

        public final boolean f() {
            return this.f14901e;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NumberHexFormat(");
            sb2.append('\n');
            b(sb2, "    ").append('\n');
            sb2.append(")");
            return sb2.toString();
        }
    }

    static {
        a.C0258a c0258a = a.f14884j;
        a aVarA = c0258a.a();
        c.a aVar = c.f14895h;
        f14879e = new f(false, aVarA, aVar.a());
        f14880f = new f(true, c0258a.a(), aVar.a());
    }

    public f(boolean z10, a bytes, c number) {
        kotlin.jvm.internal.t.f(bytes, "bytes");
        kotlin.jvm.internal.t.f(number, "number");
        this.f14881a = z10;
        this.f14882b = bytes;
        this.f14883c = number;
    }

    public final c b() {
        return this.f14883c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HexFormat(");
        sb2.append('\n');
        sb2.append("    upperCase = ");
        sb2.append(this.f14881a);
        sb2.append(com.amazon.a.a.o.b.f.f4598a);
        sb2.append('\n');
        sb2.append("    bytes = BytesHexFormat(");
        sb2.append('\n');
        this.f14882b.b(sb2, "        ").append('\n');
        sb2.append("    ),");
        sb2.append('\n');
        sb2.append("    number = NumberHexFormat(");
        sb2.append('\n');
        this.f14883c.b(sb2, "        ").append('\n');
        sb2.append("    )");
        sb2.append('\n');
        sb2.append(")");
        return sb2.toString();
    }
}
