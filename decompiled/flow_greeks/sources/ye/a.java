package ye;

import dd.n0;
import dd.r;
import df.e;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import vd.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0469a f25360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f25361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f25362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f25363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f25364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f25365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f25366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f25367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f25368i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: ye.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class EnumC0469a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0470a f25369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Map f25370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0469a f25371d = new EnumC0469a("UNKNOWN", 0, 0);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0469a f25372e = new EnumC0469a("CLASS", 1, 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0469a f25373f = new EnumC0469a("FILE_FACADE", 2, 2);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0469a f25374g = new EnumC0469a("SYNTHETIC_CLASS", 3, 3);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0469a f25375h = new EnumC0469a("MULTIFILE_CLASS", 4, 4);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0469a f25376i = new EnumC0469a("MULTIFILE_CLASS_PART", 5, 5);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ EnumC0469a[] f25377j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ jd.a f25378k;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f25379a;

        /* JADX INFO: renamed from: ye.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0470a {
            public /* synthetic */ C0470a(k kVar) {
                this();
            }

            public final EnumC0469a a(int i10) {
                EnumC0469a enumC0469a = (EnumC0469a) EnumC0469a.f25370c.get(Integer.valueOf(i10));
                return enumC0469a == null ? EnumC0469a.f25371d : enumC0469a;
            }

            public C0470a() {
            }
        }

        static {
            EnumC0469a[] enumC0469aArrA = a();
            f25377j = enumC0469aArrA;
            f25378k = jd.b.a(enumC0469aArrA);
            f25369b = new C0470a(null);
            EnumC0469a[] enumC0469aArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(n0.d(enumC0469aArrValues.length), 16));
            for (EnumC0469a enumC0469a : enumC0469aArrValues) {
                linkedHashMap.put(Integer.valueOf(enumC0469a.f25379a), enumC0469a);
            }
            f25370c = linkedHashMap;
        }

        public EnumC0469a(String str, int i10, int i11) {
            this.f25379a = i11;
        }

        public static final /* synthetic */ EnumC0469a[] a() {
            return new EnumC0469a[]{f25371d, f25372e, f25373f, f25374g, f25375h, f25376i};
        }

        public static final EnumC0469a c(int i10) {
            return f25369b.a(i10);
        }

        public static EnumC0469a valueOf(String str) {
            return (EnumC0469a) Enum.valueOf(EnumC0469a.class, str);
        }

        public static EnumC0469a[] values() {
            return (EnumC0469a[]) f25377j.clone();
        }
    }

    public a(EnumC0469a kind, e metadataVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i10, String str2, byte[] bArr) {
        t.f(kind, "kind");
        t.f(metadataVersion, "metadataVersion");
        this.f25360a = kind;
        this.f25361b = metadataVersion;
        this.f25362c = strArr;
        this.f25363d = strArr2;
        this.f25364e = strArr3;
        this.f25365f = str;
        this.f25366g = i10;
        this.f25367h = str2;
        this.f25368i = bArr;
    }

    public final String[] a() {
        return this.f25362c;
    }

    public final String[] b() {
        return this.f25363d;
    }

    public final EnumC0469a c() {
        return this.f25360a;
    }

    public final e d() {
        return this.f25361b;
    }

    public final String e() {
        String str = this.f25365f;
        if (this.f25360a == EnumC0469a.f25376i) {
            return str;
        }
        return null;
    }

    public final List f() {
        String[] strArr = this.f25362c;
        if (this.f25360a != EnumC0469a.f25375h) {
            strArr = null;
        }
        List listD = strArr != null ? dd.l.d(strArr) : null;
        return listD == null ? r.k() : listD;
    }

    public final String[] g() {
        return this.f25364e;
    }

    public final boolean h(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public final boolean i() {
        return h(this.f25366g, 2);
    }

    public final boolean j() {
        return h(this.f25366g, 16) && !h(this.f25366g, 32);
    }

    public String toString() {
        return this.f25360a + " version=" + this.f25361b;
    }
}
