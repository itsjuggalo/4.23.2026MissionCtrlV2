package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f14751a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f14752a = new HashMap();

        public e b() {
            return new e(this);
        }
    }

    public e(a aVar) {
        this.f14751a = Collections.unmodifiableMap(new HashMap(aVar.f14752a));
    }

    public boolean a(Class cls) {
        return this.f14751a.containsKey(cls);
    }
}
