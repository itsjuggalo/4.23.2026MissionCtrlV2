package com.amazon.a.a.i;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f8492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a[] f8493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f8494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f8495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f8496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f8497i;

    public enum a {
        DEFAULT,
        HELP,
        DEEPLINK
    }

    public c(String str, String str2, String str3, boolean z4) {
        this(str, str2, str3, z4, false);
    }

    public String a() {
        return this.f8492d[this.f8496h];
    }

    public String[] b() {
        return this.f8492d;
    }

    public a[] c() {
        return this.f8493e;
    }

    public String d() {
        return this.f8491c;
    }

    public String e() {
        return this.f8490b;
    }

    public String f() {
        return this.f8489a;
    }

    public int g() {
        return this.f8497i;
    }

    public boolean h() {
        return this.f8494f;
    }

    public boolean i() {
        return this.f8495g;
    }

    public String toString() {
        return "PromptContent: [ title:" + this.f8489a + ", message: " + this.f8491c + ", label: " + this.f8492d[0] + ", visible: " + this.f8494f + ", shouldShowFixup: " + this.f8495g + "]";
    }

    public c(String str, String str2, String str3, boolean z4, boolean z5) {
        this(str, str2, new String[]{str3}, new a[]{a.DEFAULT}, z4, z5, 0);
    }

    public c(String str, String str2, String[] strArr, a[] aVarArr, boolean z4, boolean z5, int i4) {
        this(new String[]{str}, str2, strArr, aVarArr, z4, z5, i4);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z4, boolean z5, int i4) {
        this(strArr, str, strArr2, aVarArr, z4, z5, i4, -1);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z4, boolean z5, int i4, int i5) {
        String str2 = strArr[0];
        this.f8489a = str2;
        if (strArr.length > 1) {
            this.f8490b = strArr[1];
        } else {
            this.f8490b = str2;
        }
        this.f8491c = str;
        this.f8492d = strArr2;
        this.f8493e = aVarArr;
        this.f8494f = z4;
        this.f8495g = z5;
        this.f8496h = i4;
        this.f8497i = i5;
    }
}
