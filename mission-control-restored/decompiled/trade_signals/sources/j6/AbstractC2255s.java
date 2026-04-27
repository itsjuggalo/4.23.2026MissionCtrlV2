package j6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import z6.EnumC3021e;

/* JADX INFO: renamed from: j6.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2255s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20219a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f20220b = new d(EnumC3021e.BOOLEAN);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f20221c = new d(EnumC3021e.CHAR);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f20222d = new d(EnumC3021e.BYTE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f20223e = new d(EnumC3021e.SHORT);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f20224f = new d(EnumC3021e.INT);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f20225g = new d(EnumC3021e.FLOAT);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f20226h = new d(EnumC3021e.LONG);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f20227i = new d(EnumC3021e.DOUBLE);

    /* JADX INFO: renamed from: j6.s$a */
    public static final class a extends AbstractC2255s {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final AbstractC2255s f20228j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC2255s elementType) {
            super(null);
            AbstractC2304t.f(elementType, "elementType");
            this.f20228j = elementType;
        }

        public final AbstractC2255s i() {
            return this.f20228j;
        }
    }

    /* JADX INFO: renamed from: j6.s$b */
    public static final class b {
        public b() {
        }

        public final d a() {
            return AbstractC2255s.f20220b;
        }

        public final d b() {
            return AbstractC2255s.f20222d;
        }

        public final d c() {
            return AbstractC2255s.f20221c;
        }

        public final d d() {
            return AbstractC2255s.f20227i;
        }

        public final d e() {
            return AbstractC2255s.f20225g;
        }

        public final d f() {
            return AbstractC2255s.f20224f;
        }

        public final d g() {
            return AbstractC2255s.f20226h;
        }

        public final d h() {
            return AbstractC2255s.f20223e;
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: j6.s$c */
    public static final class c extends AbstractC2255s {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f20229j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String internalName) {
            super(null);
            AbstractC2304t.f(internalName, "internalName");
            this.f20229j = internalName;
        }

        public final String i() {
            return this.f20229j;
        }
    }

    /* JADX INFO: renamed from: j6.s$d */
    public static final class d extends AbstractC2255s {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final EnumC3021e f20230j;

        public d(EnumC3021e enumC3021e) {
            super(null);
            this.f20230j = enumC3021e;
        }

        public final EnumC3021e i() {
            return this.f20230j;
        }
    }

    public AbstractC2255s() {
    }

    public String toString() {
        return C2257u.f20231a.a(this);
    }

    public /* synthetic */ AbstractC2255s(AbstractC2296k abstractC2296k) {
        this();
    }
}
