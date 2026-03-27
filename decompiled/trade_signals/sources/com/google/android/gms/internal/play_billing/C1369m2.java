package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.m2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1369m2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1369m2 f15457c = new C1369m2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f15459b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1389q2 f15458a = new Y1();

    public static C1369m2 a() {
        return f15457c;
    }

    public final InterfaceC1384p2 b(Class cls) {
        P1.c(cls, "messageType");
        ConcurrentMap concurrentMap = this.f15459b;
        InterfaceC1384p2 interfaceC1384p2Zza = (InterfaceC1384p2) concurrentMap.get(cls);
        if (interfaceC1384p2Zza == null) {
            interfaceC1384p2Zza = this.f15458a.zza(cls);
            P1.c(cls, "messageType");
            InterfaceC1384p2 interfaceC1384p2 = (InterfaceC1384p2) concurrentMap.putIfAbsent(cls, interfaceC1384p2Zza);
            if (interfaceC1384p2 != null) {
                return interfaceC1384p2;
            }
        }
        return interfaceC1384p2Zza;
    }
}
