package com.google.gson;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f6636d = new d("", "", false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f6637e = new d("\n", "  ", true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6640c;

    public d(String str, String str2, boolean z10) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f6638a = str;
        this.f6639b = str2;
        this.f6640c = z10;
    }

    public String a() {
        return this.f6639b;
    }

    public String b() {
        return this.f6638a;
    }

    public boolean c() {
        return this.f6640c;
    }
}
