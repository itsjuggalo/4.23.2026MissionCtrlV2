package I5;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f4296c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f4297d = new s(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f4298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f4299b;

    public static final class a {
        public a() {
        }

        public final s a(q type) {
            AbstractC2304t.f(type, "type");
            return new s(t.f4302b, type);
        }

        public final s b(q type) {
            AbstractC2304t.f(type, "type");
            return new s(t.f4303c, type);
        }

        public final s c() {
            return s.f4297d;
        }

        public final s d(q type) {
            AbstractC2304t.f(type, "type");
            return new s(t.f4301a, type);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4300a;

        static {
            int[] iArr = new int[t.values().length];
            try {
                iArr[t.f4301a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[t.f4302b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[t.f4303c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f4300a = iArr;
        }
    }

    public s(t tVar, q qVar) {
        String str;
        this.f4298a = tVar;
        this.f4299b = qVar;
        if ((tVar == null) == (qVar == null)) {
            return;
        }
        if (tVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + tVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final t a() {
        return this.f4298a;
    }

    public final q b() {
        return this.f4299b;
    }

    public final q c() {
        return this.f4299b;
    }

    public final t d() {
        return this.f4298a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f4298a == sVar.f4298a && AbstractC2304t.b(this.f4299b, sVar.f4299b);
    }

    public int hashCode() {
        t tVar = this.f4298a;
        int iHashCode = (tVar == null ? 0 : tVar.hashCode()) * 31;
        q qVar = this.f4299b;
        return iHashCode + (qVar != null ? qVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb;
        String str;
        t tVar = this.f4298a;
        int i8 = tVar == null ? -1 : b.f4300a[tVar.ordinal()];
        if (i8 == -1) {
            return "*";
        }
        if (i8 == 1) {
            return String.valueOf(this.f4299b);
        }
        if (i8 == 2) {
            sb = new StringBuilder();
            str = "in ";
        } else {
            if (i8 != 3) {
                throw new C2487o();
            }
            sb = new StringBuilder();
            str = "out ";
        }
        sb.append(str);
        sb.append(this.f4299b);
        return sb.toString();
    }
}
