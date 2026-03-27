package H2;

import W2.j;
import W2.k;
import X2.AbstractC0769p;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import com.google.firebase.sessions.settings.RemoteSettings;
import dev.fluttercommunity.plus.share.SharePlusPendingIntent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;
import r3.x;
import x.AbstractC1910b;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dev.fluttercommunity.plus.share.a f719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f721e;

    public d(Context context, Activity activity, dev.fluttercommunity.plus.share.a manager) {
        r.f(context, "context");
        r.f(manager, "manager");
        this.f717a = context;
        this.f718b = activity;
        this.f719c = manager;
        this.f720d = k.b(new Function0() { // from class: H2.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.m(this.f716a);
            }
        });
        this.f721e = k.b(new Function0() { // from class: H2.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(d.l());
            }
        });
    }

    public static final int l() {
        return 33554432;
    }

    public static final String m(d dVar) {
        return dVar.f().getPackageName() + ".flutter.share_provider";
    }

    public final void c() {
        File fileJ = j();
        File[] fileArrListFiles = fileJ.listFiles();
        if (!fileJ.exists() || fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            file.delete();
        }
        fileJ.delete();
    }

    public final File d(File file) {
        File fileJ = j();
        if (!fileJ.exists()) {
            fileJ.mkdirs();
        }
        File file2 = new File(fileJ, file.getName());
        g3.j.f(file, file2, true, 0, 4, null);
        return file2;
    }

    public final boolean e(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            r.c(canonicalPath);
            String canonicalPath2 = j().getCanonicalPath();
            r.e(canonicalPath2, "getCanonicalPath(...)");
            return x.C(canonicalPath, canonicalPath2, false, 2, null);
        } catch (IOException unused) {
            return false;
        }
    }

    public final Context f() {
        Activity activity = this.f718b;
        if (activity == null) {
            return this.f717a;
        }
        r.c(activity);
        return activity;
    }

    public final int g() {
        return ((Number) this.f721e.getValue()).intValue();
    }

    public final String h(String str) {
        if (str == null || !AbstractC1753A.I(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, null)) {
            return "*";
        }
        String strSubstring = str.substring(0, AbstractC1753A.S(str, RemoteSettings.FORWARD_SLASH_STRING, 0, false, 6, null));
        r.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String i() {
        return (String) this.f720d.getValue();
    }

    public final File j() {
        return new File(f().getCacheDir(), "share_plus");
    }

    public final ArrayList k(List list) throws IOException {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next());
            if (e(file)) {
                throw new IOException("Shared file can not be located in '" + j().getCanonicalPath() + "'");
            }
            arrayList.add(AbstractC1910b.h(f(), i(), d(file)));
        }
        return arrayList;
    }

    public final String n(List list) {
        if (list == null || list.isEmpty()) {
            return "*/*";
        }
        int i4 = 1;
        if (list.size() == 1) {
            return (String) X2.x.H(list);
        }
        String str = (String) X2.x.H(list);
        int i5 = AbstractC0769p.i(list);
        if (1 <= i5) {
            while (true) {
                if (!r.b(str, list.get(i4))) {
                    if (!r.b(h(str), h((String) list.get(i4)))) {
                        return "*/*";
                    }
                    str = h((String) list.get(i4)) + "/*";
                }
                if (i4 == i5) {
                    break;
                }
                i4++;
            }
        }
        return str;
    }

    public final void o(Activity activity) {
        this.f718b = activity;
    }

    public final void p(Map arguments, boolean z4) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        r.f(arguments, "arguments");
        c();
        String str = (String) arguments.get("text");
        String str2 = (String) arguments.get("uri");
        String str3 = (String) arguments.get("subject");
        String str4 = (String) arguments.get(com.amazon.a.a.o.b.f8745S);
        List list = (List) arguments.get("paths");
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof String) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        List list2 = (List) arguments.get("mimeTypes");
        if (list2 != null) {
            arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                if (obj2 instanceof String) {
                    arrayList2.add(obj2);
                }
            }
        } else {
            arrayList2 = null;
        }
        ArrayList<? extends Parcelable> arrayListK = arrayList != null ? k(arrayList) : null;
        Intent intent = new Intent();
        if (arrayListK == null) {
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            if (str2 != null) {
                str = str2;
            }
            intent.putExtra("android.intent.extra.TEXT", str);
            if (str3 != null && !AbstractC1753A.U(str3)) {
                intent.putExtra("android.intent.extra.SUBJECT", str3);
            }
            if (str4 != null && !AbstractC1753A.U(str4)) {
                intent.putExtra("android.intent.extra.TITLE", str4);
            }
        } else {
            if (arrayListK.isEmpty()) {
                throw new IOException("Error sharing files: No files found");
            }
            if (arrayListK.size() == 1) {
                String str5 = (arrayList2 == null || arrayList2.isEmpty()) ? "*/*" : (String) X2.x.H(arrayList2);
                intent.setAction("android.intent.action.SEND");
                intent.setType(str5);
                intent.putExtra("android.intent.extra.STREAM", (Parcelable) X2.x.H(arrayListK));
            } else {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                intent.setType(n(arrayList2));
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayListK);
            }
            if (str != null && !AbstractC1753A.U(str)) {
                intent.putExtra("android.intent.extra.TEXT", str);
            }
            if (str3 != null && !AbstractC1753A.U(str3)) {
                intent.putExtra("android.intent.extra.SUBJECT", str3);
            }
            if (str4 != null && !AbstractC1753A.U(str4)) {
                intent.putExtra("android.intent.extra.TITLE", str4);
            }
            intent.addFlags(1);
        }
        Intent intentCreateChooser = z4 ? Intent.createChooser(intent, str4, PendingIntent.getBroadcast(this.f717a, 0, new Intent(this.f717a, (Class<?>) SharePlusPendingIntent.class), 134217728 | g()).getIntentSender()) : Intent.createChooser(intent, str4);
        if (arrayListK != null) {
            List<ResolveInfo> listQueryIntentActivities = f().getPackageManager().queryIntentActivities(intentCreateChooser, 65536);
            r.e(listQueryIntentActivities, "queryIntentActivities(...)");
            Iterator<T> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                String str6 = ((ResolveInfo) it.next()).activityInfo.packageName;
                Iterator<T> it2 = arrayListK.iterator();
                while (it2.hasNext()) {
                    f().grantUriPermission(str6, (Uri) it2.next(), 3);
                }
            }
        }
        r.c(intentCreateChooser);
        q(intentCreateChooser, z4);
    }

    public final void q(Intent intent, boolean z4) {
        Activity activity = this.f718b;
        if (activity == null) {
            intent.addFlags(268435456);
            if (z4) {
                this.f719c.d();
            }
            this.f717a.startActivity(intent);
            return;
        }
        if (z4) {
            r.c(activity);
            activity.startActivityForResult(intent, 22643);
        } else {
            r.c(activity);
            activity.startActivity(intent);
        }
    }
}
