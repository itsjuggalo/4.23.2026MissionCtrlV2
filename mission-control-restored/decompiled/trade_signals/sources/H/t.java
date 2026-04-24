package H;

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
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f3548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence[] f3549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f3552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f3553g;

    public static class a {
        public static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(t tVar) {
            Set setD;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(tVar.i()).setLabel(tVar.h()).setChoices(tVar.e()).setAllowFreeFormInput(tVar.c()).addExtras(tVar.g());
            if (Build.VERSION.SDK_INT >= 26 && (setD = tVar.d()) != null) {
                Iterator it = setD.iterator();
                while (it.hasNext()) {
                    b.d(builderAddExtras, (String) it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(builderAddExtras, tVar.f());
            }
            return builderAddExtras.build();
        }

        public static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    public static class b {
        public static void a(t tVar, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(t.a(tVar), intent, map);
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

        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i8) {
            return builder.setEditChoicesBeforeSending(i8);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3554a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f3557d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence[] f3558e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f3555b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f3556c = new Bundle();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3559f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3560g = 0;

        public d(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f3554a = str;
        }

        public t a() {
            return new t(this.f3554a, this.f3557d, this.f3558e, this.f3559f, this.f3560g, this.f3556c, this.f3555b);
        }

        public d b(String str, boolean z7) {
            if (z7) {
                this.f3555b.add(str);
            } else {
                this.f3555b.remove(str);
            }
            return this;
        }

        public d c(boolean z7) {
            this.f3559f = z7;
            return this;
        }

        public d d(CharSequence[] charSequenceArr) {
            this.f3558e = charSequenceArr;
            return this;
        }

        public d e(CharSequence charSequence) {
            this.f3557d = charSequence;
            return this;
        }
    }

    public t(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z7, int i8, Bundle bundle, Set set) {
        this.f3547a = str;
        this.f3548b = charSequence;
        this.f3549c = charSequenceArr;
        this.f3550d = z7;
        this.f3551e = i8;
        this.f3552f = bundle;
        this.f3553g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static RemoteInput a(t tVar) {
        return a.b(tVar);
    }

    public static RemoteInput[] b(t[] tVarArr) {
        if (tVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[tVarArr.length];
        for (int i8 = 0; i8 < tVarArr.length; i8++) {
            remoteInputArr[i8] = a(tVarArr[i8]);
        }
        return remoteInputArr;
    }

    public static Bundle j(Intent intent) {
        return a.c(intent);
    }

    public boolean c() {
        return this.f3550d;
    }

    public Set d() {
        return this.f3553g;
    }

    public CharSequence[] e() {
        return this.f3549c;
    }

    public int f() {
        return this.f3551e;
    }

    public Bundle g() {
        return this.f3552f;
    }

    public CharSequence h() {
        return this.f3548b;
    }

    public String i() {
        return this.f3547a;
    }

    public boolean k() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
