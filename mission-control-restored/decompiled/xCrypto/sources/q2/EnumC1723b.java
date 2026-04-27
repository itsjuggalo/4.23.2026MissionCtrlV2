package q2;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: q2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class EnumC1723b implements q2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1723b f14201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1723b f14202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1723b f14203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1723b f14204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC1723b f14205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC1723b f14206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC1723b f14207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumC1723b[] f14208h;

    /* JADX INFO: renamed from: q2.b$a */
    public enum a extends EnumC1723b {
        public a(String str, int i4) {
            super(str, i4, null);
        }

        @Override // q2.c
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f14201a = aVar;
        EnumC1723b enumC1723b = new EnumC1723b("UPPER_CAMEL_CASE", 1) { // from class: q2.b.b
            {
                a aVar2 = null;
            }

            @Override // q2.c
            public String a(Field field) {
                return EnumC1723b.g(field.getName());
            }
        };
        f14202b = enumC1723b;
        EnumC1723b enumC1723b2 = new EnumC1723b("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: q2.b.c
            {
                a aVar2 = null;
            }

            @Override // q2.c
            public String a(Field field) {
                return EnumC1723b.g(EnumC1723b.c(field.getName(), ' '));
            }
        };
        f14203c = enumC1723b2;
        EnumC1723b enumC1723b3 = new EnumC1723b("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: q2.b.d
            {
                a aVar2 = null;
            }

            @Override // q2.c
            public String a(Field field) {
                return EnumC1723b.c(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        f14204d = enumC1723b3;
        EnumC1723b enumC1723b4 = new EnumC1723b("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: q2.b.e
            {
                a aVar2 = null;
            }

            @Override // q2.c
            public String a(Field field) {
                return EnumC1723b.c(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        f14205e = enumC1723b4;
        EnumC1723b enumC1723b5 = new EnumC1723b("LOWER_CASE_WITH_DASHES", 5) { // from class: q2.b.f
            {
                a aVar2 = null;
            }

            @Override // q2.c
            public String a(Field field) {
                return EnumC1723b.c(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        f14206f = enumC1723b5;
        EnumC1723b enumC1723b6 = new EnumC1723b("LOWER_CASE_WITH_DOTS", 6) { // from class: q2.b.g
            {
                a aVar2 = null;
            }

            @Override // q2.c
            public String a(Field field) {
                return EnumC1723b.c(field.getName(), com.amazon.a.a.o.c.a.b.f8816a).toLowerCase(Locale.ENGLISH);
            }
        };
        f14207g = enumC1723b6;
        f14208h = new EnumC1723b[]{aVar, enumC1723b, enumC1723b2, enumC1723b3, enumC1723b4, enumC1723b5, enumC1723b6};
    }

    public EnumC1723b(String str, int i4) {
    }

    public static String c(String str, char c4) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c4);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String g(String str) {
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            char cCharAt = str.charAt(i4);
            if (!Character.isLetter(cCharAt)) {
                i4++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i4 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i4) + upperCase + str.substring(i4 + 1);
            }
        }
        return str;
    }

    public static EnumC1723b valueOf(String str) {
        return (EnumC1723b) Enum.valueOf(EnumC1723b.class, str);
    }

    public static EnumC1723b[] values() {
        return (EnumC1723b[]) f14208h.clone();
    }

    public /* synthetic */ EnumC1723b(String str, int i4, a aVar) {
        this(str, i4);
    }
}
