package w2;

import java.util.Map;
import v2.InterfaceC2840f;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class a implements InterfaceC2840f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24030a = new C0422a("KEY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f24031b = new b("VALUE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a[] f24032c = a();

        /* JADX INFO: renamed from: w2.q$a$a, reason: collision with other inner class name */
        public enum C0422a extends a {
            public C0422a(String str, int i8) {
                super(str, i8, null);
            }

            @Override // v2.InterfaceC2840f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        public enum b extends a {
            public b(String str, int i8) {
                super(str, i8, null);
            }

            @Override // v2.InterfaceC2840f
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        public a(String str, int i8) {
        }

        public static /* synthetic */ a[] a() {
            return new a[]{f24030a, f24031b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f24032c.clone();
        }

        public /* synthetic */ a(String str, int i8, p pVar) {
            this(str, i8);
        }
    }

    public static boolean a(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static String b(Map map) {
        StringBuilder sbA = AbstractC2916e.a(map.size());
        sbA.append('{');
        boolean z7 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z7) {
                sbA.append(", ");
            }
            sbA.append(entry.getKey());
            sbA.append('=');
            sbA.append(entry.getValue());
            z7 = false;
        }
        sbA.append('}');
        return sbA.toString();
    }

    public static InterfaceC2840f c() {
        return a.f24031b;
    }
}
