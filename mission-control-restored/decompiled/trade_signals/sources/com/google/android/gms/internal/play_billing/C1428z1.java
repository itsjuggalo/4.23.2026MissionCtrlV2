package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.z1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1428z1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile C1428z1 f15542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1428z1 f15543c = new C1428z1(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f15544a = Collections.emptyMap();

    public C1428z1(boolean z7) {
    }

    public static C1428z1 a() {
        C1428z1 c1428z1 = f15542b;
        if (c1428z1 != null) {
            return c1428z1;
        }
        synchronized (C1428z1.class) {
            try {
                C1428z1 c1428z12 = f15542b;
                if (c1428z12 != null) {
                    return c1428z12;
                }
                C1369m2 c1369m2 = C1369m2.f15457c;
                C1428z1 c1428z1A = F1.a(C1428z1.class);
                f15542b = c1428z1A;
                return c1428z1A;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final I1 b(InterfaceC1334f2 interfaceC1334f2, int i8) {
        android.support.v4.media.session.b.a(this.f15544a.get(new C1424y1(interfaceC1334f2, i8)));
        return null;
    }
}
