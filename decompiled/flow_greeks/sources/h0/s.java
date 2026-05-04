package h0;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f10921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence[] f10922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f10925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f10926g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static RemoteInput a(s sVar) {
            Set setD;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(sVar.i()).setLabel(sVar.h()).setChoices(sVar.e()).setAllowFreeFormInput(sVar.c()).addExtras(sVar.g());
            if (Build.VERSION.SDK_INT >= 26 && (setD = sVar.d()) != null) {
                Iterator it = setD.iterator();
                while (it.hasNext()) {
                    b.a(builderAddExtras, (String) it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.a(builderAddExtras, sVar.f());
            }
            return builderAddExtras.build();
        }

        public static Bundle b(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {
        public static RemoteInput.Builder a(RemoteInput.Builder builder, String str, boolean z10) {
            return builder.setAllowDataType(str, z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {
        public static RemoteInput.Builder a(RemoteInput.Builder builder, int i10) {
            return builder.setEditChoicesBeforeSending(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10927a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f10930d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence[] f10931e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f10928b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f10929c = new Bundle();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f10932f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f10933g = 0;

        public d(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f10927a = str;
        }

        public s a() {
            return new s(this.f10927a, this.f10930d, this.f10931e, this.f10932f, this.f10933g, this.f10929c, this.f10928b);
        }

        public d b(String str, boolean z10) {
            if (z10) {
                this.f10928b.add(str);
                return this;
            }
            this.f10928b.remove(str);
            return this;
        }

        public d c(boolean z10) {
            this.f10932f = z10;
            return this;
        }

        public d d(CharSequence[] charSequenceArr) {
            this.f10931e = charSequenceArr;
            return this;
        }

        public d e(CharSequence charSequence) {
            this.f10930d = charSequence;
            return this;
        }
    }

    public s(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z10, int i10, Bundle bundle, Set set) {
        this.f10920a = str;
        this.f10921b = charSequence;
        this.f10922c = charSequenceArr;
        this.f10923d = z10;
        this.f10924e = i10;
        this.f10925f = bundle;
        this.f10926g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static RemoteInput a(s sVar) {
        return a.a(sVar);
    }

    public static RemoteInput[] b(s[] sVarArr) {
        if (sVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[sVarArr.length];
        for (int i10 = 0; i10 < sVarArr.length; i10++) {
            remoteInputArr[i10] = a(sVarArr[i10]);
        }
        return remoteInputArr;
    }

    public static Bundle j(Intent intent) {
        return a.b(intent);
    }

    public boolean c() {
        return this.f10923d;
    }

    public Set d() {
        return this.f10926g;
    }

    public CharSequence[] e() {
        return this.f10922c;
    }

    public int f() {
        return this.f10924e;
    }

    public Bundle g() {
        return this.f10925f;
    }

    public CharSequence h() {
        return this.f10921b;
    }

    public String i() {
        return this.f10920a;
    }

    public boolean k() {
        if (c()) {
            return false;
        }
        return ((e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
