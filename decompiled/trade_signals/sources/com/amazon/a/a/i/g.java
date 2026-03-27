package com.amazon.a.a.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amazon.a.a.i.c;
import com.amazon.a.a.i.h;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class g extends h implements com.amazon.a.a.k.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f13815b = 31536000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13816e = new com.amazon.a.a.o.c("ShutdownPrompt");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f13817f = "https://www.amazon.com/appstore-error-help";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f13818g = "badcert";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f13819h = "1.1";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a f13820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f13821j;

    public static class a extends AsyncTask<Void, Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.amazon.a.a.a.a f13822a;

        private a(com.amazon.a.a.a.a aVar) {
            this.f13822a = aVar;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            g.b(this.f13822a);
        }
    }

    public static class b extends AsyncTask<Intent, Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f13823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.amazon.a.a.a.a f13824b;

        private b(Context context, com.amazon.a.a.a.a aVar) {
            this.f13823a = context;
            this.f13824b = aVar;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Intent... intentArr) {
            this.f13823a.startActivity(intentArr[0]);
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            g.b(this.f13824b);
        }
    }

    public g(c cVar) {
        super(cVar, h.a.EXTENDED);
        f13816e.a("new ShutdownPrompt called!");
    }

    private final Intent a(Context context) {
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder(f13817f);
        PackageManager packageManager = context.getPackageManager();
        a(sb, "?k=", f13819h);
        a(sb, "&m=", ((h) this).f13827c.e());
        a(sb, "&ec=", String.valueOf(((h) this).f13827c.g()));
        String str = (String) this.f13821j.a(com.amazon.a.a.m.c.f13881f);
        if (str != null) {
            a(sb, "&t=", str);
            a(sb, "&tv=", str, packageManager);
        }
        String str2 = (String) this.f13821j.a(com.amazon.a.a.m.c.f13882g);
        if (str2 != null) {
            a(sb, "&c=", str2);
        }
        String str3 = (String) this.f13821j.a(com.amazon.a.a.m.c.f13879d);
        if (str3 != null) {
            a(sb, "&e=", str3);
        }
        String str4 = Build.PRODUCT;
        if (str4 != null) {
            a(sb, "&d=", str4);
        }
        String str5 = Build.MANUFACTURER;
        if (str5 != null) {
            a(sb, "&ma=", str5);
        }
        String str6 = Build.MODEL;
        if (str6 != null) {
            a(sb, "&mo=", str6);
        }
        String str7 = Build.ID;
        if (str7 != null) {
            a(sb, "&bn=", str7);
        }
        a(sb, "&sz=", String.valueOf(context.getResources().getConfiguration().screenLayout & 15));
        a(sb, "&s=", String.valueOf(Build.VERSION.SDK_INT));
        a(sb, "&p=", packageName);
        a(sb, "&pv=", packageName, packageManager);
        a(sb, "&l=", n());
        String strB = b(context);
        if (!TextUtils.isEmpty(strB)) {
            a(sb, "&mc=", strB);
        }
        String string = sb.toString();
        f13816e.a("Starting browser for uri " + string);
        return new Intent("android.intent.action.VIEW", Uri.parse(string));
    }

    private String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            f13816e.a("tm was null!");
            return null;
        }
        com.amazon.a.a.o.c cVar = f13816e;
        cVar.a("tm was not null.");
        int simState = telephonyManager.getSimState();
        if (simState == 5) {
            return telephonyManager.getSimOperator();
        }
        cVar.a("SIM not ready, returning null.  State was " + simState);
        return null;
    }

    private String n() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }

    @Override // com.amazon.a.a.e.c
    public long h() {
        return f13815b;
    }

    @Override // com.amazon.a.a.i.h
    public void i() {
        a(0);
    }

    public void m() {
        com.amazon.a.a.o.c cVar = f13816e;
        cVar.a("Store contains " + this.f13821j.toString());
        if (!((h) this).f13827c.i()) {
            cVar.a("Should not show fixup");
            new a(this.f13820i).execute(new Void[0]);
        } else {
            cVar.a("Should show fixup");
            Activity activityA = this.f13820i.a();
            a(activityA, a((Context) activityA));
            cVar.a("Attempted to start browser.");
        }
    }

    public String toString() {
        return "ShutdownPrompt";
    }

    private Intent a(Context context, String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse("amzn://apps/android?p=" + context.getPackageName() + "&ref=" + str));
    }

    @Override // com.amazon.a.a.e.a
    public void b() {
        this.f13820i.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.amazon.a.a.a.a aVar) {
        com.amazon.a.a.o.c cVar = f13816e;
        cVar.a("doShutdown()");
        cVar.c("Killing application");
        System.exit(0);
    }

    @Override // com.amazon.a.a.i.h
    public void a(int i8) {
        com.amazon.a.a.o.c cVar = f13816e;
        cVar.a("doAction(" + i8 + ")");
        c.a[] aVarArrC = ((h) this).f13827c.c();
        c.a aVar = c.a.DEFAULT;
        c.a aVar2 = i8 < aVarArrC.length ? aVarArrC[i8] : aVar;
        if (aVar2 == c.a.HELP) {
            cVar.a("doAction() help");
            m();
        } else if (aVar2 == c.a.DEEPLINK) {
            cVar.a("doAction() deeplink");
            a(f13818g);
        } else if (aVar2 == aVar) {
            b(this.f13820i);
        }
    }

    private void a(Context context, Intent intent) {
        if (b(context, intent)) {
            new b(context, this.f13820i).execute(intent);
        } else {
            f13816e.b("Could not start activity, nothing resolves for the given data.");
            b(this.f13820i);
        }
    }

    private boolean b(Context context, Intent intent) {
        intent.addFlags(268435456);
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    private void a(String str) {
        f13816e.a("Attempting to deep link to appstore.");
        Activity activityA = this.f13820i.a();
        a(activityA, a(activityA, str));
    }

    private final void a(StringBuilder sb, String str, String str2) {
        try {
            String strEncode = URLEncoder.encode(str2, "UTF-8");
            sb.append(str);
            sb.append(strEncode);
        } catch (UnsupportedEncodingException e8) {
            f13816e.b("Failed to URL-encode argument", e8);
        }
    }

    private final void a(StringBuilder sb, String str, String str2, PackageManager packageManager) {
        try {
            a(sb, str, String.valueOf(packageManager.getPackageInfo(str2, 0).versionCode));
        } catch (PackageManager.NameNotFoundException unused) {
            f13816e.b("Could not find information for package " + str2);
        }
    }

    @Override // com.amazon.a.a.i.h
    public boolean a(c.a aVar) {
        if (aVar == c.a.DEFAULT) {
            return true;
        }
        Activity activityA = this.f13820i.a();
        Intent intentA = aVar == c.a.DEEPLINK ? a(activityA, f13818g) : aVar == c.a.HELP ? a((Context) activityA) : null;
        if (intentA != null) {
            return b(activityA, intentA);
        }
        f13816e.b("Unexpected action " + aVar + ", could not create intent.");
        return false;
    }
}
