package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements com.google.gson.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f15980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f15981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f15982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f15983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f15984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f15985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f15986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ b[] f15987h;

    public enum a extends b {
        public a(String str, int i8) {
            super(str, i8, null);
        }

        @Override // com.google.gson.c
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f15980a = aVar;
        b bVar = new b("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.b.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.g(field.getName());
            }
        };
        f15981b = bVar;
        b bVar2 = new b("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.b.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.g(b.b(field.getName(), ' '));
            }
        };
        f15982c = bVar2;
        b bVar3 = new b("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.b.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.b(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        f15983d = bVar3;
        b bVar4 = new b("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: com.google.gson.b.e
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.b(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        f15984e = bVar4;
        b bVar5 = new b("LOWER_CASE_WITH_DASHES", 5) { // from class: com.google.gson.b.f
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.b(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        f15985f = bVar5;
        b bVar6 = new b("LOWER_CASE_WITH_DOTS", 6) { // from class: com.google.gson.b.g
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.c
            public String a(Field field) {
                return b.b(field.getName(), com.amazon.a.a.o.c.a.b.f14112a).toLowerCase(Locale.ENGLISH);
            }
        };
        f15986g = bVar6;
        f15987h = new b[]{aVar, bVar, bVar2, bVar3, bVar4, bVar5, bVar6};
    }

    public b(String str, int i8) {
    }

    public static String b(String str, char c8) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c8);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String g(String str) {
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i8 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i8) + upperCase + str.substring(i8 + 1);
            }
        }
        return str;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f15987h.clone();
    }

    public /* synthetic */ b(String str, int i8, a aVar) {
        this(str, i8);
    }
}
