package com.amazon.a.a.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f4304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a[] f4305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f4306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f4307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f4308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f4309i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        DEFAULT,
        HELP,
        DEEPLINK
    }

    public c(String str, String str2, String str3, boolean z10) {
        this(str, str2, str3, z10, false);
    }

    public String a() {
        return this.f4304d[this.f4308h];
    }

    public String[] b() {
        return this.f4304d;
    }

    public a[] c() {
        return this.f4305e;
    }

    public String d() {
        return this.f4303c;
    }

    public String e() {
        return this.f4302b;
    }

    public String f() {
        return this.f4301a;
    }

    public int g() {
        return this.f4309i;
    }

    public boolean h() {
        return this.f4306f;
    }

    public boolean i() {
        return this.f4307g;
    }

    public String toString() {
        return "PromptContent: [ title:" + this.f4301a + ", message: " + this.f4303c + ", label: " + this.f4304d[0] + ", visible: " + this.f4306f + ", shouldShowFixup: " + this.f4307g + "]";
    }

    public c(String str, String str2, String str3, boolean z10, boolean z11) {
        this(str, str2, new String[]{str3}, new a[]{a.DEFAULT}, z10, z11, 0);
    }

    public c(String str, String str2, String[] strArr, a[] aVarArr, boolean z10, boolean z11, int i10) {
        this(new String[]{str}, str2, strArr, aVarArr, z10, z11, i10);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z10, boolean z11, int i10) {
        this(strArr, str, strArr2, aVarArr, z10, z11, i10, -1);
    }

    public c(String[] strArr, String str, String[] strArr2, a[] aVarArr, boolean z10, boolean z11, int i10, int i11) {
        String str2 = strArr[0];
        this.f4301a = str2;
        if (strArr.length > 1) {
            this.f4302b = strArr[1];
        } else {
            this.f4302b = str2;
        }
        this.f4303c = str;
        this.f4304d = strArr2;
        this.f4305e = aVarArr;
        this.f4306f = z10;
        this.f4307g = z11;
        this.f4308h = i10;
        this.f4309i = i11;
    }
}
