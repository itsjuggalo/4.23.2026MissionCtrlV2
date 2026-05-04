package f;

import android.content.Context;
import android.content.Intent;
import cd.q;
import cd.w;
import dd.a0;
import dd.n;
import dd.n0;
import dd.o0;
import f.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import vd.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9034a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final Intent a(String[] input) {
            t.f(input, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            t.e(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }

        public a() {
        }
    }

    @Override // f.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] input) {
        t.f(context, "context");
        t.f(input, "input");
        return f9034a.a(input);
    }

    @Override // f.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a.C0169a b(Context context, String[] input) {
        t.f(context, "context");
        t.f(input, "input");
        if (input.length == 0) {
            return new a.C0169a(o0.h());
        }
        for (String str : input) {
            if (i0.a.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(n0.d(input.length), 16));
        for (String str2 : input) {
            q qVarA = w.a(str2, Boolean.TRUE);
            linkedHashMap.put(qVarA.c(), qVarA.d());
        }
        return new a.C0169a(linkedHashMap);
    }

    @Override // f.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i10, Intent intent) {
        if (i10 != -1) {
            return o0.h();
        }
        if (intent == null) {
            return o0.h();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return o0.h();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i11 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i11 == 0));
        }
        return o0.t(a0.S0(n.A(stringArrayExtra), arrayList));
    }
}
