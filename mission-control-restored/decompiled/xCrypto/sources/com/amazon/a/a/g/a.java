package com.amazon.a.a.g;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.amazon.a.a.o.c f8457a = new com.amazon.a.a.o.c("Appstore SDK - Not Initialized Mode");

    private static String d(String str, String str2) {
        return str + ": " + str2;
    }

    @Override // com.amazon.a.a.g.c
    public boolean a() {
        return com.amazon.a.a.o.c.f8809a;
    }

    @Override // com.amazon.a.a.g.c
    public boolean b() {
        return com.amazon.a.a.o.c.f8810b;
    }

    @Override // com.amazon.a.a.g.c
    public boolean c() {
        return com.amazon.a.a.o.c.b();
    }

    @Override // com.amazon.a.a.g.c
    public void a(String str, String str2) {
        f8457a.a(d(str, str2));
    }

    @Override // com.amazon.a.a.g.c
    public void b(String str, String str2) {
        f8457a.b(d(str, str2));
    }

    @Override // com.amazon.a.a.g.c
    public void c(String str, String str2) {
        f8457a.c(d(str, str2));
    }
}
