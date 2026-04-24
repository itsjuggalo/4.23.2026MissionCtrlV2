package com.amazon.a.a.i;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f9677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a[] f9678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f9679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f9680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f9682i;

    public enum a {
        DEFAULT,
        HELP,
        DEEPLINK
    }

    public c(String str, String str2, String str3, boolean z7) {
        this(str, str2, str3, z7, false);
    }

    public String a() {
        return this.f9677d[this.f9681h];
    }

    public String[] b() {
        return this.f9677d;
    }

    public a[] c() {
        return this.f9678e;
    }

    public String d() {
        return this.f9676c;
    }

    public String e() {
        return this.f9675b;
    }

    public String f() {
        return this.f9674a;
    }

    public int g() {
        return this.f9682i;
    }

    public boolean h() {
        return this.f9679f;
    }

    public boolean i() {
        return this.f9680g;
    }

    public String toString() {
        return "PromptContent: [ title:" + this.f9674a + ", message: " + this.f9676c + ", label: " + this.f9677d[0] + ", visible: " + this.f9679f + ", shouldShowFixup: " + this.f9680g + "]";
    }

    public c(String str, String str2, String str3, boolean z7, boolean z8) {
        this(str, str2, new String[]{str3}, new a[]{a.DEFAULT}, z7, z8, 0);
    }

    public c(String str, String str2, String[] strArr, a[] aVarArr, boolean z7, boolean z8, int i7) {
        this(new String[]{str}, str2, strArr, aVarArr, z7, z8, i7);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z7, boolean z8, int i7) {
        this(strArr, str, strArr2, aVarArr, z7, z8, i7, -1);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z7, boolean z8, int i7, int i8) {
        String str2 = strArr[0];
        this.f9674a = str2;
        if (strArr.length > 1) {
            this.f9675b = strArr[1];
        } else {
            this.f9675b = str2;
        }
        this.f9676c = str;
        this.f9677d = strArr2;
        this.f9678e = aVarArr;
        this.f9679f = z7;
        this.f9680g = z8;
        this.f9681h = i7;
        this.f9682i = i8;
    }
}
