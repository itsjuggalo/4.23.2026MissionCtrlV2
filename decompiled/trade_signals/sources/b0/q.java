package b0;

import java.io.File;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2707e;
import u5.AbstractC2777d;

/* JADX INFO: loaded from: classes.dex */
public final class q extends C1183n implements P {

    public static final class a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f12804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f12805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12806c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12808e;

        public a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f12806c = obj;
            this.f12808e |= Integer.MIN_VALUE;
            return q.this.d(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(File file, E serializer) {
        super(file, serializer);
        AbstractC2304t.f(file, "file");
        AbstractC2304t.f(serializer, "serializer");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b0.P
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.Object r6, s5.InterfaceC2707e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof b0.q.a
            if (r0 == 0) goto L13
            r0 = r7
            b0.q$a r0 = (b0.q.a) r0
            int r1 = r0.f12808e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12808e = r1
            goto L18
        L13:
            b0.q$a r0 = new b0.q$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f12806c
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f12808e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f12805b
            java.io.FileOutputStream r6 = (java.io.FileOutputStream) r6
            java.lang.Object r0 = r0.f12804a
            java.io.Closeable r0 = (java.io.Closeable) r0
            o5.AbstractC2491s.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L62
        L31:
            r6 = move-exception
            goto L74
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            o5.AbstractC2491s.b(r7)
            r5.f()
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r2 = r5.g()
            r7.<init>(r2)
            b0.E r2 = r5.h()     // Catch: java.lang.Throwable -> L72
            b0.N r4 = new b0.N     // Catch: java.lang.Throwable -> L72
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L72
            r0.f12804a = r7     // Catch: java.lang.Throwable -> L72
            r0.f12805b = r7     // Catch: java.lang.Throwable -> L72
            r0.f12808e = r3     // Catch: java.lang.Throwable -> L72
            java.lang.Object r6 = r2.b(r6, r4, r0)     // Catch: java.lang.Throwable -> L72
            if (r6 != r1) goto L60
            return r1
        L60:
            r6 = r7
            r0 = r6
        L62:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L31
            r6.sync()     // Catch: java.lang.Throwable -> L31
            o5.H r6 = o5.C2470H.f21956a     // Catch: java.lang.Throwable -> L31
            r6 = 0
            z5.AbstractC3014b.a(r0, r6)
            o5.H r6 = o5.C2470H.f21956a
            return r6
        L72:
            r6 = move-exception
            r0 = r7
        L74:
            throw r6     // Catch: java.lang.Throwable -> L75
        L75:
            r7 = move-exception
            z5.AbstractC3014b.a(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.q.d(java.lang.Object, s5.e):java.lang.Object");
    }
}
