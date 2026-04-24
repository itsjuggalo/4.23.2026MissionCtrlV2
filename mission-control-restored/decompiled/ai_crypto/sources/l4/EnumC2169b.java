package l4;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: l4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class EnumC2169b implements InterfaceC2170c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC2169b f18309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC2169b f18310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC2169b f18311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC2169b f18312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC2169b f18313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC2169b f18314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC2169b f18315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumC2169b[] f18316h;

    /* JADX INFO: renamed from: l4.b$a */
    public enum a extends EnumC2169b {
        public a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // l4.InterfaceC2170c
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f18309a = aVar;
        EnumC2169b enumC2169b = new EnumC2169b("UPPER_CAMEL_CASE", 1) { // from class: l4.b.b
            {
                a aVar2 = null;
            }

            @Override // l4.InterfaceC2170c
            public String a(Field field) {
                return EnumC2169b.c(field.getName());
            }
        };
        f18310b = enumC2169b;
        EnumC2169b enumC2169b2 = new EnumC2169b("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: l4.b.c
            {
                a aVar2 = null;
            }

            @Override // l4.InterfaceC2170c
            public String a(Field field) {
                return EnumC2169b.c(EnumC2169b.b(field.getName(), ' '));
            }
        };
        f18311c = enumC2169b2;
        EnumC2169b enumC2169b3 = new EnumC2169b("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: l4.b.d
            {
                a aVar2 = null;
            }

            @Override // l4.InterfaceC2170c
            public String a(Field field) {
                return EnumC2169b.b(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        f18312d = enumC2169b3;
        EnumC2169b enumC2169b4 = new EnumC2169b("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: l4.b.e
            {
                a aVar2 = null;
            }

            @Override // l4.InterfaceC2170c
            public String a(Field field) {
                return EnumC2169b.b(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        f18313e = enumC2169b4;
        EnumC2169b enumC2169b5 = new EnumC2169b("LOWER_CASE_WITH_DASHES", 5) { // from class: l4.b.f
            {
                a aVar2 = null;
            }

            @Override // l4.InterfaceC2170c
            public String a(Field field) {
                return EnumC2169b.b(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        f18314f = enumC2169b5;
        EnumC2169b enumC2169b6 = new EnumC2169b("LOWER_CASE_WITH_DOTS", 6) { // from class: l4.b.g
            {
                a aVar2 = null;
            }

            @Override // l4.InterfaceC2170c
            public String a(Field field) {
                return EnumC2169b.b(field.getName(), com.amazon.a.a.o.c.a.b.f10001a).toLowerCase(Locale.ENGLISH);
            }
        };
        f18315g = enumC2169b6;
        f18316h = new EnumC2169b[]{aVar, enumC2169b, enumC2169b2, enumC2169b3, enumC2169b4, enumC2169b5, enumC2169b6};
    }

    public EnumC2169b(String str, int i7) {
    }

    public static String b(String str, char c7) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c7);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String c(String str) {
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i7 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i7) + upperCase + str.substring(i7 + 1);
            }
        }
        return str;
    }

    public static EnumC2169b valueOf(String str) {
        return (EnumC2169b) Enum.valueOf(EnumC2169b.class, str);
    }

    public static EnumC2169b[] values() {
        return (EnumC2169b[]) f18316h.clone();
    }

    public /* synthetic */ EnumC2169b(String str, int i7, a aVar) {
        this(str, i7);
    }
}
