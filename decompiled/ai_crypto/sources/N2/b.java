package N2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f3961a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f3962b = new AtomicBoolean(false);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: N2.b$b, reason: collision with other inner class name */
    public static abstract class EnumC0056b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0056b f3963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0056b f3964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumC0056b[] f3965c;

        /* JADX INFO: renamed from: N2.b$b$a */
        public enum a extends EnumC0056b {
            public a(String str, int i7) {
                super(str, i7);
            }

            @Override // N2.b.EnumC0056b
            public boolean a() {
                return !b.c();
            }
        }

        /* JADX INFO: renamed from: N2.b$b$b, reason: collision with other inner class name */
        public enum C0057b extends EnumC0056b {
            public C0057b(String str, int i7) {
                super(str, i7);
            }

            @Override // N2.b.EnumC0056b
            public boolean a() {
                return !b.c() || b.b();
            }
        }

        static {
            a aVar = new a("ALGORITHM_NOT_FIPS", 0);
            f3963a = aVar;
            C0057b c0057b = new C0057b("ALGORITHM_REQUIRES_BORINGCRYPTO", 1);
            f3964b = c0057b;
            f3965c = new EnumC0056b[]{aVar, c0057b};
        }

        public EnumC0056b(String str, int i7) {
        }

        public static EnumC0056b valueOf(String str) {
            return (EnumC0056b) Enum.valueOf(EnumC0056b.class, str);
        }

        public static EnumC0056b[] values() {
            return (EnumC0056b[]) f3965c.clone();
        }

        public abstract boolean a();
    }

    public static Boolean a() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
        } catch (Exception unused) {
            f3961a.info("Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }

    public static boolean b() {
        return a().booleanValue();
    }

    public static boolean c() {
        return N2.a.a() || f3962b.get();
    }
}
