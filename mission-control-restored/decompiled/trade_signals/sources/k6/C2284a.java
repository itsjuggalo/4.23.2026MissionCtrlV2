package k6;

import H5.i;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;
import p5.AbstractC2595q;
import p5.L;
import p6.C2602e;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX INFO: renamed from: k6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2284a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0339a f20412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2602e f20413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f20414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f20415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f20416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f20417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f20418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f20419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f20420i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: k6.a$a, reason: collision with other inner class name */
    public static final class EnumC0339a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0340a f20421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Map f20422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0339a f20423d = new EnumC0339a("UNKNOWN", 0, 0);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0339a f20424e = new EnumC0339a("CLASS", 1, 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0339a f20425f = new EnumC0339a("FILE_FACADE", 2, 2);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0339a f20426g = new EnumC0339a("SYNTHETIC_CLASS", 3, 3);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0339a f20427h = new EnumC0339a("MULTIFILE_CLASS", 4, 4);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0339a f20428i = new EnumC0339a("MULTIFILE_CLASS_PART", 5, 5);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ EnumC0339a[] f20429j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC2874a f20430k;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20431a;

        /* JADX INFO: renamed from: k6.a$a$a, reason: collision with other inner class name */
        public static final class C0340a {
            public C0340a() {
            }

            public final EnumC0339a a(int i8) {
                EnumC0339a enumC0339a = (EnumC0339a) EnumC0339a.f20422c.get(Integer.valueOf(i8));
                return enumC0339a == null ? EnumC0339a.f20423d : enumC0339a;
            }

            public /* synthetic */ C0340a(AbstractC2296k abstractC2296k) {
                this();
            }
        }

        static {
            EnumC0339a[] enumC0339aArrA = a();
            f20429j = enumC0339aArrA;
            f20430k = AbstractC2875b.a(enumC0339aArrA);
            f20421b = new C0340a(null);
            EnumC0339a[] enumC0339aArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i.b(L.d(enumC0339aArrValues.length), 16));
            for (EnumC0339a enumC0339a : enumC0339aArrValues) {
                linkedHashMap.put(Integer.valueOf(enumC0339a.f20431a), enumC0339a);
            }
            f20422c = linkedHashMap;
        }

        public EnumC0339a(String str, int i8, int i9) {
            this.f20431a = i9;
        }

        public static final /* synthetic */ EnumC0339a[] a() {
            return new EnumC0339a[]{f20423d, f20424e, f20425f, f20426g, f20427h, f20428i};
        }

        public static final EnumC0339a g(int i8) {
            return f20421b.a(i8);
        }

        public static EnumC0339a valueOf(String str) {
            return (EnumC0339a) Enum.valueOf(EnumC0339a.class, str);
        }

        public static EnumC0339a[] values() {
            return (EnumC0339a[]) f20429j.clone();
        }
    }

    public C2284a(EnumC0339a kind, C2602e metadataVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i8, String str2, byte[] bArr) {
        AbstractC2304t.f(kind, "kind");
        AbstractC2304t.f(metadataVersion, "metadataVersion");
        this.f20412a = kind;
        this.f20413b = metadataVersion;
        this.f20414c = strArr;
        this.f20415d = strArr2;
        this.f20416e = strArr3;
        this.f20417f = str;
        this.f20418g = i8;
        this.f20419h = str2;
        this.f20420i = bArr;
    }

    public final String[] a() {
        return this.f20414c;
    }

    public final String[] b() {
        return this.f20415d;
    }

    public final EnumC0339a c() {
        return this.f20412a;
    }

    public final C2602e d() {
        return this.f20413b;
    }

    public final String e() {
        String str = this.f20417f;
        if (this.f20412a == EnumC0339a.f20428i) {
            return str;
        }
        return null;
    }

    public final List f() {
        String[] strArr = this.f20414c;
        if (this.f20412a != EnumC0339a.f20427h) {
            strArr = null;
        }
        List listD = strArr != null ? AbstractC2590l.d(strArr) : null;
        return listD == null ? AbstractC2595q.i() : listD;
    }

    public final String[] g() {
        return this.f20416e;
    }

    public final boolean h(int i8, int i9) {
        return (i8 & i9) != 0;
    }

    public final boolean i() {
        return h(this.f20418g, 2);
    }

    public final boolean j() {
        return h(this.f20418g, 16) && !h(this.f20418g, 32);
    }

    public String toString() {
        return this.f20412a + " version=" + this.f20413b;
    }
}
