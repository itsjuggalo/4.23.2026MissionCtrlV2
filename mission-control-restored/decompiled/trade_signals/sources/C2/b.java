package C2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f627a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f628b = new AtomicBoolean(false);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: C2.b$b, reason: collision with other inner class name */
    public static abstract class EnumC0009b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0009b f629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0009b f630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumC0009b[] f631c;

        /* JADX INFO: renamed from: C2.b$b$a */
        public enum a extends EnumC0009b {
            public a(String str, int i8) {
                super(str, i8);
            }

            @Override // C2.b.EnumC0009b
            public boolean a() {
                return !b.c();
            }
        }

        /* JADX INFO: renamed from: C2.b$b$b, reason: collision with other inner class name */
        public enum C0010b extends EnumC0009b {
            public C0010b(String str, int i8) {
                super(str, i8);
            }

            @Override // C2.b.EnumC0009b
            public boolean a() {
                return !b.c() || b.b();
            }
        }

        static {
            a aVar = new a("ALGORITHM_NOT_FIPS", 0);
            f629a = aVar;
            C0010b c0010b = new C0010b("ALGORITHM_REQUIRES_BORINGCRYPTO", 1);
            f630b = c0010b;
            f631c = new EnumC0009b[]{aVar, c0010b};
        }

        public EnumC0009b(String str, int i8) {
        }

        public static EnumC0009b valueOf(String str) {
            return (EnumC0009b) Enum.valueOf(EnumC0009b.class, str);
        }

        public static EnumC0009b[] values() {
            return (EnumC0009b[]) f631c.clone();
        }

        public abstract boolean a();
    }

    public static Boolean a() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
        } catch (Exception unused) {
            f627a.info("Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }

    public static boolean b() {
        return a().booleanValue();
    }

    public static boolean c() {
        return C2.a.a() || f628b.get();
    }
}
