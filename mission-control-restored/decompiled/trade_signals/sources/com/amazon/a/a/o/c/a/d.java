package com.amazon.a.a.o.c.a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public enum d implements Serializable {
    SENSITIVE("Sensitive", true),
    INSENSITIVE("Insensitive", false),
    SYSTEM("System", !b.a());


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f14123d = -6343169151696340687L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient boolean f14126f;

    d(String str, boolean z7) {
        this.f14125e = str;
        this.f14126f = z7;
    }

    private Object c() {
        return a(this.f14125e);
    }

    public int a(String str, int i8, String str2) {
        int length = str.length() - str2.length();
        if (length < i8) {
            return -1;
        }
        while (i8 <= length) {
            if (b(str, i8, str2)) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public boolean b() {
        return this.f14126f;
    }

    public boolean d(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.f14126f, str.length() - length, str2, 0, length);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f14125e;
    }

    public int a(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.f14126f ? str.compareTo(str2) : str.compareToIgnoreCase(str2);
    }

    public boolean b(String str, int i8, String str2) {
        return str.regionMatches(!this.f14126f, i8, str2, 0, str2.length());
    }

    public boolean c(String str, String str2) {
        return str.regionMatches(!this.f14126f, 0, str2, 0, str2.length());
    }

    public static d a(String str) {
        for (d dVar : values()) {
            if (dVar.a().equals(str)) {
                return dVar;
            }
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    public boolean b(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.f14126f ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public String a() {
        return this.f14125e;
    }
}
