package com.amazon.a.a.o.c.a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public enum d implements Serializable {
    SENSITIVE("Sensitive", true),
    INSENSITIVE("Insensitive", false),
    SYSTEM("System", !b.a());


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f8827d = -6343169151696340687L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient boolean f8830f;

    d(String str, boolean z4) {
        this.f8829e = str;
        this.f8830f = z4;
    }

    public static d a(String str) {
        for (d dVar : values()) {
            if (dVar.a().equals(str)) {
                return dVar;
            }
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    private Object c() {
        return a(this.f8829e);
    }

    public boolean b() {
        return this.f8830f;
    }

    public boolean d(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.f8830f, str.length() - length, str2, 0, length);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f8829e;
    }

    public boolean b(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.f8830f ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public boolean c(String str, String str2) {
        return str.regionMatches(!this.f8830f, 0, str2, 0, str2.length());
    }

    public String a() {
        return this.f8829e;
    }

    public boolean b(String str, int i4, String str2) {
        return str.regionMatches(!this.f8830f, i4, str2, 0, str2.length());
    }

    public int a(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.f8830f ? str.compareTo(str2) : str.compareToIgnoreCase(str2);
    }

    public int a(String str, int i4, String str2) {
        int length = str.length() - str2.length();
        if (length < i4) {
            return -1;
        }
        while (i4 <= length) {
            if (b(str, i4, str2)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }
}
