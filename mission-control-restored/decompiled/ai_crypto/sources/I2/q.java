package I2;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class a implements H2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2982a = new C0032a("KEY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2983b = new b("VALUE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a[] f2984c = a();

        /* JADX INFO: renamed from: I2.q$a$a, reason: collision with other inner class name */
        public enum C0032a extends a {
            public C0032a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // H2.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        public enum b extends a {
            public b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // H2.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        public a(String str, int i7) {
        }

        public static /* synthetic */ a[] a() {
            return new a[]{f2982a, f2983b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f2984c.clone();
        }

        public /* synthetic */ a(String str, int i7, p pVar) {
            this(str, i7);
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
        StringBuilder sbA = e.a(map.size());
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

    public static H2.e c() {
        return a.f2983b;
    }
}
