package w;

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
    public final String f15535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f15536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence[] f15537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f15540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f15541g;

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

        public static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z4) {
            return builder.setAllowDataType(str, z4);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i4) {
            return builder.setEditChoicesBeforeSending(i4);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15542a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f15545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence[] f15546e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f15543b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f15544c = new Bundle();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f15547f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f15548g = 0;

        public d(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f15542a = str;
        }

        public v a() {
            return new v(this.f15542a, this.f15545d, this.f15546e, this.f15547f, this.f15548g, this.f15544c, this.f15543b);
        }

        public d b(String str, boolean z4) {
            if (z4) {
                this.f15543b.add(str);
                return this;
            }
            this.f15543b.remove(str);
            return this;
        }

        public d c(boolean z4) {
            this.f15547f = z4;
            return this;
        }

        public d d(CharSequence[] charSequenceArr) {
            this.f15546e = charSequenceArr;
            return this;
        }

        public d e(CharSequence charSequence) {
            this.f15545d = charSequence;
            return this;
        }
    }

    public v(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z4, int i4, Bundle bundle, Set set) {
        this.f15535a = str;
        this.f15536b = charSequence;
        this.f15537c = charSequenceArr;
        this.f15538d = z4;
        this.f15539e = i4;
        this.f15540f = bundle;
        this.f15541g = set;
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
        for (int i4 = 0; i4 < vVarArr.length; i4++) {
            remoteInputArr[i4] = a(vVarArr[i4]);
        }
        return remoteInputArr;
    }

    public static Bundle j(Intent intent) {
        return a.c(intent);
    }

    public boolean c() {
        return this.f15538d;
    }

    public Set d() {
        return this.f15541g;
    }

    public CharSequence[] e() {
        return this.f15537c;
    }

    public int f() {
        return this.f15539e;
    }

    public Bundle g() {
        return this.f15540f;
    }

    public CharSequence h() {
        return this.f15536b;
    }

    public String i() {
        return this.f15535a;
    }

    public boolean k() {
        if (c()) {
            return false;
        }
        return ((e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
