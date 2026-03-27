package M0;

import android.content.Context;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class e extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MethodCall f1594f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MethodCall call, MethodChannel.Result result) {
        super(result);
        r.f(call, "call");
        r.f(result, "result");
        this.f1594f = call;
    }

    public static final void g(e eVar, Context context) throws IOException {
        int i4;
        Object obj = eVar.f1594f.arguments;
        r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        r.d(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
        byte[] bArr = (byte[]) obj2;
        Object obj3 = list.get(1);
        r.d(obj3, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj3).intValue();
        Object obj4 = list.get(2);
        r.d(obj4, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue2 = ((Integer) obj4).intValue();
        Object obj5 = list.get(3);
        r.d(obj5, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue3 = ((Integer) obj5).intValue();
        Object obj6 = list.get(4);
        r.d(obj6, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue4 = ((Integer) obj6).intValue();
        Object obj7 = list.get(5);
        r.d(obj7, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj7).booleanValue();
        Object obj8 = list.get(6);
        r.d(obj8, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue5 = ((Integer) obj8).intValue();
        Object obj9 = list.get(7);
        r.d(obj9, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue2 = ((Boolean) obj9).booleanValue();
        Object obj10 = list.get(8);
        r.d(obj10, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue6 = ((Integer) obj10).intValue();
        int iC = zBooleanValue ? N0.a.f2708a.c(bArr) : 0;
        if (iC == 90 || iC == 270) {
            i4 = iIntValue2;
        } else {
            i4 = iIntValue;
            iIntValue = iIntValue2;
        }
        Q0.a aVarA = P0.a.f3381a.a(iIntValue5);
        if (aVarA == null) {
            T0.a.a("No support format.");
            eVar.c(null);
            return;
        }
        int i5 = iIntValue4 + iC;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                aVarA.a(context, bArr, byteArrayOutputStream, i4, iIntValue, iIntValue3, i5, zBooleanValue2, iIntValue6);
                eVar.c(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
            } catch (Exception e4) {
                if (L0.a.f1391c.a()) {
                    e4.printStackTrace();
                }
                eVar.c(null);
                byteArrayOutputStream.close();
            }
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public final void f(final Context context) {
        r.f(context, "context");
        g.f1597c.a().execute(new Runnable() { // from class: M0.d
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                e.g(this.f1592a, context);
            }
        });
    }
}
