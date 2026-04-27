package com.amazon.a.a.o.c.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f14119a;

    public c(String... strArr) {
        this.f14119a = Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
    }

    @Override // com.amazon.a.a.o.c.a.a
    public boolean a(String str) {
        return this.f14119a.contains(str);
    }
}
