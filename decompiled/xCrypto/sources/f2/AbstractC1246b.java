package f2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: renamed from: f2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1246b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f11535a = Logger.getLogger(AbstractC1246b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f11536b = new AtomicBoolean(false);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: f2.b$b, reason: collision with other inner class name */
    public static abstract class EnumC0193b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0193b f11537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0193b f11538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumC0193b[] f11539c;

        /* JADX INFO: renamed from: f2.b$b$a */
        public enum a extends EnumC0193b {
            public a(String str, int i4) {
                super(str, i4);
            }

            @Override // f2.AbstractC1246b.EnumC0193b
            public boolean a() {
                return !AbstractC1246b.c();
            }
        }

        /* JADX INFO: renamed from: f2.b$b$b, reason: collision with other inner class name */
        public enum C0194b extends EnumC0193b {
            public C0194b(String str, int i4) {
                super(str, i4);
            }

            @Override // f2.AbstractC1246b.EnumC0193b
            public boolean a() {
                return !AbstractC1246b.c() || AbstractC1246b.b();
            }
        }

        static {
            a aVar = new a("ALGORITHM_NOT_FIPS", 0);
            f11537a = aVar;
            C0194b c0194b = new C0194b("ALGORITHM_REQUIRES_BORINGCRYPTO", 1);
            f11538b = c0194b;
            f11539c = new EnumC0193b[]{aVar, c0194b};
        }

        public EnumC0193b(String str, int i4) {
        }

        public static EnumC0193b valueOf(String str) {
            return (EnumC0193b) Enum.valueOf(EnumC0193b.class, str);
        }

        public static EnumC0193b[] values() {
            return (EnumC0193b[]) f11539c.clone();
        }

        public abstract boolean a();
    }

    public static Boolean a() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            f11535a.info("Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }

    public static boolean b() {
        return a().booleanValue();
    }

    public static boolean c() {
        return AbstractC1245a.a() || f11536b.get();
    }
}
