package com.google.gson;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f15988d = new d("", "", false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f15989e = new d("\n", "  ", true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15992c;

    public d(String str, String str2, boolean z7) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f15990a = str;
        this.f15991b = str2;
        this.f15992c = z7;
    }

    public String a() {
        return this.f15991b;
    }

    public String b() {
        return this.f15990a;
    }

    public boolean c() {
        return this.f15992c;
    }
}
