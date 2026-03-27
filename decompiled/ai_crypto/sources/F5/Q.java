package F5;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Q {

    public static final class a extends J5.k implements Q5.o {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f2354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f2355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2357e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f2358f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f2359g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f2360h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Iterator f2361i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f2362j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f2363k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i7, int i8, Iterator it, boolean z7, boolean z8, H5.d dVar) {
            super(2, dVar);
            this.f2359g = i7;
            this.f2360h = i8;
            this.f2361i = it;
            this.f2362j = z7;
            this.f2363k = z8;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            a aVar = new a(this.f2359g, this.f2360h, this.f2361i, this.f2362j, this.f2363k, dVar);
            aVar.f2358f = obj;
            return aVar;
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Y5.h hVar, H5.d dVar) {
            return ((a) create(hVar, dVar)).invokeSuspend(E5.E.f1657a);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x014e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a2 -> B:16:0x0055). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0117 -> B:59:0x011a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0145 -> B:72:0x0148). Please report as a decompilation issue!!! */
        @Override // J5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 358
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: F5.Q.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void a(int i7, int i8) {
        String str;
        if (i7 <= 0 || i8 <= 0) {
            if (i7 != i8) {
                str = "Both size " + i7 + " and step " + i8 + " must be greater than zero.";
            } else {
                str = "size " + i7 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final Iterator b(Iterator iterator, int i7, int i8, boolean z7, boolean z8) {
        kotlin.jvm.internal.r.f(iterator, "iterator");
        return !iterator.hasNext() ? w.f2383a : Y5.i.a(new a(i7, i8, iterator, z8, z7, null));
    }
}
