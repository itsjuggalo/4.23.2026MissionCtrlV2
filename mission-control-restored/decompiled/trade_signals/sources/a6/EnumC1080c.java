package a6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: a6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC1080c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1080c f10128b = new EnumC1080c("METHOD_RETURN_TYPE", 0, "METHOD");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1080c f10129c = new EnumC1080c("VALUE_PARAMETER", 1, "PARAMETER");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1080c f10130d = new EnumC1080c("FIELD", 2, "FIELD");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC1080c f10131e = new EnumC1080c("TYPE_USE", 3, "TYPE_USE");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC1080c f10132f = new EnumC1080c("TYPE_PARAMETER_BOUNDS", 4, "TYPE_USE");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC1080c f10133g = new EnumC1080c("TYPE_PARAMETER", 5, "TYPE_PARAMETER");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumC1080c[] f10134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f10135i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10136a;

    static {
        EnumC1080c[] enumC1080cArrA = a();
        f10134h = enumC1080cArrA;
        f10135i = AbstractC2875b.a(enumC1080cArrA);
    }

    public EnumC1080c(String str, int i8, String str2) {
        this.f10136a = str2;
    }

    public static final /* synthetic */ EnumC1080c[] a() {
        return new EnumC1080c[]{f10128b, f10129c, f10130d, f10131e, f10132f, f10133g};
    }

    public static EnumC1080c valueOf(String str) {
        return (EnumC1080c) Enum.valueOf(EnumC1080c.class, str);
    }

    public static EnumC1080c[] values() {
        return (EnumC1080c[]) f10134h.clone();
    }

    public final String b() {
        return this.f10136a;
    }
}
