package B4;

import V6.A;
import V6.C;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import dev.fluttercommunity.plus.share.SharePlusPendingIntent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;
import p5.AbstractC2595q;
import p5.z;
import z5.j;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dev.fluttercommunity.plus.share.a f165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2483k f166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2483k f167e;

    public d(Context context, Activity activity, dev.fluttercommunity.plus.share.a manager) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(manager, "manager");
        this.f163a = context;
        this.f164b = activity;
        this.f165c = manager;
        this.f166d = AbstractC2484l.a(new Function0() { // from class: B4.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.m(this.f162a);
            }
        });
        this.f167e = AbstractC2484l.a(new Function0() { // from class: B4.c
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
        j.e(file, file2, true, 0, 4, null);
        return file2;
    }

    public final boolean e(File file) {
        try {
            String canonicalPath = file.getCanonicalPath();
            AbstractC2304t.c(canonicalPath);
            String canonicalPath2 = j().getCanonicalPath();
            AbstractC2304t.e(canonicalPath2, "getCanonicalPath(...)");
            return A.G(canonicalPath, canonicalPath2, false, 2, null);
        } catch (IOException unused) {
            return false;
        }
    }

    public final Context f() {
        Activity activity = this.f164b;
        if (activity == null) {
            return this.f163a;
        }
        AbstractC2304t.c(activity);
        return activity;
    }

    public final int g() {
        return ((Number) this.f167e.getValue()).intValue();
    }

    public final String h(String str) {
        if (str == null || !C.L(str, "/", false, 2, null)) {
            return "*";
        }
        String strSubstring = str.substring(0, C.Y(str, "/", 0, false, 6, null));
        AbstractC2304t.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String i() {
        return (String) this.f166d.getValue();
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
            arrayList.add(I.b.h(f(), i(), d(file)));
        }
        return arrayList;
    }

    public final String n(List list) {
        if (list == null || list.isEmpty()) {
            return "*/*";
        }
        int i8 = 1;
        if (list.size() == 1) {
            return (String) z.Y(list);
        }
        String str = (String) z.Y(list);
        int iK = AbstractC2595q.k(list);
        if (1 <= iK) {
            while (true) {
                if (!AbstractC2304t.b(str, list.get(i8))) {
                    if (!AbstractC2304t.b(h(str), h((String) list.get(i8)))) {
                        return "*/*";
                    }
                    str = h((String) list.get(i8)) + "/*";
                }
                if (i8 == iK) {
                    break;
                }
                i8++;
            }
        }
        return str;
    }

    public final void o(Activity activity) {
        this.f164b = activity;
    }

    public final void p(Map arguments, boolean z7) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        AbstractC2304t.f(arguments, "arguments");
        c();
        String str = (String) arguments.get("text");
        String str2 = (String) arguments.get("uri");
        String str3 = (String) arguments.get("subject");
        String str4 = (String) arguments.get(com.amazon.a.a.o.b.f14041S);
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
            if (str3 != null && !C.a0(str3)) {
                intent.putExtra("android.intent.extra.SUBJECT", str3);
            }
            if (str4 != null && !C.a0(str4)) {
                intent.putExtra("android.intent.extra.TITLE", str4);
            }
        } else {
            if (arrayListK.isEmpty()) {
                throw new IOException("Error sharing files: No files found");
            }
            if (arrayListK.size() == 1) {
                String str5 = (arrayList2 == null || arrayList2.isEmpty()) ? "*/*" : (String) z.Y(arrayList2);
                intent.setAction("android.intent.action.SEND");
                intent.setType(str5);
                intent.putExtra("android.intent.extra.STREAM", (Parcelable) z.Y(arrayListK));
            } else {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                intent.setType(n(arrayList2));
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayListK);
            }
            if (str != null && !C.a0(str)) {
                intent.putExtra("android.intent.extra.TEXT", str);
            }
            if (str3 != null && !C.a0(str3)) {
                intent.putExtra("android.intent.extra.SUBJECT", str3);
            }
            if (str4 != null && !C.a0(str4)) {
                intent.putExtra("android.intent.extra.TITLE", str4);
            }
            intent.addFlags(1);
        }
        Intent intentCreateChooser = z7 ? Intent.createChooser(intent, str4, PendingIntent.getBroadcast(this.f163a, 0, new Intent(this.f163a, (Class<?>) SharePlusPendingIntent.class), 134217728 | g()).getIntentSender()) : Intent.createChooser(intent, str4);
        if (arrayListK != null) {
            List<ResolveInfo> listQueryIntentActivities = f().getPackageManager().queryIntentActivities(intentCreateChooser, 65536);
            AbstractC2304t.e(listQueryIntentActivities, "queryIntentActivities(...)");
            Iterator<T> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                String str6 = ((ResolveInfo) it.next()).activityInfo.packageName;
                Iterator<T> it2 = arrayListK.iterator();
                while (it2.hasNext()) {
                    f().grantUriPermission(str6, (Uri) it2.next(), 3);
                }
            }
        }
        AbstractC2304t.c(intentCreateChooser);
        q(intentCreateChooser, z7);
    }

    public final void q(Intent intent, boolean z7) {
        Activity activity = this.f164b;
        if (activity == null) {
            intent.addFlags(268435456);
            if (z7) {
                this.f165c.d();
            }
            this.f163a.startActivity(intent);
            return;
        }
        AbstractC2304t.c(activity);
        if (z7) {
            activity.startActivityForResult(intent, 22643);
        } else {
            activity.startActivity(intent);
        }
    }
}
