package d1;

import V4.i;
import V4.j;
import android.content.Context;
import c1.C1124a;
import e1.C1469a;
import g1.C1633a;
import h1.InterfaceC1668a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import k1.AbstractC2065a;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class e extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f13159f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(i call, j.d result) {
        super(result);
        r.f(call, "call");
        r.f(result, "result");
        this.f13159f = call;
    }

    public static final void g(e this$0, Context context) throws IOException {
        int i7;
        r.f(this$0, "this$0");
        r.f(context, "$context");
        Object obj = this$0.f13159f.f5333b;
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
        int iC = zBooleanValue ? C1469a.f13559a.c(bArr) : 0;
        if (iC == 90 || iC == 270) {
            i7 = iIntValue2;
        } else {
            i7 = iIntValue;
            iIntValue = iIntValue2;
        }
        InterfaceC1668a interfaceC1668aA = C1633a.f14257a.a(iIntValue5);
        if (interfaceC1668aA == null) {
            AbstractC2065a.a("No support format.");
            this$0.c(null);
            return;
        }
        int i8 = iIntValue4 + iC;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                interfaceC1668aA.a(context, bArr, byteArrayOutputStream, i7, iIntValue, iIntValue3, i8, zBooleanValue2, iIntValue6);
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

    public final void f(final Context context) {
        r.f(context, "context");
        g.f13162c.a().execute(new Runnable() { // from class: d1.d
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                e.g(this.f13157a, context);
            }
        });
    }
}
