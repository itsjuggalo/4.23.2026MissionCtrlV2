package a3;

import Z2.AbstractC0777w;

/* JADX INFO: renamed from: a3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0849f extends AbstractC0777w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6207c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6208d = false;

    @Override // Z2.AbstractC0777w
    public final void a(boolean z7) {
        this.f6208d = z7;
    }

    @Override // Z2.AbstractC0777w
    public final void b(boolean z7) {
        this.f6207c = z7;
    }

    @Override // Z2.AbstractC0777w
    public final void c(String str, String str2) {
        this.f6205a = str;
        this.f6206b = str2;
    }

    public final String d() {
        return this.f6205a;
    }

    public final String e() {
        return this.f6206b;
    }

    public final boolean f() {
        return this.f6208d;
    }

    public final boolean g() {
        return (this.f6205a == null || this.f6206b == null) ? false : true;
    }

    public final boolean h() {
        return this.f6207c;
    }
}
