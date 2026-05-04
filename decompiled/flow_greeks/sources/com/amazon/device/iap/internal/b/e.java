package com.amazon.device.iap.internal.b;

import com.amazon.a.a.o.f;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f4966b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f4967a = new ConcurrentSkipListSet();

    public boolean a(String str) {
        if (f.a(str)) {
            return false;
        }
        return this.f4967a.remove(str);
    }

    public void b(String str) {
        if (f.a(str)) {
            return;
        }
        this.f4967a.add(str);
    }

    public static e a() {
        return f4966b;
    }
}
