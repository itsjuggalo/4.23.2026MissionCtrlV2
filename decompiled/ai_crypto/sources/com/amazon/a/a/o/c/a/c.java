package com.amazon.a.a.o.c.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f10008a;

    public c(String... strArr) {
        this.f10008a = Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
    }

    @Override // com.amazon.a.a.o.c.a.a
    public boolean a(String str) {
        return this.f10008a.contains(str);
    }
}
