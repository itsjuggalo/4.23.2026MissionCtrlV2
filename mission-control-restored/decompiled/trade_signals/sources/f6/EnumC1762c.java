package f6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: f6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC1762c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1762c f17571a = new EnumC1762c("INFLEXIBLE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1762c f17572b = new EnumC1762c("FLEXIBLE_UPPER_BOUND", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1762c f17573c = new EnumC1762c("FLEXIBLE_LOWER_BOUND", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC1762c[] f17574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f17575e;

    static {
        EnumC1762c[] enumC1762cArrA = a();
        f17574d = enumC1762cArrA;
        f17575e = AbstractC2875b.a(enumC1762cArrA);
    }

    public EnumC1762c(String str, int i8) {
    }

    public static final /* synthetic */ EnumC1762c[] a() {
        return new EnumC1762c[]{f17571a, f17572b, f17573c};
    }

    public static EnumC1762c valueOf(String str) {
        return (EnumC1762c) Enum.valueOf(EnumC1762c.class, str);
    }

    public static EnumC1762c[] values() {
        return (EnumC1762c[]) f17574d.clone();
    }
}
