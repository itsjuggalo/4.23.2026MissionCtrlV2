package d1;

import O5.h;
import V4.i;
import V4.j;
import android.content.Context;
import c1.C1124a;
import e1.C1469a;
import g1.C1633a;
import h1.InterfaceC1668a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import k1.AbstractC2065a;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: d1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1392c extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f13156f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1392c(i call, j.d result) {
        super(result);
        r.f(call, "call");
        r.f(result, "result");
        this.f13156f = call;
    }

    public static final void h(C1392c this$0, Context context) throws IllegalAccessException, IOException, InvocationTargetException {
        int i7;
        r.f(this$0, "this$0");
        r.f(context, "$context");
        Object obj = this$0.f13156f.f5333b;
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
        InterfaceC1668a interfaceC1668aA = C1633a.f14257a.a(iIntValue5);
        if (interfaceC1668aA == null) {
            AbstractC2065a.a("No support format.");
            this$0.c(null);
            return;
        }
        if (zBooleanValue) {
            iC = C1469a.f13559a.c(h.c(new File(str)));
        }
        if (iC == 90 || iC == 270) {
            i7 = iIntValue;
        } else {
            i7 = iIntValue2;
            iIntValue2 = iIntValue;
        }
        int i8 = iIntValue4 + iC;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                interfaceC1668aA.b(context, str, byteArrayOutputStream, iIntValue2, i7, iIntValue3, i8, zBooleanValue2, iIntValue6, iIntValue7);
                this$0.c(byteArrayOutputStream.toByteArray());
            } catch (Exception e7) {
                if (C1124a.f9329e.a()) {
                    e7.printStackTrace();
                }
                this$0.c(null);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0103: MOVE (r14 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]) (LINE:260), block:B:21:0x0103 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(d1.C1392c r17, android.content.Context r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.C1392c.j(d1.c, android.content.Context):void");
    }

    public final void g(final Context context) {
        r.f(context, "context");
        g.f13162c.a().execute(new Runnable() { // from class: d1.a
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IOException, InvocationTargetException {
                C1392c.h(this.f13152a, context);
            }
        });
    }

    public final void i(final Context context) {
        r.f(context, "context");
        g.f13162c.a().execute(new Runnable() { // from class: d1.b
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                C1392c.j(this.f13154a, context);
            }
        });
    }
}
