package f;

import W2.o;
import W2.t;
import X2.AbstractC0765l;
import X2.K;
import X2.L;
import X2.x;
import android.content.Context;
import android.content.Intent;
import f.AbstractC1238a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import o3.AbstractC1681l;
import x.AbstractC1909a;

/* JADX INFO: renamed from: f.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1239b extends AbstractC1238a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11518a = new a(null);

    /* JADX INFO: renamed from: f.b$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final Intent a(String[] input) {
            r.f(input, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            r.e(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }

        public a() {
        }
    }

    @Override // f.AbstractC1238a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] input) {
        r.f(context, "context");
        r.f(input, "input");
        return f11518a.a(input);
    }

    @Override // f.AbstractC1238a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC1238a.C0191a b(Context context, String[] input) {
        r.f(context, "context");
        r.f(input, "input");
        if (input.length == 0) {
            return new AbstractC1238a.C0191a(L.e());
        }
        for (String str : input) {
            if (AbstractC1909a.checkSelfPermission(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC1681l.b(K.b(input.length), 16));
        for (String str2 : input) {
            o oVarA = t.a(str2, Boolean.TRUE);
            linkedHashMap.put(oVarA.c(), oVarA.d());
        }
        return new AbstractC1238a.C0191a(linkedHashMap);
    }

    @Override // f.AbstractC1238a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i4, Intent intent) {
        if (i4 != -1) {
            return L.e();
        }
        if (intent == null) {
            return L.e();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return L.e();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i5 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i5 == 0));
        }
        return L.o(x.n0(AbstractC0765l.t(stringArrayExtra), arrayList));
    }
}
