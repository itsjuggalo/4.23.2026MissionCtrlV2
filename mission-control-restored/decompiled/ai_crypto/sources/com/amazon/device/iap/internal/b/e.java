package com.amazon.device.iap.internal.b;

import com.amazon.a.a.o.f;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f10357b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f10358a = new ConcurrentSkipListSet();

    public boolean a(String str) {
        if (f.a(str)) {
            return false;
        }
        return this.f10358a.remove(str);
    }

    public void b(String str) {
        if (f.a(str)) {
            return;
        }
        this.f10358a.add(str);
    }

    public static e a() {
        return f10357b;
    }
}
