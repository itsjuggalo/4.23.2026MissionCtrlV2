package b8;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import i4.h;
import java.nio.charset.Charset;
import l4.u;
import u7.m0;
import u7.z;
import x7.f0;
import y7.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f3007c = new j();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f3008d = d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3009e = d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f3010f = new h() { // from class: b8.a
        @Override // i4.h
        public final Object apply(Object obj) {
            return b.f3007c.M((f0) obj).getBytes(Charset.forName("UTF-8"));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f3011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f3012b;

    public b(e eVar, h hVar) {
        this.f3011a = eVar;
        this.f3012b = hVar;
    }

    public static b b(Context context, c8.j jVar, m0 m0Var) {
        u.f(context);
        i4.j jVarG = u.c().g(new j4.a(f3008d, f3009e));
        i4.c cVarB = i4.c.b("json");
        h hVar = f3010f;
        return new b(new e(jVarG.b("FIREBASE_CRASHLYTICS_REPORT", f0.class, cVarB, hVar), jVar.b(), m0Var), hVar);
    }

    public static String d(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb2.append(str.charAt(i10));
            if (str2.length() > i10) {
                sb2.append(str2.charAt(i10));
            }
        }
        return sb2.toString();
    }

    public Task c(z zVar, boolean z10) {
        return this.f3011a.i(zVar, z10).getTask();
    }
}
