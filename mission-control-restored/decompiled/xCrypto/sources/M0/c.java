package M0;

import android.content.Context;
import g3.h;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class c extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MethodCall f1591f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MethodCall call, MethodChannel.Result result) {
        super(result);
        r.f(call, "call");
        r.f(result, "result");
        this.f1591f = call;
    }

    public static final void h(c cVar, Context context) throws IllegalAccessException, IOException, InvocationTargetException {
        int i4;
        int i5;
        Object obj = cVar.f1591f.arguments;
        r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        int iC = 0;
        Object obj2 = list.get(0);
        r.d(obj2, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj2;
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
        Object obj11 = list.get(9);
        r.d(obj11, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue7 = ((Integer) obj11).intValue();
        Q0.a aVarA = P0.a.f3381a.a(iIntValue5);
        if (aVarA == null) {
            T0.a.a("No support format.");
            cVar.c(null);
            return;
        }
        if (zBooleanValue) {
            iC = N0.a.f2708a.c(h.c(new File(str)));
        }
        if (iC == 90 || iC == 270) {
            i4 = iIntValue;
            i5 = iIntValue2;
        } else {
            i5 = iIntValue;
            i4 = iIntValue2;
        }
        int i6 = iIntValue4 + iC;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            aVarA.b(context, str, byteArrayOutputStream, i5, i4, iIntValue3, i6, zBooleanValue2, iIntValue6, iIntValue7);
            cVar.c(byteArrayOutputStream.toByteArray());
        } catch (Exception e4) {
            if (L0.a.f1391c.a()) {
                e4.printStackTrace();
            }
            cVar.c(null);
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(M0.c r16, android.content.Context r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M0.c.j(M0.c, android.content.Context):void");
    }

    public final void g(final Context context) {
        r.f(context, "context");
        g.f1597c.a().execute(new Runnable() { // from class: M0.a
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IOException, InvocationTargetException {
                c.h(this.f1587a, context);
            }
        });
    }

    public final void i(final Context context) {
        r.f(context, "context");
        g.f1597c.a().execute(new Runnable() { // from class: M0.b
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                c.j(this.f1589a, context);
            }
        });
    }
}
