package com.dexterous.flutterlocalnotifications;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f4981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f4982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f4983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f4984d;
    public static final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ f[] f4985f;

    static {
        f fVar = new f("None", 0);
        f4981a = fVar;
        f fVar2 = new f("RequestingNotificationPermission", 1);
        f4982b = fVar2;
        f fVar3 = new f("RequestingNotificationPolicyAccess", 2);
        f4983c = fVar3;
        f fVar4 = new f("RequestingExactAlarmsPermission", 3);
        f4984d = fVar4;
        f fVar5 = new f("RequestingFullScreenIntentPermission", 4);
        e = fVar5;
        f4985f = new f[]{fVar, fVar2, fVar3, fVar4, fVar5};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f4985f.clone();
    }
}
