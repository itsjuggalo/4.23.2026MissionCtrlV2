package F;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f1863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence[] f1864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f1867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f1868g;

    public static class a {
        public static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(v vVar) {
            Set setD;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(vVar.i()).setLabel(vVar.h()).setChoices(vVar.e()).setAllowFreeFormInput(vVar.c()).addExtras(vVar.g());
            if (Build.VERSION.SDK_INT >= 26 && (setD = vVar.d()) != null) {
                Iterator it = setD.iterator();
                while (it.hasNext()) {
                    b.d(builderAddExtras, (String) it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(builderAddExtras, vVar.f());
            }
            return builderAddExtras.build();
        }

        public static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    public static class b {
        public static void a(v vVar, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(v.a(vVar), intent, map);
        }

        public static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        public static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        public static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z7) {
            return builder.setAllowDataType(str, z7);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i7) {
            return builder.setEditChoicesBeforeSending(i7);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1869a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f1872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence[] f1873e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f1870b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f1871c = new Bundle();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1874f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1875g = 0;

        public d(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f1869a = str;
        }

        public v a() {
            return new v(this.f1869a, this.f1872d, this.f1873e, this.f1874f, this.f1875g, this.f1871c, this.f1870b);
        }

        public d b(String str, boolean z7) {
            if (z7) {
                this.f1870b.add(str);
            } else {
                this.f1870b.remove(str);
            }
            return this;
        }

        public d c(boolean z7) {
            this.f1874f = z7;
            return this;
        }

        public d d(CharSequence[] charSequenceArr) {
            this.f1873e = charSequenceArr;
            return this;
        }

        public d e(CharSequence charSequence) {
            this.f1872d = charSequence;
            return this;
        }
    }

    public v(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z7, int i7, Bundle bundle, Set set) {
        this.f1862a = str;
        this.f1863b = charSequence;
        this.f1864c = charSequenceArr;
        this.f1865d = z7;
        this.f1866e = i7;
        this.f1867f = bundle;
        this.f1868g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static RemoteInput a(v vVar) {
        return a.b(vVar);
    }

    public static RemoteInput[] b(v[] vVarArr) {
        if (vVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[vVarArr.length];
        for (int i7 = 0; i7 < vVarArr.length; i7++) {
            remoteInputArr[i7] = a(vVarArr[i7]);
        }
        return remoteInputArr;
    }

    public static Bundle j(Intent intent) {
        return a.c(intent);
    }

    public boolean c() {
        return this.f1865d;
    }

    public Set d() {
        return this.f1868g;
    }

    public CharSequence[] e() {
        return this.f1864c;
    }

    public int f() {
        return this.f1866e;
    }

    public Bundle g() {
        return this.f1867f;
    }

    public CharSequence h() {
        return this.f1863b;
    }

    public String i() {
        return this.f1862a;
    }

    public boolean k() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
