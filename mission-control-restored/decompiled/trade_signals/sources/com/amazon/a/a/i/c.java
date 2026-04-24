package com.amazon.a.a.i;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f13788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a[] f13789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f13790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f13791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f13792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f13793i;

    public enum a {
        DEFAULT,
        HELP,
        DEEPLINK
    }

    public c(String str, String str2, String str3, boolean z7) {
        this(str, str2, str3, z7, false);
    }

    public String a() {
        return this.f13788d[this.f13792h];
    }

    public String[] b() {
        return this.f13788d;
    }

    public a[] c() {
        return this.f13789e;
    }

    public String d() {
        return this.f13787c;
    }

    public String e() {
        return this.f13786b;
    }

    public String f() {
        return this.f13785a;
    }

    public int g() {
        return this.f13793i;
    }

    public boolean h() {
        return this.f13790f;
    }

    public boolean i() {
        return this.f13791g;
    }

    public String toString() {
        return "PromptContent: [ title:" + this.f13785a + ", message: " + this.f13787c + ", label: " + this.f13788d[0] + ", visible: " + this.f13790f + ", shouldShowFixup: " + this.f13791g + "]";
    }

    public c(String str, String str2, String str3, boolean z7, boolean z8) {
        this(str, str2, new String[]{str3}, new a[]{a.DEFAULT}, z7, z8, 0);
    }

    public c(String str, String str2, String[] strArr, a[] aVarArr, boolean z7, boolean z8, int i8) {
        this(new String[]{str}, str2, strArr, aVarArr, z7, z8, i8);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z7, boolean z8, int i8) {
        this(strArr, str, strArr2, aVarArr, z7, z8, i8, -1);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z7, boolean z8, int i8, int i9) {
        String str2 = strArr[0];
        this.f13785a = str2;
        if (strArr.length > 1) {
            this.f13786b = strArr[1];
        } else {
            this.f13786b = str2;
        }
        this.f13787c = str;
        this.f13788d = strArr2;
        this.f13789e = aVarArr;
        this.f13790f = z7;
        this.f13791g = z8;
        this.f13792h = i8;
        this.f13793i = i9;
    }
}
