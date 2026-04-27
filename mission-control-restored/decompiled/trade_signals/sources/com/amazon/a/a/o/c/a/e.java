package com.amazon.a.a.o.c.a;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pattern f14127a;

    public e(String str) {
        this(Pattern.compile(str));
    }

    @Override // com.amazon.a.a.o.c.a.a
    public boolean a(String str) {
        return this.f14127a.matcher(str).matches();
    }

    public e(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Null pattern");
        }
        this.f14127a = pattern;
    }
}
