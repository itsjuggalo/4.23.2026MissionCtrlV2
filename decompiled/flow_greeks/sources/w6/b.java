package w6;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f23673a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f23674b = new AtomicBoolean(false);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: w6.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class EnumC0412b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0412b f23675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0412b f23676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumC0412b[] f23677c;

        /* JADX INFO: renamed from: w6.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum a extends EnumC0412b {
            public a(String str, int i10) {
                super(str, i10);
            }

            @Override // w6.b.EnumC0412b
            public boolean a() {
                return !b.c();
            }
        }

        /* JADX INFO: renamed from: w6.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public enum C0413b extends EnumC0412b {
            public C0413b(String str, int i10) {
                super(str, i10);
            }

            @Override // w6.b.EnumC0412b
            public boolean a() {
                return !b.c() || b.b();
            }
        }

        static {
            a aVar = new a("ALGORITHM_NOT_FIPS", 0);
            f23675a = aVar;
            C0413b c0413b = new C0413b("ALGORITHM_REQUIRES_BORINGCRYPTO", 1);
            f23676b = c0413b;
            f23677c = new EnumC0412b[]{aVar, c0413b};
        }

        public EnumC0412b(String str, int i10) {
        }

        public static EnumC0412b valueOf(String str) {
            return (EnumC0412b) Enum.valueOf(EnumC0412b.class, str);
        }

        public static EnumC0412b[] values() {
            return (EnumC0412b[]) f23677c.clone();
        }

        public abstract boolean a();
    }

    public static Boolean a() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
        } catch (Exception unused) {
            f23673a.info("Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }

    public static boolean b() {
        return a().booleanValue();
    }

    public static boolean c() {
        return w6.a.a() || f23674b.get();
    }
}
