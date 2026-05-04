package com.amazon.a.b;

import com.amazon.a.a.i.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.amazon.a.a.i.c f4662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.amazon.a.a.i.c f4663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.amazon.a.a.i.c f4664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.amazon.a.a.i.c f4665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.amazon.a.a.i.c f4666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.amazon.a.a.i.c f4667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.amazon.a.a.i.c f4668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f4669h = "Quit";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f4670i = "Help";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f4671j = "Update";

    static {
        String[] strArr = {f4669h, f4670i};
        c.a aVar = c.a.DEFAULT;
        c.a aVar2 = c.a.HELP;
        f4662a = new com.amazon.a.a.i.c(new String[]{"Amazon Appstore required"}, "Amazon Appstore is not installed on your device. Please install Amazon Appstore and sign in to Amazon to use this app.", strArr, new c.a[]{aVar, aVar2}, true, true, 1, 1);
        f4663b = new com.amazon.a.a.i.c("Amazon Appstore connection failure", "An error occurred connecting to Amazon Appstore. Please try opening this app again", f4669h, true, false);
        f4664c = new com.amazon.a.a.i.c(new String[]{"New Appstore version required", "Amazon Appstore Update Required"}, "Amazon Appstore is out of date.  Please visit the Amazon website to install the latest version of the Appstore. ", new String[]{f4669h, f4670i}, new c.a[]{aVar, aVar2}, true, true, 1, 2);
        f4665d = new com.amazon.a.a.i.c("Internet connection required", "An internet connection is required to open this app. Please connect to the internet and reopen this app.", f4669h, true, false);
        f4666e = new com.amazon.a.a.i.c(new String[]{"Connection error"}, "An unknown error occurred connecting to Amazon Appstore.", new String[]{f4669h, f4670i}, new c.a[]{aVar, aVar2}, true, true, 1, 3);
        f4667f = new com.amazon.a.a.i.c("Internal error", "An internal error occurred, please try opening this app again", f4669h, true, false);
        f4668g = new com.amazon.a.a.i.c("App update required", "Please update this app from the Amazon Appstore.", new String[]{f4669h, f4671j}, new c.a[]{aVar, c.a.DEEPLINK}, true, false, 0);
    }

    private e() {
    }
}
